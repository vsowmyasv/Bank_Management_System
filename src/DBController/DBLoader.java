package DBController;
import java.sql.*;

public class DBLoader {
    
    static Connection connection;
    public static Statement statement;

    public static void establishConnection()
    {
        try {
        //establishing connection using JDBC, try-catch
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK_MANAGEMENT_SYSTEM", "root", "mySQL313");
        }
        catch(SQLException e){
            System.out.println("Error in connection establishment "+e);
        }
    }
    public static void createStatements()
    {
        try{
        statement = connection.createStatement();

        }
        catch(SQLException e) 
        {
            System.out.println("Error in creating the statement for execution "+e);
        }
    }
    public static void closeConnection()
    {
        try{
        connection.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error in closing the connection "+e);;
        }
    }
}
