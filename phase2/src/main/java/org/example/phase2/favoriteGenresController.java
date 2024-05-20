package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Exceptions.InterestedGenreLimit;
import org.example.phase2.Model.Audios.Genre;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Database.GeneralOperation;
import org.example.phase2.Model.Users.Listener;
import org.example.phase2.Model.Users.UserAccount;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class favoriteGenresController implements Initializable , GeneralOperation {

    @FXML
    private Button add_btn;

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Button home_btn;

    @FXML
    private Button library_btn;

    @FXML
    private VBox vbox2;

    @FXML
    private CheckBox countryCheck;

    @FXML
    private Label genreLabel;

    @FXML
    private HBox hbox;

    @FXML
    private CheckBox hipHopCheck;

    @FXML
    private CheckBox historyCheck;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private CheckBox interviewCheck;

    @FXML
    private Label noticeLabel;

    @FXML
    private CheckBox popCheck;

    @FXML
    private CheckBox rockCheck;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private CheckBox societyCheck;

    @FXML
    private CheckBox trueCrimeCheck;

    @FXML
    private CheckBox jazzCheck;

    @FXML
    private VBox vbox;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        favoriteGenresController.stage = stage;
    }

    @FXML
    void addAction(ActionEvent event) throws IOException {
        if(countryCheck.isSelected()) {
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("COUNTRY");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        if (hipHopCheck.isSelected()){
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("HIPHOP");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        if(historyCheck.isSelected())
        {
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("HISTORY");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        if(interviewCheck.isSelected())
        {
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("INTERVIEW");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        if(popCheck.isSelected())
        {
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("POP");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        if(jazzCheck.isSelected())
        {
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("JAZZ");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        if(rockCheck.isSelected())
        {
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("ROCK");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        if(societyCheck.isSelected())
        {
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("SOCIETY");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        if(trueCrimeCheck.isSelected())
        {
            try {
                ListenerController.getListenerController().chooseFavouriteGenres("TRUECRIME");
            } catch (InterestedGenreLimit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You can't choose more than 4 genres.");
                alert.showAndWait();
            }
        }
        ListenerController.getListenerController().logout();
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Favorite-genre.fxml")));
        Database.getDatabase().getTitles().add("Favorite Genre");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void artistsAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Favorite-genres.fxml")));
        Database.getDatabase().getTitles().add("Favorite Genres");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Artists");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Favorite-genres.fxml")));
        Database.getDatabase().getTitles().add("Favorite Genres");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowAudios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Audios");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        backTo();
    }

    @FXML
    void homeAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Favorite-genre.fxml")));
        Database.getDatabase().getTitles().add("Favorite Genre");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void libraryAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Favorite_genres.fxml")));
        Database.getDatabase().getTitles().add("Favorite Genres");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Listener Panel");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            hbox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("side-bar.fxml")).load());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            vbox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("Play-bar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void backTo() throws IOException {
        FXMLLoader fxmlLoader= Database.getDatabase().getScenes().pop();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(Database.getDatabase().getTitles().pop());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void logout() throws IOException {

    }

    @Override
    public void login() throws IOException {

    }

    @Override
    public void signup() throws IOException {

    }

    @Override
    public void search() throws IOException {

    }
}