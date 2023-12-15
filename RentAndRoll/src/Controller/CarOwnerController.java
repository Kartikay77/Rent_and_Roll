/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CarOwner;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;  
import java.sql.PreparedStatement;  

import utilities.DatabaseConnector;

/**
 * The CarOwnerController class is responsible for adding, retrieving and querying data 
 from the CarOwner table in the database.
 */
public class CarOwnerController {
    List<CarOwner> carOwners = new ArrayList<>();
    Statement stmt;
    Connection connection;
    DatabaseConnector databaseConnector = new DatabaseConnector();

    public CarOwnerController() {
        try {
            this.connection = databaseConnector.getConnection();
            this.stmt = connection.createStatement(); 
        } catch(SQLException e) {
            System.out.println("Unable to make database connection: "+e);
        }
    }
     protected CarOwnerController(Connection conn) {
            this.connection = conn;
    }   
     
        /**
     * Gets all Owners from database.
     * @return list of Car Owners objects
     */
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
        } catch (Exception e) {
            System.out.println("Unable to get all Car Owners: "+e);
        }
        return car_owners;
    }
    
        /**
     * Gets Owner object by ID
     * @param id id of the owners whose details are to be retrieved.
     * @return owner object
     */
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
    
        /**
     * Gets all owners that match the given name.
     * @param owner_name name to be matched
     * @return List of owner objects whose name matches the name given.
     */
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
        } catch (Exception e) {
            System.out.println("Unable to get carowner: "+e);
        }
        return car_owners;
    }
    
    
        /**
     * Adds owner with given details to the database
     * @param name name of the owner
     * @param phoneNo contact number of the owner
     * @param bill amount pending to be by the owner
     * @return int id of the owner after addition in the database
     */
    public int addOwner(String name, String phoneNo, double balance){
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedOwnerId;
    }
    
        /**
     * Removes owner from database
     * @param id ID of the owner to be removed.
     * @return true if removal was successful else false.
     */
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
    
        /**
     * Clears the balance of the owner whose id is given.
     * @param id ID of the owner whose balance is to be cleared.
     * @return true if clearing balance was successful else false.
     */
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
    public Connection getConnection() {
		return this.connection;
	}

	public Statement getStatement() {
		return this.stmt;
	}

	public void setDatabaseConnector(DatabaseConnector databaseConnector) throws SQLException {
		this.databaseConnector = databaseConnector;
        this.connection = this.databaseConnector.getConnection();
		
	}   
        
        public void setStatement(Statement statementMock) {
		this.stmt = statementMock;
	}
}
