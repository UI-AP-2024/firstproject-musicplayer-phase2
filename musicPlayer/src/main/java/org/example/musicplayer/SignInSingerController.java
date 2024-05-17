package org.example.musicplayer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInSingerController implements Initializable {

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private TextField emailField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button registerButton;

    @FXML
    private CheckBox showPasswordCheckBox;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField usernameField1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        passwordTextField.managedProperty().bind(showPasswordCheckBox.selectedProperty());
        passwordTextField.visibleProperty().bind(showPasswordCheckBox.selectedProperty());
        passwordField.managedProperty().bind(showPasswordCheckBox.selectedProperty().not());
        passwordField.visibleProperty().bind(showPasswordCheckBox.selectedProperty().not());
        passwordTextField.textProperty().bindBidirectional(passwordField.textProperty());
    }
}
