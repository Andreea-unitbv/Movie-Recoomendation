package com.example.demo.database;
import com.example.demo.database.DBConnection;
import java.util.Scanner;


public class Register {
    private DBConnection database;
    private Scanner scanner;

    public Register() {
        database = new DBConnection();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Insert the new user into the database
        int result = database.executeUpdate("INSERT INTO app_user (username, role, password) VALUES " +
                "('" + username + "', '" + role + "', '" + password + "')");
        if (result == 1) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Try again later.");
        }
    }
}

