package View;

import java.sql.*;

import DBController.*;
import Model.*;

public class Admin {

    static UserDetails userDetails = new UserDetails();

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
            case 1: Util.printToConsole("Enter user ID for the new customer : ");
                    userDetails.setUserID(Util.scanString());

                    Util.printToConsole("Enter new password for the account : ");
                    userDetails.setUserPassword(Util.scanString());

                    Util.printToConsole("Enter customer account number : ");
                break;
        
            default:
                break;
        }
    }

}
