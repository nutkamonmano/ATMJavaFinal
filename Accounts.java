public class Accounts{
    Accounts(){}
    // Accounts(String accID, String accName, Double balance){
    //     this.accID = accID;
    //     this.accName = accName;
    //     this.balance = balance;
    // }

    Accounts(String accID, String accName, String password){
        this.accID = accID;
        this.accName = accName;
        this.password = password;
    }

    //Attributes and Operators Below
    protected String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    protected String accID;
    public String getAccID() {
        return accID;
    }
    public void setAccID(String accID) {
        this.accID = accID;
    }

    protected String accName;
    public String getAccName() {
        return accName;
    }
    public void setAccName(String accName) {
        this.accName = accName;
    }

    protected double balance;
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
