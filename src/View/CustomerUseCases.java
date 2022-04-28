package View;

import Model.CustomerBasicDetails;

public class CustomerUseCases
{
    CustomerBasicDetails customerBasicDetails = new CustomerBasicDetails();
    public void customerUpdate(int choice, String userID)
    {
        switch (choice) {
            case 1: Util.printToConsole("Enter new name to update : ");
                    customerBasicDetails.setCustomerName(Util.scanString());

                    updatePersonalDetailsString(userID, customerBasicDetails.getCustomerName());
                
                break;
        
            default:
                break;
        }
    }
    
}
