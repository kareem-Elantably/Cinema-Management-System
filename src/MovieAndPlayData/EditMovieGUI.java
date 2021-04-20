package MovieAndPlayData;

import Users.Admin;
import Users.AdminPanelMovieGUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditMovieGUI extends JFrame{
    
    Movie myMovie;
    
    JLabel lblEditMovie;
    JLabel lblMovieName;
    JLabel lblMovieLength;
    JLabel lblMovieLanguage;
    JLabel lblMovieGenre;
    JLabel lblMovieDesc;
    JLabel lblMoviePrice;
        
    JTextField txtfMovieName;
    JTextField txtfMovieLength;
    JTextField txtfMovieDesc;
    JTextField txtfMoviePrice;
    
    JComboBox comboLang;
    JComboBox comboGenre;
    
    JButton Save;
    
    JButton Back;
    
    Container cont;
    
    private final int LANGUAGES = 3;
    private final int GENRES = 7;
     
    
    public EditMovieGUI(Movie myMovie){
        
       setSize(485, 470);
       setTitle("Edit Movie");
       
       this.myMovie = myMovie;
       
        lblEditMovie = new JLabel ("Edit Movie");
        lblMovieName = new JLabel("Enter Movie Name: ");
        lblMovieLength = new JLabel("Enter Movie Length: ");
        lblMovieLanguage = new JLabel("Enter Movie Language: ");
        lblMovieGenre = new JLabel("Enter Movie Genre: ");
        lblMovieDesc = new JLabel("Enter Movie Description: ");
        lblMoviePrice = new JLabel("Enter Movie Price: ");
        
        
        txtfMovieName = new JTextField(20);
        txtfMovieLength = new JTextField(20);
        txtfMovieDesc = new JTextField(20);
        txtfMoviePrice = new JTextField(20);
            
        Save = new JButton("Save");
        
        Back = new JButton("Back");
        
        String[] Lang = {"Arabic","English","French"};
        
        comboLang = new JComboBox();
        for(int i =0;i<LANGUAGES;i++)
        {
            comboLang.addItem(Lang[i]);
        }
        
        
        String[] Genre = {"Comedy","Action","Drama","Horror","Family","Adventure","SCI-FI"};
        
        comboGenre = new JComboBox();
        for(int i =0;i<GENRES;i++)
        {
            comboGenre.addItem(Genre[i]);
        }
        
        
        cont = getContentPane();
        cont.setLayout(null);
        
        cont.add(lblEditMovie);
        lblEditMovie.setBounds(150, 40,200,25);
        cont.add(lblMovieName);
        lblEditMovie.setFont(new Font("Calibiri",Font.BOLD,25));
        lblMovieName.setBounds(50, 110, 150, 25);
        cont.add(txtfMovieName);
        txtfMovieName.addFocusListener(new movieTxtFocusListener());
        txtfMovieName.setBounds(200, 110, 200, 25);
        txtfMovieName.setText(myMovie.getMovieName());
        cont.add(lblMovieLength);
        lblMovieLength.setBounds(50, 150, 150, 25);
        cont.add(txtfMovieLength);
        txtfMovieLength.addFocusListener(new movieTxtFocusListener());
        txtfMovieLength.setBounds(200, 150, 200, 25);
        txtfMovieLength.setText(myMovie.getMovieLength()+"");
        cont.add(lblMovieLanguage);
        lblMovieLanguage.setBounds(50, 190, 150, 25);
        cont.add(comboLang);
        comboLang.setBounds(200, 190, 200, 25);
        comboLang.setSelectedItem(myMovie.getMovieLanguage());
        cont.add(lblMovieGenre);
        lblMovieGenre.setBounds(50, 230, 150, 25);
        cont.add(comboGenre);
        comboGenre.setBounds(200, 230, 200, 25);
        comboGenre.setSelectedItem(myMovie.getMovieGenre());
        cont.add(lblMovieDesc);
        lblMovieDesc.setBounds(50, 270, 150, 25);
        cont.add(txtfMovieDesc);
        txtfMovieDesc.setText(myMovie.getMovieDescription());
        txtfMovieDesc.addFocusListener(new movieTxtFocusListener());
        txtfMovieDesc.setBounds(200, 270, 200, 25);
        cont.add(lblMoviePrice);
        lblMoviePrice.setBounds(50, 310, 150, 25);
        cont.add(txtfMoviePrice);
        txtfMoviePrice.setBounds(200, 310, 200, 25);
        txtfMoviePrice.addFocusListener(new movieTxtFocusListener());
        txtfMoviePrice.setText(myMovie.getMoviePrice()+"");
        cont.add(Save);
        Save.setBounds(300, 350, 100, 25);
        Save.addActionListener(new movieWatcher(myMovie));
        cont.add(Back);
        Back.setBounds(50,350,100,25);
        Back.addActionListener(new back());
    }
    
    public class movieTxtFocusListener implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            javax.swing.border.Border myBorder = BorderFactory.createLineBorder(Color.RED, 1);
            if(e.getSource().equals(txtfMovieName)){
                if(txtfMovieName.getText().equals("")){
                    txtfMovieName.setBorder(myBorder);
                }else{
                    txtfMovieName.setBorder(null);
                }
            }else if(e.getSource().equals(txtfMovieLength)){
                if(txtfMovieLength.getText().equals("")){
                    txtfMovieLength.setBorder(myBorder);
                }else{
                    txtfMovieLength.setBorder(null);
                }
            }else if(e.getSource().equals(txtfMovieDesc)){
                if(txtfMovieDesc.getText().equals("")){
                    txtfMovieDesc.setBorder(myBorder);
                }else{
                    txtfMovieDesc.setBorder(null);
                }
            }else if(e.getSource().equals(txtfMoviePrice)){
                if(txtfMoviePrice.getText().equals("")){
                    txtfMoviePrice.setBorder(myBorder);
                }else{
                    txtfMoviePrice.setBorder(null);
                }
            }
        }
    }
    
    public class movieWatcher implements ActionListener{
        
        Movie myMovie;
        
        public movieWatcher(Movie myMovie){
            this.myMovie = myMovie;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!txtfMovieDesc.getText().equals("") && !txtfMovieLength.getText().equals("") && !txtfMovieName.getText().equals("") && !txtfMoviePrice.getText().equals("")){
                Movie myNewMovie = new Movie();
                myNewMovie.setMovieDescription(txtfMovieDesc.getText());
                myNewMovie.setMovieGenre(comboGenre.getSelectedItem().toString());
                myNewMovie.setMovieLanguage(comboLang.getSelectedItem().toString());
                myNewMovie.setMovieLength(Double.parseDouble(txtfMovieLength.getText()));
                myNewMovie.setMovieName(txtfMovieName.getText());
                myNewMovie.setMoviePrice(Double.parseDouble(txtfMoviePrice.getText()));
                Admin myAdmin = new Admin();
                    if(myAdmin.editMovieArray(this.myMovie, myNewMovie)){
                        JOptionPane.showMessageDialog(cont, "Movie Successfully Edited!");
                        AdminPanelMovieGUI myAdminPanelGUI = new AdminPanelMovieGUI();
                        myAdminPanelGUI.setVisible(true);
                        myAdminPanelGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(cont, "Error !!");                    
                    }
            }
        }
        
    }
    
     public class back implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPanelMovieGUI myGUI = new AdminPanelMovieGUI();
            dispose();
            myGUI.setVisible(true);
        }
        
    }     

}