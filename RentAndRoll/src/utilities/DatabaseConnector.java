/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DatabaseConnector file is a utility file for making database connection.
 */
public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/se";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin123";

    /**
     * Gets connection to database
     * @return connection
     */
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
        return connection;
    }
    
    /**
     * Closes connection to database
     * @param connection
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Unable to close database connection: "+e);
            }
        }
    }
}
