package org.example.prj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.prj.controller.ArtistController;
import org.example.prj.controller.ListenerController;
import org.example.prj.controller.PodcasterController;
import org.example.prj.controller.SingerController;
import org.example.prj.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class HelloApplication extends Application {

    private static Stage stage;
    private static Scene mainScene;

    public static Stage getStage() {
        return stage;
    }

    public static Scene getMainScene() {
        return mainScene;
    }

    public static void setStage(Stage stage) {
        HelloApplication.stage = stage;
    }

    public static void setMainScene(Scene mainScene) {
        HelloApplication.mainScene = mainScene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        mainScene = scene;
        HelloApplication.stage.setScene(mainScene);
        HelloApplication.stage.show();
    }

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("JAZZ");
        ListenerController.getListenerController().registration("user1","pass","ali","alirezaharandi@Gmail.com","09140405053","2004","12","29");
        ListenerController.getListenerController().getGener(al);
//        ListenerController.getListenerController().setUserAccount(null);
        ListenerController.getListenerController().registration("user2","pass","reza","kdsdkdsf@Gmail.com","09133690846","2000","4","7");
        ListenerController.getListenerController().getGener(al);
//        ListenerController.getListenerController().setUserAccount(null);
        ArtistController.getArtistController().registration("S","singer1","pass","singer1","jvdbgkhh@Gmail.com","09138240670","2004","6","10","bio Singer1");
        SingerController.getSingerController().newAlbum("album1");
        SingerController.getSingerController().publishMusic("music1","JAZZ","music text1","https://dl.musicdel.ir/Music/1400/05/trevor_daniel_falling%20128.mp3","src/main/resources/picture/images.jpg",1);
        SingerController.getSingerController().publishMusic("music2","JAZZ","music text2","https://dlmusicmim.ir/musicc/Mehrad%20Hidden%20-%20Aroos.mp3","src/main/resources/picture/images.jpg",1);
        SingerController.getSingerController().publishMusic("music3","JAZZ","music text3","https://dl.pmcmusic.tv/1402/09/Mehrad%20Hidden%20-%20Cheap.mp3","src/main/resources/picture/images.jpg",1);
//        SingerController.getSingerController().setUserAccount(null);
//        ArtistController.getArtistController().setUserAccount(null);
        ArtistController.getArtistController().registration("S","singer2","pass","singer2","jvdbgkhvdjhh@Gmail.com","09138290671","2002","9","22","bio Singer2");
//        SingerController.getSingerController().setUserAccount(null);
//        ArtistController.getArtistController().setUserAccount(null);
        ArtistController.getArtistController().registration("P","ala","pass","alireza","alirezaharandi@Gmail.com","09140405053","2004","12","29","bio");
//        ArtistController.getArtistController().setUserAccount(null);
//        PodcasterController.getPodcasterController().setUserAccount(null);
        launch();
    }
}
