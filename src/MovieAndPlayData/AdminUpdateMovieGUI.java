package MovieAndPlayData;

import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AdminUpdateMovieGUI extends JFrame {
    
     private final int LANGUAGES = 3;
     private final int GENRES = 7;
     
    
   public AdminUpdateMovieGUI(){
        
       setSize(630, 480);
       setTitle("Update Movie");
       
        JLabel lblAddMovie = new JLabel ("Add Movie");
        JLabel lblMovieName = new JLabel("Enter Movie Name: ");
        JLabel lblMovieLength = new JLabel("Enter Movie Length: ");
        JLabel lblMovieLanguage = new JLabel("Enter Movie Language: ");
        JLabel lblMovieGenre = new JLabel("Enter Movie Genre: ");
        JLabel lblMovieDesc = new JLabel("Enter Movie Description: ");
        JLabel lblMoviePrice = new JLabel("Enter Movie Price: ");
        
        
        JTextField txtfMovieName = new JTextField(20);
        JTextField txtfMovieLength = new JTextField(20);
        JTextField txtfMovieDesc = new JTextField(20);
        JTextField txtfMoviePrice = new JTextField(20);
        //movie seat , ovie seat size
               
        String[] Lang = {"Arabic","English","French"};
        
        JComboBox [] comboLang = new JComboBox[LANGUAGES];
        for(int i =0;i<LANGUAGES;i++)
        {
            comboLang[i]=new JComboBox(Lang);
        }
        
        
        String[] Genre = {"Comedy","Action","Drama","Horror","Family","Adventure","SCI-FI"};
        
        JComboBox [] comboGenre = new JComboBox[GENRES];
        for(int i =0;i<GENRES;i++)
        {
            comboGenre[i]=new JComboBox(Genre);
        }
        
        
        Container cont = getContentPane();
        cont.setLayout(null);
        
        cont.add(lblAddMovie);
        lblAddMovie.setBounds(200,20,100,25);
        //------------------------------------------------------
        cont.add(lblMovieName);
        lblMovieName.setBounds(20, 60, 150, 25);
        cont.add(txtfMovieName);
        txtfMovieName.setBounds(180, 60, 100, 25);
        cont.add(lblMovieLength);
        lblMovieLength.setBounds(20, 90, 150, 25);
        cont.add(txtfMovieLength);
        txtfMovieLength.setBounds(180, 90, 100, 25);
        cont.add(lblMovieLanguage);
        lblMovieLanguage.setBounds(20, 120, 150, 25);
        cont.add(comboLang[0]);
        comboLang[0].setBounds(180, 120, 100, 25);
        cont.add(lblMovieGenre);
        lblMovieGenre.setBounds(20, 150, 150, 25);
        cont.add(comboGenre[0]);
        comboGenre[0].setBounds(180, 150, 100, 25);
        cont.add(lblMovieDesc);
        lblMovieDesc.setBounds(20, 180, 150, 25);
        cont.add(txtfMovieDesc);
        txtfMovieDesc.setBounds(180, 180, 100, 25);
        cont.add(lblMoviePrice);
        lblMoviePrice.setBounds(20, 210, 150, 25);
        cont.add(txtfMoviePrice);
        txtfMoviePrice.setBounds(180, 210, 100, 25);
        
   }
    
}
