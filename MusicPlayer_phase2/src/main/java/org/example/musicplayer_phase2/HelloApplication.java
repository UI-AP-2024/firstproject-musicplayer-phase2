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
import org.example.musicplayer_phase2.model.Types.Free;
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
        Audio audio1 = new Music("1" , "" , "" , Genre.POP , "https://ts1.tarafdari.com/contents/user141862/content-sound/richard_clayderman_-_mariage_d_amour.mp3" , "" , "");
        Audio audio2 = new Music("2" , "" , "" , Genre.POP , "https://dl.musicdel.ir/Music/1400/12/andy_williams_love_story.mp3" , "" , "");
        Audio audio3 = new Music("3" , "" , "" , Genre.HIPHOP , "http://www.coca.ir/wp-content/uploads/2013/06/pirate-of-caribbean.mp3" , "" , "");

        Artist artist1 = new Singer("fatemeh" , "fahim" , "1234!@#$" , "f@gmail.com" , "09131111111" , LocalDate.now() , "I don't have biography");
        Artist artist12 = new Podcaster("maryam" , "mary" , "1234!@#$" , "m@gmail.com" , "09131111111" , LocalDate.now() , "");

        Free listener = new Free("zahra" , "zahra" , "1234!@#$" , "" , "" , LocalDate.now());

        launch();
    }
}