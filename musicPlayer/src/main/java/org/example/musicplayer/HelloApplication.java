package org.example.musicplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    //public static BorderPane mainScene = new BorderPane();
    public static Stage currentstage;

    @Override
    public void start(Stage stage) throws IOException {
        currentstage = stage;
        BorderPane mainScene = new BorderPane();
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("login-and-signIn-bar-view.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("sidebar-view.fxml"));
        mainScene.setTop(fxmlLoader1.load());
        mainScene.setLeft(fxmlLoader2.load());
        Scene scene = new Scene(mainScene, 700, 500);
        stage.setTitle("mohsenify");
        stage.setScene(scene);
        stage.show();
    }

    public static void setMainScene(String path) throws IOException {
        BorderPane borderPane = new BorderPane();
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("login-and-signIn-bar-view.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("sidebar-view.fxml"));
        borderPane.setTop(fxmlLoader1.load());
        borderPane.setLeft(fxmlLoader2.load());
        //mainScene.setBottom();
        borderPane.setCenter(new FXMLLoader(HelloApplication.class.getResource(path)).load());
        Scene scene = new Scene(borderPane, 700, 500);
        currentstage.setTitle("mohsenify");
        currentstage.setScene(scene);
        currentstage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}