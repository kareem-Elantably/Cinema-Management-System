package MovieAndPlayData;

import Users.Admin;
import Users.AdminPanelMovieGUI;
import Users.AdminPanelTheatreGUI;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class AdminAddPlayGUI extends JFrame {
    
    JTextField txtfPlayName;
    JTextField txtfPlayLength;
    JTextField txtfPlayLanguage;
    JTextField txtfPlayGenre;
    JTextField txtfPlayDesc;
    JTextField txtfPlayPrice;
    
    JComboBox  comboLang;
    JComboBox  comboGenre;
    
    JButton Save;
    JButton Back;
    
    Container cont;
    
    private final int LANGUAGES = 3;
     private final int GENRES = 7;
    
    public AdminAddPlayGUI(){
        
       setSize(630, 480);
       setTitle("Add Play");
       
        JLabel lblAddPlay = new JLabel ("Add Play");
        JLabel lblPlayName = new JLabel("Enter Play Name: ");
        JLabel lblPlayLength = new JLabel("Enter Play Length: ");
        JLabel lblPlayLanguage = new JLabel("Enter Play Language: ");
        JLabel lblPlayGenre = new JLabel("Enter Play Genre: ");
        JLabel lblPlayDesc = new JLabel("Enter Play Description: ");
        JLabel lblPlayPrice = new JLabel("Enter Play Price: ");
        
        
        txtfPlayName = new JTextField(20);
        txtfPlayLength = new JTextField(20);
        txtfPlayLanguage = new JTextField(20);
        txtfPlayGenre = new JTextField(20);
        txtfPlayDesc = new JTextField(20);
        txtfPlayPrice = new JTextField(20);
               
        Save = new JButton("Save");
        Back = new JButton("Back");
        
        String [] Lang = {"Arabic","English","French"};
        
        comboLang = new JComboBox();
        for(int i =0;i<LANGUAGES;i++)
        {
            comboLang.addItem(Lang[i]);
        }
        
        
        String [] Genre = {"Comedy","Action","Drama","Horror","Family","Adventure","SCI-FI"};
        
        comboGenre = new JComboBox();
        for(int i =0;i<GENRES;i++)
        {
            comboGenre.addItem(Genre[i]);
        }
        
        
        
        cont = getContentPane();
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
        cont.add(comboLang);
        comboLang.setBounds(180, 120, 100, 25);
        cont.add(lblPlayGenre);
        lblPlayGenre.setBounds(20, 150, 150, 25);
        cont.add(comboGenre);
        comboGenre.setBounds(180, 150, 100, 25);
        cont.add(lblPlayDesc);
        lblPlayDesc.setBounds(20, 180, 150, 25);
        cont.add(txtfPlayDesc);
        txtfPlayDesc.setBounds(180, 180, 100, 25);
        cont.add(lblPlayPrice);
        lblPlayPrice.setBounds(20, 210, 150, 25);
        cont.add(txtfPlayPrice);
        txtfPlayPrice.setBounds(180, 210, 100, 25);
        cont.add(Save);
        Save.setBounds(180, 250, 100, 25);
        Save.addActionListener(new playWatcher());
        cont.add(Back);
        Back.setBounds(120,250,100,25);
        Back.addActionListener(new back());
        
    }
    
    public class playWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Play myPlay = new Play();
            myPlay.setPlayDescription(txtfPlayDesc.getText());
            myPlay.setPlayGenre(comboGenre.getSelectedItem().toString());
            myPlay.setPlayLanguage(comboLang.getSelectedItem().toString());
            myPlay.setPlayLength(Integer.parseInt(txtfPlayLength.getText()));
            myPlay.setPlayName(txtfPlayName.getText());
            myPlay.setPlayPrice(Integer.parseInt(txtfPlayPrice.getText()));
            Admin myAdmin = new Admin();
                if(myAdmin.addTheatreArray(myPlay)){
                    JOptionPane.showMessageDialog(cont, "Play Successfully Added!");
                }else{
                    JOptionPane.showMessageDialog(cont, "Error !!");                    
                }
        }
        
    }
    public class back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPanelTheatreGUI myGUI = new AdminPanelTheatreGUI();
            dispose();
            myGUI.setVisible(true);
        }   
    }
}

