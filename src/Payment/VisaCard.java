package Payment;

import Interfaces.IPay;


public class VisaCard implements IPay{

    private int Id;
    private int TypeOfVisa;
    
    public void PaymentThroughVisa(){
        
             
    }

    @Override
    public boolean pay(double Amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean setAmount(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
