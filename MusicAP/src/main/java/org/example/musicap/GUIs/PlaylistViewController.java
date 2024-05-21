package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Playlist;

import java.io.IOException;

public class PlaylistViewController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ListView<Audio> listViewPane;
    @FXML
    private Label titleLabel;
    private Playlist playlistModel;


    public void customInitialize(Playlist playlistModel)
    {
        LayoutViewController.pagesStack.add("listener-view.fxml");
        this.playlistModel = playlistModel;
        titleLabel.setText("Playlist : " + playlistModel.toString());
        for(Audio tmpAudio : playlistModel.getAudioFiles())
        {
            listViewPane.getItems().add(tmpAudio);
        }
    }


    public void showAudio() throws IOException {
        Audio selectedAudio = listViewPane.getSelectionModel().getSelectedItem();
        if(selectedAudio != null)
        {
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("audio-view.fxml"));
            AnchorPane newPane = loader.load();
            AudioViewController audioViewController = loader.getController();
            audioViewController.customInitialize(selectedAudio);
            rootPane.getChildren().add(newPane);
        }

    }
}
