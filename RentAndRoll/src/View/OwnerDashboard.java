/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CarOwnerController;
import Model.CarOwner;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
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
public class OwnerDashboard implements ActionListener{
    private JTextField SearchIdTextField;
    private JButton SearchIdButton, SearchNameButton, UpdateButton, AddButton, RemoveButton, BackButton, ClearBalanceButton;
    private JScrollPane ScrollPane1;
    private JTable OwnerTable;
    private JTextField SearchNameTextField;
    static DefaultTableModel TableModel;
    private JPanel MainPanel;
    
    private CarOwnerController ownerController = new CarOwnerController();

    public OwnerDashboard() {
        MainPanel = new JPanel();
        ParentFrame.getMainFrame().setTitle("Car Owner Details");
        MainPanel.setLayout(new AbsoluteLayout());
        MainPanel.setMinimumSize(new Dimension(1366, 730));

        SearchIdButton = new JButton("Search ID");
        UpdateButton = new JButton("Update");
        AddButton = new JButton("Add");
        RemoveButton = new JButton("Remove");
        BackButton = new JButton("Back");
        SearchNameButton = new JButton("Search Name");
        ClearBalanceButton = new JButton("Clear Balance");
        SearchIdTextField = new JTextField();
        SearchNameTextField = new JTextField();
        ScrollPane1 = new JScrollPane();
        OwnerTable = new JTable();

        String[] columns = {"ID", "Name", "Contact Number", "Balance"};
        TableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        OwnerTable = new JTable(TableModel);

        OwnerTable.setSize(new Dimension(1330, 550));
        ScrollPane1 = new JScrollPane(OwnerTable);
        OwnerTable.setFillsViewportHeight(true);// makes the size of table equal to that of scroll pane to fill the table in the scrollpane
        List<CarOwner> OwnersList = ownerController.getAllOwners();
        for (int i = 0; i < OwnersList.size(); i++) {
            int ID = OwnersList.get(i).getOwnerId();
            String Name = OwnersList.get(i).getOwnerName();
            String ContactNo = OwnersList.get(i).getPhoneNo();
            float Balance = OwnersList.get(i).getBalanceDue();

            String[] tableRecord = {"" + ID, Name, ContactNo, Balance + ""};
            TableModel.addRow(tableRecord);
        }

        // center aligning the text in all the columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        OwnerTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        OwnerTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        OwnerTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        OwnerTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        // adjusting size of each column
        OwnerTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        OwnerTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        OwnerTable.getColumnModel().getColumn(2).setPreferredWidth(170);
        OwnerTable.getColumnModel().getColumn(3).setPreferredWidth(110);

//        jScrollPane1.setViewportView(jTable1);
        MainPanel.add(SearchIdButton, new AbsoluteConstraints(390, 10, 130, 22));
        MainPanel.add(SearchIdTextField, new AbsoluteConstraints(525, 10, 240, 22));
        MainPanel.add(SearchNameButton, new AbsoluteConstraints(10, 10, 130, 22));
        MainPanel.add(SearchNameTextField, new AbsoluteConstraints(145, 10, 240, 22));
        MainPanel.add(ScrollPane1, new AbsoluteConstraints(10, 50, 1330, 550));
        MainPanel.add(UpdateButton, new AbsoluteConstraints(579, 625, 130, 22));
        MainPanel.add(AddButton, new AbsoluteConstraints(420, 625, 130, 22));
        MainPanel.add(RemoveButton, new AbsoluteConstraints(735, 625, 130, 22));
        MainPanel.add(BackButton, new AbsoluteConstraints(1106, 625, 130, 22));
        MainPanel.add(ClearBalanceButton, new AbsoluteConstraints(10, 625, 130, 22));

        SearchIdButton.addActionListener(this);
        SearchNameButton.addActionListener(this);
        BackButton.addActionListener(this);
        RemoveButton.addActionListener(this);
        AddButton.addActionListener(this);
        UpdateButton.addActionListener(this);    
        ClearBalanceButton.addActionListener(this);
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Search ID": {
                String id = SearchIdTextField.getText().trim();
                if (!id.isEmpty()) {
                      int searchId = Integer.parseInt(id);
                      CarOwner co = ownerController.getOwnerById(searchId);
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
                        List<CarOwner> carOwnerArrayList = ownerController.getOwnersByName(name);
                        String record = "";
                        if (!carOwnerArrayList.isEmpty()) {
                            for (int i = 0; i < carOwnerArrayList.size(); i++) {
                                record += carOwnerArrayList.get(i).toString() + "\n";
                            }
                            JOptionPane.showMessageDialog(null, record);
                            SearchNameTextField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Required person not found");
                            SearchNameTextField.setText("");
                        }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a name");
                }
            }
            break;
            case "Add": {
                ParentFrame.getMainFrame().setEnabled(false);
                AddCarOwner aco = new AddCarOwner();
                aco.frame.setVisible(true);
            }
            break;
            case "Remove": {
                int selectedIndex = OwnerTable.getSelectedRow();
                if (selectedIndex == -1 && OwnerTable.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                }
                else {
                    String clearId = (String)OwnerTable.getValueAt(selectedIndex, 0);
                    int id = Integer.parseInt(clearId);
                    CarOwner carOwner = ownerController.getOwnerById(id);
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about the following car owner\n"
                            + carOwner + "\nAre you sure you want to continue ?", "Remove Owner Confirmation",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                    if (showConfirmDialog == 0) {
                        boolean removed = ownerController.removeOwner(id);
                        if(removed){
                            ParentFrame.getMainFrame().getContentPane().removeAll();
                            OwnerDashboard cd = new OwnerDashboard();
                            ParentFrame.getMainFrame().add(cd.getMainPanel());
                            ParentFrame.getMainFrame().getContentPane().revalidate();
                            JOptionPane.showMessageDialog(null, "Owner Removed Succesfully!");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Error in deleting owner. Please try again later!");
                        }
                    }
                }
            }
            break;
            case "Update": {
                ParentFrame.getMainFrame().setEnabled(false);
                new UpdateCarOwner().frame.setVisible(true);
            }
            break;
            case "Clear Balance": {
                int selectedIndex = OwnerTable.getSelectedRow();
                if (selectedIndex == -1 && OwnerTable.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "No row selected!");
                }
                else {
                    String clearId = (String)OwnerTable.getValueAt(selectedIndex, 0);
                    int id = Integer.parseInt(clearId);
                    CarOwner carOwner = ownerController.getOwnerById(id);
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to clear the balance for the following Car Owner\n"
                            + carOwner + "\nAre you sure you want to continue ?", "Clear Balance Confirmation",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                    if (showConfirmDialog == 0) {
                        boolean cleared = ownerController.clearBalance(id);
                        if(cleared) {
                            ParentFrame.getMainFrame().getContentPane().removeAll();
                            OwnerDashboard cd = new OwnerDashboard();
                            ParentFrame.getMainFrame().add(cd.getMainPanel());
                            ParentFrame.getMainFrame().getContentPane().revalidate();
                            JOptionPane.showMessageDialog(null, "Balance Successfully Cleared!");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Error in clearing balance. Please try again later!");
                        }
                    }
                }
            }
            break;
            case "Back": {
                ParentFrame.getMainFrame().setTitle("Rent and Roll - Car Management System");
                MainMenu mm = new MainMenu();
                ParentFrame.getMainFrame().getContentPane().removeAll();
                ParentFrame.getMainFrame().add(mm.getMainPanel());
                ParentFrame.getMainFrame().getContentPane().revalidate();
            }
            break;
        }
    }
    
}
