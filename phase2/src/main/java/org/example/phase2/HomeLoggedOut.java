package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Model.Database.Database;

import java.io.IOException;

public class HomeLoggedOut {

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
    private ListView<?> lView;

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
    private static Stage stage;
    public static void getStage(Stage stage){
        HomeLoggedOut.stage =stage;
    }

    @FXML
    void allArtistsAction(ActionEvent event) {

    }

    @FXML
    void allAudiosAction(ActionEvent event) {

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

}