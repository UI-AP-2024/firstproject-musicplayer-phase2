package org.example.musicplayer_phase2.controller.AboutView;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import org.example.musicplayer_phase2.HelloApplication;

public class AboutStyleSheet {
    public static void putStyleSheet (Scene scene){
        scene.getStylesheets().add(HelloApplication.class.getResource("darkStyle.css").toExternalForm());
    }

    public static Color getLabelEnterColor(){
        return Color.BLUE;
    }

    public static Color getLabelExitColor(){
        return Color.WHITE;
    }
}
