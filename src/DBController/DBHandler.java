package DBController;

import java.sql.*;

import View.Util;

public class DBHandler {
    //function to check if the input credentials are valid
    public static void checkIfLoginExists(ResultSet resultSet)
    {
        int check = 0;
        try
        {
            if(resultSet.next()) // checking if the query returns atleast 1 row
            {
                check = 1;
            }
            else
            {
                check = 0;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(check == 1)
        Util.printToConsole("Logged in successfully");
        else
        Util.printToConsole("Invalid Login");
    }
}