package com.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTableExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/imdb";
        String user = "postgres";
        String password = "amplanslaDaneza2.";
        //String createTableSQL = "CREATE TABLE app_user (id SERIAL PRIMARY KEY, username VARCHAR(50), role VARCHAR(50),password VARCHAR(50))";
        String insertRowSQL = "INSERT INTO app_user (username, role, password) VALUES ('Mihai','admin','1234')";
        //"INSERT INTO employees (name, age) VALUES (?, ?)"

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(createTableSQL);
//            System.out.println("Table created successfully");

            try (var insertStatement = connection.createStatement()) {
//                insertStatement.setString(1, "Andreea");
//                insertStatement.setInt(2, 20);
                insertStatement.executeUpdate(insertRowSQL);
                System.out.println("Row inserted successfully");
            } catch (SQLException e) {
                System.out.println("Error while inserting row: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error while creating table: " + e.getMessage());
        }
    }
}
