import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MainATM {
    static final int size = 10;
	static MainATM OS = new MainATM();
    static int countA = 0;
    static Accounts []A = new Accounts[size];
	
    public static void main(String[] args){
        OS.createStartupWindow();
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
                String ID = id.getText();
                String NAME = name.getText();
                String PASS = pass.getText();
                A[countA] = new Accounts(ID, NAME, PASS);
                regisFrame.dispose();
            }
        });

        regisFrame.add(panel);

        regisFrame.setSize(300, 300);
        regisFrame.setLocationRelativeTo(null);
        regisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regisFrame.setVisible(true);
    }
}
