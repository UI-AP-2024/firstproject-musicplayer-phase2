package org.example.musicplayer_phase2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Start;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.model.AboutHumans.*;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Music;
import org.example.musicplayer_phase2.model.Types.Genre;
import org.example.musicplayer_phase2.model.Types.Premium;

import java.time.LocalDate;
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
    public static void main(String[] args) throws Exception {
        Audio audio1 = new Music("first" , "" , "" , Genre.POP , "" , "" , "");
        Audio audio2 = new Music("abc" , "" , "" , Genre.POP , "" , "" , "");
        Audio audio3 = new Music("first" , "" , "" , Genre.HIPHOP , "" , "" , "");
        Audio audio4 = new Music("mmm" , "" , "" , Genre.COUNTRY, "" , "" , "");
        Audio audio5 = new Music("g" , "" , "" , Genre.POP , "" , "" , "");
        Audio audio6 = new Music("eeee" , "" , "" , Genre.ROCK , "" , "" , "");
        audio3.setLikesNum(100);
        audio5.setLikesNum(500);

        Artist artist1 = new Singer("fatemeh" , "first" , "" , " " , "" , LocalDate.now() , "");
        Artist artist12 = new Podcaster("fatemeh" , "ftm" , "" , " " , "" , LocalDate.now() , "");


        Premium listener = new Premium("" , "fff" , "123" , "" , "" , LocalDate.now());
//        Free listener = new Free("" , "fff" , "123" , "" , "" , LocalDate.now());
        ListenerController listenerController = new ListenerController();

        listenerController.followingArtist(artist1 , listener);
        listenerController.followingArtist(artist12 , listener);

        launch();
    }
}