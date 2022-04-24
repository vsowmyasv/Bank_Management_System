package DBController;

import Model.UserDetails;
// include DBConstants class for tables, columns
public class DBQuery {

    UserDetails userDetails = new UserDetails();

    public static String loginQuery(UserDetails userDetails)
    {
        //return SQL query to perform the login operation
        String str = "SELECT * FROM UserDetails WHERE '" + DBConstants.userID + "' LIKE %'" + userDetails.userID + "'% AND '" + DBConstants.userPassword + "'  LIKE %'" + userDetails.userPassword + "'%";
        return str;
    }
}
