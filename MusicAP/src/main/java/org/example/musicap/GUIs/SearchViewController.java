package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.Models.Audio.Audio;

public class SearchViewController {
    @FXML
    private ListView<Audio> listViewPane;
    @FXML
    private Label titleLabel;
    private String searchQuery;
    private ListenerController listenerController;


    public void customInitialize(String searchQuery)
    {
        this.searchQuery = searchQuery;
        listenerController = new NormalListenerController();
        titleLabel.setText("Search results for : " + searchQuery);
        for(Audio tmpAudio : listenerController.searchAudios(searchQuery))
        {
            listViewPane.getItems().add(tmpAudio);
        }
    }
}
