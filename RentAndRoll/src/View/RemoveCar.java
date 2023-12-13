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
public class RemoveCar extends JFrame {
    JButton RemoveButton, CancelButton;
    JLabel CarIDLabel;
    JTextField CarIDTextField;

//    private Car car;

    public RemoveCar() {
        super("Remove Car");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 140));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ParentFrame.getMainFrame().setEnabled(true);
                dispose();
            }
        });

        RemoveButton = new JButton("Remove");
        CancelButton = new JButton("Cancel");

        CarIDLabel = new JLabel("Enter Car ID to be removed");
        CarIDTextField = new JTextField();

        CarIDTextField.setPreferredSize(new Dimension(240, 22));
//        CarIDLabel.setPreferredSize(new Dimension(175, 22));
        RemoveButton.setPreferredSize(new Dimension(100, 22));
        CancelButton.setPreferredSize(new Dimension(100, 22));


        add(CarIDLabel);
        add(CarIDTextField);

        add(RemoveButton);
        add(CancelButton);

        RemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carID = CarIDTextField.getText().trim();
//                if (!carID.isEmpty()) {
//                    try {
//                        if (Integer.parseInt(carID) > 0) {
////                            if (carID != null) {
//                            Car car = Car.SearchByID(Integer.parseInt(carID));
//                            if (car != null) {
//                                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to remove this car \n "
//                                        + car.toString() + "\n Are you sure you want to continue ??", "Confirmation",
//                                        JOptionPane.OK_CANCEL_OPTION);
//                                if (showConfirmDialog == 0) {
//                                    car.Remove();
//                                    ParentFrame.getMainFrame().getContentPane().removeAll();
//                                    Car_Details cd = new Car_Details();
//                                    ParentFrame.getMainFrame().add(cd.getMainPanel());
//                                    ParentFrame.getMainFrame().getContentPane().revalidate();
//                                    
//                                    ParentFrame.getMainFrame().setEnabled(true);
//                                    dispose();
//                                }
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Car ID not found !");
//                            }
//                        } else {
//                            carID = null;
//                        }
//                    } catch (NumberFormatException ex) {
//                        carID = null;
//                    }
//                } else {
//                    carID = null;
//                }
//                /*ID, Maker, Name, Colour, Type, SeatingCapacity, Model, Condition, RegNo, RentPerHour, IsRented RentDate, carCar, customer*/

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
