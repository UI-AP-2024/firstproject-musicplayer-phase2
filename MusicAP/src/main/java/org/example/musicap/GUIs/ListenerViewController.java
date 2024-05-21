package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.Controllers.PremiumListenerController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Playlist;
import org.example.musicap.Models.User.Artist;
import org.example.musicap.Models.User.Listener;
import org.example.musicap.Models.User.NormalListener;
import org.example.musicap.Models.User.User;

import java.io.IOException;

public class ListenerViewController implements ShowAlert {

    @FXML
    private Label userNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label creditLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private TextField newPlayListNameLabel;
    @FXML
    private Button newPlaylistButton;
    @FXML
    private ListView<Artist> followingsListView;
    @FXML
    private AnchorPane mainBody;

    @FXML
    private ListView<Playlist> playlistsListView;

    private Database database;

    private Listener listenerModel;
    private ListenerController listenerController;
    public void initialize()
    {
        database = Database.getInstance();
        listenerModel = (Listener) database.getLogedInUser();
        if(listenerModel instanceof NormalListener) listenerController = new NormalListenerController();
        else listenerController = new PremiumListenerController();
        userNameLabel.setText(listenerModel.getName());
        emailLabel.setText(listenerModel.getEmail());
        phoneLabel.setText(listenerModel.getPhoneNumber());
        creditLabel.setText(String.valueOf(listenerModel.getCredit()));
        dobLabel.setText(listenerModel.getDateOfBirth().toString());
        for(Playlist tmpPlaylist : listenerModel.getPlaylists())
        {
            playlistsListView.getItems().add(tmpPlaylist);
        }
        for(Artist tmpArtist: listenerController.getFollowings())
        {
            followingsListView.getItems().add(tmpArtist);
        }
    }

    public void getPremium() throws IOException {
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("premium-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }

    public void addNewPlaylist() throws IOException {
        String playListName = newPlayListNameLabel.getText();
        if(playListName.equals("")) showAlert("Playlist name cannot be empty!", "Playlist Name", "New Playlist");
        else
        {
            listenerController.makeNewPlaylist(playListName);
            mainBody.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("listener-view.fxml"));
            AnchorPane newPane = loader.load();
            mainBody.getChildren().add(newPane);
        }
    }

    public void playlistsClick(MouseEvent event) throws IOException {
        Playlist selectedPlaylist = playlistsListView.getSelectionModel().getSelectedItem();
        if (selectedPlaylist != null)
        {
            mainBody.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("playlist-view.fxml"));
            AnchorPane newPane = loader.load();
            PlaylistViewController playlistViewController = loader.getController();
            playlistViewController.customInitialize(selectedPlaylist);
            mainBody.getChildren().add(newPane);
        }
    }

    public void followingsClick(MouseEvent event) throws IOException {
        Artist selectedArtist = followingsListView.getSelectionModel().getSelectedItem();
        if(selectedArtist != null)
        {
            mainBody.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("artist-view.fxml"));
            AnchorPane newPane = loader.load();
            ArtistViewController artistViewController = loader.getController();
            artistViewController.customInitialize(selectedArtist);
            mainBody.getChildren().add(newPane);

        }

    }

}
