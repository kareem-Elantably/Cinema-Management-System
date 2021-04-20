package Users;

import AddOns.RatingGUI;
import Halls.GrandTheaterHallGUI;
//import Halls.GrandTheaterHallGUI;
import Main.MainGUI;
import MovieAndPlayData.AdminAddPlayGUI;
import MovieAndPlayData.ExceptionFileManager;
import MovieAndPlayData.Play;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerPanelTheatreGUI extends JFrame {
    
    JButton AddNewPlay;
    JLabel SearchLabel;
    JTextField SearchField;
    JComboBox SearchComboBox;
    JButton LogoutButton;
    JLabel NameLabel;
    JLabel LanguageLabel;
    JLabel LengthLabel;
    JLabel GenreLabel;
    JLabel DescriptionLabel;
    JLabel PriceLabel;
    JLabel OptionsLabel;
    JPanel TableBarPanel;
    JButton ReserveButton;
    JButton RateButton;
    
    Container myCont;
    
    int LastY;
    
    //public static ArrayList <Play> myPlaysArrayList = new ArrayList <Play>();
    
    public CustomerPanelTheatreGUI(){
        setTitle("Customer Theatre Panel");
        setSize(1260,1000);
        setResizable(false);
        setLayout(null);
        myCont = getContentPane();
        
        
        SearchLabel = new JLabel("Search");
        SearchLabel.setBounds(400, 10, 100, 40);
        myCont.add(SearchLabel);
        SearchField = new JTextField();
        SearchField.setToolTipText("Search");
        SearchField.setBounds(450, 10, 200, 40);
        SearchField.addKeyListener(new SearchKeyListener());
        myCont.add(SearchField);
        SearchComboBox = new JComboBox();
        SearchComboBox.setBounds(655, 10, 100, 40);
        SearchComboBox.addItem("Name");
        SearchComboBox.addItem("Language");
        SearchComboBox.addItem("Genre");
        SearchComboBox.addItem("Price");
        SearchComboBox.addItemListener(new SearchItemListener());
        SearchComboBox.setToolTipText("Search By");
        myCont.add(SearchComboBox);
        LogoutButton = new JButton("Logout");
        LogoutButton.setBounds(1145, 10, 100, 40);
        LogoutButton.addActionListener(new Logout());
        myCont.add(LogoutButton);
        
        loadData();
        
        loadPlays();
        
    }
    
    public void iniGUI(){
        
        for(Component i: myCont.getComponents()){
            if(i != SearchLabel && i != SearchField && i != SearchComboBox && i != LogoutButton){
                myCont.remove(i);
            }
        }
        
        NameLabel = new JLabel("Name");
        NameLabel.setBounds(30, 75, 100, 30);
        myCont.add(NameLabel);
        LanguageLabel = new JLabel("Language");
        LanguageLabel.setBounds(280, 75, 100, 30);
        myCont.add(LanguageLabel);
        LengthLabel = new JLabel("Length");
        LengthLabel.setBounds(430, 75, 100, 30);
        myCont.add(LengthLabel);
        GenreLabel = new JLabel("Genre");
        GenreLabel.setBounds(580, 75, 100, 30);
        myCont.add(GenreLabel);
        DescriptionLabel = new JLabel("Description");
        DescriptionLabel.setBounds(730, 75, 100, 30);
        myCont.add(DescriptionLabel);
        PriceLabel = new JLabel("Price");
        PriceLabel.setBounds(900, 75, 100, 30);
        myCont.add(PriceLabel);
        OptionsLabel = new JLabel("Options");
        OptionsLabel.setBounds(1070, 75, 100, 30);
        myCont.add(OptionsLabel);
        TableBarPanel = new JPanel();
        TableBarPanel.setBounds(0, 60, 1260, 60);
        TableBarPanel.setBackground(Color.white);
        myCont.add(TableBarPanel);
        LastY = 140;
    }
    
    public class Logout implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MainGUI myMainGUI = new MainGUI();
            myMainGUI.setVisible(true);
            myMainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        }
        
    }
        
    public class SearchKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            loadPlays();
        }
        
    }
    
    public class SearchItemListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            loadPlays();
        }
        
    }
    
    public void loadData(){
       if(!ExceptionFileManager.loadPlaysData()){
            JOptionPane.showMessageDialog(myCont, "Error wile loading data from file");
        }
    }
        
    public void loadPlays(){
        iniGUI();
        if(!SearchField.getText().equals("")){
            if(SearchComboBox.getSelectedItem().toString().equals("Name")){
                for(Play i: ExceptionFileManager.myPlaysData){
                    if(i.getPlayName().toLowerCase().contains(SearchField.getText().toLowerCase())){
                        addPlayToGUI(i);
                    }
                }
            }else if(SearchComboBox.getSelectedItem().toString().equals("Language")){
                for(Play i: ExceptionFileManager.myPlaysData){
                    if(i.getPlayLanguage().toLowerCase().contains(SearchField.getText().toLowerCase())){
                        addPlayToGUI(i);
                    }
                }
            }else if(SearchComboBox.getSelectedItem().toString().equals("Genre")){
                for(Play i: ExceptionFileManager.myPlaysData){
                    if(i.getPlayGenre().toLowerCase().contains(SearchField.getText().toLowerCase())){
                        addPlayToGUI(i);
                    }
                }
            }else if(SearchComboBox.getSelectedItem().toString().equals("Price")){
                for(Play i: ExceptionFileManager.myPlaysData){
                    if(i.getPlayPrice() == Double.parseDouble(SearchField.getText().toLowerCase())){
                        addPlayToGUI(i);
                    }
                }
            }
        }else{
            for(Play i: ExceptionFileManager.myPlaysData){ 
                addPlayToGUI(i);
            }
        }
        refresh();
    }
    
    public void refresh(){
        myCont.setVisible(false);
        myCont.setVisible(true);
        
        SearchField.requestFocus(true);
    }
    
    public void addPlayToGUI(Play myPlay){
        NameLabel = new JLabel(myPlay.getPlayName());
        NameLabel.setToolTipText(myPlay.getPlayName());
        NameLabel.setBounds(30, LastY, 100, 30);
        myCont.add(NameLabel);
        LanguageLabel = new JLabel(myPlay.getPlayLanguage());
        LanguageLabel.setToolTipText(myPlay.getPlayLanguage());
        LanguageLabel.setBounds(280, LastY, 100, 30);
        myCont.add(LanguageLabel);
        LengthLabel = new JLabel(myPlay.getPlayLength()+"");
        LengthLabel.setToolTipText(myPlay.getPlayLength()+"");
        LengthLabel.setBounds(430, LastY, 100, 30);
        myCont.add(LengthLabel);
        GenreLabel = new JLabel(myPlay.getPlayGenre());
        GenreLabel.setToolTipText(myPlay.getPlayGenre());
        GenreLabel.setBounds(580, LastY, 100, 30);
        myCont.add(GenreLabel);
        DescriptionLabel = new JLabel(myPlay.getPlayDescription());
        DescriptionLabel.setToolTipText(myPlay.getPlayDescription());
        DescriptionLabel.setBounds(730, LastY, 100, 30);
        myCont.add(DescriptionLabel);
        PriceLabel = new JLabel(myPlay.getPlayPrice()+" EGP");
        PriceLabel.setToolTipText(myPlay.getPlayPrice()+" EGP");
        PriceLabel.setBounds(900, LastY, 100, 30);
        myCont.add(PriceLabel);
        ReserveButton = new JButton("Reserve");
        ReserveButton.setToolTipText("Reserve " + myPlay.getPlayName());
        ReserveButton.setBounds(1050, LastY, 90, 20);
        ReserveButton.addActionListener(new ReserveButtonListener(myPlay));
        myCont.add(ReserveButton);
        RateButton = new JButton("Rate");
        RateButton.setToolTipText("Rate" + myPlay.getPlayName());
        RateButton.setBounds(1150, LastY, 70, 20);
        RateButton.addActionListener(new RateButtonListener(myPlay));
        myCont.add(RateButton);
        LastY += 40;
    }
    
    public class ReserveButtonListener implements ActionListener{

        Play myEPlay;
        
        public ReserveButtonListener(Play myEPlay){
            this.myEPlay = myEPlay;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
            GrandTheaterHallGUI myGUI = new GrandTheaterHallGUI(myEPlay);
            myGUI.setVisible(true);
            myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
    }
    
    public class RateButtonListener implements ActionListener{

        Play myDPlay;
        
        public RateButtonListener(Play myDPlay){
            this.myDPlay = myDPlay;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
            //RatingGUI RG = new RatingGUI(myDPlay);
            //RG.setVisible(true);
            
        }
    
    }
    
}
