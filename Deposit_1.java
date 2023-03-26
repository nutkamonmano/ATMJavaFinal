import javax.swing.JOptionPane;
class Deposit_1 {
	static Deposit_1 D = new Deposit_1();
	static Bank DBeht,WBeht;
	static int count=0;
	
	public static void main(String[] args){
		int ch;
		ch=D.manu();
		do{
			switch(ch){
				case 1 : D.Inputdeposit(); break;
				case 2 : D.show(); break;
				case 0 :break;


			}

		ch=D.manu();

		}while(ch!=0);


	}


	public int manu(){
	int ch = Integer.parseInt(JOptionPane.showInputDialog("********Deposit********"
														+"\n    1.Inputdeposit    "
														+"\n    2.Show			  "));

									return ch;


	}


	public void Inputdeposit(){
	int d;
	d = Integer.parseInt(JOptionPane.showInputDialog("Input deposit"));
	DBeht = new Deposit(d);
	}
	
	public void show(){
	String output = "********Deposit********";
	output += "\n Deposit" + Deposit.caldeposit();
	JOptionPane.showMessageDialog(null,output);
	
	}


}
