import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PayBill extends MainATM {
    static int ch;
    JFrame payfinequestion = new JFrame();
    JFrame finetype = new JFrame();
    static double fine = 0;
    static String opt;

    public static void main(String[] args){
        pb.menu();
    }

    public void menu(){
        JFrame menu = new JFrame("จ่ายบิล");
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
                menu.dispose();
                pb.chooseFineType();
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

    public void payFineQuestion(){
        String question = "คุณต้องการที่จะชำระ"+opt+" หรือไม่ ?";

        int ch = JOptionPane.showConfirmDialog(payfinequestion, question, "จ่ายค่าปรับจราจร", 
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch (ch){
            case JOptionPane.YES_OPTION : JOptionPane.showMessageDialog(null, "คุณได้ชำระเงิน "+fine+" บาท เพื่อจ่าย"+opt+"เสร็จสิ้นแล้ว\nยอดเงินคงเหลือ... บาท"); break;
            case JOptionPane.NO_OPTION : payfinequestion.dispose();
        }

    }

    public void chooseFineType(){
        String ftq = "คุณต้องการที่จะชำระค่าปรับใด";
        JPanel ftypePanel = new JPanel();
        String finestring[] = {"ค่าปรับ ข้อหาขับรถเร็วกว่าความเร็วที่กำหนด", "ค่าปรับ ข้อหาขับรถผ่าสัญญาณไฟจราจร", "ค่าปรับ ข้อหากลับรถในที่ห้ามกลับรถ", "ยกเลิก และกลับหน้าหลัก"};
        JButton speedbtn = new JButton(finestring[0]);
        JButton redlightbtn = new JButton(finestring[1]);
        JButton uturnbtn = new JButton(finestring[2]);
        JButton cancelbtn = new JButton(finestring[3]);
        JLabel ftypequestion = new JLabel("<html><div style = 'text-align: center'><h1>"+ftq+"</h1></div></html>");
        ftypePanel.setLayout(new GridLayout(5,1));
        ftypePanel.add(ftypequestion);
        ftypePanel.add(speedbtn);
        ftypePanel.add(redlightbtn);
        ftypePanel.add(uturnbtn);
        ftypePanel.add(cancelbtn);

        finetype.add(ftypePanel);

        finetype.setSize(300,300);
        finetype.setLocationRelativeTo(null);
        finetype.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finetype.setVisible(true);

        speedbtn.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                opt = finestring[0];
                fine = 500;
                payFineQuestion();
            }
        });

        redlightbtn.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                opt = finestring[1];
                fine = 500;
                payFineQuestion();
            }
        });

        uturnbtn.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                opt = finestring[2];
                fine = 500;
                payFineQuestion();
            }
        });   

        cancelbtn.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                finetype.dispose();
                pb.menu();
            }
        });   
    }
}
