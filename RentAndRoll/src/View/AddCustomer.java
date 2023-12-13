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
public class AddCustomer {
    JButton AddButton, CancelButton;
    JLabel NameLabel, ContactLabel;
    JTextField NameTextField, ContactTextField;
    JFrame frame = new JFrame();

    public AddCustomer() {
        frame.setTitle("Add Customer");
        frame.setLayout(new AbsoluteLayout());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ParentFrame.getMainFrame().setEnabled(true);
                frame.dispose();
            }
        });

        frame.setSize(new Dimension(450, 290));
        frame.setResizable(false);
        frame.setLocationRelativeTo(ParentFrame.getMainFrame());

        AddButton = new JButton("Add");
        CancelButton = new JButton("Cancel");

        NameLabel = new JLabel("Enter Name");
        ContactLabel = new JLabel("Enter Contact");
        
        NameTextField = new JTextField();
        ContactTextField = new JTextField();

        NameTextField.setPreferredSize(new Dimension(240, 22));
        ContactTextField.setPreferredSize(new Dimension(240, 22));

        NameLabel.setPreferredSize(new Dimension(175, 22));
        ContactLabel.setPreferredSize(new Dimension(175, 22));

        ContactLabel.setForeground(Color.red);
        NameLabel.setForeground(Color.red);

        frame.add(NameLabel, new AbsoluteConstraints(10, 42));
        frame.add(NameTextField, new AbsoluteConstraints(195, 42));

        frame.add(ContactLabel, new AbsoluteConstraints(10, 77));
        frame.add(ContactTextField, new AbsoluteConstraints(195, 77));

        frame.add(AddButton, new AbsoluteConstraints(100, 225, 100, 22));
        frame.add(CancelButton, new AbsoluteConstraints(250, 225, 100, 22));

        AddButton.addActionListener(new Customer_Add_ActionListener());

        CancelButton.addActionListener(new Customer_Add_ActionListener());
    }

    private class Customer_Add_ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Add": {
                    String name = NameTextField.getText().trim();
                    String contact = ContactTextField.getText().trim();

//                    if (Customer.isCNICValid(cnic)) {
//                        Customer customer = Customer.SearchByCNIC(cnic);
//                        if (customer == null) {
//                            if (Customer.isNameValid(name)) {
//                                if (Customer.isContactNoValid(contact)) {
//                                    new Customer(0, 0, cnic, name, contact).Add(); // ID is Auto
//                                    ParentFrame.getMainFrame().getContentPane().removeAll();
//                                    Customer_Details cd = new Customer_Details();
//                                    ParentFrame.getMainFrame().add(cd.getMainPanel());
//                                    ParentFrame.getMainFrame().getContentPane().revalidate();
//                                    ParentFrame.getMainFrame().setEnabled(true);
//                                    JOptionPane.showMessageDialog(null, "Customer added successfully !");
//                                    frame.dispose();
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "Invalid contact no. !");
//                                }
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Invalid Name !");
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "This CNIC is already registered !");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Invalid CNIC");
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

