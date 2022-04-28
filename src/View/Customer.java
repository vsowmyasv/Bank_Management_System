package View;
import java.sql.*;
import DBController.*;
import Model.*;

public class Customer {
    
    //creating object for model class UserDetails
    static UserDetails userDetails = new UserDetails();
    static CustomerTransactionDetails customerTransactionDetails = new CustomerTransactionDetails();
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
        Util.printToConsole("Choose from options below to perform the operation : \n1. Deposit\n2. Withdraw\n3. Display current balance\n4. Update account\n5. Display account  ");
        int choice = Util.scanInt();

        CustomerUseCases customerUseCases = new CustomerUseCases();

        switch(choice)
        {
            case 1: Util.printToConsole("Enter the amount to be deposited in your account : ");
                    customerTransactionDetails.setTransactionAmount(Util.scanInt());

                    ResultSet currentBalanceBeforeDeposit = DBLoader.statement.executeQuery(DBQuery.displayCurrentBalanceQuery(userDetails.getUserID()));

                    currentBalanceBeforeDeposit.next();
                    customerTransactionDetails.setCurrentBalance(currentBalanceBeforeDeposit.getInt(1) + customerTransactionDetails.getTransactionAmount());
                    
                    customerTransactionDetails.setTransactionType("Deposit");
                    customerTransactionDetails.setTransactionDate(java.time.LocalDate.now());
                    customerTransactionDetails.setTransactionTime(java.time.LocalTime.now());

                    DBLoader.statement.executeUpdate(DBQuery.TransactionUpdate(userDetails, customerTransactionDetails));

                    Util.printToConsole("Amount Deposited !!");
                    break;

            case 2: Util.printToConsole("Enter the amount to be withdrawn : ");
                    customerTransactionDetails.setTransactionAmount(Util.scanInt());

                    ResultSet currentBalanceBeforeWithdraw = DBLoader.statement.executeQuery(DBQuery.displayCurrentBalanceQuery(userDetails.getUserID()));

                    currentBalanceBeforeWithdraw.next();
                    customerTransactionDetails.setCurrentBalance(currentBalanceBeforeWithdraw.getInt(1) - customerTransactionDetails.getTransactionAmount());
                    
                    customerTransactionDetails.setTransactionType("Withdraw");
                    customerTransactionDetails.setTransactionDate(java.time.LocalDate.now());
                    customerTransactionDetails.setTransactionTime(java.time.LocalTime.now());

                    DBLoader.statement.executeUpdate(DBQuery.TransactionUpdate(userDetails, customerTransactionDetails));

                    Util.printToConsole("Amount Withdrawn !!");
                    break;

            case 3: DBLoader.createStatements();
                    Util.printToConsole("Current Balance : ");
                    ResultSet resultSet = DBLoader.statement.executeQuery(DBQuery.displayCurrentBalanceQuery(userDetails.getUserID()));
                    resultSet.next();
                    Util.printIntToConsole(resultSet.getInt(1));
                    break;

            case 4: Util.printToConsole("Enter the field you want to update \n1. Name\n2. Address\n3. Contact number");
                    int updateChoice = Util.scanInt();                    
                    customerUseCases.customerUpdate(updateChoice, userDetails);

                    DBLoader.createStatements();
                    
                    break;

            case 5: ResultSet resultSet2 = DBLoader.statement.executeQuery(DBQuery.displayAccountDetails(userDetails));
                    while(resultSet2.next())
                    Util.printToConsole(resultSet2.getString(1) + resultSet2.getString(2) + resultSet2.getString(3) + resultSet2.getString(4) + resultSet2.getString(5));
                    break; 

            default: Util.printToConsole("Enter a valid option from the menu!");
        }
    } 
}
