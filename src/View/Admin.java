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
        String query = DBQuery.loginQuery(userDetails);

        // executing query
        DBLoader.createStatements();
        try {
            ResultSet resultSet = DBLoader.statement.executeQuery(query);

            // calling the function to check whether the input credentials are valid
            DBHandler.checkIfLoginExists(resultSet);
        } catch (SQLException e) {
            Util.printToConsole("Couldn't execute query : " + e);
        }
    }

}
