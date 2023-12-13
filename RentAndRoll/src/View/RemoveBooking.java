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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import javax.swing.JTextField;

/**
 *
 * @author erkur
 */
public class RemoveBooking extends JFrame{
    JButton UnBookButton, CancelButton;
    JLabel CarIDLabel;
    JTextField CarIDTextField;

//    private Car car;

    public RemoveBooking() {
        super("UnBook Car");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 145));
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

        UnBookButton = new JButton("UnBook");
        CancelButton = new JButton("Cancel");

        CarIDLabel = new JLabel("Enter Car ID to be UnBooked");
        CarIDTextField = new JTextField();

        CarIDTextField.setPreferredSize(new Dimension(240, 22));

        UnBookButton.setPreferredSize(new Dimension(100, 22));
        CancelButton.setPreferredSize(new Dimension(100, 22));


        add(CarIDLabel);
        add(CarIDTextField);

        add(UnBookButton);
        add(CancelButton);

        UnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String carID = CarIDTextField.getText().trim();
                // if (!carID.isEmpty()) {
                //     try {
                //         if (Integer.parseInt(carID) > 0) {
                //             CarIDValidityLabel.setText("");
                //             car = Car.SearchByID(Integer.parseInt(carID));
                //             if (car != null) {
                //                 if (car.isRented()) {
                //                     CarIDValidityLabel.setText("");
                //                 } else {
                //                     car = null;
                //                     JOptionPane.showMessageDialog(null, "This car is not booked !");
                //                 }
                //             } else {
                //                 car = null;
                //                 JOptionPane.showMessageDialog(null, "Car ID does not exists !");
                //             }
                //         } else {
                //             carID = null;
                //             CarIDValidityLabel.setText("                                                            "
                //                     + "ID cannot be '0' or negative !");
                //         }
                //     } catch (NumberFormatException ex) {
                //         carID = null;
                //         CarIDValidityLabel.setText("                                                            "
                //                 + "Invalid ID !");
                //     }
                // } else {
                //     carID = null;
                //     CarIDValidityLabel.setText("                                                            "
                //             + "Enter Car ID !");
                // }

                // if (carID != null && car != null) {
                //     setEnabled(false);
                //     int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to UnBook this Car\n" + car.toString()
                //             + "\n Are you sure you want to continue ??", "UnBook Confirmation", OK_CANCEL_OPTION);
                //     if (showConfirmDialog == 0) {

                //         ArrayList<Booking> booking = Booking.SearchByCarID(Integer.parseInt(carID));
                //         Booking last = booking.get((booking.size() - 1));
                //         last.setReturnTime(System.currentTimeMillis());
                //         last.Update();

                //         int bill = last.calculateBill(); 
                        
                //         CarOwner carOwner = last.getCar().getCarOwner();
                //         carOwner.setBalance((carOwner.getBalance() + bill));
                //         carOwner.Update();

                //         Customer customer = last.getCustomer();
                //         customer.setBill(customer.getBill()+bill);
                //         customer.Update();
                        
                //         ParentFrame.getMainFrame().getContentPane().removeAll();
                //         Booking_Details cd = new Booking_Details();
                //         ParentFrame.getMainFrame().add(cd.getMainPanel());
                //         ParentFrame.getMainFrame().getContentPane().revalidate();
                //         JOptionPane.showMessageDialog(null, "Car Successfully UnBooked !");
                //         ParentFrame.getMainFrame().setEnabled(true);
                //         dispose();
                //     } else {
                //         setEnabled(true);
                //     }
                // }
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
