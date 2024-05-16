package org.example.musicplayer_phase2.View.Informations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.controller.NecessaryMethods;

public class PlaylistInformation extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlistInformation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        NecessaryMethods.putStyleSheet(scene);
        stage.setTitle("your playlist");
        stage.setScene(scene);
        stage.show();
    }
}
