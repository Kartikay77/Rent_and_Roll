/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

public class CustomerDashboard {
    List<Customer> customers = new ArrayList<>();
        
    public List<Customer> getAllCustomers(){
        //To DO: Get all customers from database
        return null;
    }
    
    public Customer getCustomerById(int id){
        // To do: Get customer by Id
        return null;
    }
    
    public List<Customer> getCustomersByName(String name){
        // To do: Get Customer by name from database
        return null;
    }
    
    public int addCustomer(String name, String phoneNo){
        // To do: Add customer with the details into database and return id
        return 0;
    }
    
    public boolean removeCustomer(int id){
        // To do: Remove Customer from database along with all cars of the owner.
        return false;
    }  
    
    public boolean clearBalance(int id){
        // To do: Clear balance due to be paid by Customer
        return false;
    }
}
