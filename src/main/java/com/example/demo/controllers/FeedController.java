package com.example.demo.controllers;

import com.example.demo.Query;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.example.demo.Movie;
import com.example.demo.database.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FeedController  {
    @FXML
    private ListView<Movie> listView;
    private DB db;
    private ObservableList<Movie> movies = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        loadMovies();
        listView.setItems(movies);
        listView.setCellFactory(listView -> new ListCell<Movie>() {

            @Override
            protected void updateItem(Movie movie, boolean empty) {
                super.updateItem(movie, empty);

                if (empty || movie == null) {
                    setText(null);
                    setGraphic(null);
                } else {

                    Label titleLabel = new Label(movie.getTitle());
                    Label genreLabel =new Label((movie.getGenre()));
                    Button likeButton=new Button("Like");
                    likeButton.setOnAction(event -> movie.Like());
                    HBox hBox = new HBox(titleLabel, genreLabel, likeButton, movie.getLikeLabel());
                    hBox.setSpacing(10);

                    setGraphic(hBox);
                }
            }
        });
    }

    private void loadMovies() {
        try (Connection connection = db.getDb().getConnection();
             Statement statement = db.getDb().getStatement();

             ResultSet resultSet = statement.executeQuery(Query.getSelectMovie("4"))) {
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                //TODO: fix button
                //TODO:adjust layout
                //TODO: fisiere
                //TODO: adauga date in baza de date
                Integer likes=0;
                Label likeLabel=new Label(likes.toString());
                movies.add(new Movie(title,genre,likes,likeLabel));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

