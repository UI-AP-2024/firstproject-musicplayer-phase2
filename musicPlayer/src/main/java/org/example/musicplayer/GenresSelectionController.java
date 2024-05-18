package org.example.musicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import java.util.HashSet;
import java.util.Set;

public class GenresSelectionController {
    private static final int MAX_SELECTIONS = 4;

    @FXML
    private GridPane gridPane;

    private Set<Button> selectedButtons = new HashSet<>();

    @FXML
    private void btns(ActionEvent event) {
        Button button = (Button) event.getSource();

        if (selectedButtons.contains(button)) {
            selectedButtons.remove(button);
            button.setStyle(""); // Reset style to default
        } else {
            if (selectedButtons.size() < MAX_SELECTIONS) {
                selectedButtons.add(button);
                button.setStyle("-fx-background-color: #00ff00;"); // Set style for selected button
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Selection Limit Reached");
                alert.setHeaderText(null);
                alert.setContentText("You can select up to " + MAX_SELECTIONS + " genres.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void btn_confirm(ActionEvent event) {
        StringBuilder selectedGenres = new StringBuilder("Selected Genres:\n");
        for (Button button : selectedButtons) {
            selectedGenres.append(button.getText()).append("\n");
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Genres Selected");
        alert.setHeaderText(null);
        alert.setContentText(selectedGenres.toString());
        alert.showAndWait();
    }
}
