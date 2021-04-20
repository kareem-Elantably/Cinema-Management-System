package MovieAndPlayData;

import AddOns.Rating;
import Halls.Seat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Play implements Serializable{

    //public HashMap <String , Play> myPlayHashMap = new HashMap <String , Play>();
    public ArrayList <Seat> mySeatsArrayList;
    public ArrayList <Rating> myRatingsArrayList;
    
    private int Id;
    private int PlayID;
    private String PlayName;
    private double  PlayLength;
    private String PlayLanguage;
    private String PlayGenre;
    private String PlayDescription;
    private double PlayPrice;
    private Seat[] PlaySeat;
    private int PlaySeatSize;
    private int hallID;
    
    public void setRate(Rating myRating)
    {
        myRatingsArrayList.add(myRating);
    }
    
    public Play(){
        PlayID = 0;
        PlayName = " ";
        PlayLength = 0.0;
        PlayLanguage = " ";
        PlayGenre = " ";
        PlayDescription = " ";
        PlayPrice = 0.0;
        PlaySeatSize = 150;
        PlaySeat = new Seat[PlaySeatSize];
        mySeatsArrayList = new ArrayList<Seat>(150);
        myRatingsArrayList = new ArrayList<Rating>();
        for (int i = 0; i< 150; i++){
        mySeatsArrayList.add(i,new Seat(i+1));
         } 
        
    }
    
    public boolean setPlayGenre(String PlayGenre){
        
        this.PlayGenre = PlayGenre;
        return true;
    }
    
    public boolean setId(int Id){
   
       if (Id > 0 && Id <= 100){      
            this.Id = Id;
            return true;
       }
       else {
            return false;
       } 
    }
    
    public boolean setPlayName(String PlayName){
       
        if (!"@".equals(PlayName) && !"!".equals(PlayName) && !"$".equals(PlayName)){            
            this.PlayName = PlayName;
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean setPlayLength(double PlayLength){
        
        if (PlayLength > 0.00 && PlayLength < 5.00 ){
            this.PlayLength = PlayLength;
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean setPlayLanguage(String PlayLanguage){
        
       if(!PlayLanguage.isEmpty()){
            this.PlayLanguage = PlayLanguage;
            return true;
       }else{
            return false;
       }
    }
    
    public boolean setPlayType(String PlayType){ 

        if(!PlayGenre.isEmpty()){
        this.PlayGenre = PlayGenre;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean setPlayDescription(String PlayDescription){
        if(!PlayDescription.isEmpty()){
            this.PlayDescription = PlayDescription;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean setPlayPrice(double PlayPrice){
        if(PlayPrice > 0){
            this.PlayPrice = PlayPrice;
            return true;
        }else{
            return false;
        }
    }
    
      public boolean setHallID(int hallID){
   
       if (hallID > 0 && hallID <= 100){      
            this.hallID = hallID;
            return true;
       }
       else {
            return false;
       } 
    }
      
      public int getHallID(){
          
          return hallID;
      }
      
    public int getId() {
    
        return Id;
} 
    
    public String getPlayName(){
        
        return PlayName;
    }
    
    public double getPlayLength(){
        
        return PlayLength;
    }
    
    public String getPlayLanguage(){
        
        return PlayLanguage;
    }
    
    public String getPlayType(){
        
        return PlayGenre;
    }
    
    public String getPlayDescription(){
        
        return PlayDescription;
    }
    
    public double getPlayPrice(){
        return PlayPrice;
    }
    
    public String getPlayGenre(){
        
        return PlayGenre;
    }
    
}
