package utilities;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class DatabaseConnectorTest {
	
	@Test
    public void testCloseConnection() {
        Connection connection = null;

        try {
            DatabaseConnector databaseConnector = new DatabaseConnector();
            connection = databaseConnector.getConnection();
            assertNotNull("Connection should not be null", connection);

            // Now close the connection
            DatabaseConnector.closeConnection(connection);

            assertTrue("Connection should be closed", connection.isClosed());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
	
	@Test
    public void testCloseConnectionWithException() throws SQLException {
        Connection connection = mock(Connection.class);
        SQLException simulatedException = new SQLException("Simulated exception");

        // Configure the mocked connection to throw an exception when closed
        doThrow(simulatedException).when(connection).close();

        try {
            // Call the closeConnection method with the mocked connection
            DatabaseConnector.closeConnection(connection);
        } catch (Exception e) {
            // Ensure that the caught exception is the one we simulated
            assertSame(simulatedException, e);
        }

        // Verify that the close method was called on the mocked connection
        verify(connection, times(1)).close();
    }
}
