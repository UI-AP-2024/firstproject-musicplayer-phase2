package org.example.musicplayer_phase2.controller;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Start;

public class NecessaryMethods {
    public static void saveLastScene (MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        HelloApplication.lastScenes.add(source.getScene());
        HelloApplication.lastTitle = stage.getTitle();
    }

    public static Stage getStage(MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        return stage;
    }

    public static void backToLastPage (MouseEvent event){
        Scene scene = HelloApplication.lastScenes.pop();
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(HelloApplication.lastTitle);
        stage.show();
    }
}
