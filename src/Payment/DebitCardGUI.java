/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;
import javax.swing.*;
import java.awt.Container;


public class DebitCardGUI extends JFrame {

    private final int CURR = 3; 
    private final int MONTHS = 12;
    public DebitCardGUI(){
    setSize(500, 480);
    setTitle("Pay with Debit");
    
    JButton PayButton = new JButton("Pay");
    
    JLabel debitCardDetails = new  JLabel ("Pay With Debit Card");
    JLabel firstName = new JLabel ("First Name");
    JTextField txfA = new JTextField();
    JLabel lastName = new JLabel ("Last Name");
    JTextField txfA2 = new JTextField();
    JLabel debitCardNo = new JLabel ("Card Number");
    JTextField txfA4 = new JTextField();
    JLabel expirationDate = new JLabel ("Expiration Date");
    //JTextField txfA5 = new JTextField();
    JLabel securityCode = new JLabel ("Security Code");
    JTextField txfA6 = new JTextField();
    JLabel selectCurrency = new JLabel ("Select Your Currency");
    
    String [] curruncies = {"EUR","EGP","USD"};
    JComboBox currency = new JComboBox();
    
    JComboBox month = new JComboBox();
    String [] montharray = {"1","2","3","4","5","6","7","8","9","10","11","12"};
//    JComboBox []expmonth = new JComboBox[MONTHS];
//    for (int i = 0; i < MONTHS; i++){
//          expmonth[i] = new JComboBox(montharray);
//          }
    JComboBox year = new JComboBox();
    String [] yeararray = {"2016","2017","2018","2019","2020","2021","2022","2023","2024"};
    currency = new JComboBox(curruncies);
        
    
     
    
     Container cont = getContentPane();
     cont.setLayout(null);
    
    cont.add(month);
    month.setBounds(300,200,70,20);
    cont.add(year);
    year.setBounds(380,200,70,20);
    cont.add(debitCardDetails);
    debitCardDetails.setBounds(190,20,130,20);
    cont.add(currency);
    currency.setBounds(300, 80, 150, 20);
    cont.add(selectCurrency);
    selectCurrency.setBounds(50,80,150,20); 
    cont.add(firstName);
    firstName.setBounds(50,110,150,20);
    cont.add(txfA);
    txfA.setBounds(300,110,150,20);
    cont.add(lastName);
    lastName.setBounds(50,140,150,20);
    cont.add(txfA2);
    txfA2.setBounds(300,140,150,20);
    cont.add(debitCardNo);
    debitCardNo.setBounds(50, 170, 150, 20);
    cont.add(txfA4);
    txfA4.setBounds(300,170,150,20);
    cont.add(expirationDate);
    expirationDate.setBounds(50,200,100,20);
    //cont.add(txfA5);
    //txfA5.setBounds(300,200,150,20);
    cont.add(securityCode);
    securityCode.setBounds(50,230,100,20);
    cont.add(txfA6);
    txfA6.setBounds(300,230,150,20);
    cont.add(PayButton);
    PayButton.setBounds(200,350,100,20);
    }  
      
}
