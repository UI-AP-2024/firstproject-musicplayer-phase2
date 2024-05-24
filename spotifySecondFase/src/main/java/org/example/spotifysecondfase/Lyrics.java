package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Audio.Music;
import model.Audio.Podcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Lyrics implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label lyrics;
    public Label getLyrics() {return lyrics;}
    public void setLyrics(Label lyrics) {this.lyrics = lyrics;}
    @FXML
    private Label lyricsLbl;
    public Label getLyricsLbl() {return lyricsLbl;}
    public void setLyricsLbl(Label lyricsLbl) {this.lyricsLbl = lyricsLbl;}
    static boolean lyricsBool = true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boolean b = PlayMusic.audio instanceof Music;
        if(b)
        {
            getLyrics().setText(((Music)PlayMusic.audio).getLyrics());
        }
        else {
            getLyrics().setText(((Podcast)PlayMusic.audio).getCaption());
        }
        anchorPane.setOnMouseClicked(event -> {
            try {
                ChangeScene.playMusic();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
