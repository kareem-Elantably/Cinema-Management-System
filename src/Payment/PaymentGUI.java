/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import MovieAndPlayData.AdminAddMovieGUI;
import MovieAndPlayData.AdminAddPlayGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author zyad
 */
public class PaymentGUI extends JFrame {

    JButton payViaVisa;
    //JButton payViaCash;
    JButton payViaDebit;
    Container cont;
    
  public PaymentGUI(){
      
      
      setSize(630, 480);
      setTitle("Payment");
      
      JLabel paymentMenu = new  JLabel ("Payment Menu");
      payViaVisa = new JButton ("Pay With Visa");
      //payViaCash = new JButton ("Pay With Cash");
      payViaDebit = new JButton ("Pay With Debit");
      cont = getContentPane();
      cont.setLayout(null);
        
      
      PaymentListener myActionListener = new PaymentListener();
      cont.add(paymentMenu);
      paymentMenu.setBounds(250,20,100,20);
      cont.add(payViaVisa);
      payViaVisa.setBounds(220,60,150,30);
      myActionListener = new PaymentListener();
      myActionListener.setChoice(1);
      //cont.add(payViaCash);
      //payViaCash.setBounds(220,110,150,30);
      cont.add(payViaDebit);
      payViaDebit.setBounds(220,160,150,30);
      myActionListener = new PaymentListener();
      myActionListener.setChoice(2);
      
  }   
  
  public class PaymentListener implements ActionListener{

      int Choice;
      
      public void setChoice(int Choice)
      {
          this.Choice = Choice;
      }
      
        @Override
        public void actionPerformed(ActionEvent e) {
           switch (Choice){
               case 1:
                   VisaCardGUI VCG = new VisaCardGUI();
                   VCG.setVisible(true);
                   break;              
           } 
            
        }
  }
}

