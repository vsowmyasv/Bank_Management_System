package View;
import java.sql.SQLException;

public class Main {
   public static void main(String[] args) throws SQLException
   {
    System.out.println("Choose any of the following operation to perform : \n1. Login");
    int choice = Util.scanInt(); //calling function to scan input integer from user

        switch(choice)
        {
            case 1: Customer customer = new Customer();
                    customer.login(); //calling function to perform the login operation
                    break;

            default: System.out.println("Enter a valid option from the menu! ");
        }

    }
}
