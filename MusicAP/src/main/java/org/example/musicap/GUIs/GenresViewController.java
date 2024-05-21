package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Genre;
import org.example.musicap.Models.User.Listener;

import java.net.URL;
import java.util.*;

public class GenresViewController implements ShowAlert {

    private Database database;
    @FXML
    private GridPane gridPane;

    private Set<Label> selectedGenres = new HashSet<>();
    public void initialize()
    {
        LayoutViewController.pagesStack.add("genres-view.fxml");
        database = Database.getInstance();
        int index = 0;
        for (Genre genre : Genre.values()) {
            Label genreLabel = new Label(genre.toString());
            genreLabel.getStyleClass().add("genre-label");
            genreLabel.setOnMouseClicked(this::handleGenreClick);
            gridPane.add(genreLabel, index%3, index/3);
            index++;
        }
    }

    @FXML
    private void handleGenreClick(MouseEvent event) {
        Label clickedLabel = (Label) event.getSource();
        if (selectedGenres.contains(clickedLabel)) {
            clickedLabel.getStyleClass().remove("selected");
            selectedGenres.remove(clickedLabel);
        } else if (selectedGenres.size() < 4) {
            clickedLabel.getStyleClass().add("selected");
            selectedGenres.add(clickedLabel);
        } else {
            showAlert("Limit Reached", "You can select up to 4 genres only.", "Genres");
        }
    }

    @FXML
    private void handleSubmitButtonAction() {
        if (selectedGenres.size() < 4)
        {
            showAlert("Incomplete Selection", "Please select exactly 4 genres.", "Genres");
        }
        else
        {
            StringBuilder selectedGenresText = new StringBuilder("Selected Genres:\n");
            ArrayList<Genre> favoriteGenres = new ArrayList<>();
            for (Label genre : selectedGenres)
            {
                selectedGenresText.append(genre.getText()).append("\n");
                favoriteGenres.add(Genre.fromString(genre.getText()));
            }
            Listener lastRegisteredListener = (Listener) database.getUsers().get(database.getUsers().size()-1);
            lastRegisteredListener.setFavoriteGenres(favoriteGenres);
            showAlert("Submission", selectedGenresText.toString(), "Genres");
        }
    }

}
