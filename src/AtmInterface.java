import java.util.List;
import java.util.Scanner;

public class AtmInterface {
    public static void main(String[] args) {
        System.out.println("Welcome to ATM");
        Scanner scan = new Scanner(System.in);
        AccountService accountService = new AccountService();
        Bank bank = new Bank();
        User user = new User();


        int option;
        int attempt = 3;

        while (attempt > 0) {
            System.out.println("User ID: ");
            String userId = scan.nextLine();
            System.out.println("User PIN: ");
            String userPin = scan.nextLine();


            if (bank.validation(userId, userPin)) {
                user = bank.getUser(userId);
                break;
            } else {
                attempt--;
                System.out.println("Invalid user id and pin. Remaining attempt: " + attempt);
            }
        }

        if (user == null) {
            System.out.println("Too many attempts. Exiting... ");
            return;
        }

        System.out.println("Login successful. Welcome " + user.getUserId() +"!");

        do {
            System.out.println("Menu");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Switch account");
            System.out.println("6. Close ATM");

            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1: {
                    //transaction history
                    List<Transaction> userTransactionsList = user.getTransactionsList();
                    if (userTransactionsList.isEmpty()) System.out.println("No transactions yet");
                    else {
                        for (Transaction l : userTransactionsList) {
                            System.out.println(l);
                        }
                    }
                    break;
                }
                case 2: {
                    //withdrawal
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scan.nextDouble();
                    accountService.withdraw(user, withdrawalAmount);
                    break;
                }
                case 3: {
                    //deposit
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scan.nextDouble();
                    accountService.deposit(user, depositAmount);
                    break;
                }
                case 4: {
                    //transfer
                    System.out.print("Enter the amount you want to transfer: ");
                    double transferAmount = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("To which user ID you want to transfer: ");
                    String transferUserId = scan.nextLine();

                    User userIdToTransfer = bank.getUser(transferUserId);

                    if (userIdToTransfer == null) System.out.println("No user found");
                    else {
                        boolean transfer = accountService.transfer(user, userIdToTransfer, transferAmount);
                        if (transfer) {
                            System.out.println("Transfer successful. Balance: " + user.getBalance());
                        } else {
                            System.out.println("Transfer failed");
                        }
                    }
                    break;
                }
                case 5: {
                    //Switch account
                    int a = 3;
                    User switchedUser = null;

                    while (a > 0) {
                        System.out.println("User ID: ");
                        String userId = scan.nextLine();
                        System.out.println("User PIN: ");
                        String userPin = scan.nextLine();


                        if (bank.validation(userId, userPin)) {
                            switchedUser = bank.getUser(userId);
                            break;
                        } else {
                            a--;
                            System.out.println("Invalid user id and pin. Remaining attempt: " + a);
                        }
                    }

                    if (switchedUser == null) {
                        System.out.println("Failed to switch user after 3 attempts. ");
                    }else {
                        user = switchedUser;
                        System.out.println("Switches successfully. Welcome! " + switchedUser.getUserId());
                    }
                    break;
                }
                case 6: {
                    System.out.println("Closing ATM...");
                    break;
                }
                default:
                    System.out.println("Enter a valid number");
            }

        } while (option != 6);
    }

}