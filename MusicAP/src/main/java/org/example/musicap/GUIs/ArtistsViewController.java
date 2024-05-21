package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.AdminController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.User.Artist;
import org.example.musicap.Models.User.User;

import java.io.IOException;
import java.util.ArrayList;

public class ArtistsViewController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ListView<Artist> listViewPane;
    private AdminController adminController;
    public void initialize()
    {
        LayoutViewController.pagesStack.add("home-view.fxml");
        adminController = AdminController.getAdminController();
        for(Artist tmpArtist : adminController.showArtists())
        {
            listViewPane.getItems().add(tmpArtist);
        }
    }

    public void showArtist() throws IOException {
        Artist selectedArtist = listViewPane.getSelectionModel().getSelectedItem();
        if(selectedArtist != null)
        {
            rootPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("artist-view.fxml"));
            AnchorPane newPane = loader.load();
            ArtistViewController artistViewController = loader.getController();
            artistViewController.customInitialize(selectedArtist);
            rootPane.getChildren().add(newPane);

        }
    }

}
