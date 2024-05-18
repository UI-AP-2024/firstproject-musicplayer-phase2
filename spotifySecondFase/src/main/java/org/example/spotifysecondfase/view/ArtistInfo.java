package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.example.spotifysecondfase.controller.ListenerController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArtistInfo implements Initializable {
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
    private VBox artistAudios;
    public VBox getArtistAudios() {return artistAudios;}
    public void setArtistAudios(VBox artistAudios) {this.artistAudios = artistAudios;}
    @FXML
    private Label audiosLbl;
    public Label getAudiosLbl() {return audiosLbl;}
    public void setAudiosLbl(Label audiosLbl) {this.audiosLbl = audiosLbl;}
    @FXML
    private Label bioLbl;
    public Label getBioLbl() {return bioLbl;}
    public void setBioLbl(Label bioLbl) {this.bioLbl = bioLbl;}
    @FXML
    private Label biography;
    public Label getBiography() {return biography;}
    public void setBiography(Label biography) {this.biography = biography;}
    @FXML
    private Button followButton;
    public Button getFollowButton() {return followButton;}
    public void setFollowButton(Button followButton) {this.followButton = followButton;}
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
    @FXML
    private Label nameLbl;
    public Label getNameLbl() {return nameLbl;}
    public void setNameLbl(Label nameLbl) {this.nameLbl = nameLbl;}
    @FXML
    private Button reportButton;
    public Button getReportButton() {return reportButton;}
    public void setReportButton(Button reportButton) {this.reportButton = reportButton;}
    @FXML
    private ImageView searchImage;
    public ImageView getSearchImage() {return searchImage;}
    public void setSearchImage(ImageView searchImage) {this.searchImage = searchImage;}
    @FXML
    private ImageView spotify;
    ListenerController listenerController;
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
        followButton.setOnMouseClicked(event -> {
            listenerController.follow(nameLbl.getText());
        });
        reportButton.setOnMouseClicked(event -> {
            //ChangeScene.reportScene
        });
    }
}
