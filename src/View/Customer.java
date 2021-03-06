package View;

import java.sql.*;
import DBController.*;
import Model.*;

public class Customer {

        // creating object for model classes
        static UserDetails userDetails = new UserDetails();
        static CustomerTransactionDetails customerTransactionDetails = new CustomerTransactionDetails();

        void login() {
                // calling function to establish connection with DB
                DBLoader.establishConnection();

                Util.printToConsole("Enter the user ID : ");
                String userID = Util.scanString(); // calling function to scan the input String from user
                userDetails.setUserID(userID);

                Util.printToConsole("Enter password : ");
                String userPassword = Util.scanString();
                userDetails.setUserPassword(userPassword);

                // fetching query
                String query = DBQuery.customerLoginQuery(userDetails);

                // executing query
                DBLoader.createStatements();
                try {
                        ResultSet resultSet = DBLoader.statement.executeQuery(query);

                        // calling the function to check whether the input credentials are valid
                        DBHandler.checkIfLoginExistsCustomer(resultSet);
                } catch (SQLException e) {
                        Util.printToConsole("Couldn't execute query : " + e);
                }

                // calling the function to close the connection
                DBLoader.closeConnection();
        }

        public static void customerUseCases() {
                Util.printToConsole(
                                "Choose from options below to perform the operation : \n1. Deposit\n2. Withdraw\n3. Display current balance\n4. Update account\n5. Display account  ");
                int choice = Util.scanInt();

                CustomerUseCases customerUseCases = new CustomerUseCases();

                switch (choice) {
                        case 1:
                                Util.printToConsole("Enter the amount to be deposited in your account : ");
                                customerTransactionDetails.setTransactionAmount(Util.scanInt());
                                try {
                                        ResultSet currentBalanceBeforeDeposit = DBLoader.statement.executeQuery(
                                                        DBQuery.displayCurrentBalanceQuery(userDetails.getUserID()));
                                        currentBalanceBeforeDeposit.next();
                                        customerTransactionDetails.setCurrentBalance(currentBalanceBeforeDeposit
                                                        .getInt(1) + customerTransactionDetails.getTransactionAmount());
                                } catch (SQLException e) {
                                        Util.printToConsole("Couldn't execute query");
                                }

                                customerTransactionDetails.setTransactionType("Deposit");
                                customerTransactionDetails.setTransactionDate(java.time.LocalDate.now());
                                customerTransactionDetails.setTransactionTime(java.time.LocalTime.now());

                                try {
                                        DBLoader.statement.executeUpdate(DBQuery.TransactionUpdate(userDetails,
                                                        customerTransactionDetails));
                                } catch (SQLException e) {
                                        Util.printToConsole("Couldn't update the column");
                                }

                                Util.printToConsole("Amount Deposited !!");
                                break;

                        case 2:
                                Util.printToConsole("Enter the amount to be withdrawn : ");
                                customerTransactionDetails.setTransactionAmount(Util.scanInt());

                                try {
                                        ResultSet currentBalanceBeforeWithdraw = DBLoader.statement.executeQuery(
                                                        DBQuery.displayCurrentBalanceQuery(userDetails.getUserID()));

                                        if(currentBalanceBeforeWithdraw.getInt(1) < customerTransactionDetails.getTransactionAmount())
                                        {
                                                Util.printToConsole("Cannot withdraw! You do not have sufficient amount to withdraw this amount!! ");
                                        }
                                        currentBalanceBeforeWithdraw.next();
                                        customerTransactionDetails.setCurrentBalance(currentBalanceBeforeWithdraw
                                                        .getInt(1) - customerTransactionDetails.getTransactionAmount());
                                        Util.printToConsole("Amount Withdrawn !!");
                                } catch (SQLException e) {
                                        Util.printToConsole("Cannot withdraw !! You do not have sifficient funds!!");
                                }
                                customerTransactionDetails.setTransactionType("Withdraw");
                                customerTransactionDetails.setTransactionDate(java.time.LocalDate.now());
                                customerTransactionDetails.setTransactionTime(java.time.LocalTime.now());

                                try {
                                        DBLoader.statement.executeUpdate(DBQuery.TransactionUpdate(userDetails,
                                                        customerTransactionDetails));
                                } catch (SQLException e) {
                                        Util.printToConsole("Couldn't update transaction");
                                }

                                break;

                        case 3:
                                DBLoader.createStatements();
                                Util.printToConsole("Current Balance : ");

                                try {
                                        ResultSet resultSet = DBLoader.statement.executeQuery(
                                                        DBQuery.displayCurrentBalanceQuery(userDetails.getUserID()));
                                        resultSet.next();
                                        Util.printIntToConsole(resultSet.getInt(1));
                                } catch (SQLException e) {
                                        Util.printToConsole("Couldn't fetch current balance");
                                }
                                break;

                        case 4:
                                Util.printToConsole(
                                                "Enter the field you want to update \n1. Name\n2. Address\n3. Contact number");
                                int updateChoice = Util.scanInt();
                                try {
                                        customerUseCases.customerUpdate(updateChoice, userDetails);
                                } catch (Exception e) {
                                        Util.printToConsole("Couldn't update your new details");
                                }

                                DBLoader.createStatements();

                                break;

                        case 5:
                                try {
                                        ResultSet resultSet2 = DBLoader.statement
                                                        .executeQuery(DBQuery.displayAccountDetails(userDetails));
                                        while (resultSet2.next())
                                                Util.printToConsole(resultSet2.getString(1) + " "
                                                                + resultSet2.getString(2) + " " +
                                                                resultSet2.getString(3) + " " + resultSet2.getString(4)
                                                                + " " + resultSet2.getString(5));
                                } catch (SQLException e) {
                                        Util.printToConsole("Couldn't fetch your details!");
                                }

                                break;

                        default:
                                Util.printToConsole("Enter a valid option from the menu!");
                }
        }
}
