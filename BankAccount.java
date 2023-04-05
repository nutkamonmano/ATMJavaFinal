public class BankAccount {
    private String accountNumber; // The account number for the bank account
    private double balance; // The current balance of the bank account

    // Constructor for the bank account
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter method for the account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method for the current balance
    public double getBalance() {
        return balance;
    }

    // Method for depositing funds into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method for withdrawing funds from the account
    public void withdraw(double amount) {
        balance -= amount;
    }

    // Method for transferring funds from this account to another account
    public void transfer(BankAccount destination, double amount) {
        if (balance >= amount) { // Check if the account has sufficient funds to make the transfer
            withdraw(amount); // Withdraw the specified amount from this account
            destination.deposit(amount); // Deposit the specified amount into the destination account
            System.out.println(amount + " transferred from account " + accountNumber + " to account " + destination.getAccountNumber()); // Print a message to the console indicating the transfer was successful
        } else {
            System.out.println("Insufficient funds to transfer " + amount + " from account " + accountNumber + " to account " + destination.getAccountNumber()); // Print a message to the console indicating the transfer was unsuccessful due to insufficient funds
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create two bank accounts
        BankAccount account1 = new BankAccount("123456789", 1000);
        BankAccount account2 = new BankAccount("987654321", 500);

        // Transfer funds from account1 to account2
        account1.transfer(account2, 500);

        // Print the balances of the two accounts after the transfer is complete
        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());
    }
}
