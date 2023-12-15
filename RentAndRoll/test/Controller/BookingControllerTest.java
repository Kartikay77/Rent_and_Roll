/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import Controller.CarController;
import Model.Booking;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Gupta
 */
public class BookingControllerTest {
    private BookingController mockBookingDashboard;

    @Before
    public void setUp() {
        // Mock the database connection
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);

        try {
            when(mockConnection.createStatement()).thenReturn(mockStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create CarOwnerController instance with the mocked connection
        mockBookingDashboard = new BookingController(mockConnection);
        mockBookingDashboard.stmt = (mockStatement);

    }
    
    @Test
    public void testConstructor() {
        // Verify that the connection and statement are not null after construction
        assertNotNull(mockBookingDashboard.connection);
        assertNotNull(mockBookingDashboard.stmt);
    }
    
    @Test
public void testGetAllBookings() {
    // Create a mock ResultSet with sample booking data
    ResultSet mockResultSet = mock(ResultSet.class);
    try {
        when(mockBookingDashboard.stmt.executeQuery("select * from booking")).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false); // Simulate two rows
        when(mockResultSet.getInt("booking_id")).thenReturn(1, 2);
        when(mockResultSet.getString("rent_time")).thenReturn("2023-12-01 10:30:00", "2023-12-01 13:45:00");
        when(mockResultSet.getString("return_time")).thenReturn("2023-12-01 13:45:00", "2024-01-01 12:00:00");
        when(mockResultSet.getInt("customer_id")).thenReturn(1, 2);
        when(mockResultSet.getInt("car_id")).thenReturn(1, 2);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Call the method to get all bookings
    List<Booking> bookings = mockBookingDashboard.getAllBooking();

    // Verify the result
    assertEquals(2, bookings.size()); // Assuming two rows were returned

    // Verify details of the first booking
    assertEquals(1, bookings.get(0).bookingId());
    assertEquals("2023-12-01 10:30:00", bookings.get(0).getRentalStartTime());
    assertEquals("2023-12-01 13:45:00", bookings.get(0).getRentalReturnTime());
    assertEquals(1, bookings.get(0).getCustomerId());
    assertEquals(1, bookings.get(0).carId());
    assertEquals(1, bookings.get(0).getCustomerName());
    assertEquals(1, bookings.get(0).getReg_No());
    

    // Verify details of the second booking
    assertEquals(2, bookings.get(1).bookingId());
    assertEquals("2023-12-01 13:45:00", bookings.get(1).getRentalStartTime());
    assertEquals("2024-01-01 12:00:00", bookings.get(1).getRentalReturnTime());
    assertEquals(2, bookings.get(1).getCustomerId());
    assertEquals(2, bookings.get(1).carId());
    assertEquals(2, bookings.get(1).getCustomerName());
    assertEquals(1, bookings.get(0).getReg_No());

    // Print details of all bookings
    for (Booking booking : bookings) {
        System.out.println("Booking ID: " + booking.bookingId());
        System.out.println("Rent Time: " + booking.getRentalStartTime());
        System.out.println("Return Time: " + booking.getRentalReturnTime());
        System.out.println("Customer ID: " + booking.getCustomerId());
        System.out.println("Car ID: " + booking.carId());
        System.out.println("Customer Name: " + booking.getCustomerName());
        System.out.println("Car Registration Number: " + booking.getReg_No());
        System.out.println("-------------------------");
    }
}

    
    @Test
    public void testGetBookingByCustomerId() {
        try {
           // Create a mock ResultSet with sample data for getCarById
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false); // Simulate one row
        when(mockResultSet.getInt("booking_id")).thenReturn(1);
        when(mockResultSet.getLong("rent_time")).thenReturn(123456789L);
        when(mockResultSet.getLong("return_time")).thenReturn(987654321L);
        when(mockResultSet.getInt("customer_id")).thenReturn(123);
        when(mockResultSet.getInt("car_id")).thenReturn(456);
        when(mockResultSet.getString("car_name")).thenReturn("TestCar");

        // Create a BookingController object using a mock connection
        BookingController mockBookingController = new BookingController(mockConnection);

        // Call the method to get a booking by customer ID
        Booking booking = mockBookingController.getBookingByCustomerId(123);

        // Verify the result
        assertNotNull(booking);
        assertEquals(1, booking.bookingId());
        assertEquals(123456789L, booking.getRentalStartTime());
        assertEquals(987654321L, booking.getRentalReturnTime());
        assertEquals(123, booking.getCustomerId());
        assertEquals(456, booking.carId());
        assertEquals("TestCar", booking.getCarName());
    } catch (Exception e) {
        e.printStackTrace();
    }
    }


    
    
    @Test
    public void testRemoveBookingFailure() throws SQLException {
        // Mock the behavior for executeUpdate to simulate failure
        when(mockBookingDashboard.stmt.executeUpdate("delete from booking where booking_id=2;")).thenThrow(new SQLException());

        // Call the method to remove a Car
        boolean removalResult = mockBookingDashboard.removeBooking(2);

        // Verify the result
        assertFalse(removalResult);
    }
    
    @Test
    public void testRemoveBooking() throws SQLException {
        // Mock the behavior for executeUpdate
        when(mockBookingDashboard.stmt.executeUpdate("delete from booking where booking_id=1;")).thenReturn(1);

        // Call the method to remove a Car
        boolean removalResult = mockBookingDashboard.removeBooking(1);

        // Verify the result
        assertTrue(removalResult);
    }
    @Test
    public void testAddBookingWithSQLException() throws SQLException {
        // Mock the necessary objects
        Connection connectionMock = mock(Connection.class);
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(connectionMock.prepareStatement("insert into booking (rent_time, return_time,customer_id,car_id)values (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenThrow(new SQLException("Mocked SQL exception"));
        when(preparedStatementMock.getGeneratedKeys()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);
        when(resultSetMock.getInt(1)).thenReturn(123); // Mock the generated car_car ID

        // Create an instance of carCarController with the mocked Connection
        BookingController bookingController = new BookingController(connectionMock);
        Timestamp rentTime = Timestamp.valueOf("2023-12-01 10:30:00");
        Timestamp returnTime = Timestamp.valueOf("2023-12-01 10:30:00");
        // Test the addCar method
        int generatedBookingId = bookingController.addBooking(rentTime, returnTime, 2, 4);


        // Verify that the catch block is executed and the expected car Car ID is returned
        assertEquals(-999, generatedBookingId);
    }
    
    @Test
    public void testGetBookingByCustomerIdWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from booking where booking_id=1;"))
                .thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of CarController with the mocked Statement
        BookingController bookingController = new BookingController();
     

        // Test the getCarByName method
        Booking booking = bookingController.getBookingByCustomerId(1);

        // Verify that the catch block is executed and the returned list is empty
        assertEquals(0, booking);
    }
    
    @Test
    public void testGetCarByRegNoWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from car where car_id=123;"))
                .thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of Controller with the mocked Statement
        BookingController bookingController = new BookingController();

        // Test the getCarById method
        Booking booking = bookingController.getBookingByCarRegNo("MO99EK1141");

        // Verify that the catch block is executed and the returned car is null
//        assertEquals(0.0, car.setCarRegNo(), 0.01);
    }
    
    @Test
    public void testGetAllBookingWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from booking")).thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of carController with the mocked Statement
        BookingController bookingController = new BookingController();

        // Test the getAllcar method
        List<Booking> bookings = bookingController.getAllBooking();

        // Verify that the catch block is executed, and the returned list is empty
        assertTrue(bookings.isEmpty());
    }

    
}
