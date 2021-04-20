package MovieAndPlayData;

import AddOns.Rating;
import Halls.Seat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Movie implements Serializable{
  
    public ArrayList <Seat> mySeatsArrayList;
    public ArrayList <Rating> myRatingsArrayList;
    
    private int movieID;
    private String movieName;
    private double  movieLength;
    private String movieLanguage;
    private String movieGenre;
    private String movieDescription;
    private double moviePrice;
    private Seat[] movieSeat;
    private int movieSeatSize;
    private int hallID;
    
    
   public Movie(){
        movieID = 0;
        movieName = " ";
        movieLength = 0.0;
        movieLanguage = " ";
        movieGenre = " ";
        movieDescription = " ";
        moviePrice = 0.0;
        movieSeatSize = 150;
        movieSeat = new Seat [movieSeatSize];
        mySeatsArrayList = new ArrayList <Seat>(150);
        myRatingsArrayList = new ArrayList <Rating>();
        for(int i=0;i<150;i++){
            mySeatsArrayList.add(i,new Seat(i+1));
        }
    } 
    
   
    public void setRate(Rating myRating){
        myRatingsArrayList.add(myRating);
        
    }
    public boolean setmovieID(int movieID){
   
       if (movieID > 0 && movieID <= 100){      
            this.movieID = movieID;
            return true;
       }
       else {
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
    
    public boolean setMovieName(String movieName){
       
        if (!"@".equals(movieName) && !"!".equals(movieName) && !"$".equals(movieName)){            
            this.movieName = movieName;
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean setMovieLength(double movieLength){
        
        if (movieLength > 0.00 && movieLength < 5.00 ){
            this.movieLength = movieLength;
            return true;
        }else{
            return false;
        }
    } 
    
    public boolean setMovieLanguage(String movieLanguage){
        
       if(!movieLanguage.isEmpty()){
            this.movieLanguage = movieLanguage;
            return true;
       }else{
            return false;
       }
    }
    
    public boolean setMovieGenre(String movieGenre){
        
       if(!movieGenre.isEmpty()){
            this.movieGenre = movieGenre;
            return true;
       }else{
            return false;
       }
    }
    
    public boolean setMovieType(String movieGenre){ 

        if(!movieGenre.isEmpty()){
        this.movieGenre = movieGenre;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean setMovieDescription(String movieDescription){
        if(!movieDescription.isEmpty()){
            this.movieDescription = movieDescription;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean setMoviePrice(double moviePrice){
        if(moviePrice > 0){
            this.moviePrice = moviePrice;
            return true;
        }else{
            return false;
        }
    }
    
    public int getID() {
    
        return movieID;
} 
    
    public int getHallID() {
    
        return hallID;
    } 
    
    public String getMovieName(){
        
        return movieName;
    }
    
    public double getMovieLength(){
        
        return movieLength;
    }
    
    public String getMovieLanguage(){
        
        return movieLanguage;
    }
    
    public String getMovieGenre(){
        
        return movieGenre;
    }
    
    public String getMovieDescription(){
        
        return movieDescription;
    }
    
    public double getMoviePrice(){
        return moviePrice;
    }
    
}
