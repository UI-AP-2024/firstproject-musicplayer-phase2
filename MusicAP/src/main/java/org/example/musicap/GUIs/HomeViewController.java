package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.example.musicap.Controllers.AdminController;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.User.Listener;

import java.io.IOException;
import java.util.ArrayList;

public class HomeViewController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private VBox leftVBox;
    @FXML
    private VBox rightVBox;
    @FXML
    private ListView listViewPane;
    private AdminController adminController;
    private ListenerController listenerController;
    private Database dbInstance;
    ArrayList<Audio> audiosToShow;
    public void initialize() throws IOException {
        
        if(dbInstance.getLogedInUser() == null)
        {
            audiosToShow = adminController.showMostLiked(2,1);
        }
        else if(dbInstance.getLogedInUser() instanceof Listener)
        {
            audiosToShow = listenerController.suggestedAudios(5);
        }
        else audiosToShow = new ArrayList<>();
        adminController = AdminController.getAdminController();

        for (int i = 0; i < audiosToShow.size(); i++) {

            Audio audio = audiosToShow.get(i);
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("audio-view.fxml"));
            AnchorPane audioPane = loader.load();
            AudioViewController audioController = loader.getController();
            Image audioImage = new Image(HelloApplication.class.getResource("example.jpg").toString());
            audioController.setAudioDetails(audio.getFileName(), audio.getArtistName(), audioImage);
            //rootPane.getChildren().add(audioPane);
            listViewPane.getItems().add(audiosToShow.get(i).getFileName() + " | " + audiosToShow.get(i).getArtistName());

        }
    }
}
