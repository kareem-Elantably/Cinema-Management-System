package Payment;

import Interfaces.IPay;
import MovieAndPlayData.ExceptionFileManager;


public class Cash implements IPay {
    
    private int Id;
    private int Currency;
    private double Amount;

    
    public int getId() {
        return Id;
    }

    public Boolean setId(int Id) {
        this.Id = Id;
        return true;
    }

    public int getCurrency() {
        return Currency;
    }

    public Boolean setCurrency(int Currency) {
        this.Currency = Currency;
        return true;
    }

    @Override
    public boolean pay(double Amount) {
       Amount = ExceptionFileManager.currCustomer.totalCash;
       return true;
    }

 
    
    
}
