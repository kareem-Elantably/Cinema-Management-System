
package MovieAndPlayData;
/*
package cinemaprojectmid;
import java.io.BufferedWriter;
import Users.Client;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import Users.Client;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import AddMovieOrPlay.Manager;
import MovieAndPlay.Movie;
import java.util.ArrayList;
*/


import Users.Admin;
import Users.Customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moham
 */
public class ExceptionFileManager {
    
    String Path = "D:\\JAVA\\";  
    
    public static HashMap <String, Admin> myAdminsData = new HashMap <String, Admin>();
    public static HashMap <String, Customer> myCustomersData = new HashMap <String, Customer>();
    
    public static ArrayList <Movie> myMoviesData = new ArrayList <Movie>();
    public static ArrayList <Play> myPlaysData = new ArrayList <Play>();
    
    public static Customer currCustomer;
    
    
    
    public static boolean loadAdminsData(){
        
        ObjectInputStream Bin;
        try {
            Bin = new ObjectInputStream (new FileInputStream ("D:\\Java\\AdminsHashMap.bin"));
            myAdminsData = (HashMap <String, Admin>)Bin.readObject();
            Bin.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {       
            return false;
        }
    }    
    
    public static boolean loadCustomersData(){
        
        ObjectInputStream Bin;
        try {
            Bin = new ObjectInputStream (new FileInputStream ("D:\\Java\\CustomersHashMap.bin"));
            myCustomersData = (HashMap <String, Customer>)Bin.readObject();
            Bin.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {       
            return false;
        }
    }
    
    public static boolean loadMoviesData(){
        ObjectInputStream Bin;
        try {
            Bin = new ObjectInputStream (new FileInputStream ("D:\\Java\\MoviesArrayList.bin"));
            myMoviesData = (ArrayList<Movie>)Bin.readObject();
            Bin.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {       
            return false;
        }
    }

    public static boolean loadPlaysData(){
        ObjectInputStream Bin;
        try {
            Bin = new ObjectInputStream (new FileInputStream ("D:\\Java\\PlaysArrayList.bin"));
            myPlaysData = (ArrayList<Play>)Bin.readObject();
            Bin.close();
            System.out.println("Loaded");
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            return false;
        } catch (IOException ex) {
            System.out.println(ex);
            return false;
        } catch (ClassNotFoundException ex) {  
            System.out.println(ex);     
            return false;
        }
    }
    
    public static boolean saveAdminsData(){
        ObjectOutputStream Bout;
        try {
            Bout = new ObjectOutputStream (new FileOutputStream ("D:\\Java\\AdminsHashMap.bin"));
            Bout.writeObject(myAdminsData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public static boolean saveCustomerData(){
        ObjectOutputStream Bout;
        try {
            Bout = new ObjectOutputStream (new FileOutputStream ("D:\\Java\\CustomersHashMap.bin"));
            Bout.writeObject(myCustomersData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public static boolean saveMoviesData(){
        ObjectOutputStream Bout;
        try {
            Bout = new ObjectOutputStream (new FileOutputStream ("D:\\Java\\MoviesArrayList.bin"));
            Bout.writeObject(myMoviesData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            return false;   
        } catch (IOException ex) {  
            System.out.println(ex);
            return false;
        }   
    }
    
    public static boolean savePlaysData(){
        ObjectOutputStream Bout;
        try {
            Bout = new ObjectOutputStream (new FileOutputStream ("D:\\Java\\PlaysArrayList.bin"));
            Bout.writeObject(myPlaysData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public static boolean updateFromServer(String FileData){
        
        BufferedWriter Bout;
        try {
            Bout = new BufferedWriter (new FileWriter ("D:\\Java\\CustomersHashMap.bin"));
            Bout.write(FileData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            return false;
        } catch (IOException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static String getDataToSendToServer(){
        
        BufferedReader Bin;
        String readText = "";
        
        try {
            Bin = new BufferedReader (new FileReader ("D:\\Java\\CustomersHashMap.bin"));
            readText = Bin.readLine();
            Bin.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return readText;
    }
}
