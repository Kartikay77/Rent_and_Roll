/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.*;

public class CarOwnerDashboard {
    List<CarOwner> carOwners = new ArrayList<>();
        
    public List<CarOwner> getAllOwners(){
        //To DO: Get all car owners from database
        return null;
    }
    
    public CarOwner getOwnerById(int id){
        // To do: Get car owner by Id
        return null;
    }
    
    public List<CarOwner> getOwnersByName(String name){
        // To do: Get Car owners by name from database
        return null;
    }
    
    public int addOwner(String name, String phoneNo){
        // To do: Add owner with the details into database and return id
        return 0;
    }
    
    public boolean removeOwner(int id){
        // To do: Remove Owner from database along with all cars of the owner.
        return false;
    }  
    
    public boolean clearBalance(int id){
        // To do: Clear balance due to pay car owner
        return false;
    }
    
}
