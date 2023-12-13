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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author erkur
 */
public class AddBooking extends JFrame{
    JButton BookButton, CancelButton;
    JLabel CarIDLabel, CustomerIDLabel;
    JTextField CarIDTextField, CustomerIDTextField;

//    private Car car;
//    private Customer customer;

    public AddBooking() {
        super("Book Car");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 200));
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

        CarIDTextField.setPreferredSize(new Dimension(240, 22));

        CustomerIDTextField.setPreferredSize(new Dimension(240, 22));

        BookButton.setPreferredSize(new Dimension(100, 22));
        CancelButton.setPreferredSize(new Dimension(100, 22));


        add(CarIDLabel);
        add(CarIDTextField);

        add(CustomerIDLabel);
        add(CustomerIDTextField);

        add(BookButton);
        add(CancelButton);

        BookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String CarID = CarIDTextField.getText().trim();
//                if (!CarID.isEmpty()) {
//                    try {
//                        if (Integer.parseInt(CarID) > 0) {
//                            car = Car.SearchByID(Integer.parseInt(CarID));
//                            if (car != null) {
//                                if (!car.isRented()) {
//                                    CarIDValidityLabel.setText("");
//                                } else {
//                                    car = null;
//                                    JOptionPane.showMessageDialog(null, "This car is already booked !");
//                                }
//                            } else {
//                                CarID = null;
//                            }
//                        } else {
//                            CarID = null;
//                        }
//                    } catch (NumberFormatException ex) {
//                        CarID = null;
//                    }
//                } else {
//                    CarID = null;
//                }
//
//                String customerID = CustomerIDTextField.getText().trim();
//                if (!customerID.isEmpty()) {
//                    try {
//                        if (Integer.parseInt(customerID) > 0) {
//                            customer = Customer.SearchByID(Integer.parseInt(customerID));
//                            if (customer != null) {
//                            } else {
//                                customerID = null;
//                                JOptionPane.showMessageDialog(null, "Customer ID does not exists !");
//                            }
//                        } else {
//                            customerID = null;
//                        }
//                    } catch (NumberFormatException ex) {
//                        customerID = null;
//                    }
//                } else {
//                    customerID = null;
//                }
//
//                if (CarID != null & customerID != null) {
//                    setEnabled(false);
//                    int showConfirmDialog = JOptionPane.showConfirmDialog(null,
//                            "You are about to Book the Car: \n" + car.toString() + "\n against the Customer: \n"
//                            + customer.toString() + "\n Are you sure you want to continue??",
//                            "Book Confirmation", JOptionPane.OK_CANCEL_OPTION);
//                    if (showConfirmDialog == 0) {
//                        Booking booking = new Booking(0, customer, car, System.currentTimeMillis(), 0);
//                        booking.Add();
//                        ParentFrame.getMainFrame().getContentPane().removeAll();
//                        Booking_Details cd = new Booking_Details();
//                        ParentFrame.getMainFrame().add(cd.getMainPanel());
//                        ParentFrame.getMainFrame().getContentPane().revalidate();
//                        JOptionPane.showMessageDialog(null, "Car Successfully Booked !");
//                        ParentFrame.getMainFrame().setEnabled(true);
//                        dispose();
//                    }
//                }
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
