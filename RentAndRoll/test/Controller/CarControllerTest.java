/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import Controller.CarController;
import Model.Car;
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
import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Gupta
 */
public class CarControllerTest {
    private CarController mockCarDashboard;

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
        mockCarDashboard = new CarController(mockConnection);
        mockCarDashboard.stmt = (mockStatement);

    }
    
    @Test
    public void testConstructor() {
        // Verify that the connection and statement are not null after construction
        assertNotNull(mockCarDashboard.connection);
        assertNotNull(mockCarDashboard.stmt);
    }
    
    @Test
    public void testGetAllCars() {
        // Create a mock ResultSet with sample car data
        ResultSet mockResultSet = mock(ResultSet.class);
        try {
            when(mockCarDashboard.stmt.executeQuery("select * from car")).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, true, false); // Simulate two rows
            when(mockResultSet.getInt("car_id")).thenReturn(1, 2);
            when(mockResultSet.getString("maker")).thenReturn("maker1", "maker2");
            when(mockResultSet.getString("car_name")).thenReturn("Car1", "Car2");
            when(mockResultSet.getString("color")).thenReturn("color1", "color2");
            when(mockResultSet.getString("car_type")).thenReturn("Type1", "Type2");
            when(mockResultSet.getString("model")).thenReturn("Model1", "Model2");
            when(mockResultSet.getString("reg_no")).thenReturn("reg_no1", "reg_no2");
            when(mockResultSet.getString("car_condition")).thenReturn("condition1", "condition2");
            when(mockResultSet.getInt("seating_capacity")).thenReturn(4, 5);
            when(mockResultSet.getFloat("rent_per_hour")).thenReturn(80.50f, 100.50f);
            when(mockResultSet.getInt("owner_id")).thenReturn(1, 2);
            when(mockResultSet.getString("owner_name")).thenReturn("Owner1", "Owner2");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Call the method to get all cars
        List<Car> cars = mockCarDashboard.getAllCars();

        // Verify the result
        assertEquals(2, cars.size()); // Assuming two rows were returned

        // Verify details of the first car
        assertEquals(1, cars.get(0).carId());
        assertEquals("maker1", cars.get(0).getMakerName());
        assertEquals("Car1", cars.get(0).getCarName());
        assertEquals("color1", cars.get(0).getColor());
        assertEquals("Type1", cars.get(0).getCarType());
        assertEquals("Model1", cars.get(0).getCarModel());
        assertEquals("reg_no1", cars.get(0).getCarRegNo());
        assertEquals("condition1", cars.get(0).getCarCondition());
        assertEquals(4, cars.get(0).getSeatingCapacity());
        assertEquals(80.50f, cars.get(0).getRentPerHour(), 0.01f);
        assertEquals(1, cars.get(0).getCarOwnerId());
        assertEquals("Owner1", cars.get(0).getCarOwnerName());

        // Verify details of the second car
        assertEquals(2, cars.get(1).carId());
        assertEquals("maker2", cars.get(1).getMakerName());
        assertEquals("Car2", cars.get(1).getCarName());
        assertEquals("color2", cars.get(1).getColor());
        assertEquals("Type2", cars.get(1).getCarType());
        assertEquals("Model2", cars.get(1).getCarModel());
        assertEquals("reg_no2", cars.get(1).getCarRegNo());
        assertEquals("condition2", cars.get(1).getCarCondition());
        assertEquals(5, cars.get(1).getSeatingCapacity());
        assertEquals(100.50f, cars.get(1).getRentPerHour(), 0.01f);
        assertEquals(2, cars.get(1).getCarOwnerId());
        assertEquals("Owner2", cars.get(1).getCarOwnerName());
        for (Car car : cars) {
        System.out.println("Car ID: " + car.carId());
        System.out.println("Maker: " + car.getMakerName());
        System.out.println("Car Name: " + car.getCarName());
        System.out.println("Color: " + car.getColor());
        System.out.println("Car Type: " + car.getCarType());
        System.out.println("Model: " + car.getCarModel());
        System.out.println("Registration No.: " + car.getCarRegNo());
        System.out.println("Car Condition: " + car.getCarCondition());
        System.out.println("Seating Capacity: " + car.getSeatingCapacity());
        System.out.println("Rent per Hour: " + car.getRentPerHour());
        System.out.println("Owner ID: " + car.getCarOwnerId());
        System.out.println("Owner Name: " + car.getCarOwnerName());
        System.out.println("-------------------------");
    }
    }
    
    @Test
    public void testGetCarById() {
        try {
           // Create a mock ResultSet with sample data for getCarById
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false); // Simulate one row
        when(mockResultSet.getInt("car_id")).thenReturn(1);
        when(mockResultSet.getString("car_name")).thenReturn("Car1");
        when(mockResultSet.getString("reg_no")).thenReturn("reg_no1");
        when(mockResultSet.getFloat("rent_per_hour")).thenReturn(80.50f);

        // Call the method to get a car by id
        Car car = mockCarDashboard.getCarById("MA99KG1111");
       

        // Verify the result
        assertEquals(3, car.carId());
        assertEquals("Birla", car.getCarName());
        assertEquals("MA99KG1111", car.getCarRegNo());
        assertEquals(150.50f, car.getRentPerHour(), 0.001);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }


    
    @Test
    public void testGetCarsByName() {
        
        ResultSet mockResultSet = mock(ResultSet.class);
        try {
            when(mockCarDashboard.stmt.executeQuery("select * from cars where car_name=\"Car1\";"))
                    .thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, false); // Simulate one row
            when(mockResultSet.getInt("car_id")).thenReturn(1);
            when(mockResultSet.getString("car_name")).thenReturn("Car1");
            when(mockResultSet.getString("reg_no")).thenReturn("reg_no1");
            when(mockResultSet.getFloat("rent_per_hour")).thenReturn(80.50f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Call the method to get car by name
        List<Car> cars = mockCarDashboard.getCarsByName("City");

        // Verify the result
//        assertEquals(1, cars.size());
//        assertEquals(1, cars.get(0).carId());
//        assertEquals("City", cars.get(0).getCarName());
//        assertEquals("MA15KL9999", cars.get(0).getCarRegNo());
//        assertEquals(100.0f, cars.get(0).getRentPerHour(), 0.001);
    }
    
//    @Test
//    public void testAddOwner() throws SQLException {
//        // Mock PreparedStatement and ResultSet
//        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
//        ResultSet mockResultSet = mock(ResultSet.class);
//
//        // Mock the behavior for executeUpdate
//        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
//
//        // Mock the behavior for getGeneratedKeys
//        when(mockPreparedStatement.getGeneratedKeys()).thenReturn(mockResultSet);
//        when(mockResultSet.next()).thenReturn(true);
//        when(mockResultSet.getInt(1)).thenReturn(1);
//        
//        // Mock the PreparedStatement creation
//        when(mockCarOwnerDashboard.connection.prepareStatement(
//                "insert into car_owner (owner_name, contact_no, balance) values (?, ?, ?)",
//                Statement.RETURN_GENERATED_KEYS)).thenReturn(mockPreparedStatement);
//        
//        // Call the method to add a Owner
//        int generatedOwnerId = mockCarOwnerDashboard.addOwner("karim lala", "1357908642", 100.0);
//
//        // Verify the result
//        assertEquals(1, generatedOwnerId);
//    }
    
    @Test
    public void testRemoveCarFailure() throws SQLException {
        // Mock the behavior for executeUpdate to simulate failure
        when(mockCarDashboard.stmt.executeUpdate("delete from car where car_id=2;")).thenThrow(new SQLException());

        // Call the method to remove a Car
        boolean removalResult = mockCarDashboard.removeCar(2);

        // Verify the result
        assertFalse(removalResult);
    }
    
    @Test
    public void testRemoveCar() throws SQLException {
        // Mock the behavior for executeUpdate
        when(mockCarDashboard.stmt.executeUpdate("delete from cars where car_id=1;")).thenReturn(1);

        // Call the method to remove a Car
        boolean removalResult = mockCarDashboard.removeCar(1);

        // Verify the result
        assertTrue(removalResult);
    }
    @Test
    public void testAddCarWithSQLException() throws SQLException {
        // Mock the necessary objects
        Connection connectionMock = mock(Connection.class);
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(connectionMock.prepareStatement("insert into car (maker, car_name, color,car_type,model,reg_no,car_condition,seating_capacity,rent_per_hour,owner_id) values (?,?,?,?,?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenThrow(new SQLException("Mocked SQL exception"));
        when(preparedStatementMock.getGeneratedKeys()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);
        when(resultSetMock.getInt(1)).thenReturn(123); // Mock the generated car_car ID

        // Create an instance of carCarController with the mocked Connection
        CarController carController = new CarController(connectionMock);

        // Test the addCar method
        int generatedCarId = carController.addCar("General Motors (GM)", "BMW 5 Series","Black","Hatchback","small","AP97KG1313","Excellent",2,470.50,4);

        // Verify that the catch block is executed and the expected car Car ID is returned
        assertEquals(-999, generatedCarId);
    }
    
    @Test
    public void testGetCarByNameWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from car where car_name=\"John Doe\";"))
                .thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of CarController with the mocked Statement
        CarController carController = new CarController();
        carController.setStatement(statementMock); 

        // Test the getCarByName method
        List<Car> car = carController.getCarsByName("Chevrolet");

        // Verify that the catch block is executed and the returned list is empty
        assertEquals(0, car.size());
    }
    
    @Test
    public void testGetCarByIdWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from car where car_id=123;"))
                .thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of Controller with the mocked Statement
        CarController carController = new CarController();
        carController.setStatement(statementMock); // Assume there's a setter for Statement

        // Test the getCarById method
        Car car = carController.getCarById("MO99EK1141");

        // Verify that the catch block is executed and the returned car is null
//        assertEquals(0.0, car.setCarRegNo(), 0.01);
    }
    
    @Test
    public void testGetAllCarWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from car")).thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of carController with the mocked Statement
        CarController carController = new CarController();
        carController.setStatement(statementMock); // Assume there's a setter for Statement

        // Test the getAllcar method
        List<Car> car = carController.getAllCars();

        // Verify that the catch block is executed, and the returned list is empty
        assertTrue(car.isEmpty());
    }

    
}
