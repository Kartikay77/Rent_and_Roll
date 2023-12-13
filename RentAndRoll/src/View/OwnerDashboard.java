/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.CarOwner;
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
public class OwnerDashboard implements ActionListener{
    private JTextField SearchIdTextField;
    private JButton SearchIdButton, SearchNameButton, UpdateButton, AddButton, RemoveButton, BackButton, ClearBalanceButton;
    private JScrollPane ScrollPane1;
    private JTable OwnerTable;
    private JTextField SearchNameTextField;
    static DefaultTableModel TableModel;
    private JPanel MainPanel;

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
//        ArrayList<CarOwner> OwnersList = //Call controller;
//        ArrayList<CarOwner> CarOwner_objects = new ArrayList<CarOwner>();
//        for (int i = 0; i < CarOwner_objects.size(); i++) {
//            int ID = CarOwner_objects.get(i).getID();
//            String Name = CarOwner_objects.get(i).getName();
//            String ContactNo = CarOwner_objects.get(i).getContactNo();
//            int Balance = CarOwner_objects.get(i).getBalance();
//
//            String[] tableRecord = {"" + ID, Name, ContactNo, Balance + ""};
//            TableModel.addRow(tableRecord);
//        }

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
//                    CarOwner co = CarOwner.SearchById(Integer.parseInt(id));
//                    if (co != null) {
//                        JOptionPane.showMessageDialog(null, co.toString());
//                        SearchIdTextField.setText("");
//                    } else {
//                        JOptionPane.showMessageDialog(null, "ID not found!");
//                        SearchIdTextField.setText("");
//                    }                   
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter ID");
                }
            }
            break;
            case "Search Name": {
                String name = SearchNameTextField.getText().trim();
                if (!name.isEmpty()) {
//                        ArrayList<CarOwner> carOwnerArrayList = CarOwner.SearchByName(name);
//                        String record = "";
//                        if (!carOwnerArrayList.isEmpty()) {
//                            for (int i = 0; i < carOwnerArrayList.size(); i++) {
//                                record += carOwnerArrayList.get(i).toString() + "\n";
//                            }
//                            JOptionPane.showMessageDialog(null, record);
//                            SearchNameTextField.setText("");
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Required person not found");
//                            SearchNameTextField.setText("");
//                        }
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
                ParentFrame.getMainFrame().setEnabled(false);
                new RemoveCarOwner().frame.setVisible(true);
            }
            break;
            case "Update": {
                ParentFrame.getMainFrame().setEnabled(false);
                new UpdateCarOwner().frame.setVisible(true);
            }
            break;
            case "Clear Balance": {
//                Creating an array that contains IDs of all CarOwners
//                ArrayList<CarOwner> View = CarOwner.View(); // getting all the available Car Owner Objects
//                if (!View.isEmpty()) {
//                    ArrayList<String> IDsArray = new ArrayList<>(0);
//                    for (int i = 0; i < View.size(); i++) { // getting IDs of all the Car Owners with Balance > 0
//                        if (View.get(i).getBalance() != 0) {
//                            IDsArray.add(View.get(i).getID() + "");
//                        }
//                    }
//
//                    Object showInputDialog = JOptionPane.showInputDialog(null, "Select ID for Car Owner whose balance you want to clear.",
//                            "Clear Balance", JOptionPane.PLAIN_MESSAGE, null, IDsArray.toArray(), null);
//                    System.out.println(showInputDialog);
//
//                    if (showInputDialog != null) {
//                        CarOwner carOwner = CarOwner.SearchByID(Integer.parseInt(showInputDialog + ""));
//
//                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to clear the balance for the following Car Owner\n"
//                                + carOwner + "\nAre you sure you want to continue ?", "Clear Balance Confirmation",
//                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//                        if (showConfirmDialog == 0) {
//                            carOwner.setBalance(0);
//                            carOwner.Update();
//                            Parent_JFrame.getMainFrame().getContentPane().removeAll();
//                            CarOwner_Details cd = new CarOwner_Details();
//                            Parent_JFrame.getMainFrame().add(cd.getMainPanel());
//                            Parent_JFrame.getMainFrame().getContentPane().revalidate();
//                            JOptionPane.showMessageDialog(null, "Balance Successfully Cleared !");
//                        }
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "No Car Owner is registered !");
//                }
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
