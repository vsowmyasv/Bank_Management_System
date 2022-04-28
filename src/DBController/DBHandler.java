package DBController;

import java.sql.*;

import View.Customer;
import View.Util;

public class DBHandler {

    static Customer customer = new Customer();

    // function to check if the input credentials are valid
    public static void checkIfLoginExists(ResultSet resultSet) {
        try {
            if (resultSet.next()) // checking if the query returns atleast 1 row
            {
                Util.printToConsole("Logged in successfully\n");
                Customer.customerUseCases();
            } else {
                Util.printToConsole("Invalid Login");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}