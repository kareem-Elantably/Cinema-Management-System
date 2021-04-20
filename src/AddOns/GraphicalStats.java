package AddOns;

import java.awt.BasicStroke;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;

public class GraphicalStats extends JFrame{

    Component cp;
    JLabel movies;
    JLabel cantineItems;
    JLabel Stats;
    JLabel Movie1;
    JLabel Movie2;
    JLabel Movie3;
    JLabel Movie4;
    JLabel Movie5;
    JLabel Item1;
    JLabel Item2;
    JLabel Item3;
    JLabel Item4;
    JLabel Item5;
    JLabel Item6;
    JLabel myTest;
  
    public GraphicalStats()
    {
        cp = getContentPane();
        setSize(1360,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Stats");
        
        movies = new JLabel("Movies: ");
        movies.setFont(new Font("Calibiri",Font.BOLD,20));
        add(movies);
        movies.setBounds(135,150, 100, 100);  
        
        cantineItems = new JLabel("Cantine Items: ");
        cantineItems.setFont(new Font("Calibiri",Font.BOLD,20));
        add(cantineItems);
        cantineItems.setBounds(730,120,150,150);  //???????????????????
        
        Stats = new JLabel("Statistics");
        Stats.setFont(new Font("Calibiri",Font.BOLD,30));
        add(Stats);
        Stats.setBounds(500, -100, 300, 300);
        
        //add movies;
        Movie1 = new JLabel();
        Movie2 = new JLabel();
        Movie3 = new JLabel();
        Movie4 = new JLabel();
        Movie5 = new JLabel();
        add(Movie1);
        add(Movie2);
        add(Movie3);                                        //Ntf2 3ala aflam..
        add(Movie4);
        add(Movie5);
        Movie1.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);       
        Movie2.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        Movie3.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        Movie4.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        Movie5.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        
        
        //add items..
        Item1 = new JLabel("PopCorn");
        Item1.setFont(new Font("Calibiri",Font.BOLD,7));
        Item2 = new JLabel("Soda");
        Item2.setFont(new Font("Calibiri",Font.BOLD,7));
        Item3= new JLabel("HotDrinks");
        Item3.setFont(new Font("Calibiri",Font.BOLD,7));
        Item4 = new JLabel("Chipsy");
        Item4.setFont(new Font("Calibiri",Font.BOLD,7));
        Item5 = new JLabel("Chocolate");
        Item5.setFont(new Font("Calibiri",Font.BOLD,7));
        Item6 = new JLabel("CottonCandy");
        Item6.setFont(new Font("Calibiri",Font.BOLD,7));
        add(Item1);
        add(Item2);
        add(Item3);
        add(Item4);
        add(Item5);
        add(Item6);
        Item1.setBounds(1000, 400, 100, 100);
        Item2.setBounds(1040, 400, 100, 100);
        Item3.setBounds(1066, 400, 100, 100);
        Item4.setBounds(1105, 400, 100, 100);
        Item5.setBounds(1130, 400, 100, 100);
        Item6.setBounds(1166, 400, 100, 100);
        
        //Keep this here
       
        
    }
    
    @Override
    public void paint(Graphics g){
       
       
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke((new BasicStroke(10.0F))); 
        
        g.setColor(Color.ORANGE);
        g.drawLine(350, 390, 350, 460);
        g.setColor(Color.RED);
        g.drawLine(380, 350, 380, 460);
        g.setColor(Color.GREEN);
        g.drawLine(410, 300, 410, 460);
        g.setColor(Color.BLUE);
        g.drawLine(440, 340, 440, 460);
        g.setColor(Color.CYAN);
        g.drawLine(470, 360, 470, 460);
        
        
        g.setColor(Color.BLACK);
        g.drawOval(50,250, 250, 250);  //Movies stats

        g.setColor(Color.ORANGE);
        g.fillArc(50,250,250,250,20,80);
        g.setColor(Color.RED);  
        g.fillArc(50,250,250,250,300,80);
        g.setColor(Color.GREEN);
        g.fillArc(50,250,250,250,180,130);
        g.setColor(Color.BLUE);
        g.fillArc(50,250,250,250,100,90);
        g.setColor(Color.CYAN);
        g.fillArc(50,250,250,250,50,50);    
         
        
        g.setColor(Color.PINK);
        g.drawLine(1030, 390, 1030, 460);
        g.setColor(Color.MAGENTA);
        g.drawLine(1060, 350, 1060, 460);
        g.setColor(Color.YELLOW);
        g.drawLine(1090, 340, 1090, 460);
        g.setColor(Color.BLUE);
        g.drawLine(1120, 340, 1120, 460);
        g.setColor(Color.BLACK);
        g.drawLine(1150, 360, 1150, 460);
        g.setColor(Color.RED);
        g.drawLine(1180, 410, 1180, 460);
        
        g.setColor(Color.BLACK);
        g.drawOval(700, 250, 250, 250);  //Cantine Stats

        g.setColor(Color.PINK);
        g.fillArc(700,250,250,250,20,80);
        g.setColor(Color.MAGENTA);  
        g.fillArc(700,250,250,250,300,80);
        g.setColor(Color.DARK_GRAY);
        g.fillArc(700,250,250,250,210,60);
        g.setColor(Color.BLUE);
        g.fillArc(700,250,250,250,120,90);
        g.setColor(Color.YELLOW);
        g.fillArc(700,250,250,250,60,70);
        g.setColor(Color.RED);
        g.fillArc(700, 250, 250, 250, 270, 30);
    }
}