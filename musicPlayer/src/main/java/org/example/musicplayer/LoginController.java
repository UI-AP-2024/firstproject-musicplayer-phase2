package org.example.musicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.musicplayer.controller.SignInOutController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label error;
    @FXML
    private Button back;

    @FXML
    private Button btn_login;

    @FXML
    private PasswordField pf_pass;

    @FXML
    private TextField tf_username;

    @FXML
    private VBox vBox;

    @FXML
    void back_action(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("base-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        HelloApplication.currentstage.setScene(scene);
        HelloApplication.currentstage.show();
    }

    @FXML
    void login_action(ActionEvent event) throws IOException {
        String result = SignInOutController.getUserAccountController().login(tf_username.getText(), pf_pass.getText());
        if (Objects.equals(result, "You are logged in now")) {
            HelloApplication.loggedIn = true;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("base-page-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            HelloApplication.currentstage.setScene(scene);
            HelloApplication.currentstage.show();
        }
        else {
            error.setText(result);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
