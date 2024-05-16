package org.example.musicplayer_phase2.View.Informations;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class PlayMusicPage extends Application implements Initializable {
    private static Audio audio;

    public static Audio getAudio() {
        return audio;
    }

    public static void setAudio(Audio audio) {
        PlayMusicPage.audio = audio;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playMusicPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("play music");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private VBox sidebareVBox;

    @FXML
    private Label addLabel;

    @FXML
    private TextField artistNameTextField;

    @FXML
    private TextField audioNameTextField;

    @FXML
    private ImageView coverImageView;

    @FXML
    private TextField identifierTextField;

    @FXML
    private Label likeLabel;

    @FXML
    private TextArea lyricsTextField;

    @FXML
    private TextField playlistNameTextField;

    @FXML
    void addClicked(MouseEvent event) {
        Playlist playlist = null;
        if (playlistNameTextField.getText() != null){
            try {
                ListenerController listenerController = new ListenerController();
                playlist = listenerController.findPlaylist(playlistNameTextField.getText() , UserAccountController.listener);
                listenerController.addMusicToPlaylist(playlist , audio , UserAccountController.listener);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("fail in adding music");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void addEnter(MouseEvent event) {
        addLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void addExit(MouseEvent event) {
        addLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    @FXML
    void likeClicked(MouseEvent event) {
        if (! UserAccountController.listener.getLikedAudios().contains(audio)){
            UserAccountController.listener.setOneLikedAudios(audio);
            likeLabel.setTextFill(Color.RED);
        }

        else{
            UserAccountController.listener.getLikedAudios().remove(audio);
            likeLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        }
    }

    @FXML
    void likeEnter(MouseEvent event) {
        likeLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void likeExit(MouseEvent event) {
        likeLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebareVBox.getChildren().add(sidebarMake.getSidebar());

        if (UserAccountController.listener.getLikedAudios().contains(audio)){
            likeLabel.setTextFill(Color.RED);
        }
    }
}
