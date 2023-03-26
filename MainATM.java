import javax.swing.*;
// import java.awt.*;
class MainATM {
    public static void main(String[] args){
        //main code
    }


    public void createStartupWindow(final JFrame frame){
        int result = JOptionPane.showConfirmDialog(frame, "Do you have an account already?", "User Confirmation",
        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(result == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Proceed to login page");
        }else if(result == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Proceed to registration page");
        }else{
            frame.setVisible(false);
        }
    }
}
