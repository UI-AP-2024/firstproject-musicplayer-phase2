package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HelloController {
    @FXML
    private Label welcomeText;
    Rectangle rectangle = new Rectangle(20,30);


    @FXML
    protected void onHelloButtonClick() {
        rectangle.setFill(Color.DARKSLATEGRAY);
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}