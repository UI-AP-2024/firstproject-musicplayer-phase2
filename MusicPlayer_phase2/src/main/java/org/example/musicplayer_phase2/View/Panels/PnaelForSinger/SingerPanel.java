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
import org.example.musicplayer_phase2.controller.AboutArtist.SingerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.net.URL;
import java.util.ResourceBundle;

public class SingerPanel extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("singerPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
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

    //.....................................................
    @FXML
    void countryAction(ActionEvent event) {
        genre.setText("COUNTRY");
    }

    @FXML
    void hiphopAction(ActionEvent event) {
        genre.setText("HIPHOP");
    }

    @FXML
    void historyAction(ActionEvent event) {
        genre.setText("HISTORY");
    }

    @FXML
    void interviewAction(ActionEvent event) {
        genre.setText("INTERVIEW");
    }

    @FXML
    void jazzAction(ActionEvent event) {
        genre.setText("JAZZ");
    }

    @FXML
    void popAction(ActionEvent event) {
        genre.setText("POP");
    }

    @FXML
    void rockAction(ActionEvent event) {
        genre.setText("ROCK");
    }

    @FXML
    void societyAction(ActionEvent event) {
        genre.setText("SOCIETY");
    }

    @FXML
    void truecrimeAction(ActionEvent event) {
        genre.setText("TRUECRIME");
    }
    //........................................................

    @FXML
    void publicClicked(MouseEvent event) {
        Genre genre;
        try {
            genre = Genre.valueOf(this.genre.getText());
        }catch (Exception e){
            genre = Genre.ROCK;
        }
        new SingerController().musicPublication(UserAccountController.singer , nameTextField.getText() , datePicker.getValue() ,genre , linkTextField.getText() , coverTextField.getText() , lyricsTextField.getText() , albumTextField.getText() );
    }

    @FXML
    void publicExit(MouseEvent event) {
        publicLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
    }

    @FXML
    void publickEnter(MouseEvent event) {
        publicLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        buttonVBox.getChildren().add(sidebarMake.makeButtons());
    }
}
