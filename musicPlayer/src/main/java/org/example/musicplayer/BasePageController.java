package org.example.musicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BasePageController implements Initializable {
    public static boolean loggedIn = false;

    @FXML
    private Button btn_artists;

    @FXML
    private Button btn_audios;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_lib;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_search;

    @FXML
    private Button btn_signUp;

    @FXML
    private BorderPane mianPane;

    @FXML
    private TextField tf_search;

    @FXML
    private Button btn_back;

    @FXML
    void btn_back_action(ActionEvent event) {

    }

    @FXML
    void btn_artists_action(ActionEvent event) {

    }

    @FXML
    void btn_audios_action(ActionEvent event) {

    }

    @FXML
    void btn_home_action(ActionEvent event) {

    }

    @FXML
    void btn_lib_action(ActionEvent event) {

    }

    @FXML
    void btn_login_action(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        HelloApplication.currentstage.setScene(scene);
        HelloApplication.currentstage.show();
    }

    @FXML
    void btn_logout_action(ActionEvent event) {

    }

    @FXML
    void btn_search_action(ActionEvent event) {

    }

    @FXML
    void btn_signUp_action(ActionEvent event) {
        try {
        mianPane.setCenter(new FXMLLoader(HelloApplication.class.getResource("choose-userType-view.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (loggedIn) {

        }
        else {

        }
    }
}
