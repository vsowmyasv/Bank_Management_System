package DBController;
import java.sql.*;
import View.Util;

public class DBLoader {
    
    public static Connection connection;
    public static Statement statement;

    public static void establishConnection()
    {
        try {
        //establishing connection using JDBC, try-catch
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK_MANAGEMENT_SYSTEM", "root", "mySQL313");
        }
        catch(SQLException e){
            Util.print("Error in connection establishment "+e);
        }
    }
    public static void createStatements()
    {
        try{
        // creating statement object
        statement = connection.createStatement();
        }
        catch(SQLException e) 
        {
            Util.print("Error in creating the statement for execution "+e);
        }
    }
    public static void closeConnection()
    {
        try{
        // closing connection
        connection.close();
        }
        catch(SQLException e)
        {
            Util.print("Error in closing the connection "+e);;
        }
    }
}
