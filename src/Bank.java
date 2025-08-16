import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, User> users = new HashMap<>();

    public Bank() {
        users.put("user123", new User("user123", "123",
                0.0, new ArrayList<>()));
        users.put("user456", new User("user456", "456",
                0.0, new ArrayList<>()));
        users.put("user789", new User("user789", "789",
                0.0, new ArrayList<>()));
    }

    public boolean validation(String inputUserId, String inputUserPin){
        User user = users.get(inputUserId);

        return user != null && user.getUserPin().equals(inputUserPin);

    }

    public User getUser(String userId){
        return users.get(userId);
    }

}
