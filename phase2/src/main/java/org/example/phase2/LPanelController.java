package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Model.Database.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LPanelController implements Initializable {

    @FXML
    private Button account_btn;

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Button home_btn;

    @FXML
    private Button library_btn;

    @FXML
    private Button search_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Button followings_btn;

    @FXML
    private HBox hBox;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Button newPlaylist_btn;

    @FXML
    private Label panel_lbl;

    @FXML
    private Button premium_btn;

    @FXML
    private Button playlist_btn;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private VBox vBox;
    @FXML
    private VBox vBox2;

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        LPanelController.stage = stage;
    }
    @FXML
    void artistsAction(ActionEvent event) {

    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml")));
        Database.getDatabase().getTitles().add("Listener Panel");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowAudios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Audios");
        stage.setScene(scene);
        stage.show();
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

    @FXML
    void accountAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml")));
        Database.getDatabase().getTitles().add("Listener Panel");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AccountInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Account Information");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= Database.getDatabase().getScenes().pop();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(Database.getDatabase().getTitles().pop());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void followingsAction(ActionEvent event) {

    }

    @FXML
    void newPlaylistAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml")));
        Database.getDatabase().getTitles().add("Listener Panel");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateNewPlaylist.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Create New Playlist");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void playlistAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml")));
        Database.getDatabase().getTitles().add("Listener Panel");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MyPlaylists.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("My Playlists");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void premiumAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            hBox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("side-bar.fxml")).load());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            vBox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("Play-bar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}