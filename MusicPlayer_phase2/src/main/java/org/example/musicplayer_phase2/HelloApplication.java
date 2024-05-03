package org.example.musicplayer_phase2;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.view.Start;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

    }

    public static void main(String[] args) {
        Start.start();
    }
}