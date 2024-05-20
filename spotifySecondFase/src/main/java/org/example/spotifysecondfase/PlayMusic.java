package org.example.spotifysecondfase;

import controller.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Audio.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Playlist;

public class PlayMusic implements Initializable {
    public static ArrayList<Audio> playlists = new ArrayList<>();
    public static Audio audio;
    @FXML
    private ImageView addToPlaylistImage;
    public ImageView getAddToPlaylistImage() {return addToPlaylistImage;}
    public void setAddToPlaylistImage(ImageView addToPlaylistImage) {this.addToPlaylistImage = addToPlaylistImage;}
    @FXML
    private Button allArtists;
    public Button getAllArtists() {return allArtists;}
    public void setAllArtists(Button allArtists) {this.allArtists = allArtists;}
    @FXML
    private Button allAudios;
    public Button getAllAudios() {return allAudios;}
    public void setAllAudios(Button allAudios) {this.allAudios = allAudios;}
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label artistName;
    public Label getArtistName() {return artistName;}
    public void setArtistName(Label artistName) {this.artistName = artistName;}
    @FXML
    private Label audioName;
    public Label getAudioName() {return audioName;}
    public void setAudioName(Label audioName) {this.audioName = audioName;}
    @FXML
    private ImageView coverOfAudio;
    @FXML
    private HBox hbox;
    @FXML
    private ImageView homeImage;
    public ImageView getHomeImage() {return homeImage;}
    public void setHomeImage(ImageView homeImage) {this.homeImage = homeImage;}
    @FXML
    private ImageView homeLibrary;
    @FXML
    private VBox homeVbox;
    @FXML
    private ImageView likeImage;
    public ImageView getLikeImage() {return likeImage;}
    public void setLikeImage(ImageView likeImage) {this.likeImage = likeImage;}
    @FXML
    private ImageView lyrics;
    public ImageView getLyrics() {return lyrics;}
    public void setLyrics(ImageView lyrics) {this.lyrics = lyrics;}
    @FXML
    private VBox namesVbox;
    @FXML
    private ImageView nextIcon;
    public ImageView getNextIcon() {return nextIcon;}
    public void setNextIcon(ImageView nextIcon) {this.nextIcon = nextIcon;}
    @FXML
    private ImageView pauseIcon;
    public ImageView getPauseIcon() {return pauseIcon;}
    public void setPauseIcon(ImageView pauseIcon) {this.pauseIcon = pauseIcon;}
    @FXML
    private ImageView previousIcon;
    public ImageView getPreviousIcon() {return previousIcon;}
    public void setPreviousIcon(ImageView previousIcon) {this.previousIcon = previousIcon;}
    @FXML
    private ImageView searchImage;
    public ImageView getSearchImage() {return searchImage;}
    public void setSearchImage(ImageView searchImage) {this.searchImage = searchImage;}
    @FXML
    private ImageView spotify;
    @FXML
    private Button backButton;

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    Media media;
    MediaPlayer mediaPlayer;
    String playPath = HelloApplication.class.getResource("play.png").toExternalForm();
    Image play = new Image(playPath);
    String pausePath = HelloApplication.class.getResource("play.png").toExternalForm();
    Image pause = new Image(pausePath);
    int i;
    public void music(Audio audio)
    {
        i = PlayMusic.playlists.indexOf(audio);
        media = new Media(audio.getAudioLink());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        pauseIcon.setOnMouseClicked(event -> {
            if (pauseIcon.getImage() == play)
            {
                pauseIcon.setImage(pause);
                mediaPlayer.play();
            }
            if (pauseIcon.getImage() == pause)
            {
                pauseIcon.setImage(play);
                mediaPlayer.pause();
            }
        });
        nextIcon.setOnMouseClicked(event -> {
            if (i < PlayMusic.playlists.size()-1)
            {
                media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                i++;
                audioName.setText(PlayMusic.playlists.get(i).getName());
                artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                nextIcon.setOnMouseClicked(event1 -> {
                    if (i < PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i++;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else if (i == PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(0).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = 0;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                });
            }
            else if (i == PlayMusic.playlists.size()-1)
            {
                media = new Media(PlayMusic.playlists.get(0).getAudioLink());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                i = 0;
                audioName.setText(PlayMusic.playlists.get(i).getName());
                artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                nextIcon.setOnMouseClicked(event1 -> {
                    if (i<PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i++;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else if (i==PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(0).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = 0;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                });
            }
        });
        previousIcon.setOnMouseClicked(event -> {
            if (i>0)
            {
                media = new Media(PlayMusic.playlists.get(i-1).getAudioLink());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                i--;
                audioName.setText(PlayMusic.playlists.get(i).getName());
                artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                previousIcon.setOnMouseClicked(event1 -> {
                    if(i>0)
                    {
                        media = new Media(PlayMusic.playlists.get(i-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i--;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else {
                        media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = PlayMusic.playlists.size()-1;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());

                    }
                });
            }
            else {
                media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                i = PlayMusic.playlists.size()-1;
                audioName.setText(PlayMusic.playlists.get(i).getName());
                artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                previousIcon.setOnMouseClicked(event1 -> {
                    if(i>0)
                    {
                        media = new Media(PlayMusic.playlists.get(i-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i--;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else {
                        media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = PlayMusic.playlists.size()-1;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverOfAudio.setImage(PlayMusic.playlists.get(i).getImage());

                    }
                });
            }
        });
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        coverOfAudio.setImage(audio.getImage());
        audioName.setText(audio.getName());
        artistName.setText(audio.getArtistName());
        music(audio);
        homeImage.setOnMouseClicked(event -> {
            try {
                ChangeScene.home();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        searchImage.setOnMouseClicked(event -> {
            try {
                ChangeScene.search();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        allArtists.setOnMouseClicked(event -> {
            try {
                ChangeScene.allArtists();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        allAudios.setOnMouseClicked(event -> {
            try {
                ChangeScene.allAudios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        addToPlaylistImage.setOnMouseClicked(event -> {
            Singup.listenerController.addAudioToPlaylist(audio.getName());
        });
        likeImage.setOnMouseClicked(event -> {
            Singup.listenerController.likeAudio(audio.getName());
        });
        lyrics.setOnMouseClicked(event -> {
            try {
                ChangeScene.lyrics();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }
}
