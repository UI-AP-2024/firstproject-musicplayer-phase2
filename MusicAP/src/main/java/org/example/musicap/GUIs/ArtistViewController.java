package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.musicap.Controllers.ArtistController;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.User.Listener;

public class ArtistViewController {

    @FXML
    private Label artistNameLabel;
    @FXML
    private Label biographyLabel;

    @FXML
    private Label followersCountLabel;

    @FXML
    private Label playsCountLabel;

    @FXML
    private ListView<String> songsListView;
    private Database database;
    private ArtistController artistController;
    private Listener listenerModel;
    private ListenerController listenerController;

    public void intialize()
    {
        database = Database.getInstance();
        //artistController = new A
    }
}
