import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PuzzlingTest {
    public static void main(String[] args){
        int[] array = {3,5,1,2,7,9,8,13,25,32};
        String[] addNames = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i<addNames.length; i++){
            names.add(addNames[i]);
        }
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Puzzling puzz = new Puzzling();
        // System.out.println(puzz.graterThan10sum(array));
        // System.out.println(puzz.names5Char(names));
        // puzz.alphabetLetters(alphabet);
        // System.out.println(puzz.randomNumbers());
        // puzz.displayRandomNumbers();
        System.out.println(puzz.randomString());
        puzz.randomArrayOfString();

    }
}