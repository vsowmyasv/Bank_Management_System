package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CustomerTransactionDetails {

    String userID, transactionType, accountNumber;
    LocalDate transactionDate;
    LocalTime transactionTime;
    int transactionAmount, currentBalance;
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    public LocalTime getTransactionTime() {
        return transactionTime;
    }
    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }
    public int getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public int getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
    
    
}
