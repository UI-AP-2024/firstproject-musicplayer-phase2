package org.example.musicplayer_phase2.View.Signingup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;

public class PodcasterAndSingerSignup extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("podcasterSingerSignup.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 400);

//        scene.getStylesheets().add(getClass().getResource("myCss.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("signup page");
        stage.show();
    }
}
