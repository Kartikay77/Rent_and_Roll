/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author erkur
 */
public class RemoveCustomer {
    JButton RemoveButton, CancelButton;
    JLabel IDLabel;
    JTextField IDTextField;
    JFrame frame = new JFrame();

    public RemoveCustomer() {
        frame.setTitle("Remove Customer");
        frame.setLayout(new AbsoluteLayout());
        frame.setSize(new Dimension(450, 290));
        frame.setResizable(false);
        frame.setLocationRelativeTo(ParentFrame.getMainFrame());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ParentFrame.getMainFrame().setEnabled(true);
                frame.dispose();
            }
        });

        RemoveButton = new JButton("Remove");
        CancelButton = new JButton("Cancel");

        IDLabel = new JLabel("Enter ID (without dashes)");
        IDTextField = new JTextField();

        IDTextField.setPreferredSize(new Dimension(240, 22));
        IDLabel.setPreferredSize(new Dimension(175, 22));
        
        frame.add(IDLabel, new AbsoluteConstraints(10, 5));
        frame.add(IDTextField, new AbsoluteConstraints(195, 5));
        frame.add(RemoveButton, new AbsoluteConstraints(100, 225, 100, 22));
        frame.add(CancelButton, new AbsoluteConstraints(250, 225, 100, 22));

        RemoveButton.addActionListener(new Customer_RemoveActionListener());

        CancelButton.addActionListener(new Customer_RemoveActionListener());
    }

    private class Customer_RemoveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Remove": {
                    String id = IDTextField.getText().trim();
//                    if (Customer.isIDvalid(id)) {
//                        Customer customer = Customer.SearchByID(Integer.parseInt(id));
//                        if (customer != null) {
//                            int showConfirmDialog = JOptionPane.showConfirmDialog(frame, "You are about to remove the following Customer.\n"
//                                    + customer.toString() + " \nAll the data including Booked Cars and Balance for this Customer will also be deleted  !"
//                                    + "\n Are you sure you want to continue ??", "Remove Customer", JOptionPane.OK_CANCEL_OPTION);
//                            if (showConfirmDialog == 0) {
//                                // Deleting all the booking records of customer
//                                ArrayList<Booking> bookings = Booking.View();
//                                for (int i = 0; i < bookings.size(); i++) {
//                                    if (customer.getID() == bookings.get(i).getCustomer().getID()) {
//                                        bookings.get(i).Remove();
//                                    }
//                                }
//                                // ** Delete all cars for this Customer **
//                                customer.Remove();
//
//                                System.out.println("Customer deleted !");
//                                ParentFrame.getMainFrame().getContentPane().removeAll();
//                                Customer_Details cd = new Customer_Details();
//                                ParentFrame.getMainFrame().add(cd.getMainPanel());
//                                ParentFrame.getMainFrame().getContentPane().revalidate();
//                                JOptionPane.showMessageDialog(null, "Record successfully Removed !");
//                                ParentFrame.getMainFrame().setEnabled(true);
//                                frame.dispose();
//                            } else {
//
//                                frame.setEnabled(true);
//                            }
//
//                        } else {
//                            JOptionPane.showMessageDialog(null, "This ID does not exists !");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Enter a valid ID !\n(A valid ID is an integer number greater than 0)");
//                    }
                    break;
                }
                case "Cancel": {
                    ParentFrame.getMainFrame().setEnabled(true);
                    frame.dispose();
                    break;
                }
            }
        }
    }
}
