package org.example.musicplayer_phase2.View;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;


public class LoginView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 400);

//        scene.getStylesheets().add(getClass().getResource("myCss.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("login page");
        stage.show();
    }
    //..........................................
    @FXML
    private TextField password_textField;

    @FXML
    private TextField username_textField;


    //return......................................
    @FXML
    private Button returnButton;

    @FXML
    void returnButtonClicked(MouseEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        try {
            helloApplication.start(HelloApplication.stage);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("page not loaded\nhave a good day");
            alert.showAndWait();
        }
    }

    //login button..........................................
    @FXML
    private Button loginButton;
    @FXML
    void loginClicked(MouseEvent event) {
        String userName , password;
        if (username_textField != null && password_textField != null){
            userName = username_textField.getText();
            password = password_textField.getText();
        }
    }
}
