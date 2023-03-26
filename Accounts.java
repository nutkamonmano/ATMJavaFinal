class Accounts {
    static final int ACC_SIZE = 10;
    
    static Accounts []acc = new Accounts[10];

    public static void main(String[] args){
        double bal1 = 25000;
        acc[0] = new Accounts("651435", "Nutkamon Manosatcharak", bal1);
        System.out.println(acc[0]);
    }

    Accounts(){}
    Accounts(String accID, String accName, Double balance){
        this.accID = accID;
        this.accName = accName;
        this.balance = balance;
    }

    //Attributes and Operators Below
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
