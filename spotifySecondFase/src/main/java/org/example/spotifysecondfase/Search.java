package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import controller.ListenerController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable
{
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
    private Button searchBtn;

    @FXML
    private ImageView searchImage;

    @FXML
    private TextField searchTxtField;

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

    public Button getSearchBtn() {
        return searchBtn;
    }

    public void setSearchBtn(Button searchBtn) {
        this.searchBtn = searchBtn;
    }

    public ImageView getSearchImage() {
        return searchImage;
    }

    public void setSearchImage(ImageView searchImage) {
        this.searchImage = searchImage;
    }

    public TextField getSearchTxtField() {
        return searchTxtField;
    }

    public void setSearchTxtField(TextField searchTxtField) {
        this.searchTxtField = searchTxtField;
    }

    public ImageView getSpotify() {
        return spotify;
    }

    public void setSpotify(ImageView spotify) {
        this.spotify = spotify;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeImage.setOnMouseClicked(event -> {
            try {
                ChangeScene.home();
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
        searchBtn.setOnMouseClicked(event -> {
            Singup.listenerController.searching(searchTxtField.getText());
            try {
                ChangeScene.searchSecondScene();
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
    }
}
