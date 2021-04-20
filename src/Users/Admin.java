package Users;

import MovieAndPlayData.ExceptionFileManager;
import MovieAndPlayData.Play;
import MovieAndPlayData.Movie;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

   public class Admin extends Human implements Serializable {
    
   protected static int Size;
   protected static int countLines = 0;
   protected static int MAX = 4;
    
   public Admin(){
       Size = 0;
   }
   
  public Admin(int id,String UserName,String Password){
        
     this.myID = id;
     this.myUserName = UserName;
     this.myPassword = Password;
   }
   
      public boolean RegisterAsAdminHash(Admin myAdmin){    
          ExceptionFileManager.myAdminsData.put(myAdmin.getUserName(), myAdmin);
          if(ExceptionFileManager.saveAdminsData()){
                return true;
          }
          return false;
      }
 
      public boolean LoginAsAdminHash (String Username ,String Password){
          
          if(ExceptionFileManager.loadAdminsData()){
              for (Admin i : ExceptionFileManager.myAdminsData.values()){
                   if(i.getUserName().toString().equals(Username) && i.getPassword().toString().equals(Password)){
                       return true;
                   } 
               }
            }
           return false;
      }
        
        public boolean addMovieArray (Movie myMovie){
            ExceptionFileManager.myMoviesData.add(myMovie);
            if(ExceptionFileManager.saveMoviesData()){
                return true;
            }
            return false;
        }
        
        public boolean editMovieArray (Movie oldMovie, Movie myMovie){
            ExceptionFileManager.myMoviesData.remove(oldMovie);
            ExceptionFileManager.myMoviesData.add(myMovie);
            if(ExceptionFileManager.saveMoviesData()){
                return true;
            }
            return false;
        }
       
         public boolean addTheatreArray (Play myPlay){
            ExceptionFileManager.myPlaysData.add(myPlay);
            if(ExceptionFileManager.savePlaysData()){
                return true;
            }
            return false;
        }
        
         public boolean editTheatreArray (Play oldPlay, Play myPlay){
            ExceptionFileManager.myPlaysData.remove(oldPlay);
            ExceptionFileManager.myPlaysData.add(myPlay);
            if(ExceptionFileManager.savePlaysData()){
                return true;
                
            }
            return false;
        }
}


        

