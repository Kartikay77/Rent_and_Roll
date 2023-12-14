/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.CarOwnerController;
import utilities.DatabaseConnector;
import Model.CarOwner;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
public class CarOwnerControllerTest {
    private CarOwnerController mockCarOwnerDashboard;

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
        mockCarOwnerDashboard = new CarOwnerController(mockConnection);
        mockCarOwnerDashboard.stmt = (mockStatement);

    }
    
    @Test
    public void testConstructor() {
        try {
            // Create an instance of CustomerController
            CarOwnerController carownerController = new CarOwnerController();

            // Access private fields if needed (not recommended in general, but may be necessary for some tests)
            Connection connection = carownerController.getConnection();
            Statement statement = carownerController.getStatement();

            // Check if the connection and statement are not null
            assertNotNull("Connection should not be null", connection);
            assertNotNull("Statement should not be null", statement);

            // Additional assertions or verifications can be added as needed

        } catch (Exception e) {
            // Fail the test if an exception is thrown during the constructor
            fail("Exception occurred: " + e.getMessage());
        }
    }
    
    @Test
    public void testConstructor2() {
        try {
            // Mock the DatabaseConnector
            DatabaseConnector databaseConnectorMock = mock(DatabaseConnector.class);
            Connection connectionMock = mock(Connection.class);
            Statement statementMock = mock(Statement.class);

            // Mock the behavior of DatabaseConnector
            when(databaseConnectorMock.getConnection()).thenReturn(connectionMock);
            when(connectionMock.createStatement()).thenReturn(statementMock);

            // Create an instance of CustomerController without passing DatabaseConnector
            CarOwnerController carownerController = new CarOwnerController();
            
            // Set the DatabaseConnector using a setter method or constructor injection
            carownerController.setDatabaseConnector(databaseConnectorMock);

            // Access private fields if needed (not recommended in general, but may be necessary for some tests)
            Connection connection = carownerController.getConnection();
            Statement statement = carownerController.getStatement();

            // Verify that the mocked connection and statement are not null
            assertNotNull("Connection should not be null", connection);
            assertNotNull("Statement should not be null", statement);

            // Additional assertions or verifications can be added as needed

        } catch (SQLException e) {
            // Fail the test if an unexpected SQLException occurs
            fail("Unexpected SQLException occurred: " + e.getMessage());
        }
    }
    
    @Test
    public void testConstructorWithException() {
        try {
            // Mock the DatabaseConnector to throw SQLException
            DatabaseConnector databaseConnectorMock = mock(DatabaseConnector.class);
            when(databaseConnectorMock.getConnection()).thenThrow(new SQLException("Mocked exception"));

            // Create an instance of CustomerController with the mocked DatabaseConnector
//            CustomerController customerController = new CustomerController(databaseConnectorMock);
            // Create an instance of CustomerController without passing DatabaseConnector
            CarOwnerController carownerController = new CarOwnerController();
            
            // Set the DatabaseConnector using a setter method or constructor injection
            carownerController.setDatabaseConnector(databaseConnectorMock);

            // Access private fields if needed (not recommended in general, but may be necessary for some tests)
            Connection connection = carownerController.getConnection();
            Statement statement = carownerController.getStatement();

            // If no exception is thrown, fail the test
            fail("Expected SQLException, but no exception was thrown");

        } catch (SQLException e) {
            // Verify that the expected exception is thrown
            System.out.println("Caught expected exception: " + e.getMessage());
            // Additional assertions or verifications can be added as needed
        }
    }
    
    
    
    @Test
    public void testGetAllOwners() {
        
        ResultSet mockResultSet = mock(ResultSet.class);
        try {
            when(mockCarOwnerDashboard.stmt.executeQuery("select * from car_owner")).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, true, false); // Simulate two rows
            when(mockResultSet.getInt("owner_id")).thenReturn(1, 2);
            when(mockResultSet.getString("owner_name")).thenReturn("Owner1", "Owner2");
            when(mockResultSet.getString("contact_no")).thenReturn("1357908642", "2468097531");
            when(mockResultSet.getFloat("balance")).thenReturn(100.0f, 200.0f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        List<CarOwner> car_owners = mockCarOwnerDashboard.getAllOwners();

        // Verify the result
        assertEquals(2, car_owners.size()); // Assuming two rows were returned
        assertEquals(1, car_owners.get(0).getOwnerId());
        assertEquals("Owner1", car_owners.get(0).getOwnerName());
        assertEquals("1357908642", car_owners.get(0).getPhoneNo());
        assertEquals(100.0f, car_owners.get(0).getBalanceDue(), 0.001);

        assertEquals(2, car_owners.get(1).getOwnerId());
        assertEquals("Owner2", car_owners.get(1).getOwnerName());
        assertEquals("2468097531", car_owners.get(1).getPhoneNo());
        assertEquals(200.0f, car_owners.get(1).getBalanceDue(), 0.001);
    }
    
    @Test
    public void testGetOwnerById() {
        
        // Create a mock ResultSet with sample data for getOwnerById
        ResultSet mockResultSet = mock(ResultSet.class);
        try {
            when(mockCarOwnerDashboard.stmt.executeQuery("select * from car_owner where owner_id=1;")).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, false); // Simulate one row
            when(mockResultSet.getInt("owner_id")).thenReturn(1);
            when(mockResultSet.getString("owner_name")).thenReturn("TestOwner");
            when(mockResultSet.getString("contact_no")).thenReturn("1357908642");
            when(mockResultSet.getFloat("balance")).thenReturn(100.0f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Call the method to get a Owner by id
        CarOwner carOwner = mockCarOwnerDashboard.getOwnerById(1);

        // Verify the result
        assertEquals(1, carOwner.getOwnerId());
        assertEquals("TestOwner", carOwner.getOwnerName());
        assertEquals("1357908642", carOwner.getPhoneNo());
        assertEquals(100.0f, carOwner.getBalanceDue(), 0.001);
    }
    
    @Test
    public void testGetOwnersByName() {
        
        ResultSet mockResultSet = mock(ResultSet.class);
        try {
            when(mockCarOwnerDashboard.stmt.executeQuery("select * from car_owner where owner_name=\"TestOwner\";"))
                    .thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, false); // Simulate one row
            when(mockResultSet.getInt("owner_id")).thenReturn(1);
            when(mockResultSet.getString("owner_name")).thenReturn("TestOwner");
            when(mockResultSet.getString("contact_no")).thenReturn("1357908642");
            when(mockResultSet.getFloat("balance")).thenReturn(100.0f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Call the method to get owner by name
        List<CarOwner> carOwners = mockCarOwnerDashboard.getOwnersByName("TestOwner");

        // Verify the result
        assertEquals(1, carOwners.size());
        assertEquals(1, carOwners.get(0).getOwnerId());
        assertEquals("TestOwner", carOwners.get(0).getOwnerName());
        assertEquals("1357908642", carOwners.get(0).getPhoneNo());
        assertEquals(100.0f, carOwners.get(0).getBalanceDue(), 0.001);
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
    public void testRemoveOwnerFailure() throws SQLException {
        // Mock the behavior for executeUpdate to simulate failure
        when(mockCarOwnerDashboard.stmt.executeUpdate("delete from car_owner where owner_id=2;")).thenThrow(new SQLException());

        // Call the method to remove a Car Owner
        boolean removalResult = mockCarOwnerDashboard.removeOwner(2);

        // Verify the result
        assertFalse(removalResult);
    }
    
    @Test
    public void testRemoveOwner() throws SQLException {
        // Mock the behavior for executeUpdate
        when(mockCarOwnerDashboard.stmt.executeUpdate("delete from car_owner where owner_id=1;")).thenReturn(1);

        // Call the method to remove a Car Owner
        boolean removalResult = mockCarOwnerDashboard.removeOwner(1);

        // Verify the result
        assertTrue(removalResult);
    }
    
    @Test
    public void testClearBalance() throws SQLException {
        // Mock the behavior for executeUpdate
        when(mockCarOwnerDashboard.stmt.executeUpdate("UPDATE car_owner SET bill = 0 WHERE owner_id = 1;")).thenReturn(1);

        // Call the method to clear balance
        boolean clearBalanceResult = mockCarOwnerDashboard.clearBalance(1);

        // Verify the result
        assertTrue(clearBalanceResult);
    }
    
    @Test
    public void testClearBalanceFailure() throws SQLException {
        // Mock the behavior for executeUpdate to simulate failure
        when(mockCarOwnerDashboard.stmt.executeUpdate("UPDATE car_owner SET balance = 0 WHERE owner_id = 2;"))
                .thenThrow(new SQLException());

        // Call the method to clear balance
        boolean clearBalanceResult = mockCarOwnerDashboard.clearBalance(2);

        // Verify the result
        assertFalse(clearBalanceResult);
    }
    
    @Test
    public void testAddCarOwnerWithSQLException() throws SQLException {
        // Mock the necessary objects
        Connection connectionMock = mock(Connection.class);
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(connectionMock.prepareStatement("insert into car_owner (owner_name, contact_no, balance) values (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenThrow(new SQLException("Mocked SQL exception"));
        when(preparedStatementMock.getGeneratedKeys()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);
        when(resultSetMock.getInt(1)).thenReturn(123); // Mock the generated car_owner ID

        // Create an instance of carownerController with the mocked Connection
        CarOwnerController carownerController = new CarOwnerController(connectionMock);

        // Test the addOwner method
        int generatedOwnerId = carownerController.addOwner("John Doe", "1234567890", 1000.0);

        // Verify that the catch block is executed and the expected customer ID is returned
        assertEquals(-999, generatedOwnerId);
    }
    
    @Test
    public void testGetOwnersByNameWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from customer where owner_name=\"John Doe\";"))
                .thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of OwnerController with the mocked Statement
        CarOwnerController carownerController = new CarOwnerController();
        carownerController.setStatement(statementMock); 

        // Test the getOwnerByName method
        List<CarOwner> car_owner = carownerController.getOwnersByName("John Doe");

        // Verify that the catch block is executed and the returned list is empty
        assertEquals(0, car_owner.size());
    }
    
    @Test
    public void testGetOwnersByIdWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from car_owner where owner_id=123;"))
                .thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of Controller with the mocked Statement
        CarOwnerController carownerController = new CarOwnerController();
        carownerController.setStatement(statementMock); // Assume there's a setter for Statement

        // Test the getOwnerById method
        CarOwner carOwner = carownerController.getOwnerById(123);

        // Verify that the catch block is executed and the returned owner is null
//        assertEquals(0.0, carOwner.setBalanceDue(), 0.01);
    }
    
    @Test
    public void testGetAllCustomersWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from customer")).thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of CustomerController with the mocked Statement
        CarOwnerController carownerController = new CarOwnerController();
        carownerController.setStatement(statementMock); // Assume there's a setter for Statement

        // Test the getAllCustomers method
        List<CarOwner> carOwners = carownerController.getAllOwners();

        // Verify that the catch block is executed, and the returned list is empty
        assertTrue(carOwners.isEmpty());
    }

    
}
