package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.musicap.Controllers.AdminController;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.User.Artist;
import org.example.musicap.Models.User.User;

import java.util.ArrayList;

public class ArtistsViewController {
    @FXML
    private ListView<Artist> listViewPane;
    private AdminController adminController;
    public void initialize()
    {
        adminController = AdminController.getAdminController();
        for(Artist tmpArtist : adminController.showArtists())
        {
            listViewPane.getItems().add(tmpArtist);
        }
    }

}
