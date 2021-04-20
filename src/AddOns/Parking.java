package AddOns;

import javax.swing.JButton;


public class Parking {
    
    int parkingID;
    JButton myParkingButton;
    boolean isTaken;
    
    public Parking(int parkingID){
        this.parkingID = parkingID; 
        myParkingButton = new JButton("Parking No." + parkingID); 
        isTaken = false;
    }
   
   
}
