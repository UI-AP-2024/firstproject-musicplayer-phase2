package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.musicap.Controllers.AdminController;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.User.Artist;

public class AudiosViewController {

    @FXML
    private ListView listViewPane;
    private AdminController adminController;
    public void initialize()
    {
        adminController = AdminController.getAdminController();
        for(Audio tmpAudio : adminController.showAudios(2, 1))
        {
            listViewPane.getItems().add(tmpAudio.getFileName() + " | " + tmpAudio.getArtistName());
        }
    }

}
