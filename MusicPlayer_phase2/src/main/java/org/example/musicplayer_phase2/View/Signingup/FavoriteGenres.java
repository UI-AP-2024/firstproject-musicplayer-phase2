package org.example.musicplayer_phase2.View.Signingup;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.util.ArrayList;

public class FavoriteGenres extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("favoriteGenres.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //        scene.getStylesheets().add(getClass().getResource("myCss.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("favorite genre page");
        stage.show();
    }

    Listener listener;
    public FavoriteGenres(Listener listener) {
        this.listener = listener;
    }

    public FavoriteGenres() {
    }

    ArrayList<Genre> favoriteGenres = new ArrayList<>();

    @FXML
    private Label countryLabel;

    @FXML
    private Button fnishButton;

    @FXML
    private Label hiphopLabel;

    @FXML
    private Label historyLabel;

    @FXML
    private Label interviewLabel;

    @FXML
    private Label jazzLabel;

    @FXML
    private Label popLabel;

    @FXML
    private Label rockLabel;

    @FXML
    private Label societyLabel;

    @FXML
    private Label trueLabel;

    @FXML
    void countryClicked(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.COUNTRY)) {
            countryLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.COUNTRY);
        }
        else if (favoriteGenres.contains(Genre.COUNTRY)){
            countryLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.COUNTRY);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.COUNTRY)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void historyClicked(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.HISTORY)) {
            historyLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.HISTORY);
        }
        else if (favoriteGenres.contains(Genre.HISTORY)){
            historyLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.HISTORY);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.HISTORY)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void interviewClicked(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.INTERVIEW)) {
            interviewLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.INTERVIEW);
        }
        else if (favoriteGenres.contains(Genre.INTERVIEW)){
            interviewLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.INTERVIEW);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.INTERVIEW)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void jazzClicked(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.JAZZ)) {
            jazzLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.JAZZ);
        }
        else if (favoriteGenres.contains(Genre.JAZZ)){
            jazzLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.JAZZ);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.JAZZ)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void popClicked(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.POP)) {
            popLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.POP);
        }
        else if (favoriteGenres.contains(Genre.POP)){
            popLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.POP);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.POP)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void rockClicked(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.ROCK)) {
            rockLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.ROCK);
        }
        else if (favoriteGenres.contains(Genre.ROCK)){
            rockLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.ROCK);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.ROCK)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void societyClicked(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.SOCIETY)) {
            societyLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.SOCIETY);
        }
        else if (favoriteGenres.contains(Genre.SOCIETY)){
            societyLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.SOCIETY);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.SOCIETY)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void trueCLicek(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.TRUECRIME)) {
            trueLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.TRUECRIME);
        }
        else if (favoriteGenres.contains(Genre.TRUECRIME)){
            trueLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.TRUECRIME);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.TRUECRIME)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void hiphopClicked(MouseEvent event) {
        if (favoriteGenres.size() < 4 && !favoriteGenres.contains(Genre.HIPHOP)) {
            hiphopLabel.setTextFill(Color.BLUE);
            favoriteGenres.add(Genre.HIPHOP);
        }
        else if (favoriteGenres.contains(Genre.HIPHOP)){
            hiphopLabel.setTextFill(Color.BLACK);
            favoriteGenres.remove(Genre.HIPHOP);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.HIPHOP)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void finishClicked(MouseEvent event) {

    }

}
