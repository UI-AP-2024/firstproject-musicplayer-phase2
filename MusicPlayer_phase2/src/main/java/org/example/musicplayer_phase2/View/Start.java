package org.example.musicplayer_phase2.View;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.SidebarItems.AllArtists;
import org.example.musicplayer_phase2.View.SidebarItems.HomeWithoutLogin;
import org.example.musicplayer_phase2.View.SidebarItems.Search;
import org.example.musicplayer_phase2.View.Signingup.SignupView;
import org.example.musicplayer_phase2.controller.NecessaryMethods;

public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        stage.setScene(scene);
        scene.getStylesheets().add(HelloApplication.class.getResource("myCss.css").toExternalForm());
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
            new HomeWithoutLogin().start(NecessaryMethods.getStage(event));
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @FXML
    void homeMouseEnter(MouseEvent event) {
        homeButton.setTextFill(Color.BLUE);
    }

    @FXML
    void homeMouseExit(MouseEvent event) {
        homeButton.setTextFill(Color.WHITE);
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
        searchButton.setTextFill(Color.BLUE);
    }

    @FXML
    void searchExit(MouseEvent event) {
        searchButton.setTextFill(Color.WHITE);
    }
    //library..................................................
    @FXML
    private Label libraryButton;

    @FXML
    void libraryClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("invalid person");
        alert.setContentText("for this part you have to login or signup");
        alert.showAndWait();
    }

    @FXML
    void libraryEnter(MouseEvent event) {
        libraryButton.setTextFill(Color.BLUE);
    }

    @FXML
    void libraryExit(MouseEvent event) {
        libraryButton.setTextFill(Color.WHITE);
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
        allArtistButton.setTextFill(Color.BLUE);
    }

    @FXML
    void allArtistExit(MouseEvent event) {
        allArtistButton.setTextFill(Color.WHITE);
    }

    //all audios...................................................
    @FXML
    private Label allAudios;

    @FXML
    void allAudiosClicked(MouseEvent event) {
        NecessaryMethods.saveLastScene(event);
        //......
    }

    @FXML
    void allAudiosEntered(MouseEvent event) {
        allAudios.setTextFill(Color.BLUE);
    }

    @FXML
    void allAudiosExite(MouseEvent event) {
        allAudios.setTextFill(Color.WHITE);
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
        signupButton.setTextFill(Color.BLUE);
    }

    @FXML
    void signupExited(MouseEvent event) {
        signupButton.setTextFill(Color.WHITE);
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
        loginButton.setTextFill(Color.BLUE);
    }

    @FXML
    void loginExited(MouseEvent event) {
        loginButton.setTextFill(Color.WHITE);
    }


    //............................................................
}
