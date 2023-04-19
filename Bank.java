import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Bank extends MainATM {
    static Bank b = new Bank();
    static Depohis []d = new Depohis[1000];
    static Addbank []a = new Addbank[1000];
    static int count=0,countt=0;

        JFrame menu = new JFrame("Money Transfer");
    public static void main(String[] args){
        b.menu();
    }




    public void menu(){
        JPanel panel1 = new JPanel();
        String Lb = "Money Transfer";
        JLabel label = new JLabel("<html><div style = 'text -align:center'><h1>"+Lb+"</h1></html>",SwingConstants.LEFT);
        
        
        JButton bkbutton = new JButton("Tranfer");
        JButton sbbutton = new JButton("ShowTransfer");
        


        panel1.setLayout(new GridLayout(3,1));

        
        panel1.add(bkbutton);
        panel1.add(sbbutton);
        

        menu.add(label,BorderLayout.NORTH);
        menu.add(panel1,BorderLayout.CENTER);

        menu.setSize(300,300);
		menu.setLocationRelativeTo(null);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);



        


        bkbutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				menu.dispose();
				b.tranfer();
				b.menu();
			}
		});

        sbbutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
			menu.dispose();
			b.showbank();
            b.menu();
			}
		});


    }
        
    


public void tranfer(){
   // string account;
    Double tranfer1 = 0.00;
 
    tranfer1 = Double.parseDouble(JOptionPane.showInputDialog("TRANFER"));       
                    
                //การโอนจะโอนน้อยกว่า 0 หรือ โอนมากกว่าค่าคงเหลือไม่ได้
                if(tranfer1<0 || tranfer1>A[accNo].getBalance()){
                JOptionPane.showMessageDialog(null,"connot");
            }else{
                double res = JOptionPane.showConfirmDialog(null,"Are you sure to tranfer THB "+tranfer1+" from your account?","tranfer Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                    if(res == JOptionPane.YES_OPTION){
                        //m-=tranfer1;
                        A[accNo].tranfer(tranfer1);
                        double bathtranfer1 = A[accNo].getBalance();
                        
                        Calendar d = Calendar.getInstance();
                        SimpleDateFormat f = new SimpleDateFormat("dd MMMM YYYY HH:mm:ss");
                        String bankdate1 = f.format(d.getTime());
                        a[count] = new Addbank(bankdate1,tranfer1,bathtranfer1);
                    }
                   

            }
            count++;
        }
            



public void showbank(){
    String output = "*****************HISTORY TRANFER*****************";
    for(int i=0 ; i<count;i++){
    output += "\nTRANFER THB "+a[i].getTranfer();
    output +="\nDate : "+a[i].getBankdate();
    output +="\nLast balance : THB "+a[i].getBathtranfer();
    output +="\n********************************************************";
    }
     
     JOptionPane.showMessageDialog(null,output);

}



    
}
