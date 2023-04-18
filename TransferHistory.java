import java.text.SimpleDateFormat;
import java.util.Date;

public class TransferHistory extends Transfer{
    private String senderAccountNumber; // the sender's account number
    private String receiverAccountNumber; // the receiver's account number
    private double amount; // the amount transferred
    private String transferDate; // the date and time of the transfer

    // constructor
    public TransferHistory(String senderAccountNumber, String receiverAccountNumber, double amount) {
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;

        // set the transfer date and time to the current date and time
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.transferDate = formatter.format(currentDate);
    }

    // getter and setter methods for sender account number
    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }
    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    // getter and setter methods for receiver account number
    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }
    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    // getter and setter methods for amount
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // getter and setter methods for transfer date
    public String getTransferDate() {
        return transferDate;
    }
    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    // override the toString method to print out the transfer history
    @Override
    public String toString() {
        return "Transfer from " + senderAccountNumber + " to " + receiverAccountNumber + " on " + transferDate + ": " + amount;
    }
}
