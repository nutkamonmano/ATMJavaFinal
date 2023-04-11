import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Depowith01 extends MainATM{
	static Depowith01 d = new Depowith01();
	static Call c = new Call();
	int dpsize = 0;
	Depohis dphistory[] = new Depohis[dpsize];

	JFrame manu = new JFrame("Main Menu");

	public static void main(String[] args){
	 d.manu();
	}

	public void manu(){
		JPanel panel1 = new JPanel();
		String Lb ="Main menu";
		JLabel label = new JLabel("<html><div style = 'text -align:center'><h1>"+Lb+"</h1></html>",SwingConstants.LEFT);

		JButton depobutton = new JButton("DEPOSIT");
		JButton shdepobutton = new JButton("Showdeposit");
		JButton withbutton = new JButton("WITHDRAW");
		JButton shwithbutton = new JButton("SHOWWITHDRAW");
		JButton exbutton = new JButton("Quit");
		
		panel1.setLayout(new GridLayout(5,1));

		panel1.add(depobutton);
		panel1.add(shdepobutton);
		panel1.add(withbutton);
		panel1.add(shwithbutton);
		panel1.add(exbutton);


		manu.add(label,BorderLayout.NORTH);
		manu.add(panel1,BorderLayout.CENTER);
		
		manu.setSize(300,300);
		manu.setLocationRelativeTo(null);
		manu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manu.setVisible(true);

		depobutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				manu.dispose();
				d.Deposit();
				d.manu();
			}
		});

		shdepobutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
			manu.dispose();
			d.showdeposit();
			}
		});

		withbutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
			manu.dispose();
			d.Withdrew();
			d.manu();
			}
		});

		shwithbutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
			manu.dispose();
			d.showwithdrew();
			}
		});

		exbutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
			manu.dispose();
			}
		});

	}

	
	public void Deposit(){
		int depoIN = 0;
		do{
			depoIN = Integer.parseInt(JOptionPane.showInputDialog("How much do you want to deposit to your account?"));
			if(depoIN < 0 || depoIN < 99 || depoIN%100 != 0  ){
				JOptionPane.showMessageDialog(null,"Unable to make a transaction >please re-enter<");
			}else{
				int res = JOptionPane.showConfirmDialog(null, "Are you sure to deposit of THB "+depoIN+" ?", "Deposit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				if (res == JOptionPane.YES_OPTION){
					bal += depoIN;
					double lastBal = bal;

					Calendar d = Calendar.getInstance();
					SimpleDateFormat f = new SimpleDateFormat("dd MMMM YYYY HH:mm:ss");
					String depoDate = f.format(d.getTime());
					dphistory[dpsize] = new Depohis(depoDate, depoIN, lastBal);
					dpsize++;
				}
				// switch(res){
				// 	case JOptionPane.YES_OPTION : addDepoHistory(depoIN); break;
				// 	case JOptionPane.NO_OPTION : break;
				// }
			}
		}while(depoIN<0 || depoIN<99 || depoIN%100 != 0);
	}

	public void showdeposit(){
		String output = "**********DEPOSIT HISTORY**********";
			for(int i=0; i<dpsize; i++){
				output += "Deposit THB "+dphistory[i].getDepoIN();
				output += "Date : "+dphistory[i].getDepoDate();
				output += "Last balance since deposit : THB "+dphistory[i].getLastBal();
			}
			JOptionPane.showMessageDialog(null,output);
			d.manu();
}

	public void Withdrew(){
		// int withOut;
		// wmoney = Integer.parseInt(JOptionPane.showInputDialog("Enter Withdrew"));
		// c.withdrew(wmoney);
		// d.manu();
		int withdrawOUT = 0;
		do{
			withdrawOUT = Integer.parseInt(JOptionPane.showInputDialog("How much you do want to withdraw out from your account?"));
			if(withdrawOUT<0 || withdrawOUT<99 || withdrawOUT%100 != 0){
				JOptionPane.showMessageDialog(null, "Unable to make a transaction. Please try again.");
			}else{
				int res = JOptionPane.showConfirmDialog(null, "Are you sure to withdraw THB "+withdrawOUT+" from your account?", "Deposit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

				switch(res){
					case JOptionPane.YES_OPTION : bal -= withdrawOUT; break;
					case JOptionPane.NO_OPTION : break;
				}
			}
		}while(withdrawOUT<0 || withdrawOUT<99 || withdrawOUT%100 != 0);
		}

	public void showwithdrew(){
		String output = "***************WITHDREW***************";
			Calendar g = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentDate = df.format(g.getTime());
			
			output +="\n Withdrew: " +bal+ "THB";
			output += "\nDate: " + currentDate;
			output += "\n****************************************";
			JOptionPane.showMessageDialog(null,output);
			d.manu();
}
	
		
	}


		






 

	

