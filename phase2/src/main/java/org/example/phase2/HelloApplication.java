package org.example.phase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.phase2.Model.Audios.Audio;
import org.example.phase2.Model.Audios.Genre;
import org.example.phase2.Model.Audios.Music;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Users.Singer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        LPanelController.setStage(stage);
        MyPlaylistsController.setStage(stage);
        MyFollowingsController.setStage(stage);
        MusicsOfPlaylistController.setStage(stage);
        MusicPageController.setStage(stage);
        AddToPlaylistController.setStage(stage);
        AllArtistsController.setStage(stage);
        HomeLoggedinController.setStage(stage);
        SearchController.setStage(stage);
        ArtistInfoController.setStage(stage);
        GetPremiumController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        scene.widthProperty().isEqualTo(stage.widthProperty());
        scene.heightProperty().isEqualTo(stage.heightProperty());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws ParseException {
        String path1="https://www.appahang5.com/cdn/tracks-mp3/1402/10/4081170458694280041704586942399617045869427678.mp3";
        String path2="https://www.appahang5.com/cdn/tracks-mp3/1395/12/1496164767068821031647670688129016476706885981.mp3";
        String path3="https://www.appahang5.com/cdn/tracks-mp3/1391/11/3453164728080326951647280803927416472808031775.mp3";
        String path4="https://www.appahang5.com/cdn/tracks-mp3/1394/11/5092164760060073101647600600790316476006001935.mp3";

        Music music1=new Music("Bi Ehsas","Shadmehr", Genre.POP,path1,"photos/Bi Ehsas-picture.png","Bi Ehsas,\ndidi goftam tah in rabete bonbaste");
        Music music2=new Music("Rooze sard","Shadmehr", Genre.COUNTRY,path2,"photos/RoozeSard-picture.png","Shayad ye rooze sard \nShayad ye nimeh dhab \nDelet bekhad beshe bargardi pisham");
        Music music3=new Music("Taghdir","Shadmehr", Genre.POP,path3,"photos/Taghdir-picture.png","To sade del kandi vali taghdir bi taghsir nist");
        Music music4=new Music("Gomet Kardam","Shadmehr", Genre.POP,path4,"photos/GometKardam-picture.png","Man az vaghti gomet kardam tamame royaham gom shod");

        Database.getDatabase().getAudios().add(music1);
        Database.getDatabase().getAudios().add(music2);
        Database.getDatabase().getAudios().add(music3);
        Database.getDatabase().getAudios().add(music4);

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date birthDate1=sdf.parse("05/27/1995");
        Singer singer1=new Singer("Sh21","A2b3D4#abcd","Shadmehr Aghili","sh@gmail.com","09134561234",birthDate1,"A good singer");
        Database.getDatabase().getUsers().add(singer1);

        PlayBar.setAudios(Database.getDatabase().getAudios());
        launch();
    }
}