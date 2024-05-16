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
import org.example.phase2.Model.Audios.Playlist;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Users.Listener;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyPlaylistsController implements Initializable {

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
    private Label playlist_lbl;

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

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        MyPlaylistsController.stage = stage;
    }

    @FXML
    void artistsAction(ActionEvent event) {

    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MyPlaylists.fxml")));
        Database.getDatabase().getTitles().add("My Playlists");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowAudios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Audios");
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
    void homeAction(ActionEvent event) {

    }

    @FXML
    void libraryAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("MyPlaylists.fxml")));
        Database.getDatabase().getTitles().add("My Playlists");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Listener Panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Playlist playlist : ListenerController.getListenerController().getListener().getPlaylists()){
            Label label=new Label("Name: "+playlist.getNameOfPlayList()+"\t\t\t"+"ID: "+playlist.getId());
            vBox3.getChildren().add(label);
        }
    }
}