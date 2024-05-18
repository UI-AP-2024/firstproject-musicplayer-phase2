package org.example.musicplayer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class GenresSelectionController implements Initializable {

    @FXML
    private ToggleButton rockButton;
    @FXML
    private ToggleButton popButton;
    @FXML
    private ToggleButton jazzButton;
    @FXML
    private ToggleButton hiphopButton;
    @FXML
    private ToggleButton countryButton;
    @FXML
    private ToggleButton truecrimeButton;
    @FXML
    private ToggleButton societyButton;
    @FXML
    private ToggleButton interviewButton;
    @FXML
    private ToggleButton historyButton;
    @FXML
    private GridPane genreGrid;

    private final Set<ToggleButton> selectedGenres = new HashSet<>();
    private static final int MAX_SELECTION = 4;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rockButton.setOnAction(event -> btn_genres_action(rockButton));
        popButton.setOnAction(event -> btn_genres_action(popButton));
        jazzButton.setOnAction(event -> btn_genres_action(jazzButton));
        hiphopButton.setOnAction(event -> btn_genres_action(hiphopButton));
        countryButton.setOnAction(event -> btn_genres_action(countryButton));
        truecrimeButton.setOnAction(event -> btn_genres_action(truecrimeButton));
        societyButton.setOnAction(event -> btn_genres_action(societyButton));
        interviewButton.setOnAction(event -> btn_genres_action(interviewButton));
        historyButton.setOnAction(event -> btn_genres_action(historyButton));
    }

    private void btn_genres_action(ToggleButton button) {
        if (selectedGenres.contains(button)) {
            selectedGenres.remove(button);
            button.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: white; -fx-font-size: 16px;");
        } else {
            if (selectedGenres.size() < MAX_SELECTION) {
                selectedGenres.add(button);
                button.setStyle("-fx-background-color: #9b59b6; -fx-text-fill: white; -fx-font-size: 16px;");
            } else {
                button.setSelected(false);
            }
        }
    }

    @FXML
    private void btn_confirm_action() {
        selectedGenres.forEach(button -> System.out.println(button.getText()));
    }
}
