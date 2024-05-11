package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.LoginView;
import org.example.musicplayer_phase2.View.Signingup.ListenerSignup;
import org.example.musicplayer_phase2.View.Start;
import org.example.musicplayer_phase2.controller.UserAccountController;

public class Logout extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        UserAccountController.listener = null;
        UserAccountController.singer = null;
        UserAccountController.podcaster = null;

        new Start().start(stage);
    }
}
