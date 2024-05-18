package org.example.musicplayer_phase2.View;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Panels.PanelForListener.ListenerPanel;
import org.example.musicplayer_phase2.View.SidebarItems.Buttons.LoginView;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.Home;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.AllArtists;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.Audios;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.Search;
import org.example.musicplayer_phase2.View.Signingup.SignupView;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;

public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        stage.setScene(scene);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("welcome :)");
        stage.show();
    }

    //home..............................................
    @FXML
    private Label homeButton;

    @FXML
    void homeClicked(MouseEvent event) {

        NecessaryMethods.saveLastScene(event);
        try {
            new Home().start(NecessaryMethods.getStage(event));
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @FXML
    void homeMouseEnter(MouseEvent event) {
        homeButton.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void homeMouseExit(MouseEvent event) {
        homeButton.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    //search.................................................
    @FXML
    private Label searchButton;

    @FXML
    void searchClicked(MouseEvent event) {
        NecessaryMethods.saveLastScene(event);
        try {
            new Search().start(NecessaryMethods.getStage(event));
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @FXML
    void searchEnter(MouseEvent event) {
        searchButton.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void searchExit(MouseEvent event) {
        searchButton.setTextFill(AboutStyleSheet.getLabelExitColor());
    }
    //library..................................................
    @FXML
    private Label libraryButton;

    @FXML
    void libraryClicked(MouseEvent event) {
        if (UserAccountController.listener == null){
            Alerts.nullListener();
        }
        else {
            try {
                NecessaryMethods.saveLastScene(event);
                new ListenerPanel().start(NecessaryMethods.getStage(event));
            } catch (Exception ex) {
                Alerts.errorAlert();
            }
        }
    }

    @FXML
    void libraryEnter(MouseEvent event) {
        libraryButton.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void libraryExit(MouseEvent event) {
        libraryButton.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    //all artist................................................
    @FXML
    private Label allArtistButton;

    @FXML
    void allArtistClicked(MouseEvent event) {
        AllArtists allArtists = new AllArtists();
        NecessaryMethods.saveLastScene(event);
        try {
            allArtists.start(NecessaryMethods.getStage(event));
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @FXML
    void allArtistEnter(MouseEvent event) {
        allArtistButton.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void allArtistExit(MouseEvent event) {
        allArtistButton.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    //all audios...................................................
    @FXML
    private Label allAudios;

    @FXML
    void allAudiosClicked(MouseEvent event) {
        Audios audios = new Audios();
        NecessaryMethods.saveLastScene(event);
        try {
            audios.start(NecessaryMethods.getStage(event));
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @FXML
    void allAudiosEntered(MouseEvent event) {
        allAudios.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void allAudiosExite(MouseEvent event) {
        allAudios.setTextFill(AboutStyleSheet.getLabelExitColor());
    }
    //signup........................................................
    @FXML
    private Label signupButton;

    @FXML
    void signupClicked(MouseEvent event) {

        NecessaryMethods.saveLastScene(event);

        SignupView signupView = new SignupView();
        try {
            signupView.start(NecessaryMethods.getStage(event));
        }catch (Exception e){
            Alerts.errorAlert();
        }

    }

    @FXML
    void signupEnter(MouseEvent event) {
        signupButton.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void signupExited(MouseEvent event) {
        signupButton.setTextFill(AboutStyleSheet.getLabelExitColor());
    }
    //login.......................................................
    @FXML
    private Label loginButton;

    @FXML
    void loginClicked(MouseEvent event) {

        NecessaryMethods.saveLastScene(event);

        LoginView loginView = new LoginView();
        try {
            loginView.start(NecessaryMethods.getStage(event));
        }catch (Exception e){
            Alerts.errorAlert();
        }
    }

    @FXML
    void loginEnter(MouseEvent event) {
        loginButton.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void loginExited(MouseEvent event) {
        loginButton.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    //............................................................
}
