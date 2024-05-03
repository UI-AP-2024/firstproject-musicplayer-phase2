package org.example.musicplayer_phase2.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Start{

    //home..............................................
    @FXML
    private Label homeButton;

    @FXML
    void homeClicked(MouseEvent event) {

    }

    @FXML
    void homeMouseEnter(MouseEvent event) {
        homeButton.setTextFill(Color.BLUE);
    }

    @FXML
    void homeMouseExit(MouseEvent event) {
        homeButton.setTextFill(Color.RED);
    }

    //search.................................................
    @FXML
    private Label searchButton;

    @FXML
    void searchClicked(MouseEvent event) {

    }

    @FXML
    void searchEnter(MouseEvent event) {
        searchButton.setTextFill(Color.BLUE);
    }

    @FXML
    void searchExit(MouseEvent event) {
        searchButton.setTextFill(Color.RED);
    }
    //library..................................................
    @FXML
    private Label libraryButton;

    @FXML
    void libraryClicked(MouseEvent event) {

    }

    @FXML
    void libraryEnter(MouseEvent event) {
        libraryButton.setTextFill(Color.BLUE);
    }

    @FXML
    void libraryExit(MouseEvent event) {
        libraryButton.setTextFill(Color.RED);
    }

    //all artist................................................
    @FXML
    private Label allArtistButton;

    @FXML
    void allArtistClicked(MouseEvent event) {

    }

    @FXML
    void allArtistEnter(MouseEvent event) {
        allArtistButton.setTextFill(Color.BLUE);
    }

    @FXML
    void allArtistExit(MouseEvent event) {
        allArtistButton.setTextFill(Color.RED);
    }

    //all audios...................................................
    @FXML
    private Label allAudios;

    @FXML
    void allAudiosClicked(MouseEvent event) {

    }

    @FXML
    void allAudiosEntered(MouseEvent event) {
        allAudios.setTextFill(Color.BLUE);
    }

    @FXML
    void allAudiosExite(MouseEvent event) {
        allAudios.setTextFill(Color.RED);
    }
    //signup........................................................
    @FXML
    private Label signupButton;

    @FXML
    void signupClicked(MouseEvent event) {

    }

    @FXML
    void signupEnter(MouseEvent event) {
        signupButton.setTextFill(Color.RED);
    }

    @FXML
    void signupExited(MouseEvent event) {
        signupButton.setTextFill(Color.BLACK);
    }
    //login.......................................................
    @FXML
    private Label loginButton;

    @FXML
    void loginClicked(MouseEvent event) {

    }

    @FXML
    void loginEnter(MouseEvent event) {
        loginButton.setTextFill(Color.RED);
    }

    @FXML
    void loginExited(MouseEvent event) {
        loginButton.setTextFill(Color.BLACK);
    }

}
