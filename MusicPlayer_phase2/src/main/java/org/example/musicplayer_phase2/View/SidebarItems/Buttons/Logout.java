package org.example.musicplayer_phase2.View.SidebarItems.Buttons;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Informations.PlayMusicPage;
import org.example.musicplayer_phase2.View.Start;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic;
import org.example.musicplayer_phase2.controller.UserAccountController;

import java.io.IOException;

import static org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic.getMediaPlayer;
import static org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic.stopPlaying;

public class Logout extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        makeEverybodyNull();
        new Start().start(stage);
    }

    public static void makeEverybodyNull(){
        UserAccountController.listener = null;
        UserAccountController.singer = null;
        UserAccountController.podcaster = null;
        HelloApplication.lastScenes.removeAll(HelloApplication.lastScenes);
        if (getMediaPlayer() != null) {
            if (getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                stopPlaying();
                PlayMusic.audio = null;
            }
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
            Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
            AboutStyleSheet.putStyleSheet(scene);
            HelloApplication.lastScenes.add(scene);
            HelloApplication.lastTitle = "welcome :)";
        } catch (IOException e) {
            Alerts.errorAlert();
        }
        finally {
            Alerts.goodDayAlert();
        }
    }
}