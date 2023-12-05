/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author erkur
 */
public class MainMenu implements ActionListener {
//    private static JLabel Image_Label;
    private static JButton CarsButton, CustomerButton, OwnerButton, BookingButton, LogoutButton;
    private JPanel MainPanel, ButtonPanel;

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
//        LogoutButton = new JButton("Logout");

//        LogoutButton.setFont(new Font("Poppins", 1, 14));
        CustomerButton.setFont(new Font("Poppins", 1, 30));
        CarsButton.setFont(new Font("Poppins", 1, 30));
        OwnerButton.setFont(new Font("Poppins", 1, 30));
        BookingButton.setFont(new Font("Poppins", 1, 30));

        CustomerButton.setBackground(new Color(0,151,178));
        OwnerButton.setBackground(new Color(0,151,178));
//        LogoutButton.setBackground(new Color(0,151,178));
        BookingButton.setBackground(new Color(0,151,178));
        CarsButton.setBackground(new Color(0,151,178));
        
//        Image_Label = new JLabel();
//        Image_Label.setIcon((new ImageIcon("MainMenuImage.png")));

//        MainPanel.add(LogoutButton);
        MainPanel.add(CustomerButton);
        MainPanel.add(CarsButton);
        MainPanel.add(OwnerButton);
        MainPanel.add(BookingButton);
//        MainPanel.add(Image_Label);
//
//        BookingButton.addActionListener(this);
//        CustomerButton.addActionListener(this);
//        OwnerButton.addActionListener(this);
//        LogoutButton.addActionListener(this);
//        CarsButton.addActionListener(this);
//        Parent_JFrame.getMainFrame().add(MainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Cars": {
                Parent_JFrame.getMainFrame().getContentPane().removeAll();
//                Car_Details cd = new Car_Details();
//                Parent_JFrame.getMainFrame().add(cd.getMainPanel());
//                Parent_JFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
            case "Customer": {
                Parent_JFrame.getMainFrame().getContentPane().removeAll();
//                Customer_Details cd = new Customer_Details();
//                Parent_JFrame.getMainFrame().add(cd.getMainPanel());
//                Parent_JFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
            case "Owner": {
                Parent_JFrame.getMainFrame().getContentPane().removeAll();
//                CarOwner_Details cd = new CarOwner_Details();
//                Parent_JFrame.getMainFrame().add(cd.getMainPanel());
//                Parent_JFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
            case "Booking Details": {
                Parent_JFrame.getMainFrame().getContentPane().removeAll();
//                Booking_Details cd = new Booking_Details();
//                Parent_JFrame.getMainFrame().add(cd.getMainPanel());
//                Parent_JFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
        }
    }
}
