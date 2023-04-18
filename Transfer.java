import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transfer extends Accounts{
    static int ch;
    static int size = 100;
    static int count = 0;
    JFrame transferQuestion = new JFrame();
    static double amount = 0;
    static String receiverAccountNumber;
    static TransferHistory[] th = new TransferHistory[size];
    static Transfer t = new Transfer();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        JFrame menu = new JFrame("โอนเงิน");
        JPanel mpanel = new JPanel();
        JPanel mpanel2 = new JPanel();
        String mm = "คุณต้องการที่จะโอนเงิน";
        JLabel mainmenu = new JLabel("<html><div style = 'text-align: center'><h1>" + mm + "</h1></div></html>",
                SwingConstants.LEFT);
        JButton otherAccountBtn = new JButton("โอนเงินไปยังบัญชีอื่น");
        JButton historyBtn = new JButton("ประวัติการโอนเงิน");
        JButton returnBtn = new JButton("กลับหน้าหลัก");

        otherAccountBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
                t.transferQuestion();
            }
        });

        historyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                JOptionPane.showMessageDialog(null, "ดูประวัติการโอนเงิน");
            }
        });

        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
                // OS.menu();  // commented out as the OS class is not provided in the code snippet
                return;
            }
        });

        mpanel.setLayout(new GridLayout(4, 2));
        mpanel2.setLayout(new GridLayout(1, 1));
        mpanel.add(otherAccountBtn);
        mpanel.add(historyBtn);
        mpanel2.add(returnBtn, SwingConstants.CENTER);

        menu.add(mainmenu, BorderLayout.NORTH);
        menu.add(mpanel, BorderLayout.CENTER);
        menu.add(mpanel2, BorderLayout.SOUTH);

        menu.setSize(300, 300);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }

    public static void transferQuestion() {
        JPanel panel = new JPanel();
        String receiverAccountNumberStr = JOptionPane.showInputDialog(panel, "กรุณากรอกหมายเลขบัญชีผู้รับเงิน:");

        if (receiverAccountNumberStr == null || receiverAccountNumberStr.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "กรุณากรอกหมายเลขบัญชีผู้รับเงิน");
            return;
        }

        receiverAccountNumber = receiverAccountNumberStr.trim();

        String amountStr = JOptionPane.showInputDialog(panel, "กรุณากรอกจำนวนเงินที่ต้องการโอน:");
        
    }
}