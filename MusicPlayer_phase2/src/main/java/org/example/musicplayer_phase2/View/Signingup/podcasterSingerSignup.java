package org.example.musicplayer_phase2.View.Signingup;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.controller.AboutArtist.ArtistController;
import org.example.musicplayer_phase2.model.AboutHumans.Podcaster;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;

import java.time.LocalDate;

import static org.example.musicplayer_phase2.controller.UserAccountController.*;
import static org.example.musicplayer_phase2.controller.UserAccountController.checkPassword;

public class podcasterSingerSignup extends Application {
    String type;

    public podcasterSingerSignup() {
        type = "singer";
    }

    public podcasterSingerSignup(String type) {
        this.type = type;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("podcasterSingerSignup.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);

        scene.getStylesheets().add(HelloApplication.class.getResource("myCss.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("signup page");
        stage.show();
    }

    @FXML
    private Button backButton;

    @FXML
    private TextField biographyTextField;

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
        String biography = biographyTextField.getText();

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


        if (name != null && username != null && password != null && email != null && number != null && birthday != null && biography != null){
            ArtistController artistController = new ArtistController();
            if (type.equals("singer"))
            {
                artistController.signup(new Singer(name , username , password , email , number , birthday , biography));
            }
            else
            {
                artistController.signup(new Podcaster(name , username , password , email , number , birthday , biography));
            }
        }
    }
}
