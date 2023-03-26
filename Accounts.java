class Accounts {
    static final int acc_size = 10;
    static int countA = 0;
    
    static Accounts []A = new Accounts[acc_size];

    public static void main(String[] args){
        A[1] = new Accounts("651435", "Nutkamon Manosatcharak");
        System.out.println(A[1]);
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
