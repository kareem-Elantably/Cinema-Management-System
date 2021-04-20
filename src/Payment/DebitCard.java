package Payment;

import Interfaces.IPay;
import java.util.ArrayList;



public class DebitCard implements IPay {

 //ArrayList <>
    DebitCardGUI DCG;
    public void PaymentThroughDebit(){
        String firstName;
        String lastName;
        int cardNumber;
        int securityCode;
        
        
    }

    @Override
    public boolean pay(double Amount) {
       
        
        
        return true;
    }

    boolean setAmount(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
