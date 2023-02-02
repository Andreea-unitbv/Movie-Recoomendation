package com.example.demo.database;
import java.util.Scanner;


public class DBRegister {
    private DBConnection database;
    private Scanner scanner;

    public DBRegister() {
        database = new DBConnection();
        scanner = new Scanner(System.in);
    }

    public boolean run(String username, String role, String password) {
        // Insert the new user into the database
        int result = database.executeUpdate("INSERT INTO app_user (username, role, password) VALUES " +
                "('" + username + "', '" + role + "', '" + password + "')");
        if (result == 1) {
            System.out.println("Registration successful!");
            return true;
        } else {
            System.out.println("Registration failed. Try again later.");
        }
        return false;
    }
}

