package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Audio.Audio;
import model.UserAccount.Artist.Artist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayListAudios implements Initializable {
    @FXML
    private ImageView addToPlaylistImage;

    @FXML
    private Button allArtists;

    @FXML
    private Button allAudios;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label artistName;

    @FXML
    private Label audioName;

    @FXML
    private VBox audiosVbox;

    @FXML
    private Button backButton;

    @FXML
    private ImageView coverImage;

    @FXML
    private VBox hboxVbox;

    @FXML
    private ImageView homeImage;

    @FXML
    private ImageView homeLibrary;

    @FXML
    private VBox homeVbox;

    @FXML
    private HBox iconsHbox;

    @FXML
    private ImageView likeImage;

    @FXML
    private ImageView lyrics;

    @FXML
    private ImageView nextIcon;

    @FXML
    private ImageView pauseIcon;

    @FXML
    private HBox playHbox;

    @FXML
    private ImageView previousIcon;

    @FXML
    private ImageView searchImage;

    @FXML
    private ImageView spotify;

    public ImageView getAddToPlaylistImage() {
        return addToPlaylistImage;
    }

    public void setAddToPlaylistImage(ImageView addToPlaylistImage) {
        this.addToPlaylistImage = addToPlaylistImage;
    }

    public Button getAllArtists() {
        return allArtists;
    }

    public void setAllArtists(Button allArtists) {
        this.allArtists = allArtists;
    }

    public Button getAllAudios() {
        return allAudios;
    }

    public void setAllAudios(Button allAudios) {
        this.allAudios = allAudios;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public Label getArtistName() {
        return artistName;
    }

    public void setArtistName(Label artistName) {
        this.artistName = artistName;
    }

    public Label getAudioName() {
        return audioName;
    }

    public void setAudioName(Label audioName) {
        this.audioName = audioName;
    }

    public VBox getAudiosVbox() {
        return audiosVbox;
    }

    public void setAudiosVbox(VBox audiosVbox) {
        this.audiosVbox = audiosVbox;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public ImageView getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(ImageView coverImage) {
        this.coverImage = coverImage;
    }

    public VBox getHboxVbox() {
        return hboxVbox;
    }

    public void setHboxVbox(VBox hboxVbox) {
        this.hboxVbox = hboxVbox;
    }

    public ImageView getHomeImage() {
        return homeImage;
    }

    public void setHomeImage(ImageView homeImage) {
        this.homeImage = homeImage;
    }

    public ImageView getHomeLibrary() {
        return homeLibrary;
    }

    public void setHomeLibrary(ImageView homeLibrary) {
        this.homeLibrary = homeLibrary;
    }

    public VBox getHomeVbox() {
        return homeVbox;
    }

    public void setHomeVbox(VBox homeVbox) {
        this.homeVbox = homeVbox;
    }

    public HBox getIconsHbox() {
        return iconsHbox;
    }

    public void setIconsHbox(HBox iconsHbox) {
        this.iconsHbox = iconsHbox;
    }

    public ImageView getLikeImage() {
        return likeImage;
    }

    public void setLikeImage(ImageView likeImage) {
        this.likeImage = likeImage;
    }

    public ImageView getLyrics() {
        return lyrics;
    }

    public void setLyrics(ImageView lyrics) {
        this.lyrics = lyrics;
    }

    public ImageView getNextIcon() {
        return nextIcon;
    }

    public void setNextIcon(ImageView nextIcon) {
        this.nextIcon = nextIcon;
    }

    public ImageView getPauseIcon() {
        return pauseIcon;
    }

    public void setPauseIcon(ImageView pauseIcon) {
        this.pauseIcon = pauseIcon;
    }

    public HBox getPlayHbox() {
        return playHbox;
    }

    public void setPlayHbox(HBox playHbox) {
        this.playHbox = playHbox;
    }

    public ImageView getPreviousIcon() {
        return previousIcon;
    }

    public void setPreviousIcon(ImageView previousIcon) {
        this.previousIcon = previousIcon;
    }

    public ImageView getSearchImage() {
        return searchImage;
    }

    public void setSearchImage(ImageView searchImage) {
        this.searchImage = searchImage;
    }

    public ImageView getSpotify() {
        return spotify;
    }

    public void setSpotify(ImageView spotify) {
        this.spotify = spotify;
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
                coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                nextIcon.setOnMouseClicked(event1 -> {
                    if (i < PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i++;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else if (i == PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(0).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = 0;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
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
                coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                nextIcon.setOnMouseClicked(event1 -> {
                    if (i<PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i++;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else if (i==PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(0).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = 0;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
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
                coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                previousIcon.setOnMouseClicked(event1 -> {
                    if(i>0)
                    {
                        media = new Media(PlayMusic.playlists.get(i-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i--;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else {
                        media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = PlayMusic.playlists.size()-1;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());

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
                coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                previousIcon.setOnMouseClicked(event1 -> {
                    if(i>0)
                    {
                        media = new Media(PlayMusic.playlists.get(i-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i--;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else {
                        media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = PlayMusic.playlists.size()-1;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());

                    }
                });
            }
        });
    }
    HBox hBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        music(PlayMusic.audio);
        for (Audio a : Singup.listenerController.getPlaylist().getPlayList())
        {
            hBox = new HBox();
            ImageView imageView = a.getCoverImageView();
            Label label = new Label(a.getName());
            hBox.getChildren().addAll(imageView,label);
            audiosVbox.getChildren().add(hBox);
            hBox.setOnMouseClicked(event -> {
                PlayMusic.audio = a;
                for (Artist artist : Singup.listenerController.showArtists())
                {
                    if (artist.getName().equals(PlayMusic.audio.getArtistName()))
                    {
                        PlayMusic.playlists.addAll(Singup.artistController.artistAudios(artist));
                    }
                }
                try {
                    ChangeScene.playMusic();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        allAudios.setOnMouseClicked(event -> {
            try {
                ChangeScene.allAudios();
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
        homeImage.setOnMouseClicked(event -> {
            try {
                ChangeScene.home();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
