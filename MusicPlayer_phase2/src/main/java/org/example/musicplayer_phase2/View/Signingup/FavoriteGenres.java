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
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.Home;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.util.ArrayList;

public class FavoriteGenres extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("favoriteGenres.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setScene(scene);
        stage.setTitle("favorite genre page");
        stage.show();
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
            countryLabel.setTextFill(Color.WHITE);
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
            historyLabel.setTextFill(Color.WHITE);
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
            interviewLabel.setTextFill(Color.WHITE);
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
            jazzLabel.setTextFill(Color.WHITE);
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
            popLabel.setTextFill(Color.WHITE);
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
            rockLabel.setTextFill(Color.WHITE);
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
            societyLabel.setTextFill(Color.WHITE);
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
            trueLabel.setTextFill(Color.WHITE);
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
            hiphopLabel.setTextFill(Color.WHITE);
            favoriteGenres.remove(Genre.HIPHOP);
        }

        else if (favoriteGenres.size() >= 4 && !favoriteGenres.contains(Genre.HIPHOP)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("you can't choose more than 4 genres");
            alert.showAndWait();
        }
    }

    @FXML
    void finishClicked(MouseEvent event){
        ListenerController listenerController = new ListenerController();
        listenerController.getFavoriteGenre(favoriteGenres , UserAccountController.listener);

        try {
            Home home = new Home();
            HelloApplication.lastScenes.removeAll(HelloApplication.lastScenes);
            home.start(NecessaryMethods.getStage(event));
        }catch (Exception e){
            Alerts.errorAlert();
        }


    }

}
