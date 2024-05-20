package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Model.Audios.Audio;
import org.example.phase2.Model.Audios.Music;
import org.example.phase2.Model.Audios.Podcast;
import org.example.phase2.Model.Database.Database;

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
    private static boolean checkLike=false;

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
    void addAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MusicPage.fxml")));
        Database.getDatabase().getTitles().add("Music Page");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddToPlaylist.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Add To Playlist");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void artistsAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MusicPage.fxml")));
        Database.getDatabase().getTitles().add("Music Page");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("All Artists");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MusicPage.fxml")));
        Database.getDatabase().getTitles().add("Music Page");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowAudios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Audios");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        PlayBar.setAudios(Database.getDatabase().getAudios());
        FXMLLoader fxmlLoader= Database.getDatabase().getScenes().pop();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(Database.getDatabase().getTitles().pop());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void homeAction(ActionEvent event) throws IOException {
        if(ListenerController.getListenerController().getListener()==null){
            Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MusicPage.fxml")));
            Database.getDatabase().getTitles().add("Music Page");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }else{
            Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MusicPage.fxml")));
            Database.getDatabase().getTitles().add("Music Page");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void libraryAction(ActionEvent event) throws IOException {
        if(ListenerController.getListenerController().getListener()!=null){
            Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MusicPage.fxml")));
            Database.getDatabase().getTitles().add("Music Page");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Listener Panel");
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText(null);
            alert.setContentText("You should first login.");
            alert.showAndWait();
        }
    }

    @FXML
    void searchAction(ActionEvent event) {

    }

    @FXML
    void likeAction(MouseEvent event) {
        if(ListenerController.getListenerController().getListener()!=null){
            if(checkLike){
                checkLike=false;
                ListenerController.getListenerController().getListener().getLikedAudios().remove(audio);
                audio.setLikes(audio.getLikes()-1);
                String photoAddress2=HelloApplication.class.getResource("photos/unliked.jpg").toExternalForm();
                Image image2=new Image(photoAddress2);
                likeImage.setImage(image2);
            }else {
                checkLike=true;
                ListenerController.getListenerController().getListener().getLikedAudios().add(audio);
                audio.setLikes(audio.getLikes()+1);
                String photoAddress2=HelloApplication.class.getResource("photos/liked.jpg").toExternalForm();
                Image image2=new Image(photoAddress2);
                likeImage.setImage(image2);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText(null);
            alert.setContentText("You should first login.");
            alert.showAndWait();
        }
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
//        Media music1=new Media(audio.getLinkOfAudioFile());
//        MediaPlayer mediaPlayer1=new MediaPlayer(music1);
        String photoAddress2;
        Image image2;
        if(ListenerController.getListenerController().getListener()!=null){
            if(ListenerController.getListenerController().getListener().getLikedAudios().contains(audio)){
                photoAddress2=HelloApplication.class.getResource("photos/liked.jpg").toExternalForm();
                image2=new Image(photoAddress2);
                likeImage.setImage(image2);
                checkLike=true;
            }
            if(!ListenerController.getListenerController().getListener().getLikedAudios().contains(audio)){
                photoAddress2=HelloApplication.class.getResource("photos/unliked.jpg").toExternalForm();
                image2=new Image(photoAddress2);
                likeImage.setImage(image2);
                checkLike=false;
            }
        }
        if(audio instanceof Music){
            Music music=(Music)audio;
            text_tF.setText(music.getLyric());
        }
        if(audio instanceof Podcast){
            Podcast podcast=(Podcast) audio;
            text_tF.setText(podcast.getCaption());
        }
    }
}
