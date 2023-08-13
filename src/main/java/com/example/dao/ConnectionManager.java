package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // .env
    private static final String JBDC_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "gitpod";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JBDC_URL, USERNAME, PASSWORD);
    }
    
}
