package DBController;

import java.sql.*;

public class DBHandler {
    public static void checkIfLoginExists(ResultSet resultSet)
    {
        int check = 0;
        try {
        check = resultSet.getInt("LOGIN");
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        //checking if query is returning atleast 1 login
        // move to userDBHandler
        if(check >= 1)
        System.out.println("Logged in successfully"); 

        else
        System.out.println("Invalid Login"); 

    }
}