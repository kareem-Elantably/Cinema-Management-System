package Users;

import Main.MainGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.*;


public class AdminRegistrationFormGUI extends JFrame{
    
     JLabel lbID;
     JLabel lbUsername;
     JLabel lbPassword;
     JTextField txtfID;
     JTextField txtfUsername;
     JPasswordField txtfPassword;
     JLabel usernamereq;
     JLabel passwordreq;
     JButton bttnSubmit;
     JButton back;
     Container cp; 
    
    public AdminRegistrationFormGUI (){
        
        setSize(330,330);
        setTitle("Admin Registration Form");
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
        bttnSubmit = new JButton("Submit");
        back = new JButton("Back");
        
        cp = getContentPane();
        cp.setLayout(null);
        
        cp.add(lbID);
        lbID.setBounds(20,35,100,25);
        cp.add(txtfID);
        txtfID.setBounds(150,35,100,25);
        cp.add(lbUsername);
        lbUsername.setBounds(20,90,150,25);
        cp.add(txtfUsername);
        txtfUsername.setBounds(150,90,100,25);
        cp.add(usernamereq);
        usernamereq.setBounds(20,115,200,25);
        usernamereq.setForeground(Color.red);
        usernamereq.setOpaque(true);
        cp.add(lbPassword);
        lbPassword.setBounds(20,150,150,25);
        cp.add(txtfPassword);
        txtfPassword.setBounds(150,150,100,25);
        cp.add(passwordreq);
        passwordreq.setBounds(20,175,200,25);
        passwordreq.setForeground(Color.red);
        passwordreq.setOpaque(true);
        cp.add(bttnSubmit);
        bttnSubmit.setBounds(20,210,100,25);
        bttnSubmit.addActionListener(new SubmitWatcher());
        cp.add(back);
        back.setBounds(150,210,100,25);
        back.addActionListener(new back());
        
        txtfUsername.addFocusListener(new usernamefocus());
        txtfPassword.addFocusListener(new passwordfocus());
        
    } 
    
    public class SubmitWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          Admin myAdmin = new Admin();
          myAdmin.setUserName(txtfUsername.getText());
          myAdmin.setPassword(txtfPassword.getText());
          if(txtfUsername.getText().equals("") || txtfPassword.getText().equals("") || txtfID.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Please Fill all fileds!");
          }else{
                if(myAdmin.RegisterAsAdminHash(myAdmin))
                {
                    JOptionPane.showMessageDialog(cp, "Succsses");
                }  
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
 
