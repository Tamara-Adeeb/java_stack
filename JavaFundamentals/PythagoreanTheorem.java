import java.lang.Math
public class PythagoreanTheorem {
    public double calculateHypotenuse(int legA, int legB){
        double four = legA**2 + legB**2;
        double squareRoot = Math.sqrt(four);
        return squareRoot;
    }
}