package DBController;

import java.sql.*;

public class DBHandler {
    public static void checkIfLoginExists(ResultSet resultSet)
    {
        int check = 0;
        try
        {
            if(resultSet.next())
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
        System.out.println("Logged in successfully");
        else
        System.out.println("Invalid Login");
    }
}