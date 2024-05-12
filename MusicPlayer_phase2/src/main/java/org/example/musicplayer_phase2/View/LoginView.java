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
import org.example.musicplayer_phase2.View.Panels.ListenerPanel;
import org.example.musicplayer_phase2.View.SidebarItems.Home;
import org.example.musicplayer_phase2.controller.AboutArtist.PodcasterContrller;
import org.example.musicplayer_phase2.controller.AboutArtist.SingerController;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.AboutHumans.Podcaster;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.model.AboutHumans.UserAccount;

import java.util.Collections;


public class LoginView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        NecessaryMethods.putStyleSheet(scene);
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
        NecessaryMethods.backToLastPage(event);
    }

    //login button..........................................
    @FXML
    private Button loginButton;

    @FXML
    void loginClicked(MouseEvent event) {
        String userName, password;
        if (username_textField != null && password_textField != null) {
            userName = username_textField.getText();
            password = password_textField.getText();
            try {
                UserAccount user = UserAccountController.findPerson(userName, password);
                if (user instanceof Listener){
                    UserAccountController.listener = ListenerController.listenerLogin(userName , password);
                    Home home = new Home();
                    HelloApplication.lastScenes.removeAll(HelloApplication.lastScenes);
                    home.start(NecessaryMethods.getStage(event));
                }
                else if (user instanceof Singer) {
                    UserAccountController.singer = SingerController.singerLogin(userName , password);
                    //singer panel...........................
                }
                else if (user instanceof Podcaster){
                    UserAccountController.podcaster = PodcasterContrller.podcasterLogin(userName , password);
                    //podcaster panel........................
                }
                else {
                    //admin panel...........................
                }

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("not founding user");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

}
