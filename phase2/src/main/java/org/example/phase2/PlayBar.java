package org.example.phase2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PlayBar {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label audioName;

    @FXML
    private ImageView next;

    @FXML
    private ImageView playOrPause;

    @FXML
    private ImageView previous;

    @FXML
    void nextAction(MouseEvent event) {

    }

    @FXML
    void playAction(MouseEvent event) {
        System.out.println("play action");
    }

    @FXML
    void previousAction(MouseEvent event) {

    }

}