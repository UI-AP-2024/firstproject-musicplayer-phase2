package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.controller.NecessaryMethods;
import org.example.musicplayer_phase2.model.GeneralOperations;

public class AllArtists extends Application implements GeneralOperations {
    @Override
    public void start(Stage stage) throws Exception {

    }

    @Override
    public void backTo(MouseEvent event) {
        NecessaryMethods.saveLastScene(event);
    }

    @Override
    public void logout(Stage stage) {

    }

    @Override
    public void login(Stage stage) {

    }

    @Override
    public void signup(Stage stage) {

    }

    @Override
    public void search(Stage stage) {

    }
}