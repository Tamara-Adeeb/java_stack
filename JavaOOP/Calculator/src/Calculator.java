
public class Calculator {
	String operation;
	double operandOne;
	double operandTwo;
	
//	public Calculator (double operandOne,String operation, double operandTwo ) {
//		this.operandOne = operandOne;
//		this.operation = operation;
//		this.operandTwo = operandTwo;
//	}
	public Calculator() {}
	public int getResults(double operandOne,String operation, double operandTwo ) {
		double result = performOperation(operandOne, operation,  operandTwo );
		return (int) result;

	}
	private int performOperation(double operandOne,String operation, double operandTwo ) {
		if(operation == "+") {
			return (int) (operandOne + operandTwo);
		}
		else  {
			return (int) (operandOne - operandTwo);
		}
	}
}
