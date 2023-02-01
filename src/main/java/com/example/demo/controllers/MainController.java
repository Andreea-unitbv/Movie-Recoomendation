package com.example.demo.controllers;

import com.example.demo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainController {
    @FXML
    private Button loginButton;
    public void StartLogin(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("LoginPage.fxml");
    }
}
