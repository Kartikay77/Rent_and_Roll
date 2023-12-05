/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author erkur
 */
public class RemoveCarOwner {
    JButton RemoveButton, CancelButton;
    JLabel IdLabel;
    JTextField IdTextField;
    JFrame frame = new JFrame();

    public RemoveCarOwner() {
        frame.setTitle("Remove Car Owner");
        frame.setLayout(new AbsoluteLayout());
        frame.setSize(new Dimension(450, 290));
        frame.setResizable(false);
        frame.setLocationRelativeTo(ParentFrame.getMainFrame());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ParentFrame.getMainFrame().setEnabled(true);
                frame.dispose();
            }
        });

        RemoveButton = new JButton("Remove");
        CancelButton = new JButton("Cancel");

        IdLabel = new JLabel("Enter ID (without dashes)");
        IdTextField = new JTextField();

        IdTextField.setPreferredSize(new Dimension(240, 22));
        IdLabel.setPreferredSize(new Dimension(175, 22));
        
        frame.add(IdLabel, new AbsoluteConstraints(10, 5));
        frame.add(IdTextField, new AbsoluteConstraints(195, 5));

        frame.add(RemoveButton, new AbsoluteConstraints(100, 225, 100, 22));
        frame.add(CancelButton, new AbsoluteConstraints(250, 225, 100, 22));

        RemoveButton.addActionListener(new CarOwner_Remove_ActionListener());
        CancelButton.addActionListener(new CarOwner_Remove_ActionListener());
    }
    private class CarOwner_Remove_ActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Remove": {
                    String id = IdTextField.getText().trim();
//                    CarOwner carOwner = 
                    if (!id.isEmpty()) {
//                            int showConfirmDialog = JOptionPane.showConfirmDialog(frame, "You are about to remove the following Car Owner.\n"+carOwner.toString()+"\nAll the data including Cars and Balance for this car owner will also be deleted  !"
//                                    + "\n Are you sure you want to continue ??", "Remove Car Owner", JOptionPane.OK_CANCEL_OPTION);
//                            if (showConfirmDialog == 0) {
////                                carOwner.Remove();
////                                System.out.println("Car owner deleted !");
//                                ParentFrame.getMainFrame().getContentPane().removeAll();
//                                CarOwnerDetails cd = new CarOwnerDetails();
//                                ParentFrame.getMainFrame().add(cd.getMainPanel());
//                                ParentFrame.getMainFrame().getContentPane().revalidate();
//                                JOptionPane.showMessageDialog(null, "Record successfully removed !");
//                                ParentFrame.getMainFrame().setEnabled(true);
//                                frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "OWner with this ID does not exist.");
                    }
                    break;
                }
                case "Cancel": {
                    ParentFrame.getMainFrame().setEnabled(true);
                    frame.dispose();
                    break;
                }
            }
        }
    }
}
