package Users;

import Main.MainGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class CustomerLoginFormGUI extends JFrame {
    
     JLabel lbID;
     JLabel lbUsername;
     JLabel lbPassword;
     JLabel usernamereq;
     JLabel passwordreq;
     JTextField txtfID;
     JTextField txtfUsername;
     JPasswordField txtfPassword;
     JButton bttn;
     JButton back;
     Container cp;
     
  public CustomerLoginFormGUI (){
      
        setSize(330,330);
        setTitle("Customer Login Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lbID = new JLabel("Enter Your ID: ");
        lbUsername = new JLabel ("Enter Your Username: ");
        usernamereq = new JLabel("*Username Is Required*");
        usernamereq.setVisible(false);
        lbPassword = new JLabel ("Enter Your Password: ");
        passwordreq = new JLabel ("*Password Is Required*");
        passwordreq.setVisible(false);
        txtfID = new JTextField(20);
        txtfUsername = new JTextField(20);
        txtfPassword = new JPasswordField(20);
        bttn = new JButton("Submit");
        back = new JButton("Back");
        
        cp = getContentPane();
        cp.setLayout(null);
        
        cp.add(lbID);
        lbID.setBounds(20 ,5, 100, 25);
        cp.add(txtfID);
        txtfID.setBounds(150 ,5, 100, 25);
        cp.add(lbUsername);
        lbUsername.setBounds(20 ,60, 150, 25);
        cp.add(txtfUsername);
        txtfUsername.setBounds(150 ,60, 100, 25);
        cp.add(usernamereq);
        usernamereq.setBounds(20,85,200,25);
        usernamereq.setForeground(Color.red);
        usernamereq.setOpaque(true);
        cp.add(lbPassword);
        lbPassword.setBounds(20, 120, 150, 25);
        cp.add(txtfPassword);
        txtfPassword.setBounds(150 ,120, 100, 25);
        cp.add(passwordreq);
        passwordreq.setBounds(20, 145, 200, 25);
        passwordreq.setForeground(Color.red);
        passwordreq.setOpaque(true);
        cp.add(bttn);
        bttn.setBounds(20, 180, 100, 25); 
        bttn.addActionListener(new LoginWatcher());
        cp.add(back);
        back.setBounds(150, 180, 100, 25);
        back.addActionListener(new back());
        
        txtfUsername.addFocusListener(new usernamefocus());
        txtfPassword.addFocusListener(new passwordfocus());
  }
    
    public class LoginWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Customer myCustomer = new Customer();
                if(myCustomer.LoginAsCustomerHash(txtfUsername.getText(), txtfPassword.getText())){
                    
                    JOptionPane.showMessageDialog(cp, "Login Succses");
                    dispose();
                    CustomerChoiceGUI myGui = new CustomerChoiceGUI();
                    myGui.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(cp, "Login Failed");
                }
 
        }
    }
     public class back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MainGUI myGUI = new MainGUI();
            dispose();
            myGUI.setVisible(true);
        }   
    }
     
      public class usernamefocus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            usernamereq.setVisible(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(txtfUsername.getText().equals("")){
                usernamereq.setVisible(true);
            }
            else {
                usernamereq.setVisible(false);
            }
        }
    }
    
    public class passwordfocus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            passwordreq.setVisible(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(txtfUsername.getText().equals("")){
               passwordreq.setVisible(true);
            }
            else {
               passwordreq.setVisible(false);
            }
        }
    }
}
