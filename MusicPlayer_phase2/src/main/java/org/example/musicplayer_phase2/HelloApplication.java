package org.example.musicplayer_phase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.SidebarItems.AllArtists;
import org.example.musicplayer_phase2.View.SidebarItems.Audios;
import org.example.musicplayer_phase2.View.Start;
import org.example.musicplayer_phase2.model.AboutHumans.Admin;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Music;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;

import static org.example.musicplayer_phase2.model.AboutHumans.Admin.getAdmin;


public class HelloApplication extends Application {

    public static Stack<Scene> lastScenes = new Stack<>();
    public static String lastTitle;
    @Override
    public void start(Stage stage) {
        Start start = new Start();
        try {
            start.start(stage);
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    public static final Admin admin = getAdmin("Fatemeh" , "fatemeh" , "1234!@#$" , "fatemefahimpoour1399@gmail.com" , "09131111111" , LocalDate.of(2005 , 12 ,12));
    public static void main(String[] args) throws IOException {
        Audio audio1 = new Music("first" , "" , "" , "POP" , "" , "" , "");
        Audio audio2 = new Music("abc" , "" , "" , "POP" , "" , "" , "");
        Audio audio3 = new Music("first" , "" , "" , "HIPHOP" , "" , "" , "");
        Audio audio4 = new Music("mmm" , "" , "" , "COUNTRY" , "" , "" , "");
        Audio audio5 = new Music("g" , "" , "" , "POP" , "" , "" , "");
        Audio audio6 = new Music("eeee" , "" , "" , "ROCK" , "" , "" , "");
        audio3.setLikesNum(100);
        audio5.setLikesNum(500);

        Artist artist1 = new Artist("fatemeh" , "first" , "" , " " , "" , LocalDate.now() , "");
        Artist artist12 = new Artist("fatemeh" , "ftm" , "" , " " , "" , LocalDate.now() , "");
        Artist artist3 = new Artist("fatemeh" , "ftm" , "" , " " , "" , LocalDate.now() , "");
        Artist artist4 = new Artist("fatemeh" , "ftm" , "" , " " , "" , LocalDate.now() , "");
        Artist artist5 = new Artist("fatemeh" , "ftm" , "" , " " , "" , LocalDate.now() , "");
        Artist artist6 = new Artist("fatemeh" , "ftm" , "" , " " , "" , LocalDate.now() , "");
        Artist artist7 = new Artist("fatemeh" , "ftm" , "" , " " , "" , LocalDate.now() , "");

        launch();
    }
}