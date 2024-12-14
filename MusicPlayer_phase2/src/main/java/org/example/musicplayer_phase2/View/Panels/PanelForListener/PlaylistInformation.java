package org.example.musicplayer_phase2.View.Panels.PanelForListener;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Informations.PlayMusicPage;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic.makeReadyToPlay;

public class PlaylistInformation extends Application implements Initializable {
    private static Playlist playlist;

    public static Playlist getPlaylist() {
        return playlist;
    }

    public static void setPlaylist(Playlist playlist) {
        PlaylistInformation.playlist = playlist;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlistInformation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("your playlist");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private VBox sidebareVBox;

    @FXML
    private TextField addMusicTextField;

    @FXML
    private Label addlabel;

    @FXML
    private ScrollPane audiosScrollPane;

    @FXML
    void addLabelClicked(MouseEvent event) {
        if (addMusicTextField != null) {
            Audio audio;
            try {
                audio = UserAccountController.findAudio(Integer.parseInt(addMusicTextField.getText()));
                new ListenerController().addMusicToPlaylist(playlist, audio, UserAccountController.listener);
                new PlaylistInformation().start(NecessaryMethods.getStage(event));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("fail in adding");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void addLabelEnter(MouseEvent event) {
        addlabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void addLabelExit(MouseEvent event) {
        addlabel.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebareVBox.getChildren().add(sidebarMake.getSidebar());

        if (playlist != null)
            putAudio(audiosScrollPane);
    }

    private void putAudio(ScrollPane scrollPane) {
        GridPane gridPane = new GridPane();

        int index = 0;
        for (Audio a : playlist) {
            Label audioLabel = new Label("name: " + a.getAudioName() + "\nidentifier: " + a.getIdentifier());
            audioLabel.setOnMouseClicked(e -> {
                try {
                    makeReadyToPlay(a , playlist.getAudioFiles() , e);
                } catch (Exception ex) {
                    Alerts.errorAlert();
                }
            });

            audioLabel.setPrefSize(350, 50);
            gridPane.add(audioLabel, 0, index);
            ++index;
        }
        scrollPane.setContent(gridPane);
    }
}