package com.example.demo.controllers;

import com.example.demo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    @FXML
    public void showLoginScreen(ActionEvent event) throws IOException {
        var loginScene = Main.getSceneByName("LoginPage.fxml");
        Main.setScene(loginScene);
    }

    @FXML
    public void showRegisterScreen(ActionEvent event) throws IOException {
        var registerScene = Main.getSceneByName("RegisterPage.fxml");
        Main.setScene(registerScene);
    }
}
