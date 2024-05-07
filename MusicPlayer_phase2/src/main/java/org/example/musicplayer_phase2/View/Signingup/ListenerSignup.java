package org.example.musicplayer_phase2.View.Signingup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.Types.Free;

import java.time.LocalDate;

import static org.example.musicplayer_phase2.controller.UserAccountController.*;


public class ListenerSignup extends Application {
    public static Free freeUser;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("listenerSignup.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);

        scene.getStylesheets().add(HelloApplication.class.getResource("myCss.css").toExternalForm());

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
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        SignupView signupView = new SignupView();
        try {
            signupView.start(stage);
        }catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @FXML
    void registerClicked(MouseEvent event) {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextfield.getText();
        String email = emailTextField.getText();
        String number = numberTextField.getText();
        LocalDate birthday = birthdayDateicker.getValue();

        try{
            checkNumber(number);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("wrong number");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        try{
            checkUsername(username);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("repeated username");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        try{
            checkEmail(email);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("invalid email");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        try{
            checkPassword(password);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("easy password");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        if (name != null && username != null && password != null && email != null && number != null && birthday != null){
            Free freeUser = new Free(name , username , password , email , number , birthday);
            ListenerController listenerController = new ListenerController();
            listenerController.signup(freeUser);
            this.freeUser = freeUser;

            FavoriteGenres favoriteGenres = new FavoriteGenres();

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            try {
                favoriteGenres.start(stage);
            } catch (Exception e) {
                Alerts.errorAlert();
            }
        }
    }
}
