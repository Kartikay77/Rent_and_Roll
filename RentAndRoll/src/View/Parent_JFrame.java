/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author erkur
 */
public class Parent_JFrame {
    private static JFrame MainFrame;
    private final JMenuBar menu_Bar;
    private final JMenuItem Exit, Logout, Help;
//    private final JMenuItem Exit, addCar, updateCar, removeCar, ViewUnbookedCars, ViewbookedCars,
//            addCustomer, updateCustomer, removeCustomer,
//            addCarOwner, updateCarOwner, removeCarOwner,
//            ViewJavaDoc, ViewDocumentation, About;

    public Parent_JFrame() {
        MainFrame = new JFrame("Rent And Roll - Car Management System");
        MainFrame.setSize(1366, 730);
        MainFrame.setVisible(true);

                
        MainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        MainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to terminate the program.\n"
                        + " Are you sure you want to continue ?", "Close Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                if (showConfirmDialog == 0) {
                    System.exit(0);
                }
            }
        });

        menu_Bar = new JMenuBar();

        Exit = new JMenuItem("Exit");
        Logout = new JMenuItem("Logout");
        Help = new JMenuItem("Help");

        menu_Bar.add(Exit);
        menu_Bar.add(Logout);
        menu_Bar.add(Help);
        
        MainFrame.setJMenuBar(menu_Bar);

        Exit.addActionListener(new Parent_JFrame_ActionListner());
        Logout.addActionListener(new Parent_JFrame_ActionListner());
        Help.addActionListener(new Parent_JFrame_ActionListner());

    }

    public static JFrame getMainFrame() {
        return MainFrame;
    }

    private class Parent_JFrame_ActionListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Exit": {
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to terminate the program.\n"
                            + " Are you sure you want to continue ?", "Close Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                    if (showConfirmDialog == 0) {
                        System.exit(0);
                    }
                }
                break;
       
                case "Help": {
                    JOptionPane.showMessageDialog(null, "THIS PROGRAM IS WRITTEN AS A SEMESTER PROJECT OF OBJECT ORIENTED PROGRAMMING PROGRAMMIG  BY ABDULLAH SHAHID !");
                }
                break;
                
                case "Logout": {
                Parent_JFrame.getMainFrame().dispose();
                Runner r = new Runner();
                JFrame frame = r.getFrame();
                Login login = new Login();
                JPanel panel = login.getMainPanel();
                frame.add(panel);
                frame.setVisible(true);
            }
            break;

            }
        }
    }
}
