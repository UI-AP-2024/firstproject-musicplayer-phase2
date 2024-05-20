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
import org.example.musicplayer.controller.SignInOutController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignUpPodcasterController implements Initializable {

    @FXML
    private Button back;

    @FXML
    private TextField bioField;

    @FXML
    private TextField birthDatePicker;

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
    private Label error;
    @FXML
    void back_action(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("base-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        HelloApplication.currentstage.setScene(scene);
        HelloApplication.currentstage.show();
    }

    @FXML
    void register_action(ActionEvent event) throws IOException {

        String result = SignInOutController.getUserAccountController().sinUpPodcaster(usernameField.getText(), passwordField.getText(), nameField.getText(), emailField.getText(), phoneNumberField.getText(), birthDatePicker.getText(), bioField.getText());
        if (Objects.equals(result, "Now you can login!")) {
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
