package Model;

public class UserDetails {

    //declaring attributes of the table
    // public variables - no static 
    public String userID;
    public String userPassword;

    //declaring getter and setter methods
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) { // add only if neccessary
        this.userID = userID;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
