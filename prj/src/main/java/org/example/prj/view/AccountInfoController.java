package org.example.prj.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.example.prj.controller.ListenerController;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AccountInfoController implements Initializable {

    @FXML
    private Text NameArtist_text;

    @FXML
    private Text NameMusic_text;

    @FXML
    private Button addPLayList_button;

    @FXML
    private Button artists_button;

    @FXML
    private Button audios_button;

    @FXML
    private Button back_button;

    @FXML
    private Text birth_text;

    @FXML
    private Text credit_text;

    @FXML
    private Text daySub_text;

    @FXML
    private Text email_text;

    @FXML
    private Text error_text;

    @FXML
    private Button following_button;

    @FXML
    private Text genre_text;

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
    private Text name_text;

    @FXML
    private Circle next_button;

    @FXML
    private Text phone_text;

    @FXML
    private Button playLists_button;

    @FXML
    private Circle playPause_button;

    @FXML
    private Button premium_button;

    @FXML
    private Circle previous_button;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button register_button;

    @FXML
    private TextField search_Text;

    @FXML
    private Button search_button;

    @FXML
    private Text userName_text;

    @FXML
    void addPlayList_Action(ActionEvent event) {

    }

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
    void following_Action(ActionEvent event) {

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
    void playLIsts_Action(ActionEvent event) {

    }

    @FXML
    void playPause_Action(MouseEvent event) {

    }

    @FXML
    void premium_Action(ActionEvent event) {

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
        userName_text.setText(ListenerController.getListenerController().getUserNameView());
        name_text.setText(ListenerController.getListenerController().getNameView());
        email_text.setText(ListenerController.getListenerController().getEmailView());
        phone_text.setText(ListenerController.getListenerController().getPhoneView());
        birth_text.setText(ListenerController.getListenerController().getDateView());
        daySub_text.setText(ListenerController.getListenerController().getDaySubView());
        credit_text.setText(ListenerController.getListenerController().getCreditView());
        genre_text.setText(ListenerController.getListenerController().getFavoriteGenreView());
    }
}
