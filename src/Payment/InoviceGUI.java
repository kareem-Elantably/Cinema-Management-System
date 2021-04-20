
package Payment;

import MovieAndPlayData.ExceptionFileManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class InoviceGUI extends JFrame {

    JLabel inovice;
    JLabel moviePrice;
    JLabel cantinePrice;
    JLabel parkingPrice;
    JLabel movie;
    JLabel cantine;
    JLabel parking;
    JRadioButton Cash;
    JRadioButton Visa;
    JButton ConfirmPayment;
    JLabel myTotal;
    String currChoice;
    ButtonGroup PaymentGroup;
    
    public InoviceGUI(String currChoice){
        
        setSize(700,700);
        setTitle("Inovice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.currChoice = currChoice;
        getContentPane();
        setLayout(null);
        
        inovice = new JLabel("Invoice: ");
        inovice.setFont(new Font("Calibiri",Font.BOLD,30));
        cantinePrice = new JLabel ("Cantine: ");
        parkingPrice = new JLabel ("Parking: ");
        if(currChoice.equals("Movie")){
            moviePrice = new JLabel("Movie: ");
            movie = new JLabel(ExceptionFileManager.currCustomer.movieCash + " LE");
        }else{
            moviePrice = new JLabel("Play: ");
            movie = new JLabel(ExceptionFileManager.currCustomer.playCash + " LE");
        }
        cantine = new JLabel(ExceptionFileManager.currCustomer.cantineCash + " LE");
        parking = new JLabel(ExceptionFileManager.currCustomer.parkingCash + " LE");
        myTotal = new JLabel("Total: " + ExceptionFileManager.currCustomer.getTotalCash() + " EGP");
        myTotal.setFont(new Font("Calibiri",Font.BOLD,30));
        
        Cash = new JRadioButton("Cash",true);
        Visa = new JRadioButton("Visa",false);
        
        
        
        
        ConfirmPayment = new JButton("Confirm Payment");
        
        PaymentGroup= new ButtonGroup();
        PaymentGroup.add(Cash);
        PaymentGroup.add(Visa);
        
        add(inovice);
        add(moviePrice);
        add(cantinePrice);
        add(parkingPrice);
        add(movie);
        add(cantine);
        add(parking);
        add(myTotal);
        add(Cash);
        add(Visa);
        add(ConfirmPayment);
        
        inovice.setBounds(300,20,160, 100);
        moviePrice.setBounds(300,80,100,100);
        cantinePrice.setBounds(300,120,100,100);
        parkingPrice.setBounds(300,160,100,100);
        
        movie.setBounds(400,80,100,100);
        cantine.setBounds(400,120,100,100);
        parking.setBounds(400,160,100,100);
        
        Cash.setBounds(260,230,70,70);
        Visa.setBounds(430,230,70,70);
        
        myTotal.setBounds(150,220,300,200);
        
        ConfirmPayment.setBounds(470,500,200,40);
        
        ConfirmPayment.addActionListener(new Submit());
        
    }
       
    public class Submit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(Cash.isSelected()){
                FinalInvoiceGUI myGUI = new FinalInvoiceGUI();
                myGUI.setVisible(true);
                dispose();
                myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }else if(Visa.isSelected()){
                VisaCardGUI myGUI = new VisaCardGUI();
                myGUI.setVisible(true);
                dispose();
                myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
          }    
  
    }
}
