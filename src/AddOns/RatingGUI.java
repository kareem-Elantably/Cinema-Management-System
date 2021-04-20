package AddOns;

import MovieAndPlayData.ExceptionFileManager;
import MovieAndPlayData.Movie;
import Users.CustomerPanelMovieGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RatingGUI extends JFrame {
    
    private final int RATINGS = 6;
    private Movie myMovie;
        JLabel RatingInstructions;
        JLabel RateMovie;
        JLabel RateMovieQuality;
        JLabel RateAudioQuality;
        JLabel Rate3dQuality;
        JLabel RateHall;
        JLabel RateOverall;
        JLabel Ideas;
        JLabel IdeasPT2;
        String [] Stars ={ "1","2","3" ,"4", "5"}; //Info inside the box
        JTextArea UserIdeas;
        JComboBox []Ratings;
        JButton Submit;
        Container cp;
    
    public RatingGUI(Movie myMovie){
        
        setSize(630,480);   
        setTitle("Rating");
        RatingInstructions = new JLabel("Out of 5 Stars Please Rate each of the following aspects ");
        RateMovie = new JLabel("Movie: ");
        RateMovieQuality = new JLabel("Picture Quality: ");
        RateAudioQuality = new JLabel ("Audio Quality: ");
        Rate3dQuality = new JLabel ("3D Quality: ");
        RateHall = new JLabel ("Hall Cleanlinees And Comfort: ");
        RateOverall = new JLabel ("Overall MIU Cinema's Rating: ");
        Ideas = new JLabel("Please Share with us any ideas or recomendations");
        IdeasPT2 = new JLabel("that would make your second visit more pleasent.");
        UserIdeas = new JTextArea(4,20);
        Ratings = new JComboBox[RATINGS];
        Submit = new JButton("Submit");
        
        this.myMovie = myMovie;
        
        //Initliazing Labels
        
        //Intiliazing ComboBoxes and its Array Of string Choices
        
        for (int i = 0; i < RATINGS; i++){
          Ratings[i] = new JComboBox(Stars);
        }
        //Initilizaing Text area
        
        //Setting the layoutmanager to null
        cp = getContentPane();
        cp.setLayout(null);
        
        //Manually Placing the GUI Elements
        cp.setBackground(Color.LIGHT_GRAY);
        cp.add(RatingInstructions);
        RatingInstructions.setBounds(150,20,350,20);
        cp.add(RateMovie);
        RateMovie.setBounds(30, 60, 40, 20);
        cp.add(Ratings[0]);
        Ratings[0].setBounds(220, 60, 90, 20);
        cp.add(RateMovieQuality);
        RateMovieQuality.setBounds(30, 90, 100, 20);
        cp.add(Ratings[1]);
        Ratings[1].setBounds(220, 90, 90, 20);
        cp.add(RateAudioQuality);
        RateAudioQuality.setBounds(30, 120, 100, 20);
        cp.add(Ratings[2]);
        Ratings[2].setBounds(220, 120, 90, 20);
        cp.add(Rate3dQuality);
        Rate3dQuality.setBounds(30, 150, 100, 20);
        cp.add(Ratings[3]);
        Ratings[3].setBounds(220, 150, 90, 20);
        cp.add(RateHall);
        RateHall.setBounds(30,180,190,20);
        cp.add(Ratings[4]);
        Ratings[4].setBounds(220, 180, 90, 20);
        cp.add(RateOverall);
        RateOverall.setBounds(30, 210, 170, 20);
        cp.add(Ratings[5]);
        Ratings[5].setBounds(220, 210, 90, 20);
        cp.add(Ideas);
        Ideas.setBounds(30,250,300,20);
        cp.add(IdeasPT2);
        IdeasPT2.setBounds(30, 265, 300,20);
        cp.add(UserIdeas);
        UserIdeas.setBounds(30, 300,300, 120);
        Submit.setBounds(450, 300, 100, 50);
        cp.add(Submit);
        Submit.addActionListener(new SubmitListener());
        
    }
    
    public class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Rating myRating = new Rating();
            myRating.setMovie(Integer.parseInt(Ratings[0].getSelectedItem().toString()));
            myRating.setPicture(Integer.parseInt(Ratings[0].getSelectedItem().toString()));
            myRating.setAudio(Integer.parseInt(Ratings[0].getSelectedItem().toString()));
            myRating.setThreeD(Integer.parseInt(Ratings[0].getSelectedItem().toString()));
            myRating.setComfort(Integer.parseInt(Ratings[0].getSelectedItem().toString()));
            myRating.setOverall(Integer.parseInt(Ratings[0].getSelectedItem().toString()));
            myRating.setExtra(UserIdeas.getText());
            for(Movie i: ExceptionFileManager.myMoviesData){
                if(i.equals(myMovie)){
                    i.myRatingsArrayList.add(myRating);
                    if(ExceptionFileManager.saveMoviesData()){
                        JOptionPane.showMessageDialog(cp, "Thank You!");
                        dispose();
                        CustomerPanelMovieGUI myGUI = new CustomerPanelMovieGUI();
                        myGUI.setVisible(true);
                        myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }else{
                        JOptionPane.showMessageDialog(cp, "Error!");
                    }
                }
            }
        }
        
    }
    
}
