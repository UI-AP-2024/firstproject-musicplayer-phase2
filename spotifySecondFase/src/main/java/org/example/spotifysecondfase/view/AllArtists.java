package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.example.spotifysecondfase.controller.ListenerController;
import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllArtists implements Initializable {
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
    private VBox showArtistVbox;
    public VBox getShowArtistVbox() {return showArtistVbox;}
    public void setShowArtistVbox(VBox showArtistVbox) {this.showArtistVbox = showArtistVbox;}

    @FXML
    private ImageView spotify;
    ListenerController listenerController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Artist a : listenerController.showArtists())
        {
            Label label = new Label(a.getName());
            label.setFont(Font.font(14));
            label.textFillProperty().setValue(Color.WHITE);
            showArtistVbox.getChildren().add(label);
            label.setOnMouseClicked(event -> {
                //ChangeScene.artistPanel
            });
        }
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
    }
}
