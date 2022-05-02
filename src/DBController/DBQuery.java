package DBController;

import Model.CustomerTransactionDetails;
import Model.UserDetails;

public class DBQuery {

    UserDetails userDetails = new UserDetails();

    public static String customerLoginQuery(UserDetails userDetails) {
        // return SQL query to perform the login operation
        return "SELECT * FROM " + DBConstants.userTable + " WHERE " + DBConstants.userID + " = '"
                + userDetails.getUserID() + "' AND " + DBConstants.userPassword + " = '" + userDetails.getUserPassword()
                + "' AND '" + userDetails.getUserID() + "' LIKE 'C%'";
    }

    public static String adminLoginQuery(UserDetails userDetails) {
        // return SQL query to perform the login operation
        return "SELECT * FROM " + DBConstants.userTable + " WHERE " + DBConstants.userID + " = '"
                + userDetails.getUserID() + "' AND " + DBConstants.userPassword + " = '" + userDetails.getUserPassword()
                + "' AND '" + userDetails.getUserID() + "' LIKE 'A%'";
    }

    public static String TransactionUpdate(UserDetails userDetails,
            CustomerTransactionDetails customerTransactionDetails) {
        String accNumber = "ASDBGD56463";
        return "INSERT INTO " + DBConstants.customerTransactionDetails + " VALUES( '" + userDetails.getUserID()
                + "' , '" + accNumber + "' , " + customerTransactionDetails.getTransactionAmount() + " , '"
                + customerTransactionDetails.getTransactionType() + "' , '"
                + customerTransactionDetails.getTransactionDate() + "' , '"
                + customerTransactionDetails.getTransactionTime() + "' , "
                + customerTransactionDetails.getCurrentBalance() + " )";
    }

    public static String displayCurrentBalanceQuery(String UserID) {
        return "SELECT " + DBConstants.currentBalance + " FROM " + DBConstants.customerTransactionDetails + " WHERE "
                + DBConstants.userID + " = '" + UserID + "' ORDER BY " + DBConstants.transactionDate + " DESC ,"
                + DBConstants.transactionTime + " DESC LIMIT 1 ";
    }

    public static String updatePersonalDetailsName(UserDetails userDetails, String newName) {
        String query = "UPDATE " + DBConstants.customerPersonalDetails + " SET " + DBConstants.customerName + " = '"
                + newName + "' WHERE " + DBConstants.userID + " = '" + userDetails.getUserID() + "' ";
        return query;
    }

    public static String updatePersonalDetailsAddress(UserDetails userDetails, String newAddress) {
        String query = "UPDATE " + DBConstants.customerPersonalDetails + " SET " + DBConstants.customerAddress + " = '"
                + newAddress + "' WHERE " + DBConstants.userID + " = '" + userDetails.getUserID() + "' ";
        return query;
    }

    public static String updatePersonalDetailsContactNumber(UserDetails userDetails, String newContactNumber) {
        String query = "UPDATE " + DBConstants.customerPersonalDetails + " SET " + DBConstants.customerContactNumber
                + " = " + newContactNumber + " WHERE " + DBConstants.userID + " = '" + userDetails.getUserID() + "' ";
        return query;
    }

    public static String displayAccountDetails(UserDetails userDetails) {
        String query = "SELECT * FROM " + DBConstants.customerPersonalDetails + " WHERE " + DBConstants.userID + " = '"
                + userDetails.getUserID() + "' ";
        return query;
    }
}
