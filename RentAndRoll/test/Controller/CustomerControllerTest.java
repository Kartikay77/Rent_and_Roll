/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.CustomerController;
import Model.Customer;
import utilities.DatabaseConnector;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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
 * @author Bora
 */
public class CustomerControllerTest {
    private CustomerController mockCustomerDashboard;

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

        // Create CustomerController instance with the mocked connection
        mockCustomerDashboard = new CustomerController(mockConnection);
        mockCustomerDashboard.stmt = (mockStatement);

    }
    
    
    @Test
    public void testConstructor() {
        try {
            // Create an instance of CustomerController
            CustomerController customerController = new CustomerController();

            // Access private fields if needed (not recommended in general, but may be necessary for some tests)
            Connection connection = customerController.getConnection();
            Statement statement = customerController.getStatement();

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
            CustomerController customerController = new CustomerController();
            
            // Set the DatabaseConnector using a setter method or constructor injection
            customerController.setDatabaseConnector(databaseConnectorMock);

            // Access private fields if needed (not recommended in general, but may be necessary for some tests)
            Connection connection = customerController.getConnection();
            Statement statement = customerController.getStatement();

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
            CustomerController customerController = new CustomerController();
            
            // Set the DatabaseConnector using a setter method or constructor injection
            customerController.setDatabaseConnector(databaseConnectorMock);

            // Access private fields if needed (not recommended in general, but may be necessary for some tests)
            Connection connection = customerController.getConnection();
            Statement statement = customerController.getStatement();

            // If no exception is thrown, fail the test
            fail("Expected SQLException, but no exception was thrown");

        } catch (SQLException e) {
            // Verify that the expected exception is thrown
            System.out.println("Caught expected exception: " + e.getMessage());
            // Additional assertions or verifications can be added as needed
        }
    }

    @Test
    public void testGetAllCustomers() {
        
        ResultSet mockResultSet = mock(ResultSet.class);
        try {
            when(mockCustomerDashboard.stmt.executeQuery("select * from customer")).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, true, false); // Simulate two rows
            when(mockResultSet.getInt("customer_id")).thenReturn(1, 2);
            when(mockResultSet.getString("customer_name")).thenReturn("Customer1", "Customer2");
            when(mockResultSet.getString("contact_no")).thenReturn("1234567890", "9876543210");
            when(mockResultSet.getFloat("bill")).thenReturn(100.0f, 200.0f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        List<Customer> customers = mockCustomerDashboard.getAllCustomers();

        // Verify the result
        assertEquals(2, customers.size()); // Assuming two rows were returned
        assertEquals(1, customers.get(0).getCustomerId());
        assertEquals("Customer1", customers.get(0).getCustomerName());
        assertEquals("1234567890", customers.get(0).getPhoneNo());
        assertEquals(100.0f, customers.get(0).getBillAmount(), 0.001);

        assertEquals(2, customers.get(1).getCustomerId());
        assertEquals("Customer2", customers.get(1).getCustomerName());
        assertEquals("9876543210", customers.get(1).getPhoneNo());
        assertEquals(200.0f, customers.get(1).getBillAmount(), 0.001);
    }
    
    @Test
    public void testGetCustomerById() {
        
        // Create a mock ResultSet with sample data for getCustomerById
        ResultSet mockResultSet = mock(ResultSet.class);
        try {
            when(mockCustomerDashboard.stmt.executeQuery("select * from customer where customer_id=1;")).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, false); // Simulate one row
            when(mockResultSet.getInt("customer_id")).thenReturn(1);
            when(mockResultSet.getString("customer_name")).thenReturn("TestCustomer");
            when(mockResultSet.getString("contact_no")).thenReturn("1234567890");
            when(mockResultSet.getFloat("bill")).thenReturn(100.0f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Call the method to get a customer by id
        Customer customer = mockCustomerDashboard.getCustomerById(1);

        // Verify the result
        assertEquals(1, customer.getCustomerId());
        assertEquals("TestCustomer", customer.getCustomerName());
        assertEquals("1234567890", customer.getPhoneNo());
        assertEquals(100.0f, customer.getBillAmount(), 0.001);
    }
    
    @Test
    public void testGetCustomersByName() {
        
        ResultSet mockResultSet = mock(ResultSet.class);
        try {
            when(mockCustomerDashboard.stmt.executeQuery("select * from customer where customer_name=\"TestCustomer\";"))
                    .thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, false); // Simulate one row
            when(mockResultSet.getInt("customer_id")).thenReturn(1);
            when(mockResultSet.getString("customer_name")).thenReturn("TestCustomer");
            when(mockResultSet.getString("contact_no")).thenReturn("1234567890");
            when(mockResultSet.getFloat("bill")).thenReturn(100.0f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Call the method to get customers by name
        List<Customer> customers = mockCustomerDashboard.getCustomersByName("TestCustomer");

        // Verify the result
        assertEquals(1, customers.size());
        assertEquals(1, customers.get(0).getCustomerId());
        assertEquals("TestCustomer", customers.get(0).getCustomerName());
        assertEquals("1234567890", customers.get(0).getPhoneNo());
        assertEquals(100.0f, customers.get(0).getBillAmount(), 0.001);
    }
    
    @Test
    public void testAddCustomer() throws SQLException {
        // Mock PreparedStatement and ResultSet
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Mock the behavior for executeUpdate
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Mock the behavior for getGeneratedKeys
        when(mockPreparedStatement.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(1);
        
        // Mock the PreparedStatement creation
        when(mockCustomerDashboard.connection.prepareStatement(
                "insert into customer (customer_name, contact_no, bill) values (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)).thenReturn(mockPreparedStatement);

        // Call the method to add a customer
        int generatedCustomerId = mockCustomerDashboard.addCustomer("TestCustomer", "1234567890", 100.0);

        // Verify the result
        assertEquals(1, generatedCustomerId);
    }
    
    @Test
    public void testRemoveCustomerFailure() throws SQLException {
        // Mock the behavior for executeUpdate to simulate failure
        when(mockCustomerDashboard.stmt.executeUpdate("delete from customer where customer_id=2;")).thenThrow(new SQLException());

        // Call the method to remove a customer
        boolean removalResult = mockCustomerDashboard.removeCustomer(2);

        // Verify the result
        assertFalse(removalResult);
    }
    
    @Test
    public void testRemoveCustomer() throws SQLException {
        // Mock the behavior for executeUpdate
        when(mockCustomerDashboard.stmt.executeUpdate("delete from customer where customer_id=1;")).thenReturn(1);

        // Call the method to remove a customer
        boolean removalResult = mockCustomerDashboard.removeCustomer(1);

        // Verify the result
        assertTrue(removalResult);
    }
    
    @Test
    public void testClearBalance() throws SQLException {
        // Mock the behavior for executeUpdate
        when(mockCustomerDashboard.stmt.executeUpdate("UPDATE customer SET bill = 0 WHERE customer_id = 1;")).thenReturn(1);

        // Call the method to clear balance
        boolean clearBalanceResult = mockCustomerDashboard.clearBalance(1);

        // Verify the result
        assertTrue(clearBalanceResult);
    }
    
    @Test
    public void testClearBalanceFailure() throws SQLException {
        // Mock the behavior for executeUpdate to simulate failure
        when(mockCustomerDashboard.stmt.executeUpdate("UPDATE customer SET bill = 0 WHERE customer_id = 2;"))
                .thenThrow(new SQLException());

        // Call the method to clear balance
        boolean clearBalanceResult = mockCustomerDashboard.clearBalance(2);

        // Verify the result
        assertFalse(clearBalanceResult);
    }
    
    @Test
    public void testAddCustomerWithSQLException() throws SQLException {
        // Mock the necessary objects
        Connection connectionMock = mock(Connection.class);
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(connectionMock.prepareStatement("insert into customer (customer_name, contact_no, bill) values (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenThrow(new SQLException("Mocked SQL exception"));
        when(preparedStatementMock.getGeneratedKeys()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);
        when(resultSetMock.getInt(1)).thenReturn(123); // Mock the generated customer ID

        // Create an instance of CustomerController with the mocked Connection
        CustomerController customerController = new CustomerController(connectionMock);

        // Test the addCustomer method
        int generatedCustomerId = customerController.addCustomer("John Doe", "1234567890", 1000.0);

        // Verify that the catch block is executed and the expected customer ID is returned
        assertEquals(-999, generatedCustomerId);
    }
    
    @Test
    public void testGetCustomersByNameWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from customer where customer_name=\"John Doe\";"))
                .thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of CustomerController with the mocked Statement
        CustomerController customerController = new CustomerController();
        customerController.setStatement(statementMock); // Assume there's a setter for Statement

        // Test the getCustomersByName method
        List<Customer> customers = customerController.getCustomersByName("John Doe");

        // Verify that the catch block is executed and the returned list is empty
        assertEquals(0, customers.size());
    }
    
    @Test
    public void testGetCustomerByIdWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from customer where customer_id=123;"))
                .thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of CustomerController with the mocked Statement
        CustomerController customerController = new CustomerController();
        customerController.setStatement(statementMock); // Assume there's a setter for Statement

        // Test the getCustomerById method
        Customer customer = customerController.getCustomerById(123);

        // Verify that the catch block is executed and the returned customer is null
        assertEquals(0.0, customer.getBillAmount(), 0.01);
    }
    
    @Test
    public void testGetAllCustomersWithSQLException() throws SQLException {
        // Mock the necessary objects
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Mock the behavior of the mocked objects
        when(statementMock.executeQuery("select * from customer")).thenThrow(new SQLException("Mocked SQL exception"));

        // Create an instance of CustomerController with the mocked Statement
        CustomerController customerController = new CustomerController();
        customerController.setStatement(statementMock); // Assume there's a setter for Statement

        // Test the getAllCustomers method
        List<Customer> customers = customerController.getAllCustomers();

        // Verify that the catch block is executed, and the returned list is empty
        assertTrue(customers.isEmpty());
    }

    
    
}
