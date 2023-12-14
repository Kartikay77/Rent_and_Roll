/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
//ID,  Maker,  Name,  Colour,  Type,  SeatingCapacity,  Model,  Condition,  RegNo, RentPerHour,  IsRented RentDate, carOwner customer

        String[] columns = {"Sr#", "ID", "Maker", "Name", "Colour", "Type", "Seats", "Model", "Condition",
            "Reg No.", "Rent/hour", "Car Owner"};
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
        CarTable.setFillsViewportHeight(true);// makes the size of table equal to that of scroll pane to fill the table in the scrollpane
//        ArrayList<Car> Car_objects = Car.View();
//        for (int i = 0; i < Car_objects.size(); i++) {
////ID,  Maker,  Name,  Colour,  Type,  SeatingCapacity,  Model,  Condition,  RegNo, 
////RentPerHour,  IsRented RentDate, carOwner customer
//            int ID = Car_objects.get(i).getID();
//            String maker = Car_objects.get(i).getMaker();
//            String Name = Car_objects.get(i).getName();
//            String color = Car_objects.get(i).getColour();
//            String type = Car_objects.get(i).getType();
//            int seatingCapacity = Car_objects.get(i).getSeatingCapacity();
//            String model = Car_objects.get(i).getModel();
//            String condition = Car_objects.get(i).getCondition();
//            String regNo = Car_objects.get(i).getRegNo();
//            int rentPerHour = Car_objects.get(i).getRentPerHour();
////            CarOwner carOwner = Car_objects.get(i).getCarOwner();
//
//            String customerID = "";
//            String customerName = "";
//            String[] one_s_Record = {((i + 1) + ""), "" + ID, maker, Name, color, type, seatingCapacity+"",
//                model, condition, regNo, rentPerHour + "", carOwner.getID() + ": " + carOwner.getName(), customerID + ": " + customerName};
//            tableModel.addRow(one_s_Record);
//        }

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
        CarTable.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
        CarTable.getColumnModel().getColumn(11).setCellRenderer(centerRenderer);
        

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
        CarTable.getColumnModel().getColumn(10).setMinWidth(150);
        CarTable.getColumnModel().getColumn(11).setMinWidth(150);
       

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
//                    if (!regNo.isEmpty()) {
//                        if (Car.isRegNoValid(regNo)) {
//                            Car car = Car.SearchByRegNo(regNo);
//                            if (car != null) {
//                                JOptionPane.showMessageDialog(null, car.toString());
//                                SearchRegNoTextField.setText("");
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Required Car not found");
//                                SearchRegNoTextField.setText("");
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Invalid Reg No.");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Please Enter Car Reg no first !");
//                    }
                }
                break;
                case "Search Name": {
                    String name = SearchNameTextField.getText().trim();
//                    if (!name.isEmpty()) {
//                        if (Car.isNameValid(name)) {
//
//                            ArrayList<Car> car = Car.SearchByName(name);
//
//                            if (!car.isEmpty()) {
//                                JOptionPane.showMessageDialog(null, car.toString());
//                                SearchNameTextField.setText("");
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Required Car not found");
//                                SearchNameTextField.setText("");
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Invalid Name !");
//                            SearchNameTextField.setText("");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Please Enter Car Name first !");
//                    }

                }
                break;
                case "Add": {
                    ParentFrame.getMainFrame().setEnabled(false);
                    AddCar ac = new AddCar();
                    ac.setVisible(true);
                }
                break;
                case "Remove": {
                    ParentFrame.getMainFrame().setEnabled(false);
                    RemoveCar ac = new RemoveCar();
                    ac.setVisible(true);
                }
                break;
                case "Back": {
                    ParentFrame.getMainFrame().setTitle("Rent and Roll Car Management System");
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
