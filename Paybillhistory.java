public class Paybillhistory extends Accounts{
    public String billdate;
    public String getBilldate() {
        return billdate;
    }
    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }
    public String billtype;
    public String getBilltype() {
        return billtype;
    }
    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }
    public double amount;
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    Paybillhistory(){}

    Paybillhistory(String billdate, String billtype, double amount){
        this.billdate = billdate;
        this.billtype = billtype;
        this.amount = amount;
    }
}