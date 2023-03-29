import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PayBill extends MainATM {
    static int ch;
    static PayBill pb = new PayBill();

    public static void main(String[] args){
        pb.menu();
    }

    public void menu(){
        JFrame menu = new JFrame("Pay Bills");
        JPanel mpanel = new JPanel();
        JPanel mpanel2 = new JPanel();
        String mm = "What bill(s) do you want to pay ?";
        JLabel mainmenu = new JLabel("<html><div style = 'text-align: center'><h1>"+mm+"</h1></div></html>",SwingConstants.LEFT);
        JButton depbtn = new JButton("ค่าปรับ");
        JButton wtdbtn = new JButton("Withdrawal");
        JButton trfbtn = new JButton("Transfer");
        JButton tupbtn = new JButton("Top-Up & Pay");
        JButton logoutbtn = new JButton("Logout / Exit");

        depbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Deposit Section");
            }
        });

        wtdbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Withdrawal Section");
            }
        });

        trfbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Transfer Section");
            }
        });

        tupbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Top-Up Section");
            }
        });

        logoutbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Log Out Section");
            }
        });

        mpanel.setLayout(new GridLayout(4,2));
        mpanel2.setLayout(new GridLayout(3,1));
        mpanel.add(depbtn);
        mpanel.add(wtdbtn);
        mpanel.add(trfbtn);
        mpanel.add(tupbtn);
        mpanel2.add(logoutbtn, SwingConstants.CENTER);
        
        menu.add(mainmenu, BorderLayout.NORTH);
        menu.add(mpanel, BorderLayout.CENTER);
        menu.add(mpanel2, BorderLayout.SOUTH);
        
        menu.setSize(300,300);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    } 
}
