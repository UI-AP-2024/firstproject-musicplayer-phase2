package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.AdminController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.User.Artist;

import java.io.IOException;

public class AudiosViewController {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ListView<Audio> listViewPane;
    private AdminController adminController;
    public void initialize()
    {
        LayoutViewController.pagesStack.add("home-view.fxml");
        adminController = AdminController.getAdminController();
        for(Audio tmpAudio : adminController.showAudios(2, 1))
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
