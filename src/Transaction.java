import java.time.LocalDateTime;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime localDateTime;
    private final String fromUserId;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.localDateTime = LocalDateTime.now();
        this.fromUserId = null;
    }

    @Override
    public String toString() {
        if ("Transfer received".equals(type) && fromUserId != null) {
            return type + " of Rs. " + amount + "from " + fromUserId
                    + " on " + localDateTime;
        }
        return type + " of Rs. " + amount + " on " + localDateTime;
    }

}
