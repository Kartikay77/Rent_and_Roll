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
import Controller.CustomerController;
import Model.Customer;
import Controller.CarOwnerController;
import Model.CarOwner;

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
        
                CarOwnerController cd = new CarOwnerController();
          System.out.println(cd.addOwner("Adwait", "123456", 235))
                  ;
//        // Assuming owner ID for whom balance needs to be cleared
        int ownerId = 1; // Replace this with an existing owner ID from your database
//
//        // Clear balance for the specified owner
        boolean isBalanceCleared = cd.clearBalance(ownerId);
//
        if (isBalanceCleared) {
            System.out.println("Balance successfully cleared for owner with ID " + ownerId);
        } else {
            System.out.println("Failed to clear balance for owner with ID " + ownerId);

        // For testing purpose to be deleted
//        CustomerController cd = new CustomerController();
//        Customer customer = (cd.getCustomerById(14));
        
//        System.out.println(customer.getCustomerId() + " " + customer.getCustomerName());


//        CustomerController cd = new CustomerController();
//        Customer customer = (cd.getCustomerById(14));
//        for(Customer customer: customers){
//            System.out.println(customer.getCustomerId() + " " + customer.getCustomerName());
        }
    }
    
}
