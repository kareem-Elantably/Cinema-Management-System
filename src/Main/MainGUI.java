package Main;

import MovieAndPlayData.ExceptionFileManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Users.*;
        

public class MainGUI extends JFrame{

     public JButton RegisterAsAdmin;
     public JButton RegisterAsCustomer;
     public JButton LoginAsAdmin;
     public JButton LoginAsCustomer;
     Container cp;
     
     
    public MainGUI (){
        
        setSize(530,380);
        setTitle("Welcome To MIU Cinemas");
        
        //Initliazing Labels
        JLabel MainText = new JLabel("Welcome To MIU Cinemas");
        
        ExceptionFileManager.loadAdminsData();
        ExceptionFileManager.loadCustomersData();
        
        //Initalizing Buttons
        RegisterAsAdmin = new JButton("Register As Admin");
        RegisterAsCustomer = new JButton ("Register As Customer");
        LoginAsAdmin = new JButton("Login As Admin");
        LoginAsCustomer = new JButton("Login As Customer");
        
        //Intizliazing LayoutManager to Null
        cp = getContentPane();
        cp.setLayout(null);
        
        //Arranging the buttons 
        cp.add(MainText);
        MainText.setBounds(180,30,160,20);
        cp.add(RegisterAsAdmin);
        RegisterAsAdmin.setBounds(175,60,160,40);
        cp.add(RegisterAsCustomer);
        RegisterAsCustomer.setBounds(175, 110, 160, 40);
        cp.add(LoginAsAdmin);
        LoginAsAdmin.setBounds(175,160,160,40);
        cp.add(LoginAsCustomer);
        LoginAsCustomer.setBounds(175,210, 160, 40);
        
        RegisterAsAdmin.addActionListener(new AdminRegistrationWatcher());
        LoginAsAdmin.addActionListener(new AdminLoginWatcher());
        RegisterAsCustomer.addActionListener(new CustomerRegistrationWatcher());
        LoginAsCustomer.addActionListener(new CustomerLoginWatcher());
    }
    
    public class AdminLoginWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
          dispose();
          new AdminLoginFormGUI().setVisible(true);
        }
    }
    
    public class AdminRegistrationWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          
         dispose();
         new AdminRegistrationFormGUI().setVisible(true);
        }
    }
    
     public class CustomerLoginWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          
            dispose();
            new CustomerLoginFormGUI().setVisible(true);
        }
    }
    
      public class CustomerRegistrationWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          
            dispose();
            new CustomerRegistrationFormGUI().setVisible(true);
        }
    }
}
