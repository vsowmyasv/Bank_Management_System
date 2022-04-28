package View;

import java.sql.SQLException;

import DBController.*;
import Model.*;

public class CustomerUseCases
{
    CustomerPersonalDetails customerPersonalDetails = new CustomerPersonalDetails();
    public void customerUpdate(int choice, UserDetails userDetails) throws SQLException
    {
        switch (choice) {
            case 1: Util.printToConsole("Enter new name to update : ");
                    customerPersonalDetails.setCustomerName(Util.scanString());

                    DBLoader.statement.executeUpdate(DBQuery.updatePersonalDetailsName(userDetails, customerPersonalDetails.getCustomerName()));
                    
                    break;

            case 2: Util.printToConsole("Enter new address to update : ");
                    customerPersonalDetails.setCustomerAddress(Util.scanStringLine());

                    DBLoader.statement.executeUpdate(DBQuery.updatePersonalDetailsAddress(userDetails, customerPersonalDetails.getCustomerAddress()));

                    break;
        
            default:
                break;
        }
    }
    
}
