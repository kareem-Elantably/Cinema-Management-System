package Users;

import MovieAndPlayData.ExceptionFileManager;
import MovieAndPlayData.Movie;
import MovieAndPlayData.Play;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;      //Functions Rate,Reserve
import java.io.Serializable;
import java.util.HashMap;

public class Customer extends Human implements Serializable {
   

    int MAX = 300;
    
    private Movie myRMovie;
    private Play myRPlay;
    
    public double movieCash = 0.0;
    public double parkingCash = 0.0;
    public double cantineCash = 0.0;
    public double totalCash = 0.0;
    public double playCash = 0.0;
    
    public int parkingID = -1;
    

    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }
    
    private int movieSeatNo = -1;
    private int playSeatNO = -1;
    
    
    public Customer(){
        
    }

    public Movie getMyRMovie() {
        return myRMovie;
    }

    public void setMyRMovie(Movie myRMovie) {
        this.myRMovie = myRMovie;
    }

    public Play getMyRPlay() {
        return myRPlay;
    }

    public void setMyRPlay(Play myRPlay) {
        this.myRPlay = myRPlay;
    }
    
    

    public int getMovieSeatNo() {
        return movieSeatNo;
    }

    public void setMovieSeatNo(int movieSeatNo) {
        this.movieSeatNo = movieSeatNo;
    }

    public int getPlaySeatNo() {
        return playSeatNO;
    }

    public void setPlaySeatNo(int playSeatNO) {
        this.playSeatNO = playSeatNO;
    }
    
      public boolean RegisterAsCustomerHash(Customer myCustomer){
          ExceptionFileManager.myCustomersData.put(myCustomer.getUserName(), myCustomer);
          if(ExceptionFileManager.saveCustomerData()){
                return true;
          }
          return false;
      }
    
  public boolean LoginAsCustomerHash (String Username,String Password){
         if(ExceptionFileManager.loadCustomersData()){
              for (Customer i : ExceptionFileManager.myCustomersData.values()){
                   if(i.getUserName().toString().equals(Username) && i.getPassword().toString().equals(Password)){
                       i.totalCash = 0;
                       ExceptionFileManager.currCustomer = i;
                       return true;
                   } 
               }
            }
           return false;
  }    
  
  
}   
