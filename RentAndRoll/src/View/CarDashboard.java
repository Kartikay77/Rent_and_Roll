/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import Controller.CarController;
import Model.Car;
import Model.CarOwner;

/**
 *
 * @author erkur
 */
public class CarDashboard {
        private static DefaultTableModel tableModel; // it is made static so that it can be accessed in add GUI class to update the Jtable when a new record is added

    private static JButton SearchNameButton, SearchRegNoButton, AddButton, RemoveButton, BackButton;
    private static JTextField SearchNameTextField, SearchRegNoTextField;
    private static JScrollPane ScrollPane1;
    private static JTable CarTable;
    private JPanel MainPanel;

    private CarController carController = new CarController();
    /**
     * @return the tableModel
     */
    public static DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public CarDashboard() {
        MainPanel = new JPanel();
        ParentFrame.getMainFrame().setTitle("Car Details - Rent and Roll");
        MainPanel.setLayout(new AbsoluteLayout());
        MainPanel.setMinimumSize(new Dimension(1366, 730));

        SearchRegNoButton = new JButton("Search Registration No");
        SearchRegNoTextField = new JTextField();

        SearchNameButton = new JButton("Search Name");
        SearchNameTextField = new JTextField();

        AddButton = new JButton("Add");
        RemoveButton = new JButton("Remove");
        BackButton = new JButton("Back");
        

        ScrollPane1 = new JScrollPane();
        CarTable = new JTable();

        String[] columns = {"ID", "Maker", "Name", "Colour", "Type", "Seats", "Model", "Condition",
            "Reg No.", "Rent/hour"};
        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        CarTable = new JTable(getTableModel());
        CarTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        CarTable.setPreferredScrollableViewportSize(new Dimension(2000, 550));
        ScrollPane1 = new JScrollPane();
        ScrollPane1.setViewportView(CarTable);

        List<Car> CarsList = carController.getAllCars();
        for (int i = 0; i < CarsList.size(); i++) {
        	int ID = CarsList.get(i).carId();
            String carModel = CarsList.get(i).getCarModel();
            int seatingCapacity = CarsList.get(i).getSeatingCapacity();
            float rentPerHour = CarsList.get(i).getSeatingCapacity();
            String makerName = CarsList.get(i).getMakerName();
            String carName = CarsList.get(i).getCarName();
            String color = CarsList.get(i).getColor();
            String carType = CarsList.get(i).getCarType();
            String carCondition = CarsList.get(i).getCarCondition();
            String carRegNo = CarsList.get(i).getCarRegNo();

            String[] one_s_Record = {"" + ID, makerName, carName, color, carType, seatingCapacity+"",
                    carModel, carCondition, carRegNo, rentPerHour + ""};
           tableModel.addRow(one_s_Record);
        }


        // center aligning the text in all the columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        CarTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        

        // adjusting size of each column
        CarTable.getColumnModel().getColumn(0).setMinWidth(20);
        CarTable.getColumnModel().getColumn(1).setMinWidth(20);
        CarTable.getColumnModel().getColumn(2).setMinWidth(170);
        CarTable.getColumnModel().getColumn(3).setMinWidth(170);
        CarTable.getColumnModel().getColumn(4).setMinWidth(140);
        CarTable.getColumnModel().getColumn(5).setMinWidth(150);
        CarTable.getColumnModel().getColumn(6).setMinWidth(90);
        CarTable.getColumnModel().getColumn(7).setMinWidth(90);
        CarTable.getColumnModel().getColumn(8).setMinWidth(160);
        CarTable.getColumnModel().getColumn(9).setMinWidth(170);
       

        CarTable.getTableHeader().setReorderingAllowed(false);

        MainPanel.add(SearchRegNoButton, new AbsoluteConstraints(10, 15, 130, 22));
        MainPanel.add(SearchRegNoTextField, new AbsoluteConstraints(145, 15, 240, 22));
        MainPanel.add(SearchNameButton, new AbsoluteConstraints(390, 15, 130, 22));
        MainPanel.add(SearchNameTextField, new AbsoluteConstraints(525, 15, 240, 22));
        MainPanel.add(ScrollPane1, new AbsoluteConstraints(10, 60, 1330, 550));
        MainPanel.add(RemoveButton, new AbsoluteConstraints(785, 625, 130, 22));
        MainPanel.add(AddButton, new AbsoluteConstraints(450, 625, 130, 22));
        MainPanel.add(BackButton, new AbsoluteConstraints(1106, 625, 100, 22));
        
        SearchNameButton.addActionListener(new Car_Details_ActionListener());
        SearchRegNoButton.addActionListener(new Car_Details_ActionListener());
        AddButton.addActionListener(new Car_Details_ActionListener());
        RemoveButton.addActionListener(new Car_Details_ActionListener());
        BackButton.addActionListener(new Car_Details_ActionListener());
        
    }

