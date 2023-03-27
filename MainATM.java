import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MainATM extends Accounts{
    static final int size = 10;
	static MainATM OS = new MainATM();
    static int countA = 0;
    static Accounts []A = new Accounts[size];
	
    public static void main(String[] args){
        OS.createStartupWindow();
        OS.login();
    }

    public void login(){
        //ใช้ JPanel ในการสร้างโครงร่างในการทำ field รับค่าซึ่งใช้ JTextField
        JPanel loginpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField idlogin = new JTextField(10);
        JTextField passlogin = new JTextField(10);

        //สร้าง JFrame เพื่อนำทุกอย่างไปไว้ใน Frame
        JFrame LOGIN = new JFrame("Login account");
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
            public void actionPerformed(ActionEvent e1){
                //codeauthentication
                for(int acs=0; acs<countA; acs++){
                    if(idlogin.getText()==A[acs].getAccID() || passlogin.getText()==A[acs].getPassword()){
                        System.out.print("found"); break;
                    }else{
                        System.out.println("not found");
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

    public void createStartupWindow(){
		JFrame frame = new JFrame();
        int result = JOptionPane.showConfirmDialog(frame, "Do you have an account already?", "User Confirmation",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		switch (result){
			case JOptionPane.YES_OPTION : OS.register(); break;
			case JOptionPane.NO_OPTION : JOptionPane.showMessageDialog(null, "Proceed to registration page"); break;
		}
    }

    public void register(){
        //ใช้ JPanel ในการสร้างโครงร่างในการทำ field รับค่าซึ่งใช้ JTextField
        JPanel regis = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
            }
        });

        regisFrame.add(panel);

        regisFrame.setSize(300, 300);
        regisFrame.setLocationRelativeTo(null);
        regisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regisFrame.setVisible(true);
    }
}
