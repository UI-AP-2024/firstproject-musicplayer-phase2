package org.example.prj.view;


import  java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.example.prj.controller.ListenerController;
import org.example.prj.model.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Text NameArtist_text;

    @FXML
    private Text NameMusic_text;

    @FXML
    private Button artists_button;

    @FXML
    private Button audios_button;

    @FXML
    private Button back_button;

    @FXML
    private Text error_text;

    @FXML
    private GridPane gridPain;

    @FXML
    private Button home_button;

    @FXML
    private Rectangle imageArea;

    @FXML
    private Button library_button;

    @FXML
    private Button login_button;

    @FXML
    private Button logout_button;

    @FXML
    private Circle next_button;

    @FXML
    private Circle playPause_button;

    @FXML
    private Circle previous_button;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button register_button;

    @FXML
    private ScrollPane scroll;

    @FXML
    private TextField search_Text;

    @FXML
    private Button search_button;

    @FXML
    void artists_Action(ActionEvent event) {

    }

    @FXML
    void audios_Action(ActionEvent event) {

    }

    @FXML
    void back_Action(ActionEvent event) {

    }

    @FXML
    void home_Action(ActionEvent event) {

    }

    @FXML
    void library_Action(ActionEvent event) {

    }

    @FXML
    void login_Action(ActionEvent event) {

    }

    @FXML
    void logout_Action(ActionEvent event) {

    }

    @FXML
    void next_Action(MouseEvent event) {

    }

    @FXML
    void playPause_Action(MouseEvent event) {

    }

    @FXML
    void previous_Action(MouseEvent event) {

    }

    @FXML
    void register_Action(ActionEvent event) {

    }

    @FXML
    void search_Action(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Audio> audios;
        if(!Datail.login)
            audios = ListenerController.getListenerController().sortAudioFile("L");
        else
            audios = ListenerController.getListenerController().suggestions();
        int j=0;
        for (Audio audio : audios) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("slotOfGridPinAudio-view.fxml"));
            try {
                SlotOfGridPinAudioView controller = fxmlLoader.getController();
                controller.setData(audio.getNameArtist(), audio.getName(), new Image("file:" + audio.getCover()));
                Node node = fxmlLoader.load();
                gridPain.add(node, 0, j++);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
