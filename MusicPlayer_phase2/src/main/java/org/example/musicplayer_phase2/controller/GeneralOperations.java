package org.example.musicplayer_phase2.controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public interface GeneralOperations {
    void saveToBackTo (MouseEvent event);
    void logout (Stage stage);
    void login (Stage stage);
    void signup(Stage stage);
    void search(MouseEvent event);
}