    private class Car_Details_ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Search Registration No": {
                    String regNo = SearchRegNoTextField.getText().trim();
                    if (!regNo.isEmpty()) {
                          Car c = carController.getCarById(regNo);
                        if (c != null) {
                            JOptionPane.showMessageDialog(null, c.toString());
                            SearchRegNoTextField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Registration number not found!");
                            SearchRegNoTextField.setText("");
                        }                   
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter registration number");
                    }
                }
                break;
                case "Search Name": {
                   String name = SearchNameTextField.getText().trim();
                   if (!name.isEmpty()) {
                    List<Car> carList = carController.getCarsByName(name);
                    String record = "";
                    if (!carList.isEmpty()) {
                        for (int i = 0; i < carList.size(); i++) {
                            record += carList.get(i).toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, record);
                        SearchNameTextField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Car not found");
                        SearchNameTextField.setText("");
                    }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a name");
            }

                }
                break;
                case "Add": {
                    ParentFrame.getMainFrame().setEnabled(false);
                    AddCar ac = new AddCar();
                    ac.setVisible(true);
                }
                break;
                case "Remove": {
                	int selectedIndex = CarTable.getSelectedRow();
                    if (selectedIndex == -1 && CarTable.getRowCount() > 0) {
                        JOptionPane.showMessageDialog(null, "Please select a row!");
                    }
                    else {
                        String clearId = (String)CarTable.getValueAt(selectedIndex, 0);
                        int id = Integer.parseInt(clearId);
                        String regNo = (String)CarTable.getValueAt(selectedIndex, 8);
                        Car car = carController.getCarById(regNo);
                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about the following car\n"
                                + car.toString() + "\nAre you sure you want to continue ?", "Remove Car Confirmation",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                        if (showConfirmDialog == 0) {
                            boolean removed = carController.removeCar(id);
                            if(removed){
                                ParentFrame.getMainFrame().getContentPane().removeAll();
                                CarDashboard cd = new CarDashboard();
                                ParentFrame.getMainFrame().add(cd.getMainPanel());
                                ParentFrame.getMainFrame().getContentPane().revalidate();
                                JOptionPane.showMessageDialog(null, "Car Removed Succesfully!");
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Error in deleting car. Please try again later!");
                            }
                        }
                    }
                }
                break;
                case "Back": {
                    ParentFrame.getMainFrame().setTitle("Rent and Roll - Car Rental Management System");
                    MainMenu mm = new MainMenu();
                    ParentFrame.getMainFrame().getContentPane().removeAll();
                    ParentFrame.getMainFrame().add(mm.getMainPanel());
                    ParentFrame.getMainFrame().getContentPane().revalidate();
                }
                break;
                case "Book": {
//                    if (!Booking.getUnbookedCars().isEmpty()) {
//                        ParentFrame.getMainFrame().setEnabled(false);
//                        Booking_BookCar ac = new Booking_BookCar();
//                        ac.setVisible(true);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "No UnBooked Cars are available !");
//                    }
                }
                break;
                case "Unbook": {
//                    if (!Booking.getBookedCars().isEmpty()) {
//                        ParentFrame.getMainFrame().setEnabled(false);
//                        Booking_UnBookCar ac = new Booking_UnBookCar();
//                        ac.setVisible(true);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "No Booked Cars found !");
//                    }
                }
                break;
            }
        }
    }
}
