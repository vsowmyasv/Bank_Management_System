package DBController;

import java.sql.*;

import View.Util;

public class DBHandler {
    //function to check if the input credentials are valid
    public static void checkIfLoginExists(ResultSet resultSet)
    {
        try
        {
            if(resultSet.next()) // checking if the query returns atleast 1 row
            {
                Util.printToConsole("Logged in successfully");
            }
            else
            {
                Util.printToConsole("Invalid Login");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}