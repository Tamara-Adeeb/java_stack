
public class Main {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount();
		b1.de(500, 1);
		b1.de(300, 2);
		b1.withdrawMoney(100, 1);
		System.out.println(b1.accountNumber);
		b1.de(0, 1);
		
		

	}

}
