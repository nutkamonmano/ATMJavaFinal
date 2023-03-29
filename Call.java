import javax.swing.JOptionPane;
class Call {
	private int money;
	private int wmoney;
	private int balance;

	Call(){}

	Call(int money){
	this.money = money;
	}

	Call(int money,int wmoney){
	this.money = money;
	this.wmoney = wmoney;

	}
	public void setBalance(int balance){
	this. balance= balance;
	}

	public int getBalance(){
	return balance;
	}

	public void setMoney(int money){
	this.money=money;
	}
	public int getMoney(){
	return money;
	}

	public void setWmoney(int wmoney){
	this.wmoney = wmoney;
	}
	public int getWmoney(){
	return wmoney;
	}

	public void deposit(int atm){
		String output = "*********Deposit********";		
		if(atm<0 || atm<100){
			JOptionPane.showMessageDialog(null,"can not");
		}


		if(atm>100){
				balance = balance + atm;
		}
	}

		public void withdrew(int o){
		int n,m,sum;
		String	output = "************withdrew**********";
				balance -= o;
		JOptionPane.showMessageDialog(null,output);
		
	}
	
}
