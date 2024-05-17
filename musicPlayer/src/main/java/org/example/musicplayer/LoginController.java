package org.example.musicplayer;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.musicplayer.controller.SignInOutController;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField tf_pass;

    @FXML
    private TextField tf_username;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_signIn;

    @FXML
    void login(ActionEvent event) {
        System.out.println(SignInOutController.getUserAccountController().login(tf_username.getText(), tf_pass.getText()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
