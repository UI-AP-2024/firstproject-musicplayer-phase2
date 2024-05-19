package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.Controllers.PremiumListenerController;
import org.example.musicap.GUIs.ShowAlert;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Audio.Podcast;
import org.example.musicap.Models.Audio.Song;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Playlist;
import org.example.musicap.Models.User.Listener;
import org.example.musicap.Models.User.NormalListener;

import java.io.IOException;

public class AudioViewController implements ShowAlert {

    @FXML
    private ImageView coverImageView;

    @FXML
    private Label audioNameLabel;

    @FXML
    private Label artistNameLabel;

    @FXML
    private Label likesCountLabel;

    @FXML
    private Label captionLabel;

    @FXML
    private ComboBox<String> playListOption;
    @FXML
    private AnchorPane mainBody;
    private Audio audioModel;
    private Listener listenerModel;
    private Database database;
    private ListenerController listenerController;

    public void customInitialize(Audio audioModel)
    {
        database = Database.getInstance();
        listenerModel = (Listener) database.getLogedInUser();
        if(listenerModel instanceof NormalListener) listenerController = new NormalListenerController();
        else listenerController = new PremiumListenerController();
        this.audioModel = audioModel;
        Image image = new Image(getClass().getResourceAsStream(audioModel.getCover()));
        coverImageView.setImage(image);
        audioNameLabel.setText(audioModel.getFileName());
        artistNameLabel.setText(audioModel.getArtistName());
        likesCountLabel.setText(String.valueOf(audioModel.getLikesCount()));
        if(audioModel instanceof Song) captionLabel.setText(((Song)audioModel).getLyrics());
        else captionLabel.setText(((Podcast)audioModel).getCaption());
        for(Playlist tmpPlayList : listenerModel.getPlaylists())
        {
            playListOption.getItems().add(tmpPlayList.getPlaylistName());
        }

    }
    @FXML
    private void handleLikeButtonClick(MouseEvent event) throws IOException {
        audioModel.setLikesCount(audioModel.getLikesCount()+1);
        // Load the page again:
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("audio-view.fxml"));
        AnchorPane newPane = loader.load();
        AudioViewController audioViewController = loader.getController();
        audioViewController.customInitialize(audioModel);
        mainBody.getChildren().add(newPane);
    }

    @FXML
    private void handleAddToPlaylistButtonClick(MouseEvent event) {
        String playListName = playListOption.getValue();
        for(Playlist tmpPlayList : listenerModel.getPlaylists())
        {
            if(tmpPlayList.getPlaylistName().equals(playListName))
            {
                listenerController.addToPlaylist(playListName, audioModel);
                break;
            }
        }
    }
}
