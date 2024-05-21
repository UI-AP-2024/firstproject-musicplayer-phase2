package org.example.musicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup-listener-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        HelloApplication.currentstage.setScene(scene);
        HelloApplication.currentstage.show();
    }

    @FXML
    void btn_p_action(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup-podcaster-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        HelloApplication.currentstage.setScene(scene);
        HelloApplication.currentstage.show();
    }

    @FXML
    void btn_s_action(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup-singer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        HelloApplication.currentstage.setScene(scene);
        HelloApplication.currentstage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
