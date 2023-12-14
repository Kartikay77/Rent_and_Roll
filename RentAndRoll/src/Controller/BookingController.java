/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;  
import java.sql.PreparedStatement;  

import utilities.DatabaseConnector;

/**
 * The BookingController class is responsible for adding, retrieving and querying data 
 from the bookings table in the database.
 */
public class BookingController {
    Statement stmt;
    Connection connection;
    
    public BookingController() {
        try {
//            this.connection = DatabaseConnector.getConnection();
            this.stmt = connection.createStatement(); 
        } catch(SQLException e) {
            System.out.println("Unable to make database connection: "+e);
        }
    }
    
    protected BookingController(Connection conn) {
            this.connection = conn;
    }
    
    /**
     * Gets all customers from database.
     * @return list of customer objects
     */
    public List<Customer> getAllCustomers(){
        //To DO: Get all customers from database
        List<Customer> customers = new ArrayList<>();

        try {
            String sqlQuery = "select * from customer";
            ResultSet rs = this.stmt.executeQuery(sqlQuery); 
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setCustomerName(rs.getString("customer_name"));
                customer.setPhoneNo(rs.getString("contact_no"));
                customer.setBillAmount(rs.getFloat("bill"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Unable to get all customers: "+e);
        }
        return customers;
    }
    
    /**
     * Gets customer object by ID
     * @param id id of the customer whose details are to be retrieved.
     * @return Customer object
     */
    public Customer getCustomerById(int id){
        // To do: Get customer by Id
        Customer customer = new Customer();
        try {
            String sqlQuery = "select * from customer where customer_id=" + id +";";
            ResultSet rs = this.stmt.executeQuery(sqlQuery); 
            while(rs.next()){
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setCustomerName(rs.getString("customer_name"));
                customer.setPhoneNo(rs.getString("contact_no"));
                customer.setBillAmount(rs.getFloat("bill"));
            }
        } catch (SQLException e) {
            System.out.println("Unable to get customers: "+e);
        }
        return customer;
    }
    
    /**
     * Gets all customers that match the given name.
     * @param name name to be matched
     * @return List of Customer objects whose name matches the name given.
     */
    public List<Customer> getCustomersByName(String name){
        // To do: Get Customer by name from database
        List<Customer> customers = new ArrayList<>();
        try {
            String sqlQuery = "select * from customer where customer_name=\"" + name +"\";";
            ResultSet rs = this.stmt.executeQuery(sqlQuery); 
            while(rs.next()){
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setCustomerName(rs.getString("customer_name"));
                customer.setPhoneNo(rs.getString("contact_no"));
                customer.setBillAmount(rs.getFloat("bill"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("Unable to get customers: "+e);
        }
        return customers;
    }
    
    /**
     * Adds customer with given details to the database
     * @param name name of the customer
     * @param phoneNo contact number of the customer
     * @param balance balance amount due to be paid by the customer
     * @return int id of the customer after addition in the database
     */
    public int addCustomer(String name, String phoneNo, double balance){
        // To do: Add customer with the details into database and return id
        String sqlQuery = "insert into customer (customer_name, contact_no, bill) values (?, ?, ?)";
        int generatedCustomerId = -999;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNo);
            preparedStatement.setDouble(3, balance);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                // Retrieving the generated ID
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedCustomerId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedCustomerId;
    }
    
    /**
     * Removes customer from database
     * @param id ID of the customer to be removed.
     * @return true if removal was successful else false.
     */
    public boolean removeCustomer(int id){
        // To do: Remove Customer from database along with all bookings of the customer.
        try {
            String sqlQuery = "delete from customer where customer_id=" + id +";";
            this.stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Unable to remove customer: "+e);
            return false;
        }
        return true;
        // TO DO Remaining: Remove bookings from booking table also
    }  
    
    /**
     * Clears the balance of the customer whose id is given.
     * @param id ID of the customer whose balance is to be cleared.
     * @return true if clearing balance was successful else false.
     */
    public boolean clearBalance(int id){
        // To do: Clear balance due to be paid by Customer
        try {
            String sqlQuery = "UPDATE customer SET bill = 0 WHERE customer_id = " + id + ";";
            this.stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Unable to update customer: "+e);
            return false;
        }
        return true;
    }
    
}
