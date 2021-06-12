public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz result = new FizzBuzz();
        for (int i = 0 ; i <= 15; i++) {
            System.out.println(result.fizzBuzz(i));
        }
    }
}