import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Puzzling {
    public ArrayList<Integer> graterThan10sum(int[] array){
        int sum = 0;
        ArrayList<Integer> graterThan10 = new ArrayList<Integer>();
        for (int i = 0; i<array.length; i++){
            sum += array[i];
            if(array[i] > 10) {
                graterThan10.add(array[i]);
            }
        }
        System.out.println(sum);
        return graterThan10;
    }
    public ArrayList<String> names5Char(ArrayList<String> names){
        for (int i = 0; i<names.size(); i++){
            System.out.println(names.get(i));
            if(names.get(i).length() < 5){
                names.remove(i);
            }
        }
        return names;
    }
    public void alphabetLetters(char[] alphabet){
        ArrayList<String> alphabetsList = new ArrayList<String>();
        for(int i = 0 ; i < alphabet.length; i++){
            String l = String.valueOf(alphabet[i]);
            alphabetsList.add(l);
        }
        Collections.shuffle(alphabetsList);
        // alphabetsList.set(0,"e");
        String[] vowels = {"a","e","i","o","u"};
        for (String vowel : vowels){
            if(alphabetsList.get(0) == vowel) {
                System.out.println("I'am a vowel");
            }
        }
        System.out.println(alphabet[alphabet.length-1]);
    }
    public ArrayList<Integer> randomNumbers() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // Random r = new Random();
        int random = 0;
        for(int i = 0; i < 10; i++){
            // range = max - min +1 = 45 and then start from the min to the range
            random = (int)(Math.random() * 45) + 55;
            numbers.add(random);
        }
        return numbers;
    }
    public void displayRandomNumbers(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int random = 0;
        for (int i = 0; i<10; i++){
            random = (int)(Math.random() * 45) + 55;
            numbers.add(random);
        }
        int max = numbers.get(0);
        int min = numbers.get(0);
        Collections.shuffle(numbers);
        Collections.sort(numbers);
        for(int i=0; i<numbers.size(); i++){
            System.out.println(numbers.get(i));
            if(numbers.get(i)> max){
                max = numbers.get(i);
            }
            if(numbers.get(i)< min){
                min = numbers.get(i);
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
    public String randomString(){
        String randomLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int random = 0;
        char[] arrayOfString = new char[5];
        String randomWord = "";
        for(int i=0; i<5;i++){
            random = (int)(Math.random()*25);
            arrayOfString[i] = randomLetters.charAt(random);
        }
        randomWord = randomWord.copyValueOf(arrayOfString,0,5);
        // String randomWord = String.join(",", arrayOfString);
        return randomWord;
    }
    public void randomArrayOfString(){
        String randomLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int random = 0;
        String[] randomWordArray = new String[10];
        char[] arrayOfString = new char[5];
        String randomWord = "";
        for(int i=0; i<5;i++){
            random = (int)(Math.random()*25);
            arrayOfString[i] = randomLetters.charAt(random);
        }
        randomWord = randomWord.copyValueOf(arrayOfString,0,5);
        for(int x=0; x<10;x++){
            for(int i=0; i<5;i++){
                random = (int)(Math.random()*25);
                arrayOfString[i] = randomLetters.charAt(random);
            }
            randomWord = randomWord.copyValueOf(arrayOfString,0,5);
            randomWordArray[x] = randomWord;
        }
        System.out.println(randomWordArray);
    }
}
