package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable
{
    @FXML
    private Button allArtists;

    @FXML
    private Button allAudios;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView homeImage;

    @FXML
    private ImageView homeLibrary;

    @FXML
    private VBox homeVbox;

    @FXML
    private Button searchBtn;

    @FXML
    private ImageView searchImage;

    @FXML
    private TextField searchTxtField;

    @FXML
    private ImageView spotify;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
