package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.LoginView;
import org.example.musicplayer_phase2.View.Signingup.ListenerSignup;
import org.example.musicplayer_phase2.View.Start;
import org.example.musicplayer_phase2.controller.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;

import java.io.IOException;

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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
            Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
            NecessaryMethods.putStyleSheet(scene);
            HelloApplication.lastScenes.add(scene);
        } catch (IOException e) {
            Alerts.errorAlert();
        }
        finally {
            Alerts.goodDayAlert();
        }
    }
}
