package MovieAndPlayData;

import Users.Admin;
import Users.AdminPanelTheatreGUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditPlayGUI extends JFrame{
    
    Play myPlay;
    
    JLabel lblEditPlay;
    JLabel lblPlayName;
    JLabel lblPlayLength;
    JLabel lblPlayLanguage;
    JLabel lblPlayGenre;
    JLabel lblPlayDesc;
    JLabel lblPlayPrice;
        
    JTextField txtfPlayName;
    JTextField txtfPlayLength;
    JTextField txtfPlayDesc;
    JTextField txtfPlayPrice;
    
    JComboBox comboLang;
    JComboBox comboGenre;
    
    JButton Save;
    
    JButton Back;
    
    Container cont;
    
    private final int LANGUAGES = 3;
    private final int GENRES = 7;
     
    
    public EditPlayGUI(Play myPlay){
        
       setSize(485, 470);
       setTitle("Edit Play");
       
       this.myPlay = myPlay;
       
        lblEditPlay = new JLabel ("Edit Play");
        lblPlayName = new JLabel("Enter Play Name: ");
        lblPlayLength = new JLabel("Enter Play Length: ");
        lblPlayLanguage = new JLabel("Enter Play Language: ");
        lblPlayGenre = new JLabel("Enter Play Genre: ");
        lblPlayDesc = new JLabel("Enter Play Description: ");
        lblPlayPrice = new JLabel("Enter Play Price: ");
        
        
        txtfPlayName = new JTextField(20);
        txtfPlayLength = new JTextField(20);
        txtfPlayDesc = new JTextField(20);
        txtfPlayPrice = new JTextField(20);
        //Play seat , Play seat size
            
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
        
        cont.add(lblEditPlay);
        lblEditPlay.setBounds(150, 40,200,25);
        cont.add(lblPlayName);
        lblEditPlay.setFont(new Font("Calibiri",Font.BOLD,25));
        lblPlayName.setBounds(50, 110, 150, 25);
        cont.add(txtfPlayName);
        txtfPlayName.addFocusListener(new PlayTxtFocusListener());
        txtfPlayName.setBounds(200, 110, 200, 25);
        txtfPlayName.setText(myPlay.getPlayName());
        cont.add(lblPlayLength);
        lblPlayLength.setBounds(50, 150, 150, 25);
        cont.add(txtfPlayLength);
        txtfPlayLength.addFocusListener(new PlayTxtFocusListener());
        txtfPlayLength.setBounds(200, 150, 200, 25);
        txtfPlayLength.setText(myPlay.getPlayLength()+"");
        cont.add(lblPlayLanguage);
        lblPlayLanguage.setBounds(50, 190, 150, 25);
        cont.add(comboLang);
        comboLang.setBounds(200, 190, 200, 25);
        comboLang.setSelectedItem(myPlay.getPlayLanguage());
        cont.add(lblPlayGenre);
        lblPlayGenre.setBounds(50, 230, 150, 25);
        cont.add(comboGenre);
        comboGenre.setBounds(200, 230, 200, 25);
        comboGenre.setSelectedItem(myPlay.getPlayGenre());
        cont.add(lblPlayDesc);
        lblPlayDesc.setBounds(50, 270, 150, 25);
        cont.add(txtfPlayDesc);
        txtfPlayDesc.setText(myPlay.getPlayDescription());
        txtfPlayDesc.addFocusListener(new PlayTxtFocusListener());
        txtfPlayDesc.setBounds(200, 270, 200, 25);
        cont.add(lblPlayPrice);
        lblPlayPrice.setBounds(50, 310, 150, 25);
        cont.add(txtfPlayPrice);
        txtfPlayPrice.setBounds(200, 310, 200, 25);
        txtfPlayPrice.addFocusListener(new PlayTxtFocusListener());
        txtfPlayPrice.setText(myPlay.getPlayPrice()+"");
        cont.add(Save);
        Save.setBounds(300, 350, 100, 25);
        Save.addActionListener(new PlayWatcher(myPlay));
        cont.add(Back);
        Back.setBounds(50,350,100,25);
        Back.addActionListener(new back());
    }
    
    public class PlayTxtFocusListener implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            javax.swing.border.Border myBorder = BorderFactory.createLineBorder(Color.RED, 1);
            if(e.getSource().equals(txtfPlayName)){
                if(txtfPlayName.getText().equals("")){
                    txtfPlayName.setBorder(myBorder);
                }else{
                    txtfPlayName.setBorder(null);
                }
            }else if(e.getSource().equals(txtfPlayLength)){
                if(txtfPlayLength.getText().equals("")){
                    txtfPlayLength.setBorder(myBorder);
                }else{
                    txtfPlayLength.setBorder(null);
                }
            }else if(e.getSource().equals(txtfPlayDesc)){
                if(txtfPlayDesc.getText().equals("")){
                    txtfPlayDesc.setBorder(myBorder);
                }else{
                    txtfPlayDesc.setBorder(null);
                }
            }else if(e.getSource().equals(txtfPlayPrice)){
                if(txtfPlayPrice.getText().equals("")){
                    txtfPlayPrice.setBorder(myBorder);
                }else{
                    txtfPlayPrice.setBorder(null);
                }
            }
        }
    }
    
    public class PlayWatcher implements ActionListener{
        
        Play myPlay;
        
        public PlayWatcher(Play myPlay){
            this.myPlay = myPlay;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!txtfPlayDesc.getText().equals("") && !txtfPlayLength.getText().equals("") && !txtfPlayName.getText().equals("") && !txtfPlayPrice.getText().equals("")){
                Play myNewPlay = new Play();
                myNewPlay.setPlayDescription(txtfPlayDesc.getText());
                myNewPlay.setPlayGenre(comboGenre.getSelectedItem().toString());
                myNewPlay.setPlayLanguage(comboLang.getSelectedItem().toString());
                myNewPlay.setPlayLength(Double.parseDouble(txtfPlayLength.getText()));
                myNewPlay.setPlayName(txtfPlayName.getText());
                myNewPlay.setPlayPrice(Double.parseDouble(txtfPlayPrice.getText()));
                Admin myAdmin = new Admin();
                    if(myAdmin.editTheatreArray(this.myPlay, myNewPlay)){
                        JOptionPane.showMessageDialog(cont, "Play Successfully Edited!");
                        AdminPanelTheatreGUI myAdminPanelGUI = new AdminPanelTheatreGUI();
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
            AdminPanelTheatreGUI myGUI = new AdminPanelTheatreGUI();
            dispose();
            myGUI.setVisible(true);
        }
        
    }
     

}