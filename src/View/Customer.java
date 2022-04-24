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
        
        System.out.println("Enter the user ID : ");
        String userID = Util.scanString(); //calling function to scan the input String from user
        userDetails.setUserID(userID);

        System.out.println("Enter password : ");
        String userPassword = Util.scanString();
        userDetails.setUserPassword(userPassword);

        //fetching query
        String query = DBQuery.loginQuery(userDetails);

        //executing query
        DBLoader.createStatements();
        ResultSet resultSet = DBLoader.statement.executeQuery(query);
        
        DBHandler.checkIfLoginExists(resultSet);
        
        DBLoader.closeConnection();
    }
}
