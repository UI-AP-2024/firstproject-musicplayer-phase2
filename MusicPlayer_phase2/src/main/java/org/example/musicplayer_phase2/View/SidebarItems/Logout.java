package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.LoginView;
import org.example.musicplayer_phase2.View.Signingup.ListenerSignup;
import org.example.musicplayer_phase2.View.Start;

public class Logout extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ListenerSignup.setFreeUser(null);
        LoginView.setListener(null);
        LoginView.setSinger(null);
        LoginView.setPodcaster(null);

        new Start().start(stage);
    }
}
