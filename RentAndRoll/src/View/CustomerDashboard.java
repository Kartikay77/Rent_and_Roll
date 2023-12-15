/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CustomerController;
import Model.Customer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 * This class is responsible for painting the Customer dashboard in the UI.
 */
public class CustomerDashboard implements ActionListener{
    JTextField SearchIdTextField;
    JButton SearchIdButton;
	private JButton SearchNameButton;
	private JButton UpdateButton;
	private JButton AddButton;
	private JButton RemoveButton;
	private JButton BackButton;
	private JButton ClearBillButton;
    private JScrollPane ScrollPane1;
    private JTable CustomerTable;
    private JTextField SearchNameTextField;
    static DefaultTableModel tableModel;
    private JPanel MainPanel;
    
    CustomerController customerController = new CustomerController();

    public CustomerDashboard() {
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

        String[] columns = {"ID", "Name", "Contact Number", "Bill"};
        tableModel = new DefaultTableModel(columns, 0) {

        	/**
             * Returns whether the cell is editable.
             * @param row
             * @param column
             * @return boolean
             */
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
        List<Customer> CustomersList = customerController.getAllCustomers();
        for (int i = 0; i < CustomersList.size(); i++) {
            int ID = CustomersList.get(i).getCustomerId();
            String Name = CustomersList.get(i).getCustomerName();
            String ContactNo = CustomersList.get(i).getPhoneNo();
            float Balance = CustomersList.get(i).getBillAmount();

            String[] tableRecord = {"" + ID, Name, ContactNo, Balance + ""};
            tableModel.addRow(tableRecord);
        }

        // center aligning the text in all the columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        CustomerTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        CustomerTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        CustomerTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        CustomerTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        // adjusting size of each column
        CustomerTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        CustomerTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        CustomerTable.getColumnModel().getColumn(2).setPreferredWidth(170);
        CustomerTable.getColumnModel().getColumn(3).setPreferredWidth(110);

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
    
    /**
     * Returns the main panel for the CustomerDashboard class.
     * @return JPanel
     */
    public JPanel getMainPanel() {
        return MainPanel;
    }

    /**
     * Perform the action received from the action listener for the Customer Dashboard page.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Search ID": {
                String id = SearchIdTextField.getText().trim();
                if (!id.isEmpty()) {
                      int searchId = Integer.parseInt(id);
                      Customer co = customerController.getCustomerById(searchId);
                    if (co != null) {
                        JOptionPane.showMessageDialog(null, co.toString());
                        SearchIdTextField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID not found!");
                        SearchIdTextField.setText("");
                    }                   
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter ID");
                }
            }
            break;
            case "Search Name": {
                String name = SearchNameTextField.getText().trim();
                if (!name.isEmpty()) {
                    List<Customer> customerArrayList = customerController.getCustomersByName(name);
                    String record = "";
                    if (!customerArrayList.isEmpty()) {
                        for (int i = 0; i < customerArrayList.size(); i++) {
                            record += customerArrayList.get(i).toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, record);
                        SearchNameTextField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Required person not found");
                        SearchNameTextField.setText("");
                    }
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
                int selectedIndex = CustomerTable.getSelectedRow();
                if (selectedIndex == -1 && CustomerTable.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                }
                else {
                    String clearId = (String)CustomerTable.getValueAt(selectedIndex, 0);
                    int id = Integer.parseInt(clearId);
                    Customer customer = customerController.getCustomerById(id);
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about the following car customer\n"
                            + customer + "\nAre you sure you want to continue ?", "Remove Customer Confirmation",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                    if (showConfirmDialog == 0) {
                        boolean removed = customerController.removeCustomer(id);
                        if(removed){
                            ParentFrame.getMainFrame().getContentPane().removeAll();
                            CustomerDashboard cd = new CustomerDashboard();
                            ParentFrame.getMainFrame().add(cd.getMainPanel());
                            ParentFrame.getMainFrame().getContentPane().revalidate();
                            JOptionPane.showMessageDialog(null, "Customer Removed Succesfully!");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Error in deleting customer. Please try again later!");
                        }
                    }
                }
            }
            break;
            case "Update": {
//                ParentFrame.getMainFrame().setEnabled(false);
//                new UpdateCustomer().frame.setVisible(true);
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
            
            case "Clear Bill": {
                int selectedIndex = CustomerTable.getSelectedRow();
                if (selectedIndex == -1 && CustomerTable.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "No row selected!");
                }
                else {
                    String clearId = (String)CustomerTable.getValueAt(selectedIndex, 0);
                    int id = Integer.parseInt(clearId);
                    Customer customer = customerController.getCustomerById(id);
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to clear the bill for the following customer\n"
                            + customer + "\nAre you sure you want to continue ?", "Clear Bill Confirmation",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                    if (showConfirmDialog == 0) {
                        boolean cleared = customerController.clearBalance(id);
                        if(cleared) {
                            ParentFrame.getMainFrame().getContentPane().removeAll();
                            CustomerDashboard cd = new CustomerDashboard();
                            ParentFrame.getMainFrame().add(cd.getMainPanel());
                            ParentFrame.getMainFrame().getContentPane().revalidate();
                            JOptionPane.showMessageDialog(null, "Bill Successfully Cleared!");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Error in clearing bill. Please try again later!");
                        }
                    }
                }
            }
            break;
        }
    }
}
