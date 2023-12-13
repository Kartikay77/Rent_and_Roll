/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
//import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author erkur
 */
public class AddCar extends JFrame{
    JButton AddButton, CancelButton;
    JLabel MakerLabel, NameLabel, ColorLabel, TypeLabel, SeatingCapacityLabel, ModelLabel, ConditionLabel, RegNoLabel, RentPerHourLabel,
            OwnerIDLabel;
    JTextField MakerTextField, NameTextField, RegNoTextField, RentPerHourTextField, OwnerIDTextField;
    JComboBox<String> ColourComboBox, TypeComboBox, ModelComboBox, ConditionComboBox;
    JSpinner SeatingCapacity_Spinner;

    public AddCar() {
        super("Add Car");
        setLayout(new FlowLayout());
        setSize(new Dimension(450, 475));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ParentFrame.getMainFrame().setEnabled(true);
                dispose();
            }
        });

        AddButton = new JButton("Add");
        CancelButton = new JButton("Cancel");

        MakerLabel = new JLabel("Maker");
        NameLabel = new JLabel("Name");
        ColorLabel = new JLabel("Color");
        ModelLabel = new JLabel("Model");
        TypeLabel = new JLabel("Car type");
        SeatingCapacityLabel = new JLabel("Seating capacity");
        RegNoLabel = new JLabel("Reg no (ABC-0123)");
        OwnerIDLabel = new JLabel("Owner ID");
        RentPerHourLabel = new JLabel("Rent Per Hour (in PKR)");
        ConditionLabel = new JLabel("Condition ");

        MakerTextField = new JTextField();
        NameTextField = new JTextField();
        RegNoTextField = new JTextField();
        OwnerIDTextField = new JTextField();
        RentPerHourTextField = new JTextField();

        String[] Colours = {"White", "Red", "Silver", "Blue", "Black"};
        // try to initialize array from text file so that new items can be added and can be updated
        ColourComboBox = new JComboBox<>(Colours);
        String[] Types = {"Familycar", "Comercial", "Microcar", "Compact car", "Mid-size car", "Supercar", "Convertible", "Sports cars"};
        TypeComboBox = new JComboBox<>(Types);

        // Creating an array containing Years from Today's Year till 1950
        int TodaysYear = new Date().getYear() + 1900;
        int noOfYears = TodaysYear - 1949;
        String[] Years = new String[noOfYears];
        for (int i = 0; i < noOfYears; i++) {
            Years[i] = TodaysYear - i + "";
        }
        ModelComboBox = new JComboBox<>(Years);

        String[] Conditions = {"Excellent", "Good", "Average", "Bad"};
        ConditionComboBox = new JComboBox<>(Conditions);

        SeatingCapacity_Spinner = new JSpinner();
        SeatingCapacity_Spinner.setModel(new SpinnerNumberModel(4, 1, null, 1));
        SeatingCapacity_Spinner.setFocusable(false);

        MakerTextField.setPreferredSize(new Dimension(240, 22));
        NameTextField.setPreferredSize(new Dimension(240, 22));
        RegNoTextField.setPreferredSize(new Dimension(240, 22));
        OwnerIDTextField.setPreferredSize(new Dimension(240, 22));
        RentPerHourTextField.setPreferredSize(new Dimension(240, 22));

        MakerLabel.setPreferredSize(new Dimension(175, 22));
        NameLabel.setPreferredSize(new Dimension(175, 22));
        RegNoLabel.setPreferredSize(new Dimension(175, 22));
        OwnerIDLabel.setPreferredSize(new Dimension(175, 22));
        RentPerHourLabel.setPreferredSize(new Dimension(175, 22));


        SeatingCapacity_Spinner.setPreferredSize(new Dimension(50, 22));
        AddButton.setPreferredSize(new Dimension(100, 22));
        CancelButton.setPreferredSize(new Dimension(100, 22));

        
        add(MakerLabel);
        add(MakerTextField);

        add(NameLabel);
        add(NameTextField);

        add(RegNoLabel);
        add(RegNoTextField);

        add(OwnerIDLabel);
        add(OwnerIDTextField);

        add(RentPerHourLabel);
        add(RentPerHourTextField);

        add(ModelLabel);
        add(ModelComboBox);
        add(TypeLabel);
        add(TypeComboBox);
        add(SeatingCapacityLabel);
        add(SeatingCapacity_Spinner);
        add(ColorLabel);
        add(ColourComboBox);
        add(ConditionLabel);
        add(ConditionComboBox);

        add(AddButton);
        add(CancelButton);

        AddButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String maker = MakerTextField.getText().trim(),
                        name = NameTextField.getText().trim(),
                        regNo = RegNoTextField.getText().trim(),
                        ownerID = OwnerIDTextField.getText().trim(),
                        rentPerHour = RentPerHourTextField.getText().trim();

