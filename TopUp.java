import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class  TopUp extends MainATM{
  static int size = 100;
  
  
  static TopUpHistory []Tuphistory = new TopUpHistory[size];
  static int count=0;
  static double money = 0;
  static double lastbal = 0;
  static String topupdate;


  public String gettopupdate(){
	Calendar d = Calendar.getInstance();
	SimpleDateFormat f = new SimpleDateFormat("dd MMMM YYYY HH:mm:ss");
	String topupdate = f.format(d.getTime());

	return topupdate; 
  }

  JFrame menu = new JFrame("Main Menu...");


  public void AddVolet(){
	 double inputvo = 0;
	 String inputvnumber = JOptionPane.showInputDialog("Input Number Volet :");
	   inputvo = Double.parseDouble(JOptionPane.showInputDialog("Input Volet :"));
	   A[accNo].topup(inputvo);
	   double money = A[accNo].getBalance();
	   String topuptype = "Top Up Wallet number "+inputvnumber;
	   Tuphistory[count] = new TopUpHistory(topupdate, topuptype, inputvo, money);
        count ++;
		T.menu();
  }

  public void AddEasyPass(){
	 double inpute;
	 String inputenumber;
	   inputenumber = JOptionPane.showInputDialog("Input Number Easy pass :");
       inpute = Double.parseDouble(JOptionPane.showInputDialog("Input Easy pass :"));
	   A[accNo].topup(inpute);
	   double money = A[accNo].getBalance();
	   String topuptype = "Top Up Easy Pass number "+inputenumber;
	   Tuphistory[count] = new TopUpHistory(topupdate, topuptype, inpute, money);
        count ++;
		T.menu();
  }

 public static void main(String[] args) {  
		T.menu();
		
 	}

	public void menu(){
		JPanel panel1 = new JPanel(); 
		String lb = "Main Menu";
		JLabel label = new JLabel("<html><div style = 'text-align: center'><h1>"+lb+"</h1></div></html>",SwingConstants.LEFT);
		
		
		JButton AddVoletbutton = new JButton("Add Volet");
		JButton AddEasyPassbutton = new JButton("Add Easy Pass");
		JButton ShowListbutton = new JButton("Show List");
		JButton Quitbtn = new JButton("Quit");
        
		
        panel1.setLayout(new GridLayout(6,1));

		
		panel1.add(AddVoletbutton); 
		panel1.add(AddEasyPassbutton);
		panel1.add(ShowListbutton);
		panel1.add(Quitbtn);

		
		menu.add(label,BorderLayout.NORTH);
		menu.add(panel1,BorderLayout.CENTER);

		
		menu.setSize(300,300);
        menu.setLocationRelativeTo(null);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);


		AddVoletbutton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
			    menu.dispose();
				T.AddVolet();
               
		  }
		});	

		AddEasyPassbutton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
			    menu.dispose();
				T.AddEasyPass();
               
		  }
		});
		
		ShowListbutton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
				T.Show();
               
		  }
		});


		  Quitbtn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
			    menu.dispose();
		}	
	});


}
   
   public void Show(){ //แก้อันนี้ให้ตรงกับ top up history
   String output =  "\n------------------------ Show List  ------------------------";
   for(int i = 0; i<count;i++){
		  output += "\nTop Up type : "+Tuphistory[i].getTopuptype();
		  output += "\nTop Up date : "+Tuphistory[i].getTopupdate();
          output += "\nAmount : "+Tuphistory[i].getTopup();
		  output += "\nLast Balance : "+Tuphistory[i].getLastbal();
		  output += "\n\n----------------------------------------------------------------";
          
   }          
		  JOptionPane.showMessageDialog(null,output);
}

	
}