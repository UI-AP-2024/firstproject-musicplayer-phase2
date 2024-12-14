package org.example.musicplayer_phase2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Start;
import org.example.musicplayer_phase2.controller.AboutArtist.ArtistController;
import org.example.musicplayer_phase2.controller.AboutArtist.SingerController;
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

    public static final Admin admin = getAdmin("Fatemeh" , "fahim" , "1234!@#$" , "fatemefahimpoour1399@gmail.com" , "09131111111" , LocalDate.of(2005 , 12 ,12));
    public static void main(String[] args) throws Exception {
        SingerController singerController = new SingerController();

        Audio audio = new Music("wedding of love" , "" , LocalDate.now() , Genre.SOCIETY , "https://kk.soonami.ir/Richard%20Clayderman%20-%20Mariage%20D'amor.mp3" ,"" , "");

        Singer singer1 = new Singer("Erfan" , "Erfan" , "1234!@#$" , "f@gmail.com" , "09131111111" , LocalDate.now() , "Erfan Tahmasbi");
        singerController.musicPublication(singer1 , "khodahafez" , LocalDate.now() , Genre.POP , "https://dl.rozmusic.com/Music/1402/04/18/Erfan%20Tahmasbi%20-%20Khodahafez%20%28128%29.mp3" , "" , "" , "my album 1");
        singerController.musicPublication(singer1 , "To" , LocalDate.now() , Genre.POP , "https://dl.rozmusic.com/Music/1402/06/11/Erfan%20Tahmasbi%20-%20To%20%28128%29.mp3" , "" , "" , "my album 1");

        Singer singer2 = new Singer("Selena" , "Selena" , "1234!@#$" , "m@gmail.com" , "09131111111" , LocalDate.now() , "");
        singerController.musicPublication(singer2 , "souvenir" , LocalDate.now() , Genre.ROCK , "https://ts7.tarafdari.com/contents/user676439/content-sound/souvenir.mp3" , "" , "" , "my album 1");

        Singer singer3 = new Singer("Morteza" , "Morteza" , "1234!@#$" , "f@gmai@.com" , "0913111111" , LocalDate.now() , "");
        singerController.musicPublication(singer3 , "bia bargard" , LocalDate.now() , Genre.POP , "https://hiblog.tv/1000310/file/?Ur=https://irsv.upmusics.com/Downloads/Musics/Morteza%20Pashaei%20-%20Bia%20Bargard%20(320).mp3&hst=irsv.upmusics.com&prt=https&cuid=1000310" , "" , "" ,"my album 1");
        singerController.musicPublication(singer3 , "nabze ehsas" , LocalDate.now() , Genre.POP , "https://dl.rozmusic.com/Music/1400/04/26/Morteza%20Pashaei%20-%20Nabze%20Ehsas%20%28128%29.mp3" , "" , "" ,"my album 1");

        Free listener = new Free("zahra" , "zahra" , "1234!@#$" , "" , "" , LocalDate.now());

        launch();
    }
}