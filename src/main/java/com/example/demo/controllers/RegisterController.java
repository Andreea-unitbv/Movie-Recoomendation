package com.example.demo.controllers;


import com.example.demo.Main;
import com.example.demo.database.DBLogin;
import com.example.demo.database.DBRegister;
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

public class RegisterController implements Initializable {
    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private TextField usernameTextField, passwordTextField;
    @FXML
    private Button registerButton, exitButton;
    @FXML
    private Label validation;
    private DBRegister dbRegister;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleComboBox.setItems(FXCollections.observableArrayList("admin", "user"));
        roleComboBox.getSelectionModel().select("admin");
        System.out.println("Initialized Register..");
    }

    public void ExitPressed(ActionEvent event) throws IOException {
        var feedScene = Main.getSceneByName("hello-view.fxml");
        Main.setScene(feedScene);
    }

    public void registerPressed(ActionEvent event) throws IOException {
        var registerSuccessful = checkRegister();
        if (registerSuccessful) {
            var feedScene = Main.getSceneByName("LoginPage.fxml");
            Main.setScene(feedScene);
        }
    }

    public boolean checkRegister() throws IOException {
        String username = usernameTextField.getText().toString();
        String password = passwordTextField.getText().toString();
        String role = roleComboBox.getValue().toString();

        dbRegister = new DBRegister();

        if (dbRegister.run(username, role, password)) {
            return true;
        } else {
            validation.setText("Invalid username or password");
            return false;
        }
    }
}
