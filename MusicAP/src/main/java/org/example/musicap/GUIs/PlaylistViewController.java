package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Playlist;

public class PlaylistViewController {
    @FXML
    private ListView<Audio> listViewPane;
    @FXML
    private Label titleLabel;
    private Playlist playlistModel;


    public void customInitialize(Playlist playlistModel)
    {
        this.playlistModel = playlistModel;
        titleLabel.setText("Playlist : " + playlistModel.toString());
        for(Audio tmpAudio : playlistModel.getAudioFiles())
        {
            listViewPane.getItems().add(tmpAudio);
        }
    }
}
