package com.example.demo.database;

import java.sql.ResultSet;
import java.util.Scanner;

public class DBLogin {
    private  DBConnection database;
    private  Scanner scanner;

    public DBLogin() {
        database = new DBConnection();
        scanner = new Scanner(System.in);
    }

    public boolean run(String username,String password, String role) {

        // Check if the username and password match a record in the database
        ResultSet resultSet = database.executeQuery("SELECT * FROM app_user WHERE username = '" + username + "' AND password = '" + password + "' AND role = '" + role + "'");
        try {
            if (resultSet.next()) {
                System.out.println("LoginController successful!");
                return true;
            } else {
                System.out.println("LoginController failed. Invalid username or password.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}



