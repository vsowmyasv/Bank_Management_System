package DBController;

import Model.UserDetails;
// include DBConstants class for tables, columns
public class DBQuery {

    UserDetails userDetails = new UserDetails();

    public static String loginQuery(UserDetails userDetails)
    {
        //return SQL query to perform the login operation
        String str = "SELECT COUNT(*) AS LOGIN FROM USERDETAILS WHERE UserID = '" + userDetails.userID + "' AND UserPassword = '" + userDetails.userPassword + "'";
        return str;
    }
}
