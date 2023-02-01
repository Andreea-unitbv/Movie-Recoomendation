package com.example.demo;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Login extends Application {

    public static Stage stg1;

    public Login() {
        stg1 = stage;
        System.out.println("Im here.");
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("LoginPage.fxml"));
        Parent root =  fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

//    @Override
//    public void start(Stage stage) throws IOException {
//        stg1 = stage;
//        System.out.println("Im here.");
//        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("LoginPage.fxml"));
//        Parent root =  fxmlLoader.load();
//        Scene scene = new Scene(root);
//        stage.setTitle("Login");
//        stage.setScene(scene);
//        stage.show();
//    }

    public void changeScene(String fxml) throws IOException{
        var loadPane = getClass().getResource(fxml);
        if (loadPane != null) {
            Parent pane = FXMLLoader.load(loadPane);
            var scene = stg1.getScene();
            scene.setRoot(pane);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
