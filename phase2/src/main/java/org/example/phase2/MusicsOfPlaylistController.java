package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Model.Audios.Audio;
import org.example.phase2.Model.Audios.Playlist;
import org.example.phase2.Model.Database.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MusicsOfPlaylistController implements Initializable {

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
    private AnchorPane initialAnchor;

    @FXML
    private Button library_btn;

    @FXML
    private ListView<Label> listView;

    @FXML
    private Label music_lbl;

    @FXML
    private Button search_btn;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private VBox vBox1;

    @FXML
    private VBox vBox2;

    @FXML
    private VBox vBox3;
    private static Playlist playlist;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static Playlist getPlaylist() {
        return playlist;
    }

    public static void setStage(Stage stage) {
        MusicsOfPlaylistController.stage = stage;
    }

    public static void setPlaylist(Playlist playlist) {
        MusicsOfPlaylistController.playlist = playlist;
    }

    @FXML
    void artistsAction(ActionEvent event) {
        PlayBar.setAudios(Database.getDatabase().getAudios());
    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        PlayBar.setAudios(Database.getDatabase().getAudios());
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MusicsOfPlaylist.fxml")));
        Database.getDatabase().getTitles().add("Musics Of Playlist");
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
    void homeAction(ActionEvent event) {
        PlayBar.setAudios(Database.getDatabase().getAudios());

    }

    @FXML
    void libraryAction(ActionEvent event) throws IOException {
        PlayBar.setAudios(Database.getDatabase().getAudios());
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MusicsOfPlaylist.fxml")));
        Database.getDatabase().getTitles().add("Musics Of Playlist");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Listener Panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchAction(ActionEvent event) {
        PlayBar.setAudios(Database.getDatabase().getAudios());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PlayBar.setAudios(playlist.getAudioList());
        int i=0;
        for(Audio audio : playlist.getAudioList()){
            Label label=new Label("Name: "+audio.getName()+"\t\t\t"+"ID: "+audio.getId());
            listView.getItems().add(label);
            int finalI = i;
            listView.getItems().get(i++).setOnMouseClicked(mouseEvent -> {
                PlayBar.setIndex(finalI);
            });
        }
    }
}
