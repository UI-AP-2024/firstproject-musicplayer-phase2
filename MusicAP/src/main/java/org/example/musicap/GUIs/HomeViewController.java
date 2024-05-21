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
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.Controllers.PremiumListenerController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.PremiumPlan;
import org.example.musicap.Models.User.Artist;
import org.example.musicap.Models.User.Listener;
import org.example.musicap.Models.User.NormalListener;
import org.example.musicap.Models.User.PremiumListener;

import java.io.IOException;
import java.util.ArrayList;

public class HomeViewController {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ListView<Audio> listViewPane;
    @FXML
    private Label titleLabel;
    private AdminController adminController;
    private NormalListenerController normalListenerController;
    private PremiumListenerController premiumListenerController;
    private Database database;
    ArrayList<Audio> audiosToShow;
    public void initialize() throws IOException {
        LayoutViewController.pagesStack.add("home-view.fxml");
        database = Database.getInstance();
        adminController = AdminController.getAdminController();
        normalListenerController = new NormalListenerController();
        premiumListenerController = new PremiumListenerController();

        if(database.getLogedInUser() == null)
        {
            titleLabel.setText("Trending");
            audiosToShow = adminController.showMostLiked(2,1);
        }
        else if(database.getLogedInUser() instanceof NormalListener)
        {
            titleLabel.setText("For You");
            audiosToShow = normalListenerController.suggestedAudios(5);
        }
        else if(database.getLogedInUser() instanceof PremiumListener)
        {
            audiosToShow = premiumListenerController.suggestedAudios(5);
        }
        else audiosToShow = new ArrayList<>();

        for (int i = 0; i < audiosToShow.size(); i++) {

            //rootPane.getChildren().add(audioPane);
            listViewPane.getItems().add(audiosToShow.get(i));
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
