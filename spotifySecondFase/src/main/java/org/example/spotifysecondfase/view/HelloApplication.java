package org.example.spotifysecondfase.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       ChangeScene.stage = stage;
       ChangeScene.home();
    }

    public static void main(String[] args) {
        launch();
    }
}