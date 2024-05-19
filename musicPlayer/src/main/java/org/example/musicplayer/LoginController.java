package org.example.musicplayer;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.musicplayer.controller.SignInOutController;

public class LoginController implements Initializable {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField pf_pass;

    @FXML
    private CheckBox cb_showPass;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_signUp;
    @FXML
    private AnchorPane anchor;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_home;

    @FXML
    void back_action(ActionEvent event) {

    }

    @FXML
    void home_action(ActionEvent event) {

    }
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void togglePasswordVisibility() {

    }
}
