package org.example.musicplayer_phase2.View.Panels.PnaelForSinger;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class SingerPanel extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("singerPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("artist panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField albumTextField;

    @FXML
    private VBox buttonVBox;

    @FXML
    private TextField coverTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private SplitMenuButton genre;

    @FXML
    private TextField linkTextField;

    @FXML
    private TextField lyricsTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label publicLabel;

    @FXML
    void countryAction(ActionEvent event) {

    }

    @FXML
    void hiphopAction(ActionEvent event) {

    }

    @FXML
    void historyAction(ActionEvent event) {

    }

    @FXML
    void interviewAction(ActionEvent event) {

    }

    @FXML
    void jazzAction(ActionEvent event) {

    }

    @FXML
    void popAction(ActionEvent event) {

    }

    @FXML
    void publicClicked(MouseEvent event) {

    }

    @FXML
    void publicExit(MouseEvent event) {

    }

    @FXML
    void publickEnter(MouseEvent event) {

    }

    @FXML
    void rockAction(ActionEvent event) {

    }

    @FXML
    void societyAction(ActionEvent event) {

    }

    @FXML
    void truecrimeAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        buttonVBox.getChildren().add(sidebarMake.makeButtons());
    }
}
