/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Car;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;  
import java.sql.PreparedStatement;  

import utilities.DatabaseConnector;
public class CarController {
    List<Car> cars = new ArrayList<>();
    Statement stmt;
    Connection connection;
    DatabaseConnector databaseConnector = new DatabaseConnector();

    public CarController() {
         try {
            this.connection = databaseConnector.getConnection();
            this.stmt = connection.createStatement(); 
        } catch(SQLException e) {
            System.out.println("Unable to make database connection: "+e);
        }
    }
    protected CarController(Connection conn) {
            this.connection = conn;
    }       
    public List<Car> getAllCars(){
        //To DO: Get all car owners from database
        List<Car> cars = new ArrayList<>();

        try {
            String sqlQuery = "select * from car";
            ResultSet rs = this.stmt.executeQuery(sqlQuery); 
            while (rs.next()) {
                Car car = new Car();
                car.setCarId(rs.getInt("car_id"));
                car.setMakerName(rs.getString("maker"));
                car.setCarName(rs.getString("car_name"));
                car.setColor(rs.getString("color"));
                car.setCarType(rs.getString("car_type"));
                car.setCarModel(rs.getString("model"));
                car.setCarRegNo(rs.getString("reg_no"));
                car.setCarCondition(rs.getString("car_condition"));
                car.setSeatingCapacity(rs.getInt("seating_capacity"));
                car.setRentPerHour(rs.getFloat("rent_per_hour"));
                car.setcarOwnerID(rs.getInt("owner_id"));
                car.setCarOwnerName(rs.getString("owner_name"));
                cars.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Unable to get all Cars , Owners"+e);
        }
        return cars;
    }
    
    public Car getCarById(String carRegNo) {
    Car car = null;
    try (PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM car WHERE reg_no=?")) {
        preparedStatement.setString(1, carRegNo);

        try (ResultSet rs = preparedStatement.executeQuery()) {
            if (rs.next()) {
                car = new Car();
                car.setCarId(rs.getInt("car_id"));
                car.setCarModel(rs.getString("model"));
                car.setCarRegNo(rs.getString("reg_no"));
                car.setRentPerHour(rs.getFloat("rent_per_hour"));
            }
        }
    } catch (SQLException e) {
        System.out.println("Unable to get Car: " + e);
    }
    return car;
 }
    
    public List<Car> getCarsByName(String name){
        // To do: Get Car by name from database
        List<Car> cars = new ArrayList<>();
        try {
            String sqlQuery = "select * from car where car_name=\"" + name +"\";";
            ResultSet rs = this.stmt.executeQuery(sqlQuery); 
            while(rs.next()){
                Car car = new Car();
                car.setCarId(rs.getInt("car_id"));
                car.setCarModel(rs.getString("model"));
                car.setCarRegNo(rs.getString("reg_no"));
                car.setRentPerHour(rs.getFloat("rent_per_hour"));
                cars.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Unable to get car: "+e);
        }
        return cars;
    }
    
    public int addCar(String maker, String car_name,String color, String car_type,String model,String reg_no,String car_condition,int seating_capacity,double rent_per_hour,int owner_id){
        // To do: Add car with the details into database and return id
        String sqlQuery = "insert into car (maker, car_name, color, car_type, model,reg_no,car_condition,seating_capacity,rent_per_hour,owner_id) values (?,?,?,?,?,?,?,?,?,?)";
        int generatedCarId = -999;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, maker);
            preparedStatement.setString(2, car_name);
            preparedStatement.setString(3, color);
            preparedStatement.setString(4, car_type);
            preparedStatement.setString(5, model);
            preparedStatement.setString(6, reg_no);
            preparedStatement.setString(7, car_condition);
            preparedStatement.setInt(8, seating_capacity);
            preparedStatement.setDouble(9, rent_per_hour);
            preparedStatement.setInt(10, owner_id);
            

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                // Retrieving the generated ID
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedCarId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedCarId;
    }
    
    public boolean removeCar(int id){
        // To do: Remove Car from database.
        try {
            String sqlQuery = "delete from car where car_id=" + id +";";
            this.stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Unable to remove Car: "+e);
            return false;
        }
        return true;
    }    

    Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
