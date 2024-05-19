package org.example.musicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginAndSinInBarController implements Initializable {
    @FXML
    private Button btn_login;

    @FXML
    private Button btn_signUp;

    @FXML
    void login_action(ActionEvent event) throws IOException {
        HelloApplication.setMainScene("login-view.fxml");
    }

    @FXML
    void signUp_action(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
