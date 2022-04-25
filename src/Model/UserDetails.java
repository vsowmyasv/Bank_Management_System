package Model;

public class UserDetails {

    //declaring attributes of the table
    public String userID;
    public String userPassword;

    //declaring getter and setter methods
    public UserDetails(String userID, String userPassword)
    {
        this.userID = userID;
        this.userPassword = userPassword;
    }
    public String getUserID() {
        return userID;
    }
    public String getUserPassword() {
        return userPassword;
    }
}
