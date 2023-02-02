package com.example.demo.controllers;

import com.example.demo.Main;
import com.example.demo.database.DBLogin;
import com.example.demo.database.DBMovie;
import com.example.demo.database.DBRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class AddMovieController {

    @FXML
    private Button exitButton, addMovieButton;
    @FXML
    private TextField titleBox, genreBox, directorBox, studioBox;
    @FXML
    private DatePicker dateBox;
    @FXML
    private Label validation;
    private DBMovie dbMovie;

    public void initialize() {
        LocalDate defaultDate = LocalDate.now();
        dateBox.setValue(defaultDate);
    }

    public void ExitPressed(ActionEvent event) throws IOException {
        var feedScene = Main.getSceneByName("hello-view.fxml");
        Main.setScene(feedScene);
    }

    public void AddMoviePressed(ActionEvent event) throws IOException {
        var addMovieSuccessful = checkMovie();
        if (addMovieSuccessful) {
            validation.setTextFill(Color.GREEN);
            validation.setText("Movie successfully added!");
            titleBox.setText("");
            genreBox.setText("");
            directorBox.setText("");
            studioBox.setText("");
        } else {
            validation.setTextFill(Color.RED);
            validation.setText("Try again!");
        }
    }

    public boolean checkMovie() throws IOException {
        String title = titleBox.getText().toString();
        String genre = genreBox.getText().toString();
        String director = directorBox.getText().toString();
        String studio = studioBox.getText().toString();
        Date date = Date.valueOf(dateBox.getValue());

        if (!titleBox.getText().isEmpty()&& !genreBox.getText().isEmpty()
                && !directorBox.getText().isEmpty() && !studioBox.getText().isEmpty()) {

            dbMovie = new DBMovie();

            if (dbMovie.run(title, genre, director, studio, date)) {
                return true;
            }
        }
        return false;
    }
}




