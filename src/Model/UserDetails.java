package Model;

public class UserDetails {

    //declaring attributes of the table
    public String userID;
    public String userPassword;

    //contructor to initialize the attributes
    public UserDetails(String userID, String userPassword)
    {
        this.userID = userID;
        this.userPassword = userPassword;
    }
}
