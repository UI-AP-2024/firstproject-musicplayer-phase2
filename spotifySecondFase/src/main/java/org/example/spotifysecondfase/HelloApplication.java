package org.example.spotifysecondfase;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.spotifysecondfase.ChangeScene;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       ChangeScene.stage = stage;
//        System.out.println(this.getClass().);
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
////        Home home;
//        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
        ChangeScene.playMusic();

    }

    public static void main(String[] args) {

        launch();
    }
}