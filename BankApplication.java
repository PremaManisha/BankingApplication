package bankapplication;
import java.util.Scanner;
class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✔ Deposit Successful!");
        } else {
            System.out.println("❌ Invalid Amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✔ Withdrawal Successful!");
        } else {
            System.out.println("❌ Insufficient Balance or Invalid Amount!");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }

    // Display account details
    @Override
    public String toString() {
        return "Account Holder: " + accountHolderName +
               "\nAccount Number: " + accountNumber +
               "\nCurrent Balance: " + balance;
    }
}
public class BankingApplication {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Creating a demo account
	        BankAccount account = new BankAccount("John Doe", "AC1001", 5000);

	        int choice;

	        do {
	            System.out.println("\n===== Banking Application System =====");
	            System.out.println("1. View Account Details");
	            System.out.println("2. Check Balance");
	            System.out.println("3. Deposit Money");
	            System.out.println("4. Withdraw Money");
	            System.out.println("5. Exit");
	            System.out.print("Enter Choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1 -> System.out.println("\n" + account);
	                case 2 -> System.out.println("💲 Current Balance: " + account.getBalance());
	                case 3 -> {
	                    System.out.print("Enter Amount to Deposit: ");
	                    double amount = sc.nextDouble();
	                    account.deposit(amount);
	                }
	                case 4 -> {
	                    System.out.print("Enter Amount to Withdraw: ");
	                    double amount = sc.nextDouble();
	                    account.withdraw(amount);
	                }
	                case 5 -> System.out.println("🚪 Exiting Application... Thank You!");
	                default -> System.out.println("❌ Invalid Choice! Try Again.");
	            }

	        } while (choice != 5);

	        sc.close();
	    }
	}