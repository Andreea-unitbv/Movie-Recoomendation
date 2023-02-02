package com.example.demo.controllers;

import com.example.demo.Main;
import com.example.demo.database.DBLogin;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Label validation;
    private DBLogin dbLogin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleComboBox.setItems(FXCollections.observableArrayList("admin", "user"));
        roleComboBox.getSelectionModel().select("admin");
        System.out.println("Initialized Login..");
    }

    public void loginPressed(ActionEvent event) throws IOException {
        var loginSuccessful = checkLogin();
        if (loginSuccessful && usernameTextField.getText().toString()=="user") {
            var feedScene = Main.getSceneByName("Feed.fxml");
            Main.setScene(feedScene);
        }
        else{
            var addMovieScene= Main.getSceneByName("AddMoviePage.fxml");
            Main.setScene(addMovieScene);
        }
    }

    public boolean checkLogin() throws IOException {
        String username = usernameTextField.getText().toString();
        String password = passwordTextField.getText().toString();
        String role = roleComboBox.getValue().toString();

        dbLogin = new DBLogin();

        if (dbLogin.run(username, password, role)) {
            return true;
        } else {
            validation.setText("Invalid username or password");
            return false;
        }
    }
}
