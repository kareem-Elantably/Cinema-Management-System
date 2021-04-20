package Users;

import Main.MainGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.*;

public class CustomerRegistrationFormGUI extends JFrame {
    
     JLabel lbID;
     JLabel lbFirstname;
     JLabel lbSecondname;
     JLabel lbAge;
     JLabel lbUsername;
     JLabel lbPassword;
     JLabel lbEmail;
     JLabel lbMobile;
     JLabel lbConfirmation;
     
     JLabel firstnamereq;
     JLabel secondnamereq;
     JLabel usernamereq;
     JLabel passwordreq;
     JLabel emailreq;
     JLabel mobilereq;
     
     JTextField txtfID;
     JTextField txtfFirstname;
     JTextField txtfSecondname;
     JTextField txtfUsername;
     JPasswordField txtfPassword;
     JTextField txtfEmail;
     JTextField txtfMobile;
     
     JComboBox AgeChoice;
     
     JButton Register;
     
     JButton Back;
     
     Container cp;
     
      public CustomerRegistrationFormGUI(){
        
        //Intilization of the JFrame
        setSize(630,480);
        setTitle("Customer Registration Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Intilization of Labels
        lbID = new JLabel("Enter Your ID: ");
        lbFirstname = new JLabel("First Name: ");
        lbSecondname = new JLabel("Second Name: ");
        lbAge = new JLabel("Select Your Age"); 
        lbUsername = new JLabel("Enter Your Username: ");
        lbPassword = new JLabel("Enter Your Password: ");
        lbEmail = new JLabel("Enter Your Email: ");
        lbMobile = new JLabel("Enter Your Mobile: ");
        lbConfirmation = new JLabel ("By Clicking Register you accept our Terms & Conditions");
        
        //Intilization listners
        firstnamereq = new JLabel("*FirstName Required*");
        firstnamereq.setVisible(false);
        secondnamereq = new JLabel("*SecondName Required*");
        secondnamereq.setVisible(false);
        usernamereq = new JLabel("*UserName Required*");
        usernamereq.setVisible(false);
        passwordreq = new JLabel("*Password Required*");
        passwordreq.setVisible(false);
        emailreq = new JLabel("*Email Required*");
        emailreq.setVisible(false);
        mobilereq = new JLabel("*Mobile Required*"); 
        mobilereq.setVisible(false);
        
        //Intilization of TextFields
        txtfID = new JTextField(20);
        txtfFirstname = new JTextField(20);
        txtfSecondname = new JTextField(20);
        txtfUsername = new JTextField(20);
        txtfPassword = new JPasswordField(20);
        txtfEmail = new JTextField(20);
        txtfMobile = new JTextField(20);
       
        //Initzliataion of a ComboBox
        AgeChoice = new JComboBox();
        for (int i = 18; i <= 50; i++){
            
            AgeChoice.addItem(i);
        }
        
        //Intilization of a Button
        Register = new JButton("Register");
        
        Back = new JButton("Back");
        
        //Setting the Layout Manager to Null
        cp = getContentPane();
        cp.setLayout(null);
        
        //Manually Arranging The GUI Components
        //Notice Application is not Adaptable
        cp.add(lbID);
        lbID.setBounds(20 ,10, 100, 25);
        cp.add(txtfID);
        txtfID.setBounds(150 ,10, 100, 25);
        cp.add(lbFirstname);
        lbFirstname.setBounds(20, 50, 100, 25);
        cp.add(txtfFirstname);
        txtfFirstname.setBounds(150, 50, 100, 25);
        cp.add(firstnamereq);
        firstnamereq.setBounds(20,75,200,25);
        firstnamereq.setForeground(Color.red);
        firstnamereq.setOpaque(true);
        cp.add(lbSecondname);
        lbSecondname.setBounds(20, 100, 100, 25);
        cp.add(txtfSecondname);
        txtfSecondname.setBounds(150, 100, 100, 25);
        cp.add(secondnamereq);
        secondnamereq.setBounds(20,125,200,25);
        secondnamereq.setForeground(Color.red);
        secondnamereq.setOpaque(true);
        cp.add(lbAge);
        lbAge.setBounds(20, 150, 100, 25);
        cp.add(AgeChoice);
        AgeChoice.setBounds(150, 150, 100, 25);
        cp.add(lbUsername);
        lbUsername.setBounds(20 ,200, 150, 25);
        cp.add(txtfUsername);
        txtfUsername.setBounds(150 ,200, 100, 25);
        cp.add(usernamereq);
        usernamereq.setBounds(20,225,200,25);
        usernamereq.setForeground(Color.red);
        usernamereq.setOpaque(true);
        cp.add(lbPassword);
        lbPassword.setBounds(20, 250, 150, 25);
        cp.add(txtfPassword);
        txtfPassword.setBounds(150 ,250, 100, 25);
        cp.add(passwordreq);
        passwordreq.setBounds(20, 275, 200, 25);
        passwordreq.setForeground(Color.red);
        passwordreq.setOpaque(true);
        cp.add(lbEmail);
        lbEmail.setBounds(20, 300, 100, 25);
        cp.add(txtfEmail);
        txtfEmail.setBounds(150, 300, 100, 25);
        cp.add(emailreq);
        emailreq.setBounds(20,325,100,25);
        emailreq.setForeground(Color.red);
        emailreq.setOpaque(true);
        cp.add(lbMobile);
        lbMobile.setBounds(20, 350, 105, 25);
        cp.add(txtfMobile);
        txtfMobile.setBounds(150, 350, 100, 25);
        cp.add(mobilereq);
        mobilereq.setBounds(20,375,200,25);
        mobilereq.setForeground(Color.red);
        mobilereq.setOpaque(true);
        cp.add(lbConfirmation);
        lbConfirmation.setBounds(180, 400, 320, 25);
        cp.add(Register);
        Register.setBounds(500, 400, 100, 25);
        Register.addActionListener(new SubmitWatcher());
        cp.add(Back);
        Back.setBounds(40,400 ,100, 25);
        Back.addActionListener(new back());
        
        txtfFirstname.addFocusListener(new firstnamefocus());
        txtfSecondname.addFocusListener(new secondnamefocus());
        txtfUsername.addFocusListener(new usernamefocus());
        txtfPassword.addFocusListener(new passwordfocus());
        txtfEmail.addFocusListener(new emailfoucs());
        txtfMobile.addFocusListener(new mobilefocus());
        
      }
      
      public class SubmitWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          Customer myCustomer = new Customer();
          myCustomer.setUserName(txtfUsername.getText());
          myCustomer.setPassword(txtfPassword.getText());
          if(txtfEmail.getText().equals("") || txtfFirstname.getText().equals("") || txtfID.getText().equals("") || txtfMobile.getText().equals("") || txtfPassword.getText().equals("") || txtfSecondname.getText().equals("") || txtfUsername.getText().equals("") || !txtfEmail.getText().contains("@") || !txtfEmail.getText().contains(".com") || txtfMobile.getText().length() != 11){
                JOptionPane.showMessageDialog(null, "Please Fill all fields!");
          }else{
              if(myCustomer.RegisterAsCustomerHash(myCustomer))
                {
                    JOptionPane.showMessageDialog(cp, "Succsses");
                }else{
                    JOptionPane.showMessageDialog(cp, "Faild");
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
     
       public class firstnamefocus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            firstnamereq.setVisible(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(txtfFirstname.getText().equals("")){
                firstnamereq.setVisible(true);
            }
            else {
                firstnamereq.setVisible(false);
            }
        }
           
       }
       
         public class secondnamefocus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            secondnamereq.setVisible(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
           if(txtfSecondname.getText().equals("")){
                secondnamereq.setVisible(true);
            }
            else {
                secondnamereq.setVisible(false);
            }
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
         if(txtfPassword.getText().equals("")){
                passwordreq.setVisible(true);
            }
            else {
                passwordreq.setVisible(false);
            }
        }
    }
    
    public class mobilefocus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            mobilereq.setVisible(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(txtfMobile.getText().equals("")){
                mobilereq.setVisible(true);
            }
            else {
                mobilereq.setVisible(false);
            }
        }
    }
    
    public class emailfoucs implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            emailreq.setVisible(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
           if(txtfEmail.getText().equals("")){
                emailreq.setVisible(true);
            }
            else {
                emailreq.setVisible(false);
            }
        }
    }
}


