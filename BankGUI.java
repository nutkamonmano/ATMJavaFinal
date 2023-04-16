import javax.swing.JFrame;
import javax.swing.JLabel;

public class BankGUI extends JFrame {
    private BankAccount account1, account2;
    private JLabel balance1, balance2;

    public BankGUI(BankAccount account1, BankAccount account2) {
        this.account1 = account1;
        this.account2 = account2;

        // Create two labels to display the balances
        balance1 = new JLabel("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        balance2 = new JLabel("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        // Add the labels to the JFrame
        add(balance1);
        add(balance2);

        // Set the JFrame properties
        setTitle("Bank Accounts");
        setSize(300, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
public class Main {
    public static void main(String[] args) {
        // Create two bank accounts
        BankAccount account1 = new BankAccount("123456789", 1000);
        BankAccount account2 = new BankAccount("987654321", 500);

        // Transfer funds from account1 to account2
        account1.transfer(account2, 500);

        // Display the account balances in a JFrame
        BankGUI bankGUI = new BankGUI(account1, account2);
    }
}
