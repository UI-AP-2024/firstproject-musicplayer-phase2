package org.example.spotifysecondfase.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.example.spotifysecondfase.controller.ListenerController;
import org.example.spotifysecondfase.model.Audio.Audio;

import java.net.URL;
import java.util.ArrayList;
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
    private ListView<String> listView;
    public ListView<String> getListView() {return listView;}
    public void setListView(ListView<String> listView) {this.listView = listView;}
    @FXML
    private ImageView searchImage;
    public ImageView getSearchImage() {return searchImage;}
    public void setSearchImage(ImageView searchImage) {this.searchImage = searchImage;}
    @FXML
    private ImageView spotify;
    public ImageView getSpotify() {return spotify;}
    public void setSpotify(ImageView spotify) {this.spotify = spotify;}
    ListenerController listenerController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Audio a : listenerController.getPlaylist().getPlayList())
        {
            listView.getItems().add(a.toString());
        }
        //action on listview items
        listView.getSelectionModel().getSelectedItems();
        //move to play music scene
    }
}
