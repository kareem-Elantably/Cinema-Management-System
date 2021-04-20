package AddOns;

import MovieAndPlayData.ExceptionFileManager;
import MovieAndPlayData.Movie;
import Payment.InoviceGUI;
import Users.Customer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ParkingGUI extends JFrame {
    
    private final int PARKING = 66;
    JButton SkipParking;
    JButton ConfirmPlace;
    Parking selectedParking;
    JPanel firstpanel;
    private Parking [] myParking;
    JPanel secondpanel;
    JPanel thirdpanel;
    String currChoice;
            
    public ParkingGUI(String currChoice){
        
        this.currChoice = currChoice;
        setSize(630,480);
        setTitle("Parking");
        
        selectedParking = new Parking(-1);
        
        getContentPane().setLayout(new BorderLayout());
        
        firstpanel = new JPanel();
        myParking = new Parking[PARKING];
        for (int i = 0; i < PARKING; i++){
           myParking[i] = new Parking(i+1);
           myParking[i].myParkingButton.setBackground(Color.green);
           firstpanel.add(myParking[i].myParkingButton);
           myParking[i].myParkingButton.addActionListener(new ParkingListener(myParking[i]));
        }
        
        for(Customer i: ExceptionFileManager.myCustomersData.values()){
             if(i != null){
                if(i.parkingID != -1){
                    if(i.equals(ExceptionFileManager.currCustomer)){
                        myParking[i.parkingID-1].myParkingButton.setBackground(Color.yellow);
                    }else{
                        myParking[i.parkingID-1].myParkingButton.setBackground(Color.red);
                    }
                    myParking[i.parkingID-1].isTaken = true;
                }
            }
        }
        
        firstpanel.setBackground(Color.lightGray);
        
        secondpanel = new JPanel();
        secondpanel.add(new JLabel("Parking Area"));
        
        thirdpanel = new JPanel();
        SkipParking = new JButton("Skip Pakring");
        thirdpanel.add(SkipParking);
        SkipParking.addActionListener(new ActionListen());
        ConfirmPlace = new JButton("Confirm Place");
        thirdpanel.add(ConfirmPlace);
        ConfirmPlace.addActionListener(new ConfirmPlace());
       
        
        getContentPane().add((firstpanel),BorderLayout.CENTER);
        getContentPane().add((secondpanel),BorderLayout.NORTH);
        getContentPane().add((thirdpanel),BorderLayout.SOUTH);
        
     
        }
    
    public class ParkingListener implements ActionListener{

        Parking myParking;
        
        public ParkingListener(Parking myParking){
            this.myParking = myParking;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!selectedParking.isTaken){// || selectedSeat.getTakenBy().equals(ExceptionFileManager.currCustomer.getUserName())){
                selectedParking.myParkingButton.setBackground(Color.GREEN);
                selectedParking = myParking;
                selectedParking.myParkingButton.setBackground(Color.YELLOW);
            }
        }
        
    }
    
    public class ActionListen implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int Choice  = JOptionPane.showConfirmDialog(null, "Do You Want Items from Cantine", "Cantine Prompt", JOptionPane.YES_NO_OPTION);
            if(Choice == 0){
                
                CantineGUI myGUI = new CantineGUI(currChoice);
                myGUI.setVisible(true);
                dispose();           
            }
        }
        
    }
    
    public class ConfirmPlace implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            ExceptionFileManager.myCustomersData.get(ExceptionFileManager.currCustomer.getUserName()).parkingID = selectedParking.parkingID;
            ExceptionFileManager.currCustomer.parkingID = selectedParking.parkingID;
            ExceptionFileManager.currCustomer.parkingCash = 20;
            ExceptionFileManager.currCustomer.totalCash += 20;
            if(ExceptionFileManager.saveCustomerData()){            
                int Choice = JOptionPane.showConfirmDialog(null, "Do You Want Items from Cantine", "Cantine Prompt", JOptionPane.YES_NO_OPTION);
                if (Choice == 0){
                     CantineGUI myGUI = new CantineGUI(currChoice);
                    myGUI.setVisible(true);
                    dispose();       
                }else if (Choice == 1){

                    InoviceGUI myGUI = new InoviceGUI(currChoice);
                    myGUI.setVisible(true);
                    dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Faild to reserve parking slot","Parking Error",JOptionPane.ERROR_MESSAGE);
            }
                
        }
        
        
    }
    }
    

