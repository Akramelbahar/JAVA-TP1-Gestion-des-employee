package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully!");
            } catch (ClassNotFoundException e) {
                System.err.println("JDBC Driver not found: " + e.getMessage());
                throw new RuntimeException(e);
            } catch (SQLException e) {
                System.err.println("Error connecting to the database: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}