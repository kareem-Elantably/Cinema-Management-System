package Users;

import AddOns.RatingGUI;
import Halls.GrandMovieHallGUI;
import Main.MainGUI;
import MovieAndPlayData.AdminAddMovieGUI;
import MovieAndPlayData.ExceptionFileManager;
import MovieAndPlayData.Movie;
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

public class CustomerPanelMovieGUI extends JFrame {
    
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
    
    public CustomerPanelMovieGUI(){
        setTitle("Cusomer Movie Panel");
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
        
        loadMovies();
        
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
            loadMovies();
        }
        
    }
    
    public class SearchItemListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            loadMovies();
        }
        
    }
    
    public void loadData(){
        if(!ExceptionFileManager.loadMoviesData()){
            JOptionPane.showMessageDialog(myCont, "Error wile loading data from file");
        }
    }
        
    public void loadMovies(){
        iniGUI();
        if(!SearchField.getText().equals("")){
            if(SearchComboBox.getSelectedItem().toString().equals("Name")){
                for(Movie i: ExceptionFileManager.myMoviesData){
                    if(i.getMovieName().toLowerCase().contains(SearchField.getText().toLowerCase())){
                        addMovieToGUI(i);
                    }
                }
            }else if(SearchComboBox.getSelectedItem().toString().equals("Language")){
                for(Movie i: ExceptionFileManager.myMoviesData){
                    if(i.getMovieLanguage().toLowerCase().contains(SearchField.getText().toLowerCase())){
                        addMovieToGUI(i);
                    }
                }
            }else if(SearchComboBox.getSelectedItem().toString().equals("Genre")){
                for(Movie i: ExceptionFileManager.myMoviesData){
                    if(i.getMovieGenre().toLowerCase().contains(SearchField.getText().toLowerCase())){
                        addMovieToGUI(i);
                    }
                }
            }else if(SearchComboBox.getSelectedItem().toString().equals("Price")){
                for(Movie i: ExceptionFileManager.myMoviesData){
                    if(i.getMoviePrice() == Double.parseDouble(SearchField.getText().toLowerCase())){
                        addMovieToGUI(i);
                    }
                }
            }
        }else{
            for(Movie i: ExceptionFileManager.myMoviesData){ 
                addMovieToGUI(i);
            }
        }
        refresh();
    }
    
    public void refresh(){
        myCont.setVisible(false);
        myCont.setVisible(true);
        
        SearchField.requestFocus(true);
    }
    
    public void addMovieToGUI(Movie myMovie){
        NameLabel = new JLabel(myMovie.getMovieName());
        NameLabel.setToolTipText(myMovie.getMovieName());
        NameLabel.setBounds(30, LastY, 100, 30);
        myCont.add(NameLabel);
        LanguageLabel = new JLabel(myMovie.getMovieLanguage());
        LanguageLabel.setToolTipText(myMovie.getMovieLanguage());
        LanguageLabel.setBounds(280, LastY, 100, 30);
        myCont.add(LanguageLabel);
        LengthLabel = new JLabel(myMovie.getMovieLength()+"");
        LengthLabel.setToolTipText(myMovie.getMovieLength()+"");
        LengthLabel.setBounds(430, LastY, 100, 30);
        myCont.add(LengthLabel);
        GenreLabel = new JLabel(myMovie.getMovieGenre());
        GenreLabel.setToolTipText(myMovie.getMovieGenre());
        GenreLabel.setBounds(580, LastY, 100, 30);
        myCont.add(GenreLabel);
        DescriptionLabel = new JLabel(myMovie.getMovieDescription());
        DescriptionLabel.setToolTipText(myMovie.getMovieDescription());
        DescriptionLabel.setBounds(730, LastY, 100, 30);
        myCont.add(DescriptionLabel);
        PriceLabel = new JLabel(myMovie.getMoviePrice()+" EGP");
        PriceLabel.setToolTipText(myMovie.getMoviePrice()+" EGP");
        PriceLabel.setBounds(900, LastY, 100, 30);
        myCont.add(PriceLabel);
        ReserveButton = new JButton("Reserve");
        ReserveButton.setToolTipText("Reserve " + myMovie.getMovieName());
        ReserveButton.setBounds(1050, LastY, 90, 20);
        ReserveButton.addActionListener(new ReserveButtonListener(myMovie));
        myCont.add(ReserveButton);
        RateButton = new JButton("Rate");
        RateButton.setToolTipText("Rate " + myMovie.getMovieName());
        RateButton.setBounds(1150, LastY, 70, 20);
        RateButton.addActionListener(new RateButtonListener(myMovie));
        myCont.add(RateButton);
        LastY += 40;
    }
    
    public class ReserveButtonListener implements ActionListener{

        Movie myEMovie;
        
        public ReserveButtonListener(Movie myEMovie){
            this.myEMovie = myEMovie;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            GrandMovieHallGUI myGui = new GrandMovieHallGUI(myEMovie);
            myGui.setVisible(true);
            myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
    }
    
    public class RateButtonListener implements ActionListener{

        Movie myDMovie;
        
        public RateButtonListener(Movie myDMovie){
            this.myDMovie = myDMovie;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
            RatingGUI RG = new RatingGUI(myDMovie);
            RG.setVisible(true);
            RG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }    
    }    
}
