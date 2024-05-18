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
    private TextField tf_pass_visible;

    @FXML
    private CheckBox cb_showPass;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_signIn;
    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField tf_pass;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tf_pass_visible.textProperty().bindBidirectional(pf_pass.textProperty());
    }

    @FXML
    private void togglePasswordVisibility() {
        if (cb_showPass.isSelected()) {
            tf_pass_visible.setVisible(true);
            tf_pass_visible.setManaged(true);
            pf_pass.setVisible(false);
            pf_pass.setManaged(false);
        } else {
            tf_pass_visible.setVisible(false);
            tf_pass_visible.setManaged(false);
            pf_pass.setVisible(true);
            pf_pass.setManaged(true);
        }
    }
}
