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
        return scanner.next();
    }
    public static int scanInt()
    {
        //returning input integer from the user
        return scanner.nextInt();
    }
    public static void printToConsole(String string)
    {
        //printing the string
        System.out.println(string);
    }
}
