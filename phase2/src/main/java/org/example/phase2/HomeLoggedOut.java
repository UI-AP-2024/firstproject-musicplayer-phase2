package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.AdminController;
import org.example.phase2.Model.Audios.Audio;
import org.example.phase2.Model.Database.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeLoggedOut implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private HBox hBox;

    @FXML
    private Button home_btn;

    @FXML
    private Button back_btn;

    @FXML
    private ListView<Label> lView;

    @FXML
    private Button library_btn;

    @FXML
    private Button login_btn;

    @FXML
    private Button search_btn;

    @FXML
    private VBox sideVBox;

    @FXML
    private Button signUp_btn;

    @FXML
    private VBox vBox;

    @FXML
    private Label popularLabel;

    @FXML
    private AnchorPane secondaryAnchor;
    private static Stage stage;
    public static void setStage(Stage stage){
        HomeLoggedOut.stage =stage;
    }

    @FXML
    void allArtistsAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml")));
        Database.getDatabase().getTitles().add("Home");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Artists");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void allAudiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml")));
        Database.getDatabase().getTitles().add("Home");
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("You should first login.");
        alert.showAndWait();
    }

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml")));
        Database.getDatabase().getTitles().add("Home");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchAction(ActionEvent event) {

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
    void signUpAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml")));
        Database.getDatabase().getTitles().add("Home");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Signup");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            vBox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("Play-bar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Audio> audios= AdminController.getAdminController().showPopularAudios();
        int i=0;
        for(Audio audio : audios){
            Label label = new Label("Name: "+audio.getName()+"\t\t\t"+"Likes: "+audio.getLikes());
            lView.getItems().add(label);
            lView.getItems().get(i++).setOnMouseClicked(mouseEvent -> {
                int index=Database.getDatabase().getAudios().indexOf(audio);
                PlayBar.setIndex(index);
                MusicPageController.setAudio(audio);
                Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml")));
                Database.getDatabase().getTitles().add("Home");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MusicPage.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 800, 600);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Music Page");
                stage.setScene(scene);
                stage.show();
            });
        }
    }
}