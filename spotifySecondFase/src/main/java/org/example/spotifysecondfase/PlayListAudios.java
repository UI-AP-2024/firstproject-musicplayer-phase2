package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import controller.ListenerController;
import model.Audio.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayListAudios implements Initializable {
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
    public AnchorPane getAnchorPane() {return anchorPane;}
    public void setAnchorPane(AnchorPane anchorPane) {this.anchorPane = anchorPane;}
    @FXML
    private ImageView homeImage;
    public ImageView getHomeImage() {return homeImage;}
    public void setHomeImage(ImageView homeImage) {this.homeImage = homeImage;}
    @FXML
    private ImageView homeLibrary;
    public ImageView getHomeLibrary() {return homeLibrary;}
    public void setHomeLibrary(ImageView homeLibrary) {this.homeLibrary = homeLibrary;}
    @FXML
    private VBox homeVbox;
    public VBox getHomeVbox() {return homeVbox;}
    public void setHomeVbox(VBox homeVbox) {this.homeVbox = homeVbox;}
    @FXML
    private ImageView searchImage;
    public ImageView getSearchImage() {return searchImage;}
    public void setSearchImage(ImageView searchImage) {this.searchImage = searchImage;}
    @FXML
    private ImageView spotify;
    public ImageView getSpotify() {return spotify;}
    public void setSpotify(ImageView spotify) {this.spotify = spotify;}
    @FXML
    private VBox audiosVbox;
    public VBox getAudiosVbox() {return audiosVbox;}
    public void setAudiosVbox(VBox audiosVbox) {this.audiosVbox = audiosVbox;}

    ListenerController listenerController;
    HBox hBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Audio a : listenerController.getPlaylist().getPlayList())
        {
            hBox = new HBox();
            ImageView imageView = a.getCoverImageView();
            Label label = new Label(a.getName());
            hBox.getChildren().addAll(imageView,label);
            audiosVbox.getChildren().add(hBox);
            hBox.setOnMouseClicked(event -> {
                //move to play music scene
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
