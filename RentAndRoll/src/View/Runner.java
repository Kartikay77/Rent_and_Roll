/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import View.Login;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.List;
import Model.CustomerDashboard;
import Model.Customer;

/**
 *
 * @author erkur
 */
public class Runner {
    private static final JFrame FRAME = new JFrame();
    private final ImageIcon icon;
    private final JLabel L1;

    public static JFrame getFrame() {
        return FRAME;
    }

    public Runner() {
        
        icon = new ImageIcon("WelcomeImage2.jpg");
        L1 = new JLabel(icon);
        FRAME.setUndecorated(true);
        FRAME.setSize(new Dimension(1000, 534));
        FRAME.setLocationRelativeTo(null);
        FRAME.add(L1);
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        Runner.FRAME.setVisible(true);

        try {
            Thread.sleep(1000);
            Login LoginObject = new Login();
            Runner.FRAME.getContentPane().removeAll();
            Runner.FRAME.add(LoginObject.getMainPanel());
            Runner.FRAME.getContentPane().revalidate();

        } catch (InterruptedException e) {
            System.out.println(e);
        }
        
        // For testing purpose to be deleted
//        CustomerDashboard cd = new CustomerDashboard();
//        System.out.println(cd.removeCustomer(5));
//        for(Customer customer: customers){
//            System.out.println(customer.getCustomerId() + " " + customer.getCustomerName());
//        }
//        Customer customer = cd.getCustomerById(5);
//        System.out.println(customer.getCustomerId() + " " + customer.getCustomerName());

    }
    
}
