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
    public void showLoginScreen(ActionEvent event) throws IOException {
//        var resource = Main.class.getResource("LoginPage.fxml");
//
//        Parent root = FXMLLoader.load(resource);
//
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.show();

//        var resource = Main.class.getResource("LoginPage.fxml");
//        Parent newRoot = FXMLLoader.load(resource);
//        Scene loginScene = new Scene(newRoot);
        var loginScene = Main.getSceneByName("LoginPage.fxml");
        Main.setScene(loginScene);

//        Stage mainStage = (Stage) loginButton.getScene().getWindow();
//        mainStage.setScene(loginScene);

//        Main m = new Main();
//        m.changeScene("LoginPage.fxml");
    }
}
