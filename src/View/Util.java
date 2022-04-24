package View;
import java.util.*;
public class Util {
    static Scanner scanner = new Scanner(System.in);
    public static Scanner input()
    {
        //returning scanner object
        return scanner;
    }
    public static String scanString()
    {
        //returning input string from the user
        String str = scanner.next();
        return str;
    }
    public static int scanInt()
    {
        //returning integer from the user
        int integer = scanner.nextInt();
        return integer; // return directly
    }
    public static void print(String string)
    {
        //printing the string
        System.out.println(string);
    }
}
