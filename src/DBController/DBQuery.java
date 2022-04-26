package DBController;

import Model.UserDetails;

public class DBQuery {

    UserDetails userDetails = new UserDetails();

    public static String loginQuery(UserDetails userDetails)
    {
        //return SQL query to perform the login operation
        String query = "SELECT * FROM " + DBConstants.userTable + " WHERE " + DBConstants.userID + " = '" + userDetails.userID + "' AND " + DBConstants.userPassword + " = '" + userDetails.userPassword + "'";
        return query;
    }

    public static String depositAmountQuery(int depositAmount, String UserID)
    {
        String query = "UPDATE " + DBConstants.customerTransactionDetails + " SET " + DBConstants.currentBalance + " = " + DBConstants.currentBalance + " + " + depositAmount + " WHERE " + DBConstants.userID + " = '" + UserID + "'";
        return query;
    }
    
    public static String withdrawAmountQuery(int withdrawAmount, String UserID)
    {
        String query = "UPDATE " + DBConstants.customerTransactionDetails + " SET " + DBConstants.currentBalance + " = " + DBConstants.currentBalance + " - " + withdrawAmount + " WHERE " + DBConstants.userID + " = '" + UserID + "'";
        return query;
    }

    public static String displayCurrentBalanceQuery(String UserID)
    {
        String query = "SELECT " + DBConstants.currentBalance + " FROM " + DBConstants.customerTransactionDetails + " WHERE " + DBConstants.userID + " = '" + UserID + "'";
        return query;
    }
}
