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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BuyPremiumController implements Initializable {

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
    private Button buy_button;

    @FXML
    private Text error_text;

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
    private Text pkgOneName_text;

    @FXML
    private Text pkgThreeName_text;

    @FXML
    private Text pkgTwoName_text;

    @FXML
    private Circle playPause_button;

    @FXML
    private Circle previous_button;

    @FXML
    private Text priceOne_text;

    @FXML
    private Text priceThree_text;

    @FXML
    private Text priceTwo_text;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button register_button;

    @FXML
    private TextField search_Text;

    @FXML
    private Button search_button;

    @FXML
    private Button selectOne_button;

    @FXML
    private Button selectThree_button;

    @FXML
    private Button selectTwo_button;

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
    void buy_Action(ActionEvent event) {

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

    @FXML
    void selectOne_Action(ActionEvent event) {

    }

    @FXML
    void selectThree_Action(ActionEvent event) {

    }

    @FXML
    void selectTwo_Action(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> al = ListenerController.getListenerController().showPremium();
        pkgOneName_text.setText(al.get(0));
        priceOne_text.setText(al.get(1));
        pkgTwoName_text.setText(al.get(2));
        priceTwo_text.setText(al.get(3));
        pkgThreeName_text.setText(al.get(4));
        priceThree_text.setText(al.get(5));
    }
}
