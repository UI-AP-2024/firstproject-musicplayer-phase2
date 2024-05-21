package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Playlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class LayoutViewController implements GeneralOperation, ShowAlert {

    @FXML
    private Button playButton;
    @FXML
    private Button previousButton;
    @FXML
    private Button nextButton;
    @FXML
    private Slider timeSlider;
    private Playlist musicList;
    private MediaPlayer mediaPlayer;
    private int currentIndex;
    @FXML
    private Label nameLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label leftTimeLabel;

    Database database = Database.getInstance();
    @FXML
    private Label loginButton;

    @FXML
    private Label signUpButton;
    @FXML
    private Label logoutButton;

    @FXML
    private Label backToButton;

    @FXML
    private Button searchButton;
    @FXML
    private TextField searchField;

    @FXML
    private Label homeLabel;

    @FXML
    private Label libraryLabel;

    @FXML
    private Label artistsLabel;

    @FXML
    private Label audiosLabel;

    @FXML
    private ImageView audioImage;

    @FXML
    private AnchorPane mainBody;

    public AnchorPane getMainBody() {
        return mainBody;
    }

    public void setMainBody(AnchorPane mainBody) {
        this.mainBody = mainBody;
    }

    public void initialize() throws IOException {
        if(database.getLogedInUser() == null) logoutButton.setVisible(false);
        homeLabelClick();
    }
    @Override
    public void backTo() {
    }

    @Override
    public void logout() {
        database.setLogedInUser(null);
        logoutButton.setVisible(false);
        signUpButton.setVisible(true);
        loginButton.setVisible(true);
    }

    @Override
    public void login() throws IOException {
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }

    @Override
    public void signup() throws IOException {
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("signup-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }

    @Override
    public void search() throws IOException {
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("search-view.fxml"));
        AnchorPane newPane = loader.load();
        SearchViewController searchViewController = loader.getController();
        searchViewController.customInitialize(searchField.getText());
        mainBody.getChildren().add(newPane);
    }

    @Override
    public void navigateToSongPage() {

    }

    public void homeLabelClick() throws IOException {
        if(database.getLogedInUser() == null)
        {
            logoutButton.setVisible(false);
            loginButton.setVisible(true);
            signUpButton.setVisible(true);
        }
        else
        {
            logoutButton.setVisible(true);
            loginButton.setVisible(false);
            signUpButton.setVisible(false);
        }
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }
    public void libraryLabelClick() throws IOException {
        if(database.getLogedInUser() == null) showAlert("You should Login first!", "Login required", "Library");
        else
        {
            mainBody.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("listener-view.fxml"));
            AnchorPane newPane = loader.load();
            mainBody.getChildren().add(newPane);
        }
    }
    public void artistsLabelClick() throws IOException {
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("artists-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }
    public void audiosLabelClick() throws IOException {
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("audios-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }

    public void playPlayList(Playlist playingPlaylist, Audio playingAudio)
    {
        musicList = playingPlaylist;
        currentIndex = playingPlaylist.getAudioFiles().indexOf(playingAudio);
        mediaPlayer = new MediaPlayer(new Media(playingAudio.getAudioLink()));
        initMusic(mediaPlayer);
    }

    @FXML
    private void playMusic() {

        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING)
        {
            mediaPlayer.pause();
        }
        else
        {
            mediaPlayer.play();
        }
    }

    @FXML
    private void previousMusic() {
        currentIndex = (currentIndex+(musicList.getAudioFiles().size())-1)%(musicList.getAudioFiles().size());
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(musicList.getAudioFiles().get(currentIndex).getAudioLink()));
        initMusic(mediaPlayer);
        mediaPlayer.play();
    }

    @FXML
    private void nextMusic() {
        currentIndex = (currentIndex+1)%(musicList.getAudioFiles().size());
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(musicList.getAudioFiles().get(currentIndex).getAudioLink()));
        initMusic(mediaPlayer);
        mediaPlayer.play();
    }

    private void initMusic(MediaPlayer mediaPlayer)
    {
        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) ->
        {
            timeSlider.setValue(newValue.toSeconds());
            timeLabel.setText(String.valueOf((int)newValue.toMinutes()) + ":" + String.valueOf(((int)newValue.toSeconds())%60));
            Duration leftValue = Duration.seconds(mediaPlayer.getTotalDuration().toSeconds() - newValue.toSeconds());
            leftTimeLabel.setText(String.valueOf((int)leftValue.toMinutes()) + ":" + String.valueOf(((int)leftValue.toSeconds())%60));
        });
        timeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (Math.abs(oldValue.doubleValue() - newValue.doubleValue()) > 0.5) {
                mediaPlayer.seek(Duration.seconds(newValue.doubleValue()));
            }
        });
        mediaPlayer.setOnReady(() ->
        {
            timeSlider.setMax(mediaPlayer.getMedia().getDuration().toSeconds());
            nameLabel.setText(musicList.getAudioFiles().get(currentIndex).getAudioLink());
        });
        mediaPlayer.setOnEndOfMedia(this::nextMusic);
    }
}
