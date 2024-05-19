package org.example.musicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseUserTypeController implements Initializable {

    @FXML
    private Button btn_l;

    @FXML
    private Button btn_p;

    @FXML
    private Button btn_s;

    @FXML
    void btn_l_action(ActionEvent event) throws IOException {
        BasePageController.getMian_pane().setCenter(new FXMLLoader(HelloApplication.class.getResource("")).load());
    }

    @FXML
    void btn_p_action(ActionEvent event) {

    }

    @FXML
    void btn_s_action(ActionEvent event) {

    }    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
