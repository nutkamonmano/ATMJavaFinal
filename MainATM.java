import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MainATM extends Accounts{
    static final int size = 10;
	static MainATM OS = new MainATM();
    static PayBill pb = new PayBill();
    static Depowith01 d = new Depowith01();
    static int countA = 0;
    static Accounts []A = new Accounts[size];
    public double bal = 0;

    JFrame menu = new JFrame("Main Menu...");
    JFrame exitframe = new JFrame();
    JFrame startup = new JFrame();
    JPanel regis = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JFrame LOGIN = new JFrame("Login account");

    public static void main(String[] args){
        OS.createStartupWindow();
    }

    public void createStartupWindow(){
        int result = JOptionPane.showConfirmDialog(startup, "Do you have an account already?", "User Confirmation",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        switch (result){
            case JOptionPane.YES_OPTION : OS.login(); break;
            case JOptionPane.NO_OPTION : OS.register(); break;
        }
    }

    public void exitConfirmation(){
        Object stringArray[] = {"Quit", "Log out", "Cancel"};
        int result = JOptionPane.showOptionDialog(exitframe, "Do you want to quit or logout the system", "Quit/Logout",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, stringArray[0]);
        
        switch (result){
            case JOptionPane.YES_OPTION : menu.dispose(); break;
            case JOptionPane.NO_OPTION : menu.dispose(); OS.createStartupWindow(); break;
            case JOptionPane.CANCEL_OPTION : break;
        }
    }

    public void register(){
        //ใช้ JPanel ในการสร้างโครงร่างในการทำ field รับค่าซึ่งใช้ JTextField
        JTextField id = new JTextField(10);
        JTextField name = new JTextField(10);
        JTextField pass = new JTextField(10);

        //สร้าง JFrame เพื่อนำทุกอย่างไปไว้ใน Frame
        JFrame regisFrame = new JFrame("Register new account");
        regisFrame.setLayout(new GridLayout(3,1));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        JLabel idL = new JLabel("Account ID: ");
        JLabel nameL = new JLabel("Account Name: ");
        JLabel passL = new JLabel("Password: ");


        panel.add(idL);
        panel.add(regis.add(id));
        panel.add(nameL);
        panel.add(regis.add(name));
        panel.add(passL);
        panel.add(regis.add(pass));

        JButton addbtn = new JButton();
        addbtn.setText("Register Account");
        panel.add(addbtn);
        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String accID = id.getText();
                String accName = name.getText();
                String password = pass.getText();
                A[countA] = new Accounts(accID, accName, password);
                
                regisFrame.dispose();
                String out = "Account details: \n"+A[countA].getAccID()+"\n"+A[countA].getAccName()+"\n"+"pass: "+A[countA].getPassword();
                JOptionPane.showMessageDialog(null, out);
                
                countA = countA+1;
                OS.menu();
            }
        });

        regisFrame.add(panel);

        regisFrame.setSize(300, 300);
        regisFrame.setLocationRelativeTo(null);
        regisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regisFrame.setVisible(true);
    }

    public void login(){
        //ใช้ JPanel ในการสร้างโครงร่างในการทำ field รับค่าซึ่งใช้ JTextField
        JPanel loginpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField idlogin = new JTextField(10);
        JTextField passlogin = new JTextField(10);

        //สร้าง JFrame เพื่อนำทุกอย่างไปไว้ใน Frame
        LOGIN.setLayout(new GridLayout(3,1));
        JPanel panel = new JPanel();
        loginpanel.setLayout(new GridLayout(5,1));
        JLabel idLg = new JLabel("Account ID: ");
        JLabel passLg = new JLabel("Password: ");


        panel.add(idLg);
        panel.add(loginpanel.add(idlogin));
        panel.add(passLg);
        panel.add(loginpanel.add(passlogin));

        JButton loginbtn = new JButton();
        loginbtn.setText("LOG IN");
        panel.add(loginbtn);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //codeauthentication
                for (int i = 0; i < countA; i++) {
                    String user = idlogin.getText();
                    String pw = passlogin.getText();
                    if (user.equals(A[i].getAccID()) && pw.equals(A[i].getPassword())) {
                        bal = A[i].balance;
                        OS.menu();
                        LOGIN.dispose();
                    }
                }
            }
        });

        LOGIN.add(panel);

        LOGIN.setSize(220, 300);
        LOGIN.setLocationRelativeTo(null);
        LOGIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LOGIN.setVisible(true);
    }

    public void menu(){
        JPanel mpanel = new JPanel();
        JPanel mpanel2 = new JPanel();
        String mm = "Main Menu";
        JLabel mainmenu = new JLabel("<html><div style = 'text-align: center'><h1>"+mm+"</h1></div></html>",SwingConstants.LEFT);
        JButton depbtn = new JButton("Deposit");
        JButton wtdbtn = new JButton("Withdrawal");
        JButton trfbtn = new JButton("Transfer");
        JButton tupbtn = new JButton("Top-Up & Pay");
        JButton logoutbtn = new JButton("Logout / Exit");

        depbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Proceed to Deposit Section");
                d.manu();
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
                // JOptionPane.showMessageDialog(null, "Proceed to Top-Up Section");
                pb.menu();
                menu.dispose();
            }
        });

        logoutbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                OS.exitConfirmation();
            }
        });

        mpanel.setLayout(new GridLayout(4,2));
        mpanel2.setLayout(new GridLayout(1,1));
        mpanel.add(depbtn);
        mpanel.add(wtdbtn);
        mpanel.add(trfbtn);
        mpanel.add(tupbtn);
        mpanel2.add(logoutbtn);
        
        menu.add(mainmenu, BorderLayout.NORTH);
        menu.add(mpanel, BorderLayout.CENTER);
        menu.add(mpanel2, BorderLayout.SOUTH);
        
        menu.setSize(300,300);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
}