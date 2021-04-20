/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import MovieAndPlayData.ExceptionFileManager;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author moham
 */
public class FinalInvoiceGUI extends JFrame{
    
    JLabel myLabel;
    JButton finish;
    
    public FinalInvoiceGUI(){
        setTitle("Final Invoice");
        setSize(500, 250);
        setLayout(null);
        getContentPane();
        finish = new JButton("Finish");
        myLabel = new JLabel("Total: " + ExceptionFileManager.currCustomer.getTotalCash() + " LE");
        myLabel.setBounds(10,10,100,100);
        finish.setBounds(10, 100, 100, 50);
        add(finish);
        add(myLabel);
        finish.addActionListener(new finishL());
        
    }
    
    public class finishL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
}
