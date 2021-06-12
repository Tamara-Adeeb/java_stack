import java.util.ArrayList;
public class BasicJava {
    int sum = 0;
    public String print1To255(int number) {
        // int sum = 0;
        // for (int i = 1; i < 256; i++) {
        //     // System.out.println(i);
        //     sum += i;
        //     if (i%2 == 1){
        //         System.out.println(String.format("New number: %d Sum: %d, Odd",i, sum) );
        //     }
        //     else {
        //         System.out.println(String.format("New number: %d Sum: %d",i, sum) );
        //     }

            
        // }
        sum += number;
        if (number%2 != 0) {
            return String.format("New number: %d Sum: %d, Odd",number,sum);
        }
        else if (number%2 == 0) {
            return String.format("New number: %d Sum: %d",number,sum);
        }
        else {
            return "Strange";
        }
    }
    public void IteratingArray(int[] array) { //Object[] does it wirke insted of int[]
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }
    public int FindMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public int GetAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum / array.length;
    }
    public ArrayList<Integer> ArrayOddNumbers() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 1; i < 256; i++ ) {
            if(i%2 == 1) {
                y.add(i);
            }
        }
        return y;
    }
    public int GreaterThanY(int[] array, int y) {  
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > y) {
                counter ++;
            }
        }
        return counter;
    }
    public int[] SquareValues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]^2;
        }
        return array;
    }
    public int[] EliminateNegativeNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 ) {
                array[i] = 0;
            }
        }
        return array;
    }
    public double[] MaxMinAverage(int[] array) {
        int min = array[0];
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if ( array[i] > max ) {
                max = array[i];
            }
            if (array[i] < min ) {
                min = array[i];
            }
            sum += array[i];
        }
        double[] arr = { max, min, sum/array.length };
        return arr ;
    }
    public int[] ShiftingArrayValues(int[] array) {
        for (int i=0; i<array.length; i++) {
            if (i ==  array.length-1){
                array[i] = 0;
                break;
            }
            array[i] = array[i+1];
        }
      
        return array;
    }
    

}