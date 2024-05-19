package org.example.musicplayer_phase2.View.Informations;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.View.SidebarItems.Slider.PutSlider;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutHumans.Podcaster;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.model.AboutMusic.Album;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import javafx.scene.input.MouseEvent;
import org.example.musicplayer_phase2.model.AboutMusic.Podcast;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic.*;

public class ShowArtistsInformation extends Application implements Initializable {
    private static Artist artist = null;

    public static Artist getArtist() {
        return artist;
    }

    public static void setArtist(Artist artist) {
        ShowArtistsInformation.artist = artist;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("artistsInformation.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("artists information");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private VBox sidebareVBox;

    @FXML
    private ScrollPane audiosScrollPane;

    @FXML
    private TextArea biographyTextArea;

    @FXML
    private Label followLabel;

    @FXML
    private TextField followersNumTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label reportLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField reportTextArea;

    @FXML
    void followClicked(MouseEvent event) {
        if (UserAccountController.listener != null){
            if (! UserAccountController.listener.getFollowingArtists().contains(artist)){
                try {
                    new ListenerController().followingArtist(artist , UserAccountController.listener);
                    followLabel.setTextFill(Color.RED);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("fail in following");
                    alert.setContentText(e.getMessage());
                }
            }

            else{
                UserAccountController.listener.getFollowingArtists().remove(artist);
                followLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
            }
        }

        else {
            Alerts.nullListener();
        }
    }

    @FXML
    void reportClicked(MouseEvent event) {
        if (UserAccountController.listener != null){
            if (reportTextArea != null){
                new ListenerController().reporting(UserAccountController.listener , artist , reportTextArea.getText());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("successful report");
                alert.setContentText("your report send to the admin");
                alert.showAndWait();
            }
        }

        else {
            Alerts.nullListener();
        }
    }

    @FXML
    void reportEnter(MouseEvent event) {
        reportLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void reportExit(MouseEvent event) {
        reportLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebareVBox.getChildren().add(sidebarMake.getSidebar());

        putArtistAudios(audiosScrollPane);

        if (artist != null){
            nameTextField.setText("name: " + artist.getName());
            usernameTextField.setText("username: " + artist.getUsername());
            followersNumTextField.setText(String.valueOf("number of followers: " + artist.getArraylistOfFollowers().size()));
            biographyTextArea.setText("biography: " + artist.getBiography());

            nameTextField.setEditable(false);
            usernameTextField.setEditable(false);
            followersNumTextField.setEditable(false);
            biographyTextArea.setEditable(false);

            if (UserAccountController.listener != null) {
                if (UserAccountController.listener.getFollowingArtists().contains(artist)) {
                    followLabel.setTextFill(Color.RED);
                }
            }
        }
    }

    private void putArtistAudios(ScrollPane scrollPane){
        GridPane gridPaneForAudio = new GridPane();
        scrollPane.setContent(gridPaneForAudio);

        if (artist != null){
            if (artist instanceof Singer){
                int index = 0;
                for (Album a : ((Singer) artist).getAllAlbums()){
                    for (Audio audio : a.getAllMusics()){
                        Label label = new Label("name: " + audio.getAudioName() + "\nidentifier: " + audio.getIdentifier());
                        label.setOnMouseClicked(e -> {
                            try {
                                ArrayList<Audio> music = new ArrayList<>(a.getAllMusics());
                                makeReadyToPlay(audio , music , e);
                            } catch (Exception ex) {
                                Alerts.errorAlert();
                            }
                        });
                        gridPaneForAudio.add(label , 0 , index);
                        ++index;
                    }
                }
            }

            else if (artist instanceof Podcaster){
                int index = 0;
                for (Audio a : ((Podcaster) artist).getAllPodcasts()){
                    Label label = new Label("name: " + a.getAudioName() + "\nidentifier: " + a.getIdentifier());
                    label.setOnMouseClicked(e -> {
                        try {
                            ArrayList<Audio> podcasts = new ArrayList<>(((Podcaster) artist).getAllPodcasts());
                            makeReadyToPlay(a , podcasts , e);
                        } catch (Exception ex) {
                            Alerts.errorAlert();
                        }
                    });

                    gridPaneForAudio.add(label , 0 , index);
                    ++index;
                }
            }
        }
    }
}