package View;

import java.sql.SQLException;

import DBController.*;
import Model.*;

public class CustomerUseCases {
    CustomerPersonalDetails customerPersonalDetails = new CustomerPersonalDetails();

    public void customerUpdate(int choice, UserDetails userDetails) {
        switch (choice) {
            case 1:
                Util.printToConsole("Enter new name to update : ");
                customerPersonalDetails.setCustomerName(Util.scanString());

                try {
                    DBLoader.statement.executeUpdate(
                            DBQuery.updatePersonalDetailsName(userDetails, customerPersonalDetails.getCustomerName()));
                } catch (SQLException e) {
                    Util.printToConsole("Couldn't update your new name!!");
                }

                break;

            case 2:
                Util.printToConsole("Enter new address to update : ");
                customerPersonalDetails.setCustomerAddress(Util.scanStringLine());

                try {
                    DBLoader.statement.executeUpdate(DBQuery.updatePersonalDetailsAddress(userDetails,
                            customerPersonalDetails.getCustomerAddress()));
                } catch (SQLException e) {
                    Util.printToConsole("Couldn't update your new address!");
                }

                break;

            case 3:
                Util.printToConsole("Enter new contact number to update : ");
                customerPersonalDetails.setCustomerContactNumber(Util.scanString());

                try {
                    DBLoader.statement.executeUpdate(DBQuery.updatePersonalDetailsContactNumber(userDetails,
                            customerPersonalDetails.getCustomerContactNumber()));
                } catch (SQLException e) {
                    Util.printToConsole("Couldn't update your new contact number!");
                }

                break;

            default:
                Util.printToConsole("Enter a valid option from the menu !!");
                break;
        }
    }
}
