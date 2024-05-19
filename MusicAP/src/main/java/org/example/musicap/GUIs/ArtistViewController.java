package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.ArtistController;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.PodcasterController;
import org.example.musicap.Controllers.SingerController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.User.Artist;
import org.example.musicap.Models.User.Listener;
import org.example.musicap.Models.User.Podcaster;
import org.example.musicap.Models.User.Singer;

import java.io.IOException;

public class ArtistViewController {
    @FXML
    private AnchorPane mainBody;
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
    @FXML
    private Label followedLabel;
    @FXML
    private AnchorPane reportPane;
    private Database database;
    private Artist artistModel;
    private ArtistController artistController;
    private Listener listenerModel;
    public void customInitialize(Artist artistModel)
    {
        database = Database.getInstance();
        this.artistModel = artistModel;
        if(artistModel instanceof Singer) artistController = new SingerController((Singer)artistModel);
        else artistController = new PodcasterController((Podcaster) artistModel);
        listenerModel = (Listener) database.getLogedInUser();
        artistNameLabel.setText(artistModel.getName());
        biographyLabel.setText(artistModel.getBiography());
        followersCountLabel.setText(String.valueOf(artistController.showFollowers().size()));
        playsCountLabel.setText(String.valueOf(artistController.getPlayedCount()));
        if(artistController.isFollowedBy(listenerModel)) followedLabel.setText("Followed by you!");
        else followedLabel.setText("Not followed yet");
        for(Audio tmpAudio : artistController.showAudios())
        {
            songsListView.getItems().add(tmpAudio.getFileName() + " | " + tmpAudio.getArtistName());
        }
    }


    public void addToFollowers() throws IOException {
        // for both following and unfollowing
        artistController.followArtist(listenerModel);
        // Reload tha page
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("artist-view.fxml"));
        AnchorPane newPane = loader.load();
        ArtistViewController artistViewController = loader.getController();
        artistViewController.customInitialize(artistModel);
        mainBody.getChildren().add(newPane);
    }

    public void addReport() throws IOException {
        reportPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("report-view.fxml"));
        AnchorPane newPane = loader.load();
        ReportViewController reportViewController = loader.getController();
        reportViewController.customInitialize(listenerModel, artistModel);
        reportPane.getChildren().add(newPane);
    }
}
