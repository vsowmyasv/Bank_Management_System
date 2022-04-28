package DBController;

public class DBConstants {
    // defining constants for DB tables
    final static String userTable = "UserDetails";
    final static String userID = "UserID";                  //primary key
    final static String userPassword = "UserPassword";
    
    final static String customerBasicDetails = "CustomerBasicDetails";
    final static String customerName = "CustomerName";
    final static String customerAddress = "CustomerAddress";
    final static String customerContactNumber = "CustomerContactNumber";
    final static String accountNumber = "AccountNumber";

    final static String customerAccountDetails = "CustomerAccountDetails";
    final static String panNumber = "PanNumber";
    final static String accountType = "AccountType";

    final static String customerTransactionDetails = "CustomerTransactionDetails";
    final static String transactionAmount = "TransactionAmount";
    final static String transactionType = "TransactionType";
    final static String transactionDate = "TransactionDate";
    final static String transactionTime = "TransactionTime";
    final static String currentBalance = "currentBalance";

}
