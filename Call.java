import javax.swing.JOptionPane;
class Call extends Depowith01{
	static Depowith01 d = new Depowith01();
	private double money;
	private double wmoney;
	private double balance;

	Call(){}

	Call(double money){
	this.money = money;
	}

	Call(double money,double wmoney){
	this.money = money;
	this.wmoney = wmoney;

	}
	public void setBalance(double balance){
	this. balance= balance;
	}

	public double getBalance(){
	return balance;
	}

	public void setMoney(double money){
	this.money=money;
	}
	public double getMoney(){
	return money;
	}

	public void setWmoney(double wmoney){
	this.wmoney = wmoney;
	}
	public double getWmoney(){
	return wmoney;
	}

	public void deposit(double atm){
	
		if(atm<0 || atm<99 || atm%100!=0  ){
			JOptionPane.showMessageDialog(null,"Unable to make a transaction >please re-enter<");
			d.Deposit();
		}else{

			d.bal +=atm;

		}
	}

		public void withdrew(double o){

		if(o>balance || o<99 || o%100!=0){
			JOptionPane.showMessageDialog(null,"Unable to make a transaction");
			d.Withdrew();
		}else{
			d.bal -= o;
		}
		
	}
	
}
