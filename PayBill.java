import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PayBill extends MainATM {
    static int ch;

    public static void main(String[] args){
        pb.menu();
    }

    public void menu(){
        JFrame menu = new JFrame("Pay Bills");
        JPanel mpanel = new JPanel();
        JPanel mpanel2 = new JPanel();
        String mm = "คุณต้องการที่จะจ่ายบิลใด";
        JLabel mainmenu = new JLabel("<html><div style = 'text-align: center'><h1>"+mm+"</h1></div></html>",SwingConstants.LEFT);
        JButton finebtn = new JButton("ค่าปรับ");
        JButton utilsbtn = new JButton("ค่าน้ำ/ค่าไฟ");
        JButton phoneandinternetbtn = new JButton("ค่่าโทรศัพท์/ค่าอินเทอร์เน็ต");
        JButton returnbtn = new JButton("กลับหน้าหลัก");

        finebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Deposit Section");
            }
        });

        utilsbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Withdrawal Section");
            }
        });

        phoneandinternetbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Transfer Section");
            }
        });

        returnbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menu.dispose();
                OS.menu();
                return;
            }
        });

        mpanel.setLayout(new GridLayout(4,2));
        mpanel2.setLayout(new GridLayout(1,1));
        mpanel.add(finebtn);
        mpanel.add(utilsbtn);
        mpanel.add(phoneandinternetbtn);
        mpanel2.add(returnbtn, SwingConstants.CENTER);
        
        menu.add(mainmenu, BorderLayout.NORTH);
        menu.add(mpanel, BorderLayout.CENTER);
        menu.add(mpanel2, BorderLayout.SOUTH);
        
        menu.setSize(300,300);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    } 
}
