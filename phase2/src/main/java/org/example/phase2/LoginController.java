package org.example.phase2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import org.example.phase2.Controller.UserController;
import org.example.phase2.Exceptions.UserNotFoundException;
import org.example.phase2.Exceptions.WrongPasswordException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private HBox hbox;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button registerButton;

    @FXML
    private Label registerLabel;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            hbox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("side-bar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            UserController.getUserController().loginUser(usernameTextField.getText(),passTextField.getText());
        } catch (UserNotFoundException | WrongPasswordException e) {
            throw new RuntimeException(e);
        }
    }
}