package com.user.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserManagementDBC {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/lms"; // Adjust your DB URL
    private static final String DB_USER = "root"; // Adjust your DB username
    private static final String DB_PASSWORD = "akshat@123"; // Adjust your DB password
    
    // Establishing the database connection
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
