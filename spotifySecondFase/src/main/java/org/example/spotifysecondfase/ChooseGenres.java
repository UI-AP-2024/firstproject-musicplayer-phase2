package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Genre;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ChooseGenres implements Initializable
{
    @FXML
    private ImageView addToPlaylistImage;

    @FXML
    private Button allArtists;

    @FXML
    private Button allAudios;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btn;

    @FXML
    private GridPane gridPane;

    @FXML
    private HBox hbox;

    @FXML
    private ImageView home;

    @FXML
    private Label lable;

    @FXML
    private ImageView library;

    @FXML
    private ImageView likeImage;

    @FXML
    private ImageView lyrics;

    @FXML
    private ImageView nextIcon;

    @FXML
    private ImageView pauseIcon;

    @FXML
    private ImageView previousIcon;

    @FXML
    private ImageView search;

    @FXML
    private ImageView spotify;

    @FXML
    private VBox vbox;

    public ImageView getAddToPlaylistImage() {
        return addToPlaylistImage;
    }

    public void setAddToPlaylistImage(ImageView addToPlaylistImage) {
        this.addToPlaylistImage = addToPlaylistImage;
    }

    public Button getAllArtists() {
        return allArtists;
    }

    public void setAllArtists(Button allArtists) {
        this.allArtists = allArtists;
    }

    public Button getAllAudios() {
        return allAudios;
    }

    public void setAllAudios(Button allAudios) {
        this.allAudios = allAudios;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox hbox) {
        this.hbox = hbox;
    }

    public ImageView getHome() {
        return home;
    }

    public void setHome(ImageView home) {
        this.home = home;
    }

    public Label getLable() {
        return lable;
    }

    public void setLable(Label lable) {
        this.lable = lable;
    }

    public ImageView getLibrary() {
        return library;
    }

    public void setLibrary(ImageView library) {
        this.library = library;
    }

    public ImageView getLikeImage() {
        return likeImage;
    }

    public void setLikeImage(ImageView likeImage) {
        this.likeImage = likeImage;
    }

    public ImageView getLyrics() {
        return lyrics;
    }

    public void setLyrics(ImageView lyrics) {
        this.lyrics = lyrics;
    }

    public ImageView getNextIcon() {
        return nextIcon;
    }

    public void setNextIcon(ImageView nextIcon) {
        this.nextIcon = nextIcon;
    }

    public ImageView getPauseIcon() {
        return pauseIcon;
    }

    public void setPauseIcon(ImageView pauseIcon) {
        this.pauseIcon = pauseIcon;
    }

    public ImageView getPreviousIcon() {
        return previousIcon;
    }

    public void setPreviousIcon(ImageView previousIcon) {
        this.previousIcon = previousIcon;
    }

    public ImageView getSearch() {
        return search;
    }

    public void setSearch(ImageView search) {
        this.search = search;
    }

    public ImageView getSpotify() {
        return spotify;
    }

    public void setSpotify(ImageView spotify) {
        this.spotify = spotify;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public static VBox vBox(Genre genre)
    {
        VBox vBox = new VBox();
        Label label = new Label();
        ImageView imageView = genre.getImageView();
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        label.setText(genre.name());
        vBox.getChildren().addAll(imageView,label);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        return vBox;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int counter = 0;
        AtomicInteger chooseGenre = new AtomicInteger();
        for (int i=0; i<gridPane.getRowCount();i++)
        {
            for (int j=0; j<gridPane.getColumnCount(); j++)
            {
                Genre genre = Genre.genresArray().get(counter);
                VBox vBox = vBox(genre);
                gridPane.add(vBox,i,j);
                vBox.setOnMouseClicked(event -> {
                    Genre.genres(genre);
                    vBox.setBorder(Border.stroke(Color.WHITE));
                    chooseGenre.getAndIncrement();
                    vBox.setOnMouseClicked(event1 -> {
                        if (vBox.getBorder().getStrokes().equals(Color.WHITE))
                        {
                            vBox.setBorder(Border.stroke(Color.BLACK));
                            chooseGenre.getAndIncrement();
                            Genre.genres(genre);
                        }
                        else {
                            vBox.setBorder(Border.stroke(Color.WHITE));
                            chooseGenre.getAndIncrement();
                            Genre.genres(genre);
                        }
                        if (chooseGenre.get() > 4) {
                            try {
                                throw new Exception("You cant choose genres more than four");
                            } catch (Exception e) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText(e.getMessage());
                                alert.showAndWait();
                            }
                        }
                    });
                });
                counter++;
            }
        }
        getHome().setOnMouseClicked(event -> {
            try {
                ChangeScene.home();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        getAllAudios().setOnMouseClicked(event -> {
            try {
                ChangeScene.allAudios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        getSearch().setOnMouseClicked(event -> {
            try {
                ChangeScene.search();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        getAllArtists().setOnMouseClicked(event -> {
            try {
                ChangeScene.allArtists();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
