/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * This class is responsible for painting the Bookings dashboard page. 
 */
public class BookingDashboard {
    private static DefaultTableModel tableModel;
    private static JButton SearchCustomerIDButton, SearchCarRegNoButton, BackButton, BookCarButton, UnbookCarButton;
    private static JTextField CustomerIDTextField, CarRegNoTextField;
    private static JScrollPane ScrollPane1;
    private static JTable BookingsTable;
    private JPanel MainPanel;

    public BookingDashboard() {
        MainPanel = new JPanel();
        ParentFrame.getMainFrame().setTitle("Booking Details - Rent and Roll");
        MainPanel.setLayout(new AbsoluteLayout());
        MainPanel.setMinimumSize(new Dimension(1366, 730));

        SearchCustomerIDButton = new JButton("Search by Customer ID");
        SearchCarRegNoButton = new JButton("Search by Car RegNo");
        BackButton = new JButton("Back");
        BookCarButton = new JButton("Book");
        UnbookCarButton = new JButton("Unbook");

        CustomerIDTextField = new JTextField();
        CarRegNoTextField = new JTextField();

        ScrollPane1 = new JScrollPane();
        BookingsTable = new JTable();
//ID,  Maker,  Name,  Colour,  Type,  SeatingCapacity,  Model,  Condition,  RegNo, RentPerHour,  IsRented RentDate, carOwner customer

        String[] columns = {"Sr#", "ID", "Customer ID+Name", "Car Name", "Rent Time", "Return Time"};
        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        BookingsTable = new JTable(getTablemodel());
        BookingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ScrollPane1 = new JScrollPane();
        ScrollPane1.setViewportView(BookingsTable);
        BookingsTable.setFillsViewportHeight(true);// makes the size of table equal to that of scroll pane to fill the table in the scrollpane
//        ArrayList<Booking> Booking_objects = Booking.View();
//        for (int i = 0; i < Booking_objects.size(); i++) {
////ID,  Maker,  Name,  Colour,  Type,  SeatingCapacity,  Model,  Condition,  RegNo, 
////RentPerHour,  IsRented RentDate, carOwner customer
//            int ID = Booking_objects.get(i).getID();
//            String customer_ID_Name = Booking_objects.get(i).getCustomer().getID()
//                    + ": " + Booking_objects.get(i).getCustomer().getName();
//            String carName = Booking_objects.get(i).getCar().getName();
//            String carID = Booking_objects.get(i).getCar().getID()+"";
//            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm a dd-MM-yyyy");
//            Date rentime = new Date(Booking_objects.get(i).getRentTime());
//            String rentTime = dateFormat.format(rentime);
//
//            long returnTime_ = Booking_objects.get(i).getReturnTime();
//            String returnTime;
//            if (returnTime_ != 0) {
//                Date returntime = new Date(returnTime_);
//                returnTime = dateFormat.format(returntime);
//            } else {
//                returnTime = "Not returned yet !";
//            }
//
//            String[] one_s_Record = {((i + 1) + ""), "" + ID, customer_ID_Name, carID+": "+carName, rentTime, returnTime};
//            tableModel.addRow(one_s_Record);
//        }

        // center aligning the text in all the columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        BookingsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        BookingsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        BookingsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        BookingsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        BookingsTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        BookingsTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        // adjusting size of each column
        BookingsTable.getColumnModel().getColumn(0).setMinWidth(80);
        BookingsTable.getColumnModel().getColumn(1).setMinWidth(80);
        BookingsTable.getColumnModel().getColumn(2).setMinWidth(400);
        BookingsTable.getColumnModel().getColumn(3).setMinWidth(300);
        BookingsTable.getColumnModel().getColumn(4).setMinWidth(230);
        BookingsTable.getColumnModel().getColumn(5).setMinWidth(235);

        BookingsTable.getTableHeader().setReorderingAllowed(false);

        MainPanel.add(ScrollPane1, new AbsoluteConstraints(10, 60, 1330, 550));
        MainPanel.add(BackButton, new AbsoluteConstraints(1106, 625, 100, 22));
        MainPanel.add(BookCarButton, new AbsoluteConstraints(10, 625, 130, 22));
        MainPanel.add(UnbookCarButton, new AbsoluteConstraints(160, 625, 130, 22));

        MainPanel.add(SearchCarRegNoButton, new AbsoluteConstraints(10, 15, 160, 22));
        MainPanel.add(CarRegNoTextField, new AbsoluteConstraints(185, 15, 240, 22));
        MainPanel.add(SearchCustomerIDButton, new AbsoluteConstraints(440, 15, 180, 22));
        MainPanel.add(CustomerIDTextField, new AbsoluteConstraints(635, 15, 240, 22));

        SearchCustomerIDButton.addActionListener(new Booking_Details_ActionListener());
        SearchCarRegNoButton.addActionListener(new Booking_Details_ActionListener());
        BackButton.addActionListener(new Booking_Details_ActionListener());
        BookCarButton.addActionListener(new Booking_Details_ActionListener());
        UnbookCarButton.addActionListener(new Booking_Details_ActionListener());
    }

    /**
     * Returns the default table model for the booking dashboard. 
     * @return DefaultTableModel
     */
    public static DefaultTableModel getTablemodel() {
        return tableModel;
    }
    
    /**
     * Gets the main JPanel for the Bookings dashboard page.
     * @return JPanel
     */
    public JPanel getMainPanel() {
        return MainPanel;
    }

    private class Booking_Details_ActionListener implements ActionListener {
    	/**
         * Perform the action received from the action listener for BookingsDashboard page.
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {

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
                case "Search by Customer ID": {
                    String customerID = CustomerIDTextField.getText().trim();
//                    if (!customerID.isEmpty()) {
//                        if (Customer.isIDvalid(customerID)) {
//                            Customer customer = Customer.SearchByID(Integer.parseInt(customerID));
//                            if (customer != null) {
//                                ArrayList<Booking> bookings = Booking.SearchByCustomerID(Integer.parseInt(customerID));
//                                if (!bookings.isEmpty()) {
//                                    JOptionPane.showMessageDialog(null, bookings.toString());
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "This Customer has not booked any cars yet !");
//                                }
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Customer ID not found !");
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Invalid Customer ID !");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Enter Customer ID first !");
//                    }
//                    CustomerIDTextField.setText("");
                }
                break;
                case "Search by Car RegNo": {
//                    String carRegNo = CarRegNoTextField.getText().trim();
//                    if (!carRegNo.isEmpty()) {
//                        if (Car.isRegNoValid(carRegNo)) {
//                            Car car = Car.SearchByRegNo(carRegNo);
//                            if (car != null) {
//                                ArrayList<Booking> bookings = Booking.SearchByCarRegNo(carRegNo);
//                                if (!bookings.isEmpty()) {
//                                    JOptionPane.showMessageDialog(null, bookings.toString());
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "This Car is not booked yet !");
//                                }
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Registeration no. not found !");
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Invalid Registeration no !");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Enter Car Registeration No first !");
//                    }
//                    CustomerIDTextField.setText("");
                }
                break;
            }
        }
    }
}
