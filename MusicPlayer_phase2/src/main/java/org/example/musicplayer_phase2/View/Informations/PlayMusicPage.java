package org.example.musicplayer_phase2.View.Informations;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.View.SidebarItems.Slider.PutSlider;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.example.musicplayer_phase2.model.AboutMusic.Music;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;
import org.example.musicplayer_phase2.model.AboutMusic.Podcast;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;


public class PlayMusicPage extends Application implements Initializable {
    public static Audio audio;
    private static Media media;

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    private static ArrayList<Audio> allMedias = new ArrayList<>();

    public static void setAllMedias(ArrayList<Audio> allMedias1) {
        allMedias = allMedias1;
    }

    private static int musicNumber;
    private static MediaPlayer mediaPlayer;

    public static Audio getAudio() {
        return audio;
    }

    public static void setAudio(Audio audio) {
        if (mediaPlayer != null){
            if (getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING){
                mediaPlayer.stop();
            }
        }

        PlayMusicPage.audio = audio;
        media = new Media(audio.getAudioLink());
        musicNumber = allMedias.indexOf(audio);
        mediaPlayer = new MediaPlayer(media);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playMusicPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("play music");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private VBox sidebareVBox;

    @FXML
    private Label addLabel;

    @FXML
    private TextField artistNameTextField;

    @FXML
    private TextField audioNameTextField;

    @FXML
    private ImageView coverImageView;

    @FXML
    private TextField identifierTextField;

    @FXML
    private Label likeLabel;

    @FXML
    private TextArea lyricsTextField;

    @FXML
    private TextField playlistNameTextField;

    @FXML
    void addClicked(MouseEvent event) {
        Playlist playlist = null;
        if (UserAccountController.listener != null) {
            if (playlistNameTextField.getText() != null) {
                try {
                    ListenerController listenerController = new ListenerController();
                    playlist = listenerController.findPlaylist(playlistNameTextField.getText(), UserAccountController.listener);
                    listenerController.addMusicToPlaylist(playlist, audio, UserAccountController.listener);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("successful adding");
                    alert.setContentText("music added to your playlist");
                    alert.showAndWait();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("fail in adding music");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
        } else {
            Alerts.nullListener();
        }
    }

    @FXML
    void addEnter(MouseEvent event) {
        addLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void addExit(MouseEvent event) {
        addLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    @FXML
    void likeClicked(MouseEvent event) {
        if (UserAccountController.listener != null) {
            if (!UserAccountController.listener.getLikedAudios().contains(audio)) {
                UserAccountController.listener.setOneLikedAudios(audio);
                likeLabel.setTextFill(Color.RED);
            } else {
                UserAccountController.listener.getLikedAudios().remove(audio);
                likeLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
            }
        } else {
            Alerts.nullListener();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebareVBox.getChildren().add(sidebarMake.getSidebar());

        if (UserAccountController.listener != null) {
            if (UserAccountController.listener.getLikedAudios().contains(audio))
                likeLabel.setTextFill(Color.RED);
        }

        if (audio != null) {
            artistNameTextField.setText("artist: " + audio.getArtistUsername());
            identifierTextField.setText("identifier: " + audio.getIdentifier());
            audioNameTextField.setText("name: " + audio.getAudioName());
            if (audio instanceof Music) {
                lyricsTextField.setText("lyrics: " + ((Music) audio).getLyrics());
            } else if (audio instanceof Podcast) {
                lyricsTextField.setText("caption: " + ((Podcast) audio).getCaption());
            }
            artistNameTextField.setEditable(false);
            identifierTextField.setEditable(false);
            audioNameTextField.setEditable(false);
            lyricsTextField.setEditable(false);
            try{
                Image image = new Image(audio.getCover());
                coverImageView.setImage(image);
            }catch (Exception e){
                Image image = new Image(HelloApplication.class.getResourceAsStream("photo.jpg"));
                coverImageView.setImage(image);
            }
        }
    }

    public static void startPlaying(){
        if (media != null) {
            try {
                mediaPlayer.play();
                mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                    PutSlider.getSlider().setValue(newValue.toSeconds());
                });

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("fail in playing");
                alert.setContentText("audio not found");
                alert.showAndWait();
            }
        }

        mediaPlayer.setOnEndOfMedia( () -> {
            nextMusic();
        });
    }

    public static void stopPlaying(){
        mediaPlayer.pause();
    }

    public static void nextMusic(){
        musicNumber++;
        if (allMedias.size() <= musicNumber){
            musicNumber %= allMedias.size();
        }

        else if (musicNumber < 0){
            musicNumber = allMedias.size() + musicNumber % allMedias.size();
        }

        setAudio(allMedias.get(musicNumber));
        startPlaying();
    }

    public static void lastMusic (){
        musicNumber--;
        if (allMedias.size() <= musicNumber){
            musicNumber %= allMedias.size();
        }

        else if (musicNumber < 0){
            musicNumber = allMedias.size() + musicNumber % allMedias.size();
        }

        setAudio(allMedias.get(musicNumber));
        startPlaying();
    }
}
