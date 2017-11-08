import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String s = "twenty-one";
        System.out.println(s);
        String[] words = s.split("[-\\s]");
        System.out.println(Arrays.toString(words));
    }
}
