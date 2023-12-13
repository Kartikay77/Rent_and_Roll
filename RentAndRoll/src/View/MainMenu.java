/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author erkur
 */
public class MainMenu implements ActionListener {
    private static JButton CarsButton, CustomerButton, OwnerButton, BookingButton;
    private JPanel MainPanel;

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public MainMenu() {
        MainPanel = new JPanel();
        
        MainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 200));
        MainPanel.setMinimumSize(new Dimension(1366, 730));
        MainPanel.setBackground(new Color(166,166,166));

        CustomerButton = new JButton("Customer");
        CarsButton = new JButton("Cars");
        OwnerButton = new JButton("Owner");
        BookingButton = new JButton("Booking Details");

        CustomerButton.setFont(new Font("Poppins", 1, 30));
        CarsButton.setFont(new Font("Poppins", 1, 30));
        OwnerButton.setFont(new Font("Poppins", 1, 30));
        BookingButton.setFont(new Font("Poppins", 1, 30));

        CustomerButton.setBackground(new Color(0,151,178));
        OwnerButton.setBackground(new Color(0,151,178));
        BookingButton.setBackground(new Color(0,151,178));
        CarsButton.setBackground(new Color(0,151,178));
        
        MainPanel.add(CustomerButton);
        MainPanel.add(CarsButton);
        MainPanel.add(OwnerButton);
        MainPanel.add(BookingButton);
        
        BookingButton.addActionListener(this);
        CustomerButton.addActionListener(this);
        OwnerButton.addActionListener(this);
        CarsButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {  
            case "Cars": {
                ParentFrame.getMainFrame().getContentPane().removeAll();
//                CarDetails cd = new CarDetails();
//                ParentFrame.getMainFrame().add(cd.getMainPanel());
//                ParentFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
            case "Customer": {
                ParentFrame.getMainFrame().getContentPane().removeAll();
                CustomerDetails cd = new CustomerDetails();
                ParentFrame.getMainFrame().add(cd.getMainPanel());
                ParentFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
            case "Owner": {
                ParentFrame.getMainFrame().getContentPane().removeAll();
                CarOwnerDetails cd = new CarOwnerDetails();
                ParentFrame.getMainFrame().add(cd.getMainPanel());
                ParentFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
            case "Booking Details": {
                ParentFrame.getMainFrame().getContentPane().removeAll();
//                BookingDetails cd = new BookingDetails();
//                ParentJFrame.getMainFrame().add(cd.getMainPanel());
//                ParentJFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
        }
    }
}
