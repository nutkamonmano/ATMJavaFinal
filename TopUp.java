import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
class  TopUp extends Accounts{
  static final int max  = 4;
  static TopUp T = new TopUp();
  
  //static TopUpHistory []Tuphistory = new TopUpHistory[max];
  static Volet []V = new Volet[max];
  static EasyPass []E = new EasyPass[max];
  static int countV=0,countE=0;

  JFrame menu = new JFrame("Main Menu...");


  public void AddVolet(){
     double inputvo;
	 String inputvnumber;
       inputvnumber = JOptionPane.showInputDialog("Input Number Volet :");
	   inputvo = Double.parseDouble(JOptionPane.showInputDialog("Input Volet :"));
	    V[countV] = new Volet(inputvo,inputvnumber);
        countV ++;
		T.menu();
  }

  public void AddEasyPass(){
     double inpute;
	 String inputenumber;
	   inputenumber = JOptionPane.showInputDialog("Input Number Easy pass :");
       inpute = Double.parseDouble(JOptionPane.showInputDialog("Input Easy pass :"));
	    E[countE] = new EasyPass(inpute,inputenumber);
        countE ++;
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

Date date = new Date();
   
   public void Show(){
   String output =  "\n------------------------ Show List  ------------------------";
   for(int i = 0; i<countV;i++){
		  output += "\n[Top up wallet]";
          output += "\nShow Number Volet : " + V[i].getinputvnumber();
		  output += "\nShow Volet : " + V[i].getinputvo();
		  output += "\nCurrent Date : " + date.toString();
		  output += "\n\n----------------------------------------------------------------";
          A[accNo].Volet(inputvo);
		  double lastBal = A[accNo].getBalance();
		  Tuphistory[countd] = new TopUpHistory(topupdate, topup, lastbal);
   }

   for(int i = 0; i<countE;i++){
	      output += "\n[Top up Easy Pass]";
          output += "\nShow Number Easy Pass : " + E[i].getinputenumber();
		  output += "\nShow Easy Pass : " + E[i].getinpute();
		  output += "\nCurrent Date : " + date.toString();
		  output += "\n\n----------------------------------------------------------------";
          A[accNo].EasyPass(inpute);
		  double lastBal = A[accNo].getBalance();
		  Tuphistory[countd] = new TopUpHistory(topupdate, topup, lastbal);
   }
          
		  JOptionPane.showMessageDialog(null,output);
}

	
}