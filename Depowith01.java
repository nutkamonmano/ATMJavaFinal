import java.util.*;
import javax.swing.JOptionPane;
public class Depowith01 {
	static Depowith01 d = new Depowith01();
	static Call c = new Call();

	public static void main(String[] args){
	int ch;
		ch=manu();
		do{
			switch(ch){
				case 1 : d.Deposit(); break;
				case 2 : d.showdeposit(); break;
				case 3 : d.Withdrew(); break;
				case 4 : d.showwithdrew(); break;
				case 0 :break;

			}

		ch=manu();

		}while(ch!=0);

	}

	public static int manu(){
	int ch = Integer.parseInt(JOptionPane.showInputDialog("********Deposit********"
														+"\n    1.Inputdeposit    "
														+"\n    2.Show			  "));

									return ch;


	}





	public  void Deposit(){
		int money;
		money = Integer.parseInt(JOptionPane.showInputDialog("Enter Deposit"));
		c.deposit(money);

		}

	public void showdeposit(){
		
			JOptionPane.showMessageDialog(null,"Deposit"+c.getBalance());
}

	public void Withdrew(){
		int wmoney;
		wmoney = Integer.parseInt(JOptionPane.showInputDialog("Enter Withdrew"));
		c.withdrew(wmoney);

		}

	public void showwithdrew(){
	
		JOptionPane.showMessageDialog(null,"Withdrew"+c.getBalance());
		
	}


		



}


 

	

