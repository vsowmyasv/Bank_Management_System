package DBController;

import Model.UserDetails;

public class DBQuery {

    UserDetails userDetails = new UserDetails();

    public static String loginQuery(UserDetails userDetails)
    {
        //return SQL query to perform the login operation
        String query = "SELECT * FROM " + DBConstants.userTable + " WHERE " + DBConstants.userID + " = '" + userDetails.getUserID() + "' AND " + DBConstants.userPassword + " = '" + userDetails.getUserPassword() + "'";
        return query;
    }
}
