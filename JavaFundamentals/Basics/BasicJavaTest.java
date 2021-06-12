public class BasicJavaTest {
    // public static void main(String[] args) {
    //     BasicJava print = new BasicJava();
    //     print.print1To255();
    // }
    public static void main(String[] args) {
        int[] myArray = {4, -8, 8, 5, 9};
        BasicJava print = new BasicJava();
        // for (int i = 1; i < 30; i++){
        //     System.out.println(print.print1To255(i));
        // }
        // print.IteratingArray(myArray);
        // System.out.println(print.FindMax(myArray));
        // System.out.println(print.GetAverage(myArray));
        // System.out.println(print.ArrayOddNumbers());
        // System.out.println(print.GreaterThanY(myArray,5));
        // System.out.println(print.SquareValues(myArray));
        // System.out.println(print.EliminateNegativeNumbers(myArray));
        // System.out.println(print.MaxMinAverage(myArray));
        int[] array=print.ShiftingArrayValues(myArray);
        String lol="[";
          for (int i =0;i<array.length;i++){
            lol+=array[i]+",";
        }
        lol+="]";
        System.out.println(lol);

        System.out.print(myArray);
    }

}