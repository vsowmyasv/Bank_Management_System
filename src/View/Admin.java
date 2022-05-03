package View;

import java.sql.*;

import DBController.*;
import Model.*;

public class Admin {

    static UserDetails userDetails = new UserDetails();
    static CustomerAccountDetails customerAccountDetails = new CustomerAccountDetails();
    static CustomerPersonalDetails customerPersonalDetails = new CustomerPersonalDetails();

    void login() {
        DBLoader.establishConnection();

        Util.printToConsole("Enter the Admin ID : ");
        String userID = Util.scanString(); // calling function to scan the input String from user
        userDetails.setUserID(userID);

        Util.printToConsole("Enter password : ");
        String userPassword = Util.scanString();
        userDetails.setUserPassword(userPassword);

        // fetching query
        String query = DBQuery.adminLoginQuery(userDetails);

        // executing query
        DBLoader.createStatements();
        try {
            ResultSet resultSet = DBLoader.statement.executeQuery(query);

            // calling the function to check whether the input credentials are valid
            DBHandler.checkIfLoginExistsAdmin(resultSet);
        } catch (SQLException e) {
            Util.printToConsole("Couldn't execute query : " + e);
        }

        DBLoader.closeConnection();
    }

    public static void adminUseCases() {
        Util.printToConsole(
                "Choose the option from the below menu: \n1. Create new customer account\n2. Delete customer account\n3. Update customer account\n4. Display account");
        int choice = Util.scanInt();

        switch (choice) {
            case 1:
                Util.printToConsole("Enter user ID for the new customer : ");
                userDetails.setUserID(Util.scanString());

                Util.printToConsole("Enter new password for the account : ");
                userDetails.setUserPassword(Util.scanString());

                Util.printToConsole("Enter customer account number : ");
                customerAccountDetails.setAccountNumber(Util.scanString());

                Util.printToConsole("Enter customer PAN number : ");
                customerAccountDetails.setPanNumber(Util.scanString());

                Util.printToConsole("Enter customer account type : ");
                customerAccountDetails.setAccountType(Util.scanString());

                Util.printToConsole("Enter customer name : ");
                customerPersonalDetails.setCustomerName(Util.scanString());

                Util.printToConsole("Enter customer address : ");
                customerPersonalDetails.setCustomerAddress(Util.scanStringLine());

                Util.printToConsole("Enter customer contact number : ");
                customerPersonalDetails.setCustomerContactNumber(Util.scanString());
                try {
                    DBLoader.statement.executeUpdate(DBQuery.createAccountUserDetails(userDetails));
                    DBLoader.statement.executeUpdate(DBQuery.createPersonalDetails(customerPersonalDetails));
                    DBLoader.statement.executeUpdate(DBQuery.createAccountDetails(customerAccountDetails));
                } catch (SQLException e) {
                    Util.printToConsole("Couldn't create account");
                }
                break;

            default:
                Util.printToConsole("Enter a valid option from the menu !!");
                break;
        }
    }

}
