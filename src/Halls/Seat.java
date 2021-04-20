package Halls;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
    
public class Seat implements Serializable{
        
      private int SeatNumber; 
      private JButton myButton;
      boolean isTaken = false;
      private String takenBy = "";

      
    public String getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }
      
      
    public Seat(int SeatNumber){
        
            this.SeatNumber = SeatNumber;
            myButton = new JButton("CHAIR NO " + SeatNumber);
    }
    
    public boolean setSeatNumber(int SeatNumber){
        return true;
    }
    
    public int getSeatNumber(){
        return SeatNumber;
    }
    
    public void setButton(JButton myButton){
        
        this.myButton = myButton;
        
    }
    
    public JButton getButton(){
        
        return myButton;
    }   
}