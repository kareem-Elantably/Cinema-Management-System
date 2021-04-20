package Halls;

import AddOns.CantineGUI;
import AddOns.ParkingGUI;
import MovieAndPlayData.ExceptionFileManager;
import MovieAndPlayData.Movie;
import MovieAndPlayData.Play;
import Payment.InoviceGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

public class GrandTheaterHallGUI extends JFrame {
    
    public ArrayList<Seat> mySeats;
    public Play myPlay;
    public final int CHAIRS = 150;
    int ChairID;
    JButton Confirm;
    Seat selectedSeat;

  
    public GrandTheaterHallGUI(Play myPlay){
        
        this.myPlay = myPlay;
        this.mySeats = this.myPlay.mySeatsArrayList;
        
        setSize(1200,650);
        setTitle("Grand Theater Hall");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
          
        
        
        loadGui();
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                       new myClient().run();
                       return;
            }
        }, 
        2000 
        );
    }
    
    public class myClient implements Runnable{

        @Override
        public void run() {
            while(true){
            try{
                Socket s=new Socket("192.168.43.186",5000);
                InputStream is=s.getInputStream();
        
                BufferedReader bf=new BufferedReader(new InputStreamReader(is));
                String ServerMessage=bf.readLine();
                String myData = ServerMessage;
                bf.close();
                s.close();
              
                String [] msg = myData.split("3ab8anii");
                int SeatMessage=Integer.parseInt(msg[1]);
                String playName = msg[2];
                for(Play i: ExceptionFileManager.myPlaysData){
                    if(i.getPlayName().equals(playName)){
                        i.mySeatsArrayList.get(SeatMessage-1).isTaken = true;
                        i.mySeatsArrayList.get(SeatMessage-1).setTakenBy(msg[0]);
                    }
                }
                
                ExceptionFileManager.savePlaysData();
                if(myPlay.getPlayName().equals(playName)){
                    mySeats.get(SeatMessage-1).getButton().setBackground(Color.red);
                }
                
            }catch(Exception e){
                
             }
           }
        }   
    }
    
    public class myServer implements Runnable{

        @Override
        public void run() {
             try{
                ServerSocket ss=new ServerSocket(5000);
                Socket ClientSocket=new Socket();
                ClientSocket=ss.accept();
                OutputStream os=ClientSocket.getOutputStream();
                InputStream is=ClientSocket.getInputStream();
                PrintWriter pw=new PrintWriter(os);
                pw.write((ExceptionFileManager.currCustomer.getUserName()+"3ab8anii"+selectedSeat.getSeatNumber()+"3ab8anii"+myPlay.getPlayName()).toString());
                pw.close();
                ClientSocket.close();
                ss.close();
            }catch(IOException xe){
                          
            }
        }
        
    }
    
    
    
    
    public void loadGui(){
        JPanel firstpanel = new JPanel();
        
        selectedSeat = new Seat(-1);
        
        for (int j =0; j < CHAIRS; j++){
            if(mySeats.get(j).isTaken){
                if(mySeats.get(j).getTakenBy().equals(ExceptionFileManager.currCustomer.getUserName())){
                    mySeats.get(j).getButton().setBackground(Color.yellow);
                    //selectedSeat = mySeats.get(j);
                }else{
                    mySeats.get(j).getButton().setBackground(Color.red);
                }
            }else{
                mySeats.get(j).getButton().setBackground(Color.green);
            }
            firstpanel.add(mySeats.get(j).getButton()); 
            mySeats.get(j).getButton().addActionListener(new SeatListen(mySeats.get(j)));
            
            
        }
   
        firstpanel.setBackground(Color.lightGray);
        
        JPanel secondpanel = new JPanel();
        secondpanel.add(new JLabel("SCREEN"));
       
        JPanel thirdpanel = new JPanel();
        Confirm = new JButton("Confirm Place");
        thirdpanel.add(Confirm);
        Confirm.addActionListener(new ActionListen());
        
        
        
        getContentPane().add((firstpanel),BorderLayout.CENTER);
        getContentPane().add((secondpanel),BorderLayout.NORTH);
        getContentPane().add((thirdpanel),BorderLayout.SOUTH);
        
        setVisible(false);
        setVisible(true);
    }
    
    public class ActionListen implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(selectedSeat.getSeatNumber() != -1){
            
                int Choice = JOptionPane.showConfirmDialog(null, " Are you Sure You Want this Place","Confimration",JOptionPane.YES_NO_OPTION);

                if (Choice == 0 ){

                        for(Play i: ExceptionFileManager.myPlaysData){
                            if(i.equals(myPlay)){
                                i.mySeatsArrayList.get(selectedSeat.getSeatNumber()-1).isTaken = true;
                                i.mySeatsArrayList.get(selectedSeat.getSeatNumber()-1).setTakenBy(ExceptionFileManager.currCustomer.getUserName());
                                ExceptionFileManager.currCustomer.setMyRPlay(i);
                                ExceptionFileManager.currCustomer.setPlaySeatNo(selectedSeat.getSeatNumber());
                                ExceptionFileManager.currCustomer.playCash = i.getPlayPrice();
                                ExceptionFileManager.currCustomer.totalCash += i.getPlayPrice();
                            }
                        }
                      ExceptionFileManager.savePlaysData();
                      String currChoice = "Play";
                     
                      new java.util.Timer().schedule( 
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                      new myServer().run();
                                       return;
                            }
                        }, 
                        2000 
                        );
                      
                    
                      int Choice1  = JOptionPane.showConfirmDialog(null, "Do You Want A Parking Slot", "Parking", JOptionPane.YES_NO_OPTION);

                      if(Choice1 == 0){

                          ParkingGUI myGUI = new ParkingGUI(currChoice);
                          myGUI.setVisible(true);
                          dispose();

                      }
                      else if(Choice1 == 1){

                         int Choice2 = JOptionPane.showConfirmDialog(null, "Do You Want Items From Cantine ", "Cantine Prompt", JOptionPane.YES_NO_OPTION);
                         if (Choice2 == 0){

                             CantineGUI myGUI = new CantineGUI(currChoice);
                             myGUI.setVisible(true);
                             dispose();
                         }
                         else if(Choice2 == 1){
                             InoviceGUI myGUI = new InoviceGUI(currChoice);
                             myGUI.setVisible(true);
                             dispose();

                         }
                      }
                }
              }
        }
    }
    
    public class SeatListen implements ActionListener{

        Seat mySelectedSeat;
        
        public SeatListen(Seat mySelectedSeat){
            this.mySelectedSeat = mySelectedSeat;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!mySelectedSeat.isTaken){// || selectedSeat.getTakenBy().equals(ExceptionFileManager.currCustomer.getUserName())){
                selectedSeat.getButton().setBackground(Color.GREEN);
                selectedSeat = mySelectedSeat;
                selectedSeat.getButton().setBackground(Color.YELLOW);
            }
        }
        
    }
}
    

