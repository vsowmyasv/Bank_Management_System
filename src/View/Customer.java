package View;
import java.sql.*;
import DBController.*;
import Model.*;

public class Customer {
    
    //creating object for model class UserDetails
    static UserDetails userDetails = new UserDetails();
    
    void login() throws SQLException
    {
        //calling function to establish connection with DB
        DBLoader.establishConnection(); 
        
        Util.printToConsole("Enter the user ID : ");
        String userID = Util.scanString(); //calling function to scan the input String from user
        userDetails.setUserID(userID);

        Util.printToConsole("Enter password : ");
        String userPassword = Util.scanString();
        userDetails.setUserPassword(userPassword);

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
    public static void customerUseCases() throws SQLException
    {
        Util.printToConsole("Choose from options below to perform the operation : \n1. Deposit\n2. Withdraw\n3. Display current balance\n4. Update account\n5. Display account");
        int choice = Util.scanInt();

        switch(choice)
        {
            case 1: Util.printToConsole("Enter the amount to be deposited in your account : ");
                    int depositAmount = Util.scanInt();

                    DBLoader.createStatements();
                    DBLoader.statement.executeUpdate(DBQuery.depositAmountQuery(depositAmount, userDetails.userID));
                    break;

            case 2: Util.printToConsole("Enter the amount to be withdrawn : ");
                    int withdrawAmount = Util.scanInt();

                    DBLoader.createStatements();
                    DBLoader.statement.executeUpdate(DBQuery.withdrawAmountQuery(withdrawAmount, userDetails.userID));
                    break;

            case 3: DBLoader.createStatements();
                    Util.printToConsole("Current Balance : ");
                    ResultSet resultSet = DBLoader.statement.executeQuery(DBQuery.displayCurrentBalanceQuery(userDetails.userID));
                    resultSet.next();
                    Util.printIntToConsole(resultSet.getInt(1));
                    break;

            /*case 4: DBQuery.updateAccount();
                    break;

            case 5: DBQuery.displayAccount();
                    break; */

            default: Util.printToConsole("Enter a valid option from the menu!");
        }
    } 
}
