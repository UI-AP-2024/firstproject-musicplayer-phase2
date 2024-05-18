package org.example.musicplayer_phase2.View.Signingup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.Types.Free;

import java.time.LocalDate;

import static org.example.musicplayer_phase2.controller.UserAccountController.*;


public class ListenerSignup extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("listenerSignup.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setScene(scene);
        stage.setTitle("signup page");
        stage.show();
    }

    @FXML
    private DatePicker birthdayDateicker;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button backButton;

    @FXML
    void backClicked(MouseEvent event) {
        NecessaryMethods.backToLastPage(event);
    }

    @FXML
    void registerClicked(MouseEvent event) {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextfield.getText();
        String email = emailTextField.getText();
        String number = numberTextField.getText();
        LocalDate birthday = birthdayDateicker.getValue();

        if (UserAccountController.checkingSignup(username, password, email, number)) {
            if (name != null && username != null && password != null && email != null && number != null && birthday != null) {

                Free freeUser = new Free(name, username, password, email, number, birthday);
                ListenerController listenerController = new ListenerController();
                listenerController.signup(freeUser);
                UserAccountController.listener = freeUser;
                FavoriteGenres favoriteGenres = new FavoriteGenres();
                try {
                    favoriteGenres.start(NecessaryMethods.getStage(event));
                } catch (Exception e) {
                    Alerts.errorAlert();
                }
            }
        }
    }
}
