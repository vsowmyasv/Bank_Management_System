package View;

public class Main {
    public static void main(String[] args) {
        Util.printToConsole("Choose any of the following operation to perform: \n1. Customer Login\n2. Admin Login");
        int choice = Util.scanInt(); // calling function to scan input integer from user

        switch (choice) {
            case 1:
                Customer customer = new Customer();
                customer.login(); // calling function to perform the login operation
                break;

            case 2:
                Admin admin = new Admin();
                admin.login();
                break;

            default:
                Util.printToConsole("Enter a valid option from the menu! ");
                break;
        }

    }
}
