package org.example.spotifysecondfase;

import controller.ArtistController;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import model.UserAccount.Artist.Artist;
import model.Audio.*;
import model.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArtistInfo implements Initializable {
    @FXML
    private ImageView addToPlaylistImage;
    @FXML
    private Button allArtists;
    @FXML
    private Button allAudios;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private VBox artistAudios;
    @FXML
    private Label artistName;
    @FXML
    private Label audioName;
    @FXML
    private Label audiosLbl;
    @FXML
    private Label bioLbl;
    @FXML
    private Label biography;
    @FXML
    private ImageView coverImage;
    @FXML
    private Button followButton;
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
    private Label nameLbl;
    @FXML
    private ImageView nextIcon;
    @FXML
    private ImageView pauseIcon;
    @FXML
    private HBox playHbox;
    @FXML
    private ImageView previousIcon;
    @FXML
    private Button reportButton;
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
    public Label getArtistName() {
        return artistName;
    }
    public void setArtistName(Label artistName) {
        this.artistName = artistName;
    }
    public static Artist getArtist() {
        return artist;
    }
    public static void setArtist(Artist artist) {
        ArtistInfo.artist = artist;
    }
    public Label getAudioName() {
        return audioName;
    }
    public void setAudioName(Label audioName) {
        this.audioName = audioName;
    }
    public Label getAudiosLbl() {
        return audiosLbl;
    }
    public void setAudiosLbl(Label audiosLbl) {
        this.audiosLbl = audiosLbl;
    }
    public Label getBioLbl() {
        return bioLbl;
    }
    public void setBioLbl(Label bioLbl) {
        this.bioLbl = bioLbl;
    }
    public Label getBiography() {
        return biography;
    }
    public void setBiography(Label biography) {
        this.biography = biography;
    }
    public ImageView getCoverImage() {
        return coverImage;
    }
    public void setCoverImage(ImageView coverImage) {
        this.coverImage = coverImage;
    }
    public Button getFollowButton() {
        return followButton;
    }
    public void setFollowButton(Button followButton) {
        this.followButton = followButton;
    }
    public ImageView getHomeImage() {
        return homeImage;
    }
    public void setHomeImage(ImageView homeImage) {
        this.homeImage = homeImage;
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
    public Label getNameLbl() {
        return nameLbl;
    }
    public void setNameLbl(Label nameLbl) {
        this.nameLbl = nameLbl;
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
    public ImageView getPreviousIcon() {
        return previousIcon;
    }
    public void setPreviousIcon(ImageView previousIcon) {
        this.previousIcon = previousIcon;
    }
    public Button getReportButton() {
        return reportButton;
    }
    public void setReportButton(Button reportButton) {
        this.reportButton = reportButton;
    }
    public ImageView getSearchImage() {
        return searchImage;
    }
    public void setSearchImage(ImageView searchImage) {
        this.searchImage = searchImage;
    }
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
    String playPath = HelloApplication.class.getResource("image/play.png").toExternalForm();
    Image play = new Image(playPath);
    String pausePath = HelloApplication.class.getResource("image/pause.png").toExternalForm();
    Image pause = new Image(pausePath);
    int i;
    public void music(Audio audio)
    {
        if(audio!=null){
            i = PlayMusic.playlists.indexOf(audio);
            media = new Media(audio.getAudioLink());
            mediaPlayer = new MediaPlayer(media);
            audioName.setText(PlayMusic.playlists.get(i).getName());
            artistName.setText(PlayMusic.playlists.get(i).getArtistName());
            coverImage.setImage(PlayMusic.playlists.get(i).getImage());
            PlayMusic.audio = audio;
            mediaPlayer.play();
            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
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
                    ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                    audioName.setText(PlayMusic.playlists.get(i).getName());
                    artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                    coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    PlayMusic.audio = PlayMusic.playlists.get(i);
                    nextIcon.setOnMouseClicked(event1 -> {
                        if (i < PlayMusic.playlists.size()-1)
                        {
                            media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                            mediaPlayer = new MediaPlayer(media);
                            mediaPlayer.play();
                            i++;
                            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                            PlayMusic.audio = PlayMusic.playlists.get(i);
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
                            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                            PlayMusic.audio = PlayMusic.playlists.get(i);
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
                    ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                    PlayMusic.audio = PlayMusic.playlists.get(i);
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
                            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                            PlayMusic.audio = PlayMusic.playlists.get(i);
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
                            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                            PlayMusic.audio = PlayMusic.playlists.get(i);
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
                    ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                    PlayMusic.audio = PlayMusic.playlists.get(i);
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
                            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                            PlayMusic.audio = PlayMusic.playlists.get(i);
                            audioName.setText(PlayMusic.playlists.get(i).getName());
                            artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                            coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                        }
                        else {
                            media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                            mediaPlayer = new MediaPlayer(media);
                            mediaPlayer.play();
                            i = PlayMusic.playlists.size()-1;
                            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                            PlayMusic.audio = PlayMusic.playlists.get(i);
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
                    ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                    PlayMusic.audio = PlayMusic.playlists.get(i);
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
                            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                            PlayMusic.audio = PlayMusic.playlists.get(i);
                            audioName.setText(PlayMusic.playlists.get(i).getName());
                            artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                            coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                        }
                        else {
                            media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                            mediaPlayer = new MediaPlayer(media);
                            mediaPlayer.play();
                            i = PlayMusic.playlists.size()-1;
                            ListenerController.getListenerCotroller().playAudio(PlayMusic.playlists.get(i).getName());
                            PlayMusic.audio = PlayMusic.playlists.get(i);
                            audioName.setText(PlayMusic.playlists.get(i).getName());
                            artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                            coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                        }
                    });
                }
            });}
    }
    String nameOfArtist;
    public static Artist artist;
    public static HBox artisrInfoHBox;
    static boolean artistInfoBool = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnMouseClicked(event -> {
            try {
                ChangeScene.allArtists();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        getNameLbl().setText(artist.getName());
        getBiography().setText(artist.getBiography());
        PlayMusic.playlists.addAll(ArtistController.getArtistController().artistAudios(artist));
        for (Audio audio : Database.getDatabase().getAudio())
        {
            if(audio.getArtistName().equals(artist.getName()))
            {
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                Label audioName = new Label(audio.getName());
                audioName.textFillProperty().setValue(Color.WHITE);
                ImageView imageView = audio.getCoverImageView();
                imageView.setFitWidth(30);
                imageView.setFitHeight(30);
                hBox.getChildren().addAll(imageView,audioName);
                PlayMusic.audio = audio;
                music(PlayMusic.audio);
                artistAudios.getChildren().add(hBox);
                hBox.setOnMouseClicked(event -> {
                    try {
                        artistInfoBool = true;
                        ChangeScene.playMusic();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
        homeImage.setOnMouseClicked(event -> {
            try {
                artistInfoBool = true;
                ChangeScene.home();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        allAudios.setOnMouseClicked(event -> {
            try {
                artistInfoBool = true;
                ChangeScene.allAudios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        searchImage.setOnMouseClicked(event -> {
            try {
                artistInfoBool = true;
                ChangeScene.search();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        allArtists.setOnMouseClicked(event -> {
            try {
                artistInfoBool = true;
                ChangeScene.allArtists();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        followButton.setOnMouseClicked(event -> {
            Singup.listenerController.follow(nameLbl.getText());
        });
        reportButton.setOnMouseClicked(event -> {
            nameOfArtist = getNameLbl().getText();
            try {
                artistInfoBool = true;
                ChangeScene.reportScene();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        addToPlaylistImage.setOnMouseClicked(event -> {
            Singup.listenerController.addAudioToPlaylist(PlayMusic.audio.getName());
        });
        likeImage.setOnMouseClicked(event -> {
            ListenerController.getListenerCotroller().likeAudio(PlayMusic.audio.getName());
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
