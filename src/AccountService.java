public class AccountService {

    public void withdraw(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance");
            return;
        }

        user.setBalance(user.getBalance() - amount);
        user.transactionsList.add(new Transaction("Withdrawal", amount));
        System.out.println("Withdrawal successful. Balance: " + user.getBalance());
    }

    public void deposit(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        user.setBalance(user.getBalance() + amount);
        user.transactionsList.add(new Transaction("Deposit", amount));
        System.out.println("Deposit successful. Balance: " + user.getBalance());
    }

    public boolean transfer(User user, User userToTransfer, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance");
            return false;
        }

        user.setBalance(user.getBalance() - amount);
        user.transactionsList.add(new Transaction("Transfer sent", amount));

        userToTransfer.setBalance(userToTransfer.getBalance() + amount);
        userToTransfer.transactionsList.add(new Transaction("Transfer received", amount));
        return true;

    }

}
