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

import java.io.IOException;

public class SearchViewController {
    @FXML
    private AnchorPane rootPane;
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