//                if (!name.isEmpty()) {
//                    if (Car.isNameValid(NameTextField.getText().trim())) {
//                        NameValidityLabel.setText("");
////                        name = NameTextField.getText().trim();
//                    } else {
//                        name = null;
//                        NameValidityLabel.setText("                                                            Invalid  Car Name !");
//                    }
//                } else {
//                    name = null;
//                    NameValidityLabel.setText("                                                            Enter Car Name !");
//                }
//                if (!maker.isEmpty()) {
//                    if (Car.isNameValid(maker)) {
//                        MakerValidityLabel.setText("");
////                        maker = MakerTextField.getText().trim();
//                    } else {
//                        maker = null;
//                        MakerValidityLabel.setText("                                                            Invalid Maker's Name !");
//                    }
//                } else {
//                    maker = null;
//                    MakerValidityLabel.setText("                                                            Enter Maker'sName !");
//                }
//                if (!regNo.isEmpty()) {
//                    if (Car.isRegNoValid(regNo)) {
//                        RegNoValidityLabel.setText("");
//                    } else {
//                        regNo = null;
//                        RegNoValidityLabel.setText("                                                            Invalid Reg no !");
//                    }
//                } else {
//                    regNo = null;
//                    RegNoValidityLabel.setText("                                                            Enter Reg No !");
//                }
//                if (!ownerID.isEmpty()) {
//                    try {
//                        if (Integer.parseInt(ownerID) > 0) {
//                            OwnerIDValidityLabel.setText("");
////                            ownerID = OwnerIDTextField.getText().trim();
//                        } else {
//                            ownerID = null;
//                            OwnerIDValidityLabel.setText("                                                            ID cannot be '0' or negative !");
//                        }
//                    } catch (NumberFormatException ex) {
//                        System.out.println("In GUI.Car_Add: " + ex);
//                        ownerID = null;
//                        OwnerIDValidityLabel.setText("                                                            Invalid ID !");
//                    }
//                } else {
//                    ownerID = null;
//                    OwnerIDValidityLabel.setText("                                                            Enter Owner ID !");
//                }
//                if (!rentPerHour.isEmpty()) {
//                    try {
//                        if (Integer.parseInt(rentPerHour) > 0) {
//                            RentPerHourValidityLabel.setText("");
//                        } else {
//                            rentPerHour = null;
//                            RentPerHourValidityLabel.setText("                                                            Rent cannot be '0' or negative !");
//                        }
//                    } catch (NumberFormatException ex) {
//
//                        rentPerHour = null;
//                        RentPerHourValidityLabel.setText("                                                            Invalid Rent !");
//                    }
//
//                } else {
//                    rentPerHour = null;
//                    RentPerHourValidityLabel.setText("                                                            Enter Rent !");
//                }
//
////Car(id, maker, name, color, Type, seatingCapacity, model, condition, regNo, rentPerHour, carOwner);
//                try {
//                    if (maker != null && name != null && regNo != null && ownerID != null && rentPerHour != null) {
//                        CarOwner carOwner = CarOwner.SearchByID(Integer.parseInt(ownerID));
//
//                        Car car = Car.SearchByRegNo(regNo);
//
//                        if (carOwner != null) {
//                            if (car == null) {
//                                //Car(id, Maker, Name, Colour, Type, SeatingCapacity, Model, Condition, RegNo, RentPerHour, carOwner)
//                                // id is auto
//                                car = new Car(0, maker, name, ColourComboBox.getSelectedItem() + "",
//                                        TypeComboBox.getSelectedItem() + "",
//                                        Integer.parseInt(SeatingCapacity_Spinner.getValue().toString()),
//                                        ModelComboBox.getSelectedItem() + "",
//                                        ConditionComboBox.getSelectedItem() + "",
//                                        regNo, Integer.parseInt(rentPerHour), carOwner);
//                                car.Add();
//                                
//                                ParentFrame.getMainFrame().getContentPane().removeAll();
//                                Car_Details cd = new Car_Details();
//                                ParentFrame.getMainFrame().add(cd.getMainPanel());
//                                ParentFrame.getMainFrame().getContentPane().revalidate();
//                                JOptionPane.showMessageDialog(null, "Record Successfully Added !");
//                                ParentFrame.getMainFrame().setEnabled(true);
//                                dispose();
//                            } else {
//                                JOptionPane.showMessageDialog(null, "This Car Registeration no is already registered !");
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Owner ID doesnot exists !");
//                        }
//                    }
//                } catch (HeadlessException | NumberFormatException ex) {
//                    System.out.println(ex);
                }
//            }
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
