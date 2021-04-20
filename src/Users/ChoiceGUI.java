package Users;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChoiceGUI extends JFrame {
   
    JLabel Choice;
    JButton Plays;
    JButton Movies;
    
   public ChoiceGUI(){
       
       setSize(400,400);
       setTitle("Choice");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       getContentPane();
       setLayout(null);
       
       Choice = new JLabel("Choice");
       Choice.setFont(new Font("Calibiri",Font.BOLD,30));
       Plays = new JButton("Plays");
       Movies = new JButton("Movies");
       
       add(Choice);
       add(Plays);
       add(Movies);
       Choice.setBounds(130,0,100,100);
       Plays.setBounds(130,80,100,50);
       Movies.setBounds(130,150,100,50);
       Plays.addActionListener(new plays ());
       Movies.addActionListener(new movies());
       
   } 
    
   public class plays implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            CustomerPanelTheatreGUI myGUI = new CustomerPanelTheatreGUI();
            myGUI.setVisible(true);
        }
   }
           
           
   public class movies implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            CustomerPanelMovieGUI myGUI = new CustomerPanelMovieGUI();
            myGUI.setVisible(true);
        }
       
   }
           
}
