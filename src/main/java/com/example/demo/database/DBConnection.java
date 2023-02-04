package com.example.demo.database;

import java.sql.*;

public class DBConnection {
    private Connection connection;
    private Statement statement;

    public DBConnection() {

        String url = "jdbc:postgresql://localhost:5432/imdb";
        String user = "postgres";
        String password = "amplanslaDaneza2.";

        try {
            connection = DriverManager.getConnection(url, user, password);
            // Establish a connection to the database

            // Create a statement object for executing queries
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to perform SELECT operation
    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Function to perform INSERT, UPDATE, or DELETE operation
    public int executeUpdate(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
