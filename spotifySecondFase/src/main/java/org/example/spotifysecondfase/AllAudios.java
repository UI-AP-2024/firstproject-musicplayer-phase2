package org.example.spotifysecondfase;

import controller.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Audio.Audio;
import model.Database;
import model.UserAccount.Artist.Artist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllAudios implements Initializable {
    @FXML
    private ImageView addToPlaylistImage;
    @FXML
    private Button allArtists;
    @FXML
    private Button allAudios;
    @FXML
    private Label allAudiosLbl;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label artistName;
    @FXML
    private Label audioName;
    @FXML
    private ImageView coverImage;
    @FXML
    private GridPane gridPane;
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
    @FXML
    private Button backButton;
    public Button getBackButton() {
        return backButton;
    }
    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }
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
    public Label getAudioName() {
        return audioName;
    }
    public void setAudioName(Label audioName) {
        this.audioName = audioName;
    }
    public ImageView getCoverImage() {
        return coverImage;
    }
    public void setCoverImage(ImageView coverImage) {
        this.coverImage = coverImage;
    }
    public GridPane getGridPane() {
        return gridPane;
    }
    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
    public ImageView getHomeImage() {
        return homeImage;
    }
    public void setHomeImage(ImageView homeImage) {
        this.homeImage = homeImage;
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
            });
        }
    }
    public VBox vBox(Audio audio)
    {
        String fontFamily = "Arial";
        double fontSize = 12;
        FontWeight fontWeight = FontWeight.SEMI_BOLD;
        Font font=Font.font(fontFamily, fontWeight, fontSize);
        Font font2 = Font.font(fontFamily,fontSize);
        VBox vBox = new VBox();
        Label labelVbox = new Label();
        labelVbox.setFont(font);
        Label labelVbox2 = new Label();
        labelVbox2.setFont(font2);
        ImageView imageView = audio.getCoverImageView();
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        labelVbox.setText(audio.getName());
        labelVbox.textFillProperty().setValue(Color.WHITE);
        labelVbox2.setText(audio.getArtistName());
        labelVbox2.textFillProperty().setValue(Color.WHITE);
        vBox.getChildren().addAll(imageView,labelVbox,labelVbox2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        return vBox;
    }
    static boolean allAudiosBool = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        music(PlayMusic.audio);
        int counter = 0;
        for (int i=0; i<getGridPane().getRowCount(); i++)
        {
            for (int j=0; j<getGridPane().getColumnCount(); j++)
            {
                if (Database.getDatabase().getAudio().size() > counter)
                {
                    VBox vBox = vBox(Database.getDatabase().getAudio().get(counter));
                    PlayMusic.audio = Database.getDatabase().getAudio().get(counter);
                    for (Artist artist : ListenerController.getListenerCotroller().showArtists())
                    {
                        if (artist.getName().equals(PlayMusic.audio.getArtistName()))
                        {
                            PlayMusic.playlists.addAll(Singup.artistController.artistAudios(artist));
                        }
                    }
                    getGridPane().add(vBox,i,j);
                    vBox.setOnMouseClicked(event -> {
                        try {
                            ChangeScene.playMusic();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    counter++;
                }
            }
        }
        allAudios.setOnMouseClicked(event -> {
            try {
                allAudiosBool = true;
                ChangeScene.allAudios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        searchImage.setOnMouseClicked(event -> {
            try {
                allAudiosBool = true;
                ChangeScene.search();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        homeImage.setOnMouseClicked(event -> {
            try {
                allAudiosBool = true;
                ChangeScene.home();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        allArtists.setOnMouseClicked(event -> {
            try {
                allAudiosBool = true;
                ChangeScene.allArtists();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        backButton.setOnMouseClicked(event -> {
            try {
                ChangeScene.home();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        addToPlaylistImage.setOnMouseClicked(event -> {
            Singup.listenerController.addAudioToPlaylist(PlayMusic.audio.getName());
        });
        likeImage.setOnMouseClicked(event -> {
            Singup.listenerController.likeAudio(PlayMusic.audio.getName());
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
