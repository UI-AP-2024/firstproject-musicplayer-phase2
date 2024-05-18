package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AudioViewController {
    @FXML
    private AnchorPane audioItemPane;

    @FXML
    private ImageView audioImage;

    @FXML
    private Text audioTitle;

    @FXML
    private Text audioArtist;

    @FXML
    private Button playButton;

    @FXML
    private void initialize() {
        audioItemPane = new AnchorPane();
        audioItemPane.setOnMouseEntered(event -> {
            audioItemPane.setStyle("-fx-background-color: #333;");
            playButton.setOpacity(1.0);
        });

        audioItemPane.setOnMouseExited(event -> {
            audioItemPane.setStyle("-fx-background-color: #444;");
            playButton.setOpacity(0.0);
        });
    }

    public void setAudioDetails(String title, String artist, Image audioImage) {
        this.audioTitle.setText(title);
        this.audioArtist.setText(artist);
        this.audioImage.setImage(audioImage);
    }
}
