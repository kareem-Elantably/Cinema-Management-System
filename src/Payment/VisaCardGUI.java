/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VisaCardGUI extends JFrame {

    private final int CURR = 3; 
    public JButton submitButton;
    
    JLabel visaCardDetails;
    JLabel firstName;
    JTextField txfA;
    JLabel lastName;
    JTextField txfA2;
    JLabel debitCardNo;
    JTextField txfA4;
    JLabel expirationDate;
    JTextField txfA5;
    JLabel securityCode;
    JTextField txfA6;
    JLabel selectCurrency;
    
    String [] curruncies = {"EUR","EGP","USD"};
    JComboBox currency;
    
    public VisaCardGUI(){
    setSize(630, 480);
    setTitle("Pay with VisaCard");
    submitButton = new JButton("Submit");
    visaCardDetails = new  JLabel ("Pay With VIsa Card");
    firstName = new JLabel ("First Name");
    txfA = new JTextField();
    lastName = new JLabel ("Last Name");
    txfA2 = new JTextField();
    debitCardNo = new JLabel ("Card Number");
    txfA4 = new JTextField();
    expirationDate = new JLabel ("Expiration Date");
    txfA5 = new JTextField();
    securityCode = new JLabel ("Security Code");
    txfA6 = new JTextField();
    selectCurrency = new JLabel ("Select Your Cuurency");
    
    
        
    currency = new JComboBox(curruncies);
        
    
     
    
     Container cont = getContentPane();
     cont.setLayout(null);
    
    
    cont.add(visaCardDetails);
    visaCardDetails.setBounds(220,20,130,20);
    cont.add(currency);
    currency.setBounds(150, 80, 150, 20);
    cont.add(selectCurrency);
    selectCurrency.setBounds(5,80,150,20); 
    cont.add(firstName);
    firstName.setBounds(5,110,150,20);
    cont.add(txfA);
    txfA.setBounds(150,110,150,20);
    cont.add(lastName);
    lastName.setBounds(5,140,150,20);
    cont.add(txfA2);
    txfA2.setBounds(150,140,150,20);
    cont.add(debitCardNo);
    debitCardNo.setBounds(5, 170, 150, 20);
    cont.add(txfA4);
    txfA4.setBounds(150,170,150,20);
    cont.add(expirationDate);
    expirationDate.setBounds(5,200,100,20);
    cont.add(txfA5);
    txfA5.setBounds(150,200,150,20);
    cont.add(securityCode);
    securityCode.setBounds(5,230,100,20);
    cont.add(txfA6);
    txfA6.setBounds(150,230,150,20);
    submitButton.setBounds(180, 300, 100, 50);
    cont.add(submitButton);
    submitButton.addActionListener(new Submit());
    
    }
    
    public class Submit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(txfA.getText().equals("") || txfA2.getText().equals("") || txfA4.getText().equals("") || txfA5.getText().equals("") || txfA6.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "Please fill all inputs!");
            }else{
            FinalInvoiceGUI myGui = new FinalInvoiceGUI();
            myGui.setVisible(true);
            myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
            }
        }
        
    }
      
}

