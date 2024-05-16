package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.example.spotifysecondfase.model.Genre;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ChooseGenres implements Initializable
{
    @FXML
    private AnchorPane anchorPane;
    public AnchorPane getAnchorPane() {return anchorPane;}
    public void setAnchorPane(AnchorPane anchorPane) {this.anchorPane = anchorPane;}
    @FXML
    private GridPane gridPane;
    public GridPane getGridPane() {return gridPane;}
    public void setGridPane(GridPane gridPane) {this.gridPane = gridPane;}
    @FXML
    private Label lable;
    public Label getLable() {return lable;}
    public void setLable(Label lable) {this.lable = lable;}
    @FXML
    private Button btn;
    public Button getBtn() {return btn;}
    public void setBtn(Button btn) {this.btn = btn;}
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
//                ImageView imageView = Genre.genresArray().get(counter).getImageView();
//                Label label = new Label(Genre.genresArray().get(counter).name());
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


    }
}
