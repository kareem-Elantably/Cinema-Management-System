package MovieAndPlayData;

import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminUpdatePlayGUI extends JFrame {
    
    private final int LANGUAGES = 3;
     private final int GENRES = 7;
    
    public AdminUpdatePlayGUI(){
        
       setSize(630, 480);
       setTitle("Update Play");
       
        JLabel lblAddPlay = new JLabel ("Add Play");
        JLabel lblPlayName = new JLabel("Enter Play Name: ");
        JLabel lblPlayLength = new JLabel("Enter Play Length: ");
        JLabel lblPlayLanguage = new JLabel("Enter Play Language: ");
        JLabel lblPlayGenre = new JLabel("Enter Play Genre: ");
        JLabel lblPlayDesc = new JLabel("Enter Play Description: ");
        JLabel lblPlayPrice = new JLabel("Enter Play Price: ");
        
        
        JTextField txtfPlayName = new JTextField(20);
        JTextField txtfPlayLength = new JTextField(20);
        JTextField txtfPlayDesc = new JTextField(20);
        JTextField txtfPlayPrice = new JTextField(20);
               
        
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
        
        cont.add(lblAddPlay);
        lblAddPlay.setBounds(200,20,100,25);
        //------------------------------------------------------
        cont.add(lblPlayName);
        lblPlayName.setBounds(20, 60, 150, 25);
        cont.add(txtfPlayName);
        txtfPlayName.setBounds(180, 60, 100, 25);
        cont.add(lblPlayLength);
        lblPlayLength.setBounds(20, 90, 150, 25);
        cont.add(txtfPlayLength);
        txtfPlayLength.setBounds(180, 90, 100, 25);
        cont.add(lblPlayLanguage);
        lblPlayLanguage.setBounds(20, 120, 150, 25);
        cont.add(comboLang[0]);
        comboLang[0].setBounds(180, 120, 100, 25);
        cont.add(lblPlayGenre);
        lblPlayGenre.setBounds(20, 150, 150, 25);
        cont.add(comboGenre[0]);
        comboGenre[0].setBounds(180, 150, 100, 25);
        cont.add(lblPlayDesc);
        lblPlayDesc.setBounds(20, 180, 150, 25);
        cont.add(txtfPlayDesc);
        txtfPlayDesc.setBounds(180, 180, 100, 25);
        cont.add(lblPlayPrice);
        lblPlayPrice.setBounds(20, 210, 150, 25);
        cont.add(txtfPlayPrice);
        txtfPlayPrice.setBounds(180, 210, 100, 25);
    
    }
    
}
