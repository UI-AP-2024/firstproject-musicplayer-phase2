package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

    }

    @FXML
    void loginAction(ActionEvent event) {

    }

    @FXML
    void searchAction(ActionEvent event) {

    }

    @FXML
    void signUpAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

}