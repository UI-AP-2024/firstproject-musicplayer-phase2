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
        ListenerController.getListenerController().registration("al","pass","alireza","alirezaharandi@Gmail.com","09140405053","2004","12","29");
        ListenerController.getListenerController().setUserAccount(null);
        ArtistController.getArtistController().registration("P","ala","pass","alireza","alirezaharandi@Gmail.com","09140405053","2004","12","29","bio");
        PodcasterController.getPodcasterController().publishPodcast("name","POP","kjkvsv","https://dl.instamusic.ir/02/11/%20Maneskin%20-%20I%20Wanna%20Be%20Your%20Slave%20(128).mp3","file:src/main/resources/picture/images.jpg");
        launch();

    }
}
