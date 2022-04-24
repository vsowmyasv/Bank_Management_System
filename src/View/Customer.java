package View;
import java.sql.*;
import DBController.*;
import Model.*;

public class Customer {
    void login() throws SQLException
    {
        //calling function to establish connection with DB
        DBLoader.establishConnection(); 

        //creating object for model class UserDetails
        UserDetails userDetails = new UserDetails();
        
        Util.print("Enter the user ID : ");
        String userID = Util.scanString(); //calling function to scan the input String from user
        userDetails.setUserID(userID.trim());

        Util.print("Enter password : ");
        String userPassword = Util.scanString();
        userDetails.setUserPassword(userPassword.trim());

        //fetching query
        String query = DBQuery.loginQuery(userDetails);

        //executing query
        DBLoader.createStatements();
        ResultSet resultSet = DBLoader.statement.executeQuery(query);
        
        //calling the function to check whether the input credentials are valid
        DBHandler.checkIfLoginExists(resultSet);
        
        //calling the function to close the connection
        DBLoader.closeConnection();
    }
}
