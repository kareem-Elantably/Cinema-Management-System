package Main;
import AddOns.GraphicalStats;
import MovieAndPlayData.Movie;
import Users.Admin;
import Users.Customer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;
    
public class CinemaProject { 

    static Scanner Input = new Scanner(System.in);
    static Admin myAdmin = new Admin();
    static Customer myCustomer = new Customer();
    static Movie myMovie = new Movie();
    static int Choice = 0;
    static int Login = 0;
    static String CurrUserName = "";

       
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
      music();
      GraphicalStats myGUI = new GraphicalStats();
      myGUI.setVisible(true);
      MainGUI MG = new MainGUI();
      MG.setVisible(true);
      MG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     public static void music()
     {
         try{
       File clipFile = new File("D:\\Java\\Sound.wav"); 
       AudioInputStream audioStrmObj = AudioSystem.getAudioInputStream(clipFile);
       AudioFormat format = audioStrmObj.getFormat();
       DataLine.Info info = new DataLine.Info(Clip.class, format); 
       Clip audioClip = (Clip) AudioSystem.getLine(info);
       audioClip.open(audioStrmObj);
       audioClip.loop(Clip.LOOP_CONTINUOUSLY);
         }catch(Exception e){
             
         }
   }
}
 


