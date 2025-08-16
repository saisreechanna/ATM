import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String userPin;
    private Double balance;
    List<Transaction> transactionsList = new ArrayList<>();

    public User(){

    }

    public User(String userId, String userPin, Double balance,
                List<Transaction> transactionsList) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
        this.transactionsList = transactionsList;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionsList() {
        return transactionsList;
    }

}
