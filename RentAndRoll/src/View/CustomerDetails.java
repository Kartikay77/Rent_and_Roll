/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Customer;
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
public class CustomerDetails implements ActionListener{
    private JTextField SearchIdTextField;
    private JButton SearchIdButton, SearchNameButton, UpdateButton, AddButton, RemoveButton, BackButton, ClearBillButton;
    private JScrollPane ScrollPane1;
    private JTable CustomerTable;
    private JTextField SearchNameTextField;
    static DefaultTableModel tableModel;
    private JPanel MainPanel;

    public CustomerDetails() {
        MainPanel = new JPanel();
        ParentFrame.getMainFrame().setTitle("Customer Details - Rent-A-Car Management System");
        MainPanel.setLayout(new AbsoluteLayout());
        MainPanel.setMinimumSize(new Dimension(1366, 730));

        SearchIdButton = new JButton("Search ID");
        UpdateButton = new JButton("Update");
        AddButton = new JButton("Add");
        RemoveButton = new JButton("Remove");
        BackButton = new JButton("Back");
        SearchNameButton = new JButton("Search Name");
        ClearBillButton = new JButton("Clear Bill");
        SearchIdTextField = new JTextField();
        SearchNameTextField = new JTextField();
        ScrollPane1 = new JScrollPane();
        CustomerTable = new JTable();

        String[] columns = {"ID", "Name", "Contact Number", "Car Rented", "Bill"};
        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        CustomerTable = new JTable(tableModel);

        CustomerTable.setSize(new Dimension(1330, 550));
        ScrollPane1 = new JScrollPane();
        ScrollPane1.setViewportView(CustomerTable);
        CustomerTable.setFillsViewportHeight(true);// makes the size of table equal to that of scroll pane to fill the table in the scrollpane
//        ArrayList<Customer> Customer_objects = Customer.View();
//        for (int i = 0; i < Customer_objects.size(); i++) {
//
//            int ID = Customer_objects.get(i).getID();
//            String CNIC = Customer_objects.get(i).getCNIC();
//            String Name = Customer_objects.get(i).getName();
//            String ContactNo = Customer_objects.get(i).getContact_No();
//            int Bill = Customer_objects.get(i).getBill();
//
//            // getting booked cars for customer
//            ArrayList<Booking> bookings = Booking.SearchByCustomerID(ID);
//            String bookedCars = "";
//            if (!bookings.isEmpty()) {
//                for (int j = 0; j < bookings.size(); j++) {
//                    if (bookings.get(j).getReturnTime() == 0) {
//                        bookedCars += bookings.get(j).getCar().getID() + ": " + bookings.get(j).getCar().getID() + "\n";
//                    } else {
//                        bookedCars = "No Cars Booked !";
//                    }
//                }
//            } else {
//                bookedCars = "No Cars Booked !";
//            }
//            String[] one_s_Record = {(i + 1) + "", "" + ID, CNIC, Name, ContactNo, bookedCars, Bill + ""};
//            tableModel.addRow(one_s_Record);
//        }

        // center aligning the text in all the columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        CustomerTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        CustomerTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        CustomerTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        CustomerTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        CustomerTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        // adjusting size of each column
        CustomerTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        CustomerTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        CustomerTable.getColumnModel().getColumn(2).setPreferredWidth(170);
        CustomerTable.getColumnModel().getColumn(3).setPreferredWidth(110);
        CustomerTable.getColumnModel().getColumn(4).setPreferredWidth(180);

//        ScrollPane1.setViewportView(CustomerTable);
        MainPanel.add(SearchIdButton, new AbsoluteConstraints(390, 10, 130, 22));
        MainPanel.add(SearchIdTextField, new AbsoluteConstraints(525, 10, 240, 22));
        MainPanel.add(SearchNameButton, new AbsoluteConstraints(10, 10, 130, 22));
        MainPanel.add(SearchNameTextField, new AbsoluteConstraints(145, 10, 240, 22));
        MainPanel.add(ScrollPane1, new AbsoluteConstraints(10, 50, 1330, 550));
        MainPanel.add(UpdateButton, new AbsoluteConstraints(579, 625, 130, 22));
        MainPanel.add(AddButton, new AbsoluteConstraints(420, 625, 130, 22));
        MainPanel.add(RemoveButton, new AbsoluteConstraints(735, 625, 130, 22));
        MainPanel.add(BackButton, new AbsoluteConstraints(1106, 625, 100, 22));
        MainPanel.add(ClearBillButton, new AbsoluteConstraints(10, 625, 200, 22));

        SearchIdButton.addActionListener(this);
        SearchNameButton.addActionListener(this);
        RemoveButton.addActionListener(this);
        AddButton.addActionListener(this);
        UpdateButton.addActionListener(this);
        BackButton.addActionListener(this);
        ClearBillButton.addActionListener(this);
    }

//    public static void main(String args[]) {
//        new Customer_Details().setVisible(true);
//
//    }
    public JPanel getMainPanel() {
        return MainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Search ID": {
                String id = SearchIdTextField.getText().trim();
                if (!id.isEmpty()) {
//                    if (Customer.isIDvalid(id)) {
//                        Customer co = Customer.SearchByID(Integer.parseInt(id));
//                        if (co != null) {
//                            JOptionPane.showMessageDialog(null, co.toString());
//                            SearchIdTextField.setText("");
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Required person not found");
//                            SearchIdTextField.setText("");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Invalid ID !");
//                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter ID first !");
                }
            }
            break;
            case "Search Name": {
                String name = SearchNameTextField.getText().trim();
                if (!name.isEmpty()) {
//                    if (Customer.isNameValid(name)) {
//                        ArrayList<Customer> customerArrayList = Customer.SearchByName(name);
//                        String record = "";
//                        for (int i = 0; i < customerArrayList.size(); i++) {
//                            record += customerArrayList.get(i).toString() + "\n";
//                        }
//                        if (!customerArrayList.isEmpty()) {
//                            JOptionPane.showMessageDialog(null, record);
//                            SearchName_TextField.setText("");
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Required person not found");
//                            SearchName_TextField.setText("");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Invalid Name !");
//                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Name first !");
                }
            }
            break;
            case "Add": {
                ParentFrame.getMainFrame().setEnabled(false);
                AddCustomer aco = new AddCustomer();
                aco.frame.setVisible(true);
            }
            break;
            case "Remove": {
                ParentFrame.getMainFrame().setEnabled(false);
                new RemoveCustomer().frame.setVisible(true);
            }
            break;
            case "Update": {
//                ParentFrame.getMainFrame().setEnabled(false);
//                new UpdateCustomer().frame.setVisible(true);
            }
            break;
            case "Back": {
                ParentFrame.getMainFrame().setTitle("Rent-A-Car Management System [REBORN]");
                MainMenu mm = new MainMenu();
                ParentFrame.getMainFrame().getContentPane().removeAll();
                ParentFrame.getMainFrame().add(mm.getMainPanel());
                ParentFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
            
            case "Clear Bill": {
//                ArrayList<Customer> View = Customer.View();//Creating an arrayList that contains Objects of all Customers
//                if (!View.isEmpty()) {
//                    ArrayList<String> IDsArray = new ArrayList<>(0);
//                    for (int i = 0; i < View.size(); i++) { // getting IDs of all the Customers with Bill > 0
//                        if (View.get(i).getBill() != 0) {
//                            IDsArray.add(View.get(i).getID() + "");
//                        }
//                    }
//                    Object showInputDialog = JOptionPane.showInputDialog(null, "Select ID for Customer whose bill you want to clear.", "Clear Bill",
//                            JOptionPane.PLAIN_MESSAGE, null, IDsArray.toArray(), null);
//                    System.out.println(showInputDialog);
//
//                    if (showInputDialog != null) {
//                        Customer customer = Customer.SearchByID((Integer.parseInt(showInputDialog + "")));
//
//                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to clear the balance for the following Customer\n"
//                                + customer + "\nAre you sure you want to continue ?", "Clear Bill Confirmation",
//                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//                        if (showConfirmDialog == 0) {
//                            customer.setBill(0);
//                            customer.Update();
//                            ParentFrame.getMainFrame().getContentPane().removeAll();
//                            Customer_Details cd = new Customer_Details();
//                            ParentFrame.getMainFrame().add(cd.getMainPanel());
//                            ParentFrame.getMainFrame().getContentPane().revalidate();
//                            JOptionPane.showMessageDialog(null, "Bill Successfully Cleared !");
//                        }
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "No Customer Currently Registered !");
//                }
            }
            break;
        }
    }
}
