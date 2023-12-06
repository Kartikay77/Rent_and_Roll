/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;  
import java.sql.PreparedStatement;  

import utilities.DatabaseConnector;


public class CarOwnerDashboard {
//    List<CarOwner> carOwners = new ArrayList<>();
    Statement stmt;
    Connection connection;
    
    public CarOwnerDashboard() {
        try {
            this.connection = DatabaseConnector.getConnection();
            this.stmt = connection.createStatement(); 
        } catch(SQLException e) {
            System.out.println("Unable to make database connection: "+e);
        }
    }
    
    public List<CarOwner> getAllOwners(){
        //To DO: Get all car owners from database
        List<CarOwner> car_owners = new ArrayList<>();

        try {
            String sqlQuery = "select * from car_owner";
            ResultSet rs = this.stmt.executeQuery(sqlQuery); 
            while (rs.next()) {
                CarOwner car_owner = new CarOwner();
                car_owner.setOwnerId(rs.getInt("owner_id"));
                car_owner.setOwnerName(rs.getString("owner_name"));
                car_owner.setPhoneNo(rs.getString("contact_no"));
                car_owner.setBalanceDue(rs.getFloat("balance"));
                car_owners.add(car_owner);
            }
        } catch (SQLException e) {
            System.out.println("Unable to get all Car Owners: "+e);
        }
        return car_owners;
    }
    
    public CarOwner getOwnerById(int id){
        // To do: Get car owner by Id
        CarOwner car_owner = new CarOwner();
        try {
            String sqlQuery = "select * from car_owner where owner_id=" + id +";";
            ResultSet rs = this.stmt.executeQuery(sqlQuery); 
            while(rs.next()){
                car_owner.setOwnerId(rs.getInt("owner_id"));
                car_owner.setOwnerName(rs.getString("owner_name"));
                car_owner.setPhoneNo(rs.getString("contact_no"));
                car_owner.setBalanceDue(rs.getFloat("balance"));
            }
        } catch (SQLException e) {
            System.out.println("Unable to get Car Owners: "+e);
        }
        return car_owner;
    }
    
    public List<CarOwner> getOwnersByName(String name){
        // To do: Get Car owners by name from database
        List<CarOwner> car_owners = new ArrayList<>();
        try {
            String sqlQuery = "select * from car_owner where owner_name=\"" + name +"\";";
            ResultSet rs = this.stmt.executeQuery(sqlQuery); 
            while(rs.next()){
                CarOwner car_owner = new CarOwner();
                car_owner.setOwnerId(rs.getInt("owner_id"));
                car_owner.setOwnerName(rs.getString("owner_name"));
                car_owner.setPhoneNo(rs.getString("contact_no"));
                car_owner.setBalanceDue(rs.getFloat("balance"));
                car_owners.add(car_owner);
            }
        } catch (SQLException e) {
            System.out.println("Unable to get carowner: "+e);
        }
        return car_owners;
    }
    
    public int addOwner(int id,String name, String phoneNo, double balance){
        // To do: Add owner with the details into database and return id
        String sqlQuery = "insert into car_owner (owner_name, contact_no, balance) values (?,?,?)";
        int generatedOwnerId = -999;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNo);
            preparedStatement.setDouble(3, balance);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                // Retrieving the generated ID
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedOwnerId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedOwnerId;
    }
    
    public boolean removeOwner(int id){
        // To do: Remove Owner from database along with all cars of the owner.
        try {
            String sqlQuery = "delete from car_owner where owner_id=" + id +";";
            this.stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Unable to remove Owner: "+e);
            return false;
        }
        return true;
    }  
    
    public boolean clearBalance(int id){
        // To do: Clear balance due to pay car owner
        try {
            String sqlQuery = "UPDATE car_owner SET balance = 0 WHERE owner_id = " + id + ";";
            this.stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Unable to update car_owner: "+e);
            return false;
        }
        return true;
    }
}
