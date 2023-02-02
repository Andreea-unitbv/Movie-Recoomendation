package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static Stage mainStage;
    private static Scene mainScene;
    @Override
    public void start(Stage stage) throws IOException {
        this.mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        mainScene = new Scene(root);
        stage.setTitle("IMDb");
        stage.setScene(mainScene);

        stage.show();
    }

    public static Scene getSceneByName(String sceneName) throws IOException {
        var resource = Main.class.getResource(sceneName);
        Parent newRoot = FXMLLoader.load(resource);
        Scene newScene = new Scene(newRoot);
        return newScene;
    }

    public static void setScene(Scene scene) {
        mainStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }


}