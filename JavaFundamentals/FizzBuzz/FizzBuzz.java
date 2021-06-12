public class FizzBuzz {
    public String fizzBuzz(int number) {
        String str =  String.format("%o", number );
        //Strind str = number +""
        if (number%3 == 0 && number%5 == 0) {
            str = "FizzBuzz";
        }
        else if (number%3 == 0) {
            str = "Fizz";
        }
        else if (number%5 == 0) {
            str = "Buzz";
        }
        return str;
    }
}