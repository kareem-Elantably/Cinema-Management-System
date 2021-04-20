package AddOns;

import static AddOns.Cantine.MYITEMS;
import MovieAndPlayData.ExceptionFileManager;
import Payment.InoviceGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import javax.swing.*;

   
public class CantineGUI extends JFrame {
    Cantine c = new Cantine();
    String currChoice;
    @Override
    public int checkImage(Image image, ImageObserver observer) {
        return super.checkImage(image, observer);  //To change body of generated methods, choose Tools | Templates.
    }
    //---------------------------------------------------
    private int GrandSodaTotal= MYITEMS.get("Soda");
    private int GrandPopCornTotal = MYITEMS.get("PopCorn");
    private int GrandChipsyTotal = MYITEMS.get("Chipsy");
    private int GrandChocolateTotal = MYITEMS.get("Chocolate");
    private int GrandCottonCandyTotal = MYITEMS.get("CottonCandy");
    private int GrandHotDrinksTotal = MYITEMS.get("HotDrinks");
    private int GrandTotalFinalnum = 0;
    //-----------------------------------------------
    private final int BUTTONSNO = 6;
    //---------------------------
    public JLabel Soda;
    public JLabel PopCorn;
    public JLabel Chipsy;
    public JLabel Chocolate;
    public JLabel CottonCandy;
    public JLabel HotDrinks;
    //----------------------------
    public JLabel SodaPrice;
    public JLabel PopCornPrice;
    public JLabel ChipsyPrice;
    public JLabel ChocolatePrice;
    public JLabel CottonCandyPrice;
    public JLabel HotDrinksPrice;
    //-----------------------------
    public JButton [] myButtons;
    public JButton ShowGrandTotal;
    public JButton CheckOut;
    public JButton Skip;
    //----------------------------
    public JLabel SodaFinal;
    public JLabel PopCornFinal;
    public JLabel ChipsyFinal;
    public JLabel ChocolateFinal;
    public JLabel CottonCandyFinal;
    public JLabel HotDrinksFinal;
    //-------
    public JLabel GrandTotalFinal;
    public JLabel lblGrandTotalFinal;
    
    public CantineGUI (String currChoice){
        this.currChoice = currChoice;
        //super();
        setSize(630,480);
        setTitle("Cantine");
        
        
        //Menu Items Lables:
        JLabel Menu = new JLabel("Menu ");
        Soda = new JLabel("Soda: ");
        PopCorn = new JLabel("PopCorn: ");
        Chipsy = new JLabel("Chipsy: ");
        Chocolate = new JLabel("Chocolate: ");
        CottonCandy = new JLabel("Candy: ");
        HotDrinks = new JLabel("Hot Drinks: ");
        
        //Prices
        SodaPrice = new JLabel("10 LE");
        PopCornPrice = new JLabel("20 LE");
        ChipsyPrice = new JLabel ("5 LE");
        ChocolatePrice = new JLabel ("15 LE");
        CottonCandyPrice = new JLabel("20 LE");
        HotDrinksPrice = new JLabel("10 LE");
        
        //Labels to show Amount;
        SodaFinal = new JLabel("");
        PopCornFinal = new JLabel("");
        ChipsyFinal = new JLabel("");
        ChocolateFinal = new JLabel("");
        CottonCandyFinal = new JLabel("");
        HotDrinksFinal = new JLabel("");
        GrandTotalFinal = new JLabel("");
        lblGrandTotalFinal = new JLabel("Grand Total: ");
        
        //Intilizing an array of Purchase Buttons
        myButtons = new JButton[BUTTONSNO];
        for (int i = 0; i < BUTTONSNO; i++){
            
            myButtons[i] = new JButton("+1");
        }
        ShowGrandTotal = new JButton("Show Grand Total");
        CheckOut = new JButton ("CheckOut");
        
        // LayoutManager null
        Container cp = getContentPane();
        cp.setLayout(null);
        
        cp.add(Menu);
        Menu.setBounds(270,30,60,20);
        //Soda Item
        cp.add(Soda);
        Soda.setBounds(200,60,60,20);
        cp.add(SodaPrice);
        SodaPrice.setBounds(280,60,60,20);
        cp.add(myButtons[0]);
        myButtons[0].setBounds(330,60,60,20);
        cp.add(SodaFinal);
        SodaFinal.setBounds(400,60, 60, 20);
        myButtons[0].addActionListener(new SodaHandler());
        //PopCorn Item
        cp.add(PopCorn);
        PopCorn.setBounds(200,90,60,20);
        cp.add(PopCornPrice);
        PopCornPrice.setBounds(280,90,60,20);
        cp.add(myButtons[1]);
        myButtons[1].setBounds(330,90,60,20);
        cp.add(PopCornFinal);
        PopCornFinal.setBounds(400, 90, 60, 20);
        myButtons[1].addActionListener(new PopCornHandler());
        //ChipsyItem
        cp.add(Chipsy);
        Chipsy.setBounds(200, 120, 60, 20);
        cp.add(ChipsyPrice);
        ChipsyPrice.setBounds(280,120,60,20);
        cp.add(myButtons[2]);
        myButtons[2].setBounds(330,120,60,20);
        cp.add(ChipsyFinal);
        ChipsyFinal.setBounds(400, 120, 60, 20);
        myButtons[2].addActionListener(new ChipsyHandler());
        //Chocolate Item
        cp.add(Chocolate);
        Chocolate.setBounds(200, 150, 70, 20);
        cp.add(ChocolatePrice);
        ChocolatePrice.setBounds(280,150,60,20);
        cp.add(myButtons[3]);
        myButtons[3].setBounds(330,150,60,20);
        cp.add(ChocolateFinal);
        ChocolateFinal.setBounds(400, 150, 60, 20);
        myButtons[3].addActionListener(new ChocolateHandler());
        //CottonCandy Item
        cp.add(CottonCandy);
        CottonCandy.setBounds(200, 180, 80, 20);
        cp.add(CottonCandyPrice);
        CottonCandyPrice.setBounds(280,180,60,20);
        cp.add(myButtons[4]);
        myButtons[4].setBounds(330,180,60,20);
        cp.add(CottonCandyFinal);
        CottonCandyFinal.setBounds(400, 180, 60, 20);
        myButtons[4].addActionListener(new CottonCandyHandler());
        //HotDrinks Item
        cp.add(HotDrinks);
        HotDrinks.setBounds(200, 210, 80, 20);
        cp.add(HotDrinksPrice);
        HotDrinksPrice.setBounds(280,210,60,20);
        cp.add(myButtons[5]);
        myButtons[5].setBounds(330,210,60,20);
        cp.add(HotDrinksFinal);
        HotDrinksFinal.setBounds(400, 210, 60,20);
        myButtons[5].addActionListener(new HotDrinksHandler());
        
        cp.add(GrandTotalFinal);
        GrandTotalFinal.setBounds(280,250,100,20);
        cp.add(ShowGrandTotal);
        ShowGrandTotal.setBounds(320,250,150,20);
        ShowGrandTotal.addActionListener(new GrandFinalHandler());
        cp.add(lblGrandTotalFinal);
        lblGrandTotalFinal.setBounds(200, 250, 100, 20);
        cp.add(CheckOut);
        CheckOut.setBounds(320, 280, 150, 20);
        CheckOut.addActionListener(new  CheckOutHandler ());
        
        Skip = new JButton("Skip Cantine");
        cp.add(Skip);
        Skip.setBounds(320, 310, 150, 20);
        Skip.addActionListener(new Skip());
    }
  
    
    public class SodaHandler implements ActionListener{
      
