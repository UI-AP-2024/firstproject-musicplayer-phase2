package org.example.musicplayer_phase2.model;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public interface GeneralOperations {
    void backTo (MouseEvent event);
    void logout (Stage stage);
    void login (Stage stage);
    void signup(Stage stage);
    void search(Stage stage);
}
