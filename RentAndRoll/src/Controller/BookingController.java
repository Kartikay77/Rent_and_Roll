/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Booking;
import java.util.ArrayList;
import java.sql.Timestamp;
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
    DatabaseConnector databaseConnector = new DatabaseConnector();
    
    public BookingController() {
        try {
            this.connection = this.databaseConnector.getConnection();
            this.stmt = connection.createStatement(); 
        } catch(SQLException e) {
            System.out.println("Unable to make database connection: "+e);
        }
    }
    
    protected BookingController(Connection conn) {
            this.connection = conn;
    }
    
    /**
     * Gets all booking from database.
     * @return list of Booking objects
     */
    public List<Booking> getAllBooking(){
        //To DO: Get all Booking from database
        List<Booking> bookings = new ArrayList<>();

        try {
        String sqlQuery = "SELECT b.booking_id, b.rent_time, b.return_time, b.customer_id, b.car_id, c.car_name, c.reg_no, cust.customer_name  " +
                          "FROM booking b " +
                          "JOIN car c ON b.car_id = c.car_id " +
                          "JOIN customer cust ON b.customer_id = cust.customer_id";

        ResultSet rs = this.stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            Booking booking = new Booking();
            booking.setBookingId(rs.getInt("booking_id"));
            booking.setRentalStartTime(rs.getDate("rent_time"));
            booking.setRentalReturnTime(rs.getDate("return_time"));
            booking.setCustomerId(rs.getInt("customer_id"));
            booking.setCarId(rs.getInt("car_id"));
            booking.setCarName(rs.getString("car_name")); // Set car name
            booking.setReg_No(rs.getString("reg_no"));
            booking.setCustomerName(rs.getString("customer_name"));
            bookings.add(booking);
        }
    } catch (SQLException e) {
        System.out.println("Unable to get all Booking with car names: " + e);
    }
    return bookings;
    }
    
    /**
     * Gets Booking object by ID
     * @param id id of the Booking whose details are to be retrieved.
     * @return Booking object
     */
    public Booking getBookingById(int id){
        // To do: Get booking by Id
        Booking booking = new Booking();
        try {
        String sqlQuery = "SELECT b.booking_id, b.rent_time, b.return_time, b.customer_id, b.car_id, c.car_name, cust.customer_name " +
                          "FROM booking b " +
                          "JOIN car c ON b.car_id = c.car_id " +
                          "JOIN customer cust ON b.customer_id = cust.customer_id " +
                          "WHERE b.booking_id = " + id;

        ResultSet rs = this.stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            booking.setBookingId(rs.getInt("booking_id"));
            booking.setRentalStartTime(rs.getDate("rent_time"));
            booking.setRentalReturnTime(rs.getDate("return_time"));
            booking.setCustomerId(rs.getInt("customer_id"));
            booking.setCarId(rs.getInt("car_id"));
            booking.setCarName(rs.getString("car_name")); // Set car name
            booking.setCustomerName(rs.getString("customer_name"));
        }
    } catch (SQLException e) {
        System.out.println("Unable to get bookings: " + e);
    }
    return booking;
    }
    
    /**
     * Gets Booking object by Customer ID
     * @param id id of the Booking whose details are to be retrieved.
     * @return Booking object
     */
    public Booking getBookingByCustomerId(int id){
        // To do: Get booking by Id
        Booking booking = new Booking();
        try {
        String sqlQuery = "SELECT b.booking_id, b.rent_time, b.return_time, b.customer_id, b.car_id, c.car_name, cust.customer_name " +
                          "FROM booking b " +
                          "JOIN car c ON b.car_id = c.car_id " +
                          "JOIN customer cust ON b.customer_id = cust.customer_id " +
                          "WHERE b.customer_id = " + id;

        ResultSet rs = this.stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            booking.setBookingId(rs.getInt("booking_id"));
            booking.setRentalStartTime(rs.getDate("rent_time"));
            booking.setRentalReturnTime(rs.getDate("return_time"));
            booking.setCustomerId(rs.getInt("customer_id"));
            booking.setCarId(rs.getInt("car_id"));
            booking.setCarName(rs.getString("car_name")); // Set car name
            booking.setCustomerName(rs.getString("customer_name"));
        }
    } catch (SQLException e) {
        System.out.println("Unable to get bookings: " + e);
    }
    return booking;
    }
    
    
    /**
     * Adds Booking with given details to the database
     * @param name name of the customer
     * @param phoneNo contact number of the customer
     * @param balance balance amount due to be paid by the customer
     * @return int id of the customer after addition in the database
     */
    public int addBooking(Timestamp rentTime, Timestamp returnTime, int customerId, int carId) {
    String sqlQuery = "INSERT INTO booking (rent_time, return_time, customer_id, car_id) VALUES (?, ?, ?, ?)";
    int generatedBookingId = -999;
    String carRegNo = ""; // Variable to store car registration number

    try {
        // Retrieve the car registration number based on the provided carId
        String fetchCarRegNoQuery = "SELECT reg_no FROM car WHERE car_id = ?";
        try (PreparedStatement regNoStatement = connection.prepareStatement(fetchCarRegNoQuery)) {
            regNoStatement.setInt(1, carId);
            ResultSet carResultSet = regNoStatement.executeQuery();
            if (carResultSet.next()) {
                carRegNo = carResultSet.getString("reg_no");
            }
        }

        // Proceed with adding the booking details
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, rentTime);
            preparedStatement.setTimestamp(2, returnTime);
            preparedStatement.setInt(3, customerId);
            preparedStatement.setInt(4, carId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                // Retrieve the generated ID
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedBookingId = generatedKeys.getInt(1);
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return generatedBookingId;
}

    
    /**
     * Removes booking from database
     * @param id ID of the booking to be removed.
     * @return true if removal was successful else false.
     */
    public boolean removeBooking(int id){
        // To do: Remove booking from database along with all bookings of the particular booking.
        try {
            String sqlQuery = "delete from booking where booking_id=" + id +";";
            this.stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Unable to remove booking: "+e);
            return false;
        }
        return true;
        // TO DO Remaining: Remove bookings from booking table also
    }  
    /**
    * Gets Booking object by car registration number
    * @param regNo car registration number for which booking details are to be retrieved.
    * @return Booking object
    */
   public Booking getBookingByCarRegNo(String regNo){
       // To do: Get booking by car registration number
       Booking booking = null;
       try {
    	   String sqlQuery = "SELECT b.booking_id, b.rent_time, b.return_time, b.customer_id, b.car_id, c.car_name, cust.customer_name " +
                   "FROM booking b " +
                   "JOIN car c ON b.car_id = c.car_id " +
                   "JOIN customer cust ON b.customer_id = cust.customer_id " +
                   "WHERE c.reg_no = ?";
    	   
           PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
           preparedStatement.setString(1, regNo);
           ResultSet rs = preparedStatement.executeQuery();

           if (rs.next()) {
               booking = new Booking();
               booking.setBookingId(rs.getInt("booking_id"));
               booking.setRentalStartTime(rs.getDate("rent_time"));
               booking.setRentalReturnTime(rs.getDate("return_time"));
               booking.setCustomerId(rs.getInt("customer_id"));
               booking.setCarId(rs.getInt("car_id"));
               booking.setCarName(rs.getString("car_name"));
               booking.setCustomerName(rs.getString("customer_name")); // Set customer name
           }
       } catch (SQLException e) {
           System.out.println("Unable to get booking by car registration number: " + e);
       }
       return booking;
   }
    
    /**
     * Clears the balance of the booking whose id is given.
     * @param id ID of the booking whose balance is to be cleared.
     * @return true if clearing balance was successful else false.
     */
//    public boolean clearBalance(int id){
//        // To do: Clear balance due to be paid by booking
//        try {
//            String sqlQuery = "UPDATE booking SET bill = 0 WHERE customer_id = " + id + ";";
//            this.stmt.executeUpdate(sqlQuery);
//        } catch (SQLException e) {
//            System.out.println("Unable to update customer: "+e);
//            return false;
//        }
//        return true;
//    }
    
}
