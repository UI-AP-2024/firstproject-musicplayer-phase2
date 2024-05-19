package org.example.musicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.musicplayer.controller.SignInOutController;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPodcasterController implements Initializable {

    @FXML
    private TextField bioField;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

    @FXML
    void register_action(ActionEvent event) {
        try {
            SignInOutController.getUserAccountController().sinUpPodcaster(usernameField.getText(), passwordField.getText(), nameField.getText(), emailField.getText(), phoneNumberField.getText(), birthDatePicker.toString(), bioField.getText());
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