        @Override
        public void actionPerformed(ActionEvent e) {
                SodaFinal.setText((GrandSodaTotal) + "LE");
                GrandSodaTotal += MYITEMS.get("Soda");
                GrandTotalFinalnum += MYITEMS.get("Soda");
        }
        
    }
        public class PopCornHandler implements ActionListener{
      
        
        @Override
        public void actionPerformed(ActionEvent e) {
                PopCornFinal.setText((GrandPopCornTotal) + "LE");
                GrandPopCornTotal += MYITEMS.get("PopCorn");
                GrandTotalFinalnum += MYITEMS.get("PopCorn");
        }
   }
         public class ChipsyHandler implements ActionListener{
      
        @Override
        public void actionPerformed(ActionEvent e) {        
                ChipsyFinal.setText((GrandChipsyTotal) + "LE");
                GrandChipsyTotal += MYITEMS.get("Chipsy");
                GrandTotalFinalnum += MYITEMS.get("Chipsy");
        }
    }
         public class ChocolateHandler implements ActionListener{
      
        @Override
        public void actionPerformed(ActionEvent e) {        
                ChocolateFinal.setText((GrandChocolateTotal) + "LE");
                GrandChocolateTotal += MYITEMS.get("Chocolate");
                GrandTotalFinalnum += MYITEMS.get("Chocolate");
        }
    }
         public class CottonCandyHandler implements ActionListener{
      
        @Override
        public void actionPerformed(ActionEvent e) {        
                CottonCandyFinal.setText((GrandCottonCandyTotal) + "LE");
                GrandCottonCandyTotal += MYITEMS.get("CottonCandy");
                GrandTotalFinalnum += MYITEMS.get("CottonCandy");
        }
    }
         public class HotDrinksHandler implements ActionListener{
      
        @Override
        public void actionPerformed(ActionEvent e) {            
                HotDrinksFinal.setText((GrandHotDrinksTotal) + "LE");
                GrandHotDrinksTotal += MYITEMS.get("HotDrinks");
                GrandTotalFinalnum += MYITEMS.get("HotDrinks");
        }
    }
        
         public class GrandFinalHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {        
          GrandTotalFinal.setText(GrandTotalFinalnum + "LE");
        }
             
    }
         
         public class CheckOutHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {         
            int Choice = JOptionPane.showConfirmDialog(null,"Your Grand Total is " + GrandTotalFinalnum + " Are you Sure you want to CheckOut? ","CheckOut", JOptionPane.YES_NO_OPTION);
            if (Choice == 0){
                ExceptionFileManager.currCustomer.cantineCash = GrandTotalFinalnum;
                ExceptionFileManager.currCustomer.totalCash += GrandTotalFinalnum;
                InoviceGUI myGUI = new InoviceGUI(currChoice);
                myGUI.setVisible(true);
                dispose();
            }
        }
             
    }
         
         public class Skip implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            InoviceGUI myGUI = new InoviceGUI(currChoice);
            myGUI.setVisible(true);
            dispose();
        }
             
         }
}
        
