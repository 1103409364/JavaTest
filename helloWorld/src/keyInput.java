import java.util.Scanner;

public class keyInput {
    public static void main(final String[] args) {
        final Scanner s = new Scanner(System.in);
        final String c = s.next();
        System.out.println("用户输入：" + c);
        s.close();
    }
}
