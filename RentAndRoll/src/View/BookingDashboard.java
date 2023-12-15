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

import Controller.BookingController;
import Model.Booking;
import Model.Car;
import Model.Customer;

public class BookingDashboard {
    private static DefaultTableModel tableModel;
    private static JButton SearchCustomerIDButton, SearchCarRegNoButton, BackButton, BookCarButton, UnbookCarButton;
    private static JTextField CustomerIDTextField, CarRegNoTextField;
    private static JScrollPane ScrollPane1;
    private static JTable BookingsTable;
    private JPanel MainPanel;
    
    private BookingController bookingController = new BookingController();

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

        String[] columns = {"ID", "Customer", "Car Name", "Car Reg No" , "Rent Start Time", "Return Time"};
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

        List<Booking> BookingsList = bookingController.getAllBooking();
        for (int i = 0; i < BookingsList.size(); i++) {
        	int ID = BookingsList.get(i).bookingId();
            String carName = BookingsList.get(i).getCarName();
            String carRegNo = BookingsList.get(i).getReg_No();
            int customerId = BookingsList.get(i).getCustomerId();
            String customerName = BookingsList.get(i).getCustomerName();
            Date rentTime = BookingsList.get(i).getRentalStartTime();
            Date returnTime = BookingsList.get(i).getRentalReturnTime();

            String[] one_s_Record = {"" + ID, customerId + " " + customerName, carName, carRegNo, rentTime + "", returnTime + ""};
           tableModel.addRow(one_s_Record);
        }
        
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

    public static DefaultTableModel getTablemodel() {
        return tableModel;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    private class Booking_Details_ActionListener implements ActionListener {

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
                	ParentFrame.getMainFrame().setEnabled(false);
                    AddBooking aco = new AddBooking();
                    aco.setVisible(true);
                }
                break;
                case "Unbook": {
                	int selectedIndex = BookingsTable.getSelectedRow();
                    if (selectedIndex == -1 && BookingsTable.getRowCount() > 0) {
                        JOptionPane.showMessageDialog(null, "Please select a row!");
                    }
                    else {
                        String clearId = (String)BookingsTable.getValueAt(selectedIndex, 0);
                        int id = Integer.parseInt(clearId);
                        Booking customer = bookingController.getBookingById(id);
                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to unbook the following: \n"
                                + customer + "\nAre you sure you want to continue ?", "Delete Booking Confirmation",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                        if (showConfirmDialog == 0) {
                            boolean removed = bookingController.removeBooking(id);
                            if(removed){
                                ParentFrame.getMainFrame().getContentPane().removeAll();
                                CustomerDashboard cd = new CustomerDashboard();
                                ParentFrame.getMainFrame().add(cd.getMainPanel());
                                ParentFrame.getMainFrame().getContentPane().revalidate();
                                JOptionPane.showMessageDialog(null, "Booking Removed Succesfully!");
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Error in deleting booking. Please try again later!");
                            }
                        }
                    }
                }
                break;
                case "Search by Customer ID": {
                    String id = CustomerIDTextField.getText().trim();
                    if (!id.isEmpty()) {
                        int searchId = Integer.parseInt(id);
                        Booking co = bookingController.getBookingByCustomerId(searchId);
                      if (co != null) {
                          JOptionPane.showMessageDialog(null, co.toString());
                          CustomerIDTextField.setText("");
                      } else {
                          JOptionPane.showMessageDialog(null, "Booking not found!");
                          CustomerIDTextField.setText("");
                      }                   
                  } else {
                      JOptionPane.showMessageDialog(null, "Please enter ID");
                  }
                }
                break;
                case "Search by Car RegNo": {
                	String id = CarRegNoTextField.getText().trim();
                    if (!id.isEmpty()) {
                        Booking co = bookingController.getBookingByCarRegNo(id);
                      if (co != null) {
                          JOptionPane.showMessageDialog(null, co.toString());
                          CarRegNoTextField.setText("");
                      } else {
                          JOptionPane.showMessageDialog(null, "Booking not found!");
                          CarRegNoTextField.setText("");
                      }                   
                  } else {
                      JOptionPane.showMessageDialog(null, "Please enter ID");
                  }
                }
                break;
            }
        }
    }
}
