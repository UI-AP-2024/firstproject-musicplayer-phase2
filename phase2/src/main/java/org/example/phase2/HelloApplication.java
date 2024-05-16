package org.example.phase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.phase2.Model.Audios.Audio;
import org.example.phase2.Model.Audios.Genre;
import org.example.phase2.Model.Audios.Music;
import org.example.phase2.Model.Database.Database;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HomeLoggedOut.setStage(stage);
        SignupController.setStage(stage);
        LoginController.setStage(stage);
        favoriteGenresController.setStage(stage);
        AccountInfoController.setStage(stage);
        ShowAudiosController.setStage(stage);
        CreateNewPlaylistController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowAudios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Music music=new Music("musicName","musicArtist", Genre.COUNTRY,"Link","cover","lyric");
        Music music2=new Music("musicName","musicArtist", Genre.COUNTRY,"Link","cover","lyric");
        Database.getDatabase().getAudios().add(music);
        Database.getDatabase().getAudios().add(music2);
        launch();
    }
}