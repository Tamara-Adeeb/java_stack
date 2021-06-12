public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        System.out.println(manipulator.trimAndConcat("    Hello     ","     World    "));
        System.out.println(manipulator.getIndexOrNull("Coding",'g'));
        System.out.println(manipulator.getIndexOrNull("Coding","ing"));
        System.out.println(manipulator.concatSubstring("Hello", 1, 2, "world"));
    }
}