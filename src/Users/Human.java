package Users;

import MovieAndPlayData.Movie;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Human implements Serializable {

    protected int myID;
    protected String myUserName;
    protected String myName;
    protected String myEmail;       //Protected Variables, Acssesible only to classes
    protected String myPassword;    //In the same Pacakge
    protected String myMobile;
    
    public ArrayList <Customer> myCustomerArrayList = new ArrayList<>();
    public ArrayList <Admin> myAdminArrayList = new ArrayList<>(); 
    public HashMap <String ,Customer> myCustomerHashMap = new HashMap<>();
    public HashMap <String, Admin> myAdminHashMap = new HashMap<>();
    
    int myMovieSize;
    int myCustomerSize;  
    int myAdminSize;
    int myMovieHallSize;
    
    
   public Human(){
      
       myMovieSize = 0;
       myCustomerSize = 0;
       myAdminSize = 0;
       myMovieHallSize = 0;
   } 
    
    public boolean setID(int myID){
        if(myID > 0){
            this.myID = myID;
            return true;
        }else{
            return false;
        }
    }
        
    public boolean setUserName(String myUserName){
       if(!myUserName.isEmpty()){
           this.myUserName = myUserName;
           return true;
       }else{
           return false;
       }
    }    
    
    public boolean setName(String myName){
       if(!myName.isEmpty()){
           this.myName = myName;
           return true;
       }else{
           return false;
       }
    }
    
            
    public boolean setEmail(String myEmail){
       if(!myEmail.isEmpty()){
           this.myEmail = myEmail;
           return true;
       }else{
           return false;
       }
    }

    public boolean setPassword(String myPassword){
       if(!myPassword.isEmpty()){
           this.myPassword = myPassword;
           return true;
       }else{
           return false;
       }
   }  
    
            
    public boolean setMobile(String myMobile){
       if(!myMobile.isEmpty()){
           this.myMobile = myMobile;
           return true;
       }else{
           return false;
       }
    }
       
    public int getID() { 
        return myID;
    }
    
    public String getUserName(){
        return myUserName;
    }
    
    public String getName(){
        return myName;
    }
    
    public String getEmail(){
        return myEmail;
    }
    
    public String getPassword(){
        return myPassword;
    }
    
    public String getMobile(){
        return myMobile;
    }
    
}
