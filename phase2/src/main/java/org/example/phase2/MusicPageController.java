package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Model.Audios.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MusicPageController implements Initializable {

    @FXML
    private Button add_btn;

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Button back_btn;

    @FXML
    private HBox hBox;

    @FXML
    private Button home_btn;

    @FXML
    private ImageView musicImage;

    @FXML
    private ImageView likeImage;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Button library_btn;

    @FXML
    private Button search_btn;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private Label text_lbl;

    @FXML
    private TextField text_tF;

    @FXML
    private VBox vBox1;

    @FXML
    private VBox vBox2;
    private static Stage stage;
    private static Audio audio;

    public static Audio getAudio() {
        return audio;
    }

    public static void setAudio(Audio audio) {
        MusicPageController.audio = audio;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        MusicPageController.stage = stage;
    }

    @FXML
    void addAction(ActionEvent event) {

    }

    @FXML
    void artistsAction(ActionEvent event) {

    }

    @FXML
    void audiosAction(ActionEvent event) {

    }

    @FXML
    void backAction(ActionEvent event) {

    }

    @FXML
    void homeAction(ActionEvent event) {

    }

    @FXML
    void libraryAction(ActionEvent event) {

    }

    @FXML
    void searchAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            vBox1.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("Play-bar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String photoAddress =MusicPageController.class.getResource(audio.getCover()).toExternalForm();
        Image image=new Image(photoAddress);
        musicImage.setImage(image);
        Media music1=new Media(audio.getLinkOfAudioFile());
        MediaPlayer mediaPlayer1=new MediaPlayer(music1);
        String photoAddress2;
        Image image2;
        if(ListenerController.getListenerController().getListener().getLikedAudios().contains(audio)){
            photoAddress2=HelloApplication.class.getResource("photos/liked.jpg").toExternalForm();
            image2=new Image(photoAddress2);
            likeImage.setImage(image2);
        }
        if(!ListenerController.getListenerController().getListener().getLikedAudios().contains(audio)){
            photoAddress2=HelloApplication.class.getResource("photos/unliked.jpg").toExternalForm();
            image2=new Image(photoAddress2);
            likeImage.setImage(image2);
        }
    }
}
