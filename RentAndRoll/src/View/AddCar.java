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
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Controller.CarController;

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
    
    private CarController carController = new CarController();

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
                List<String> invalidFields = new ArrayList<String>();
                
                if (maker.isEmpty()) {
                	invalidFields.add("maker");
                }
                if (name.isEmpty()) {
                	invalidFields.add("name");
                }
                if (regNo.isEmpty()) {
                	invalidFields.add("regNo");
                }
                if (ownerID.isEmpty()) {
                	invalidFields.add("ownerID");
                }
                if (rentPerHour.isEmpty()) {
                	invalidFields.add("rentPerHour");
                }
                if(!invalidFields.isEmpty()) {
                	JOptionPane.showMessageDialog(null, "Complete the following fields: \n" + invalidFields);
                }
                else {
                	int newId = carController.addCar(maker, 
                			name, 
                			ColourComboBox.getSelectedItem() + "",
                			TypeComboBox.getSelectedItem() + "",
                			ModelComboBox.getSelectedItem() + "",
                			regNo,
                			ConditionComboBox.getSelectedItem() + "",
                			Integer.parseInt(SeatingCapacity_Spinner.getValue().toString()),
                			Double.parseDouble(rentPerHour),
                			Integer.parseInt(ownerID));
                    if(newId >= 0) {
                        ParentFrame.getMainFrame().getContentPane().removeAll();
                        CarDashboard cd = new CarDashboard();
                        ParentFrame.getMainFrame().add(cd.getMainPanel());
                        ParentFrame.getMainFrame().getContentPane().revalidate();
                        ParentFrame.getMainFrame().setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Car added successfully!");
                        dispose();
                    }
                    else {
                       JOptionPane.showMessageDialog(null, "Error in adding car. Please try again later.");
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
