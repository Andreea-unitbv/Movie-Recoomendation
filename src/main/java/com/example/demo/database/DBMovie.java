package com.example.demo.database;

import javafx.collections.FXCollections;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DBMovie {
    private  DBConnection database;

    public  DBMovie() {
        database = DB.getDb();
    }

    public boolean run(String title,
                       String genre,
                       String director,
                       String studio,
                       Date releaseDate) {

        // Insert the new movie into the database
        int result = database.executeUpdate("INSERT INTO movie (title, genre, director,studio,release_date) VALUES " +
                "('" + title + "', '" + genre + "', '" + director + "','" + studio + "','" + releaseDate + "')");
        if (result == 1) {
            System.out.println("Insert successful!");
            return true;
        } else {
            System.out.println("Insert failed. Try again later.");
        }
        return false;
    }
}
