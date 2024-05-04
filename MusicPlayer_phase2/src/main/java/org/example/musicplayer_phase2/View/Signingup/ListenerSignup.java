package org.example.musicplayer_phase2.View.Signingup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.musicplayer_phase2.View.SignupView;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;

import java.time.LocalDate;


public class ListenerSignup extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("listenerSignup.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 400);

//        scene.getStylesheets().add(getClass().getResource("myCss.css").toExternalForm());

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("page not loaded\nhave a good day");
            alert.showAndWait();
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

        if (name != null && username != null && password != null && email != null && number != null && birthday != null){
            new Listener(name , username , password , email , number , birthday);
        }
    }

}
