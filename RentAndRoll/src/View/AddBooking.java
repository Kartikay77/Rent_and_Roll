/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.BookingController;

/**
 *
 * @author erkur
 */
public class AddBooking extends JFrame{
    JButton BookButton, CancelButton;
    JLabel CarIDLabel, CustomerIDLabel;
    JTextField CarIDTextField, CustomerIDTextField;
    JTextField RentTimeTextField, ReturnTimeTextField;
    JLabel ReturnTimeLabel, RentTimeLabel;
    
    private BookingController bookingController = new BookingController();

    public AddBooking() {
        super("Book Car");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 300));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ParentFrame.getMainFrame().setEnabled(true);
                dispose();
            }
        });

        BookButton = new JButton("Book");
        CancelButton = new JButton("Cancel");

        CarIDLabel = new JLabel("Enter Car ID to be Booked");
        CarIDTextField = new JTextField();

        CustomerIDLabel = new JLabel("Enter Customer ID");
        CustomerIDTextField = new JTextField();
        
//        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        JTextField RentTimeTextField = new JTextField();
        JTextField ReturnTimeTextField = new JTextField();
        
        ReturnTimeLabel = new JLabel("Return Time (yyyy-mm-dd hh:mm:ss)");
        RentTimeLabel = new JLabel("Rent Time (yyyy-mm-dd hh:mm:ss)");

        CarIDTextField.setPreferredSize(new Dimension(240, 22));
        CustomerIDTextField.setPreferredSize(new Dimension(240, 22));
        
        RentTimeTextField.setPreferredSize(new Dimension(240, 22));
        ReturnTimeTextField.setPreferredSize(new Dimension(240, 22));

        BookButton.setPreferredSize(new Dimension(100, 22));
        CancelButton.setPreferredSize(new Dimension(100, 22));


        add(CarIDLabel);
        add(CarIDTextField);

        add(CustomerIDLabel);
        add(CustomerIDTextField);
        
        add(RentTimeLabel);
        add(RentTimeTextField);
        
        add(ReturnTimeLabel);
        add(ReturnTimeTextField);

        add(BookButton);
        add(CancelButton);

        BookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String carId = CarIDTextField.getText().trim();
                String custId = CustomerIDTextField.getText().trim();
                Timestamp rentTime = Timestamp.valueOf(RentTimeTextField.getText().trim());
                Timestamp returnTime = Timestamp.valueOf(ReturnTimeTextField.getText().trim());

                List<String> invalidFields = new ArrayList<String>();
                if (carId.isEmpty()) {
                	invalidFields.add("carId");
                }
                if (custId.isEmpty()) {
                	invalidFields.add("custId");
                }
                
                else {
                	int newId = bookingController.addBooking(rentTime, 
                			returnTime, 
                			Integer.parseInt(custId),
                			Integer.parseInt(carId));
                    if(newId >= 0) {
                        ParentFrame.getMainFrame().getContentPane().removeAll();
                        BookingDashboard cd = new BookingDashboard();
                        ParentFrame.getMainFrame().add(cd.getMainPanel());
                        ParentFrame.getMainFrame().getContentPane().revalidate();
                        ParentFrame.getMainFrame().setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Booking added successfully!");
                        dispose();
                    }
                    else {
                       JOptionPane.showMessageDialog(null, "Error in adding booking. Please try again later.");
                    } 
                }
            }             
          }
         );
        CancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParentFrame.getMainFrame().setEnabled(true);
                dispose();
            }
        });
    }
}
