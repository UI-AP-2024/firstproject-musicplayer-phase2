package org.example.prj.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.example.prj.HelloApplication;
import org.example.prj.controller.ArtistController;
import org.example.prj.controller.GeneralOperations;
import org.example.prj.controller.ListenerController;
import org.example.prj.controller.SingerController;
import org.example.prj.exception.InaccessibilityException;
import org.example.prj.exception.InvalidFormatException;
import org.example.prj.exception.OtherException;
import org.example.prj.model.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterSController implements Initializable, GeneralOperations {

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
    private TextField bio_text;

    @FXML
    private TextField day_text;

    @FXML
    private TextField email_text;

    @FXML
    private Text error_text;

    @FXML
    private Button home_button;

    @FXML
    private ImageView image;

    @FXML
    private Button library_button;

    @FXML
    private Button mainRegister_Button;

    @FXML
    private Button login_button;

    @FXML
    private Button logout_button;

    @FXML
    private TextField month_text;

    @FXML
    private TextField username_text;

    @FXML
    private TextField name_text1;

    @FXML
    private Circle next_button;

    @FXML
    private TextField number_text;

    @FXML
    private TextField password_text;

    @FXML
    private Circle playPause_button;

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
    private TextField year_text;

    @FXML
    void artists_Action(ActionEvent event) throws IOException {
        Detail.lastScene.push(HelloApplication.getStage().getScene());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("artistsList-view.fxml"));
        HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
    }

    @FXML
    void audios_Action(ActionEvent event) throws IOException {
        Detail.lastScene.push(HelloApplication.getStage().getScene());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("audiosList-view.fxml"));
        HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
    }

    @FXML
    void back_Action(ActionEvent event) {
        backTo();
    }

    @FXML
    void home_Action(ActionEvent event) throws IOException {
        Detail.lastScene.push(HelloApplication.getStage().getScene());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
        HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
    }

    @FXML
    void library_Action(ActionEvent event) throws IOException {
        if(Detail.login) {
            Detail.lastScene.push(HelloApplication.getStage().getScene());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("accountInfo-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }
        else{
            try {
                throw new InaccessibilityException();
            }catch (InaccessibilityException e){
                error_text.setText(e.getMessage());
            }
        }
    }

    @FXML
    void login_Action(ActionEvent event) throws IOException {
        try {
            login();
        }catch (InaccessibilityException e){
            error_text.setText(e.getMessage());
        }
    }

    @FXML
    void logout_Action(ActionEvent event) throws IOException {
        try {
            logout();
        }catch (InaccessibilityException e){
            error_text.setText(e.getMessage());
        }
    }

    @FXML
    void next_Action(MouseEvent event) {
        Audio audio = ListenerController.getListenerController().nextAudioFile();
        playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        NameMusic_text.setText(audio.getName());
        NameArtist_text.setText(audio.getNameArtist());
        image.setImage(new Image("file:"+audio.getCover()));
    }

    @FXML
    void playPause_Action(MouseEvent event) {
        if (Detail.getDetail().pause)
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        else
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/play.png")));
        Audio audio = ListenerController.getListenerController().playPauseAudioFile();
        NameMusic_text.setText(audio.getName());
        NameArtist_text.setText(audio.getNameArtist());
        image.setImage(new Image("file:"+audio.getCover()));
    }

    @FXML
    void previous_Action(MouseEvent event) {
        Audio audio = ListenerController.getListenerController().previousAudioFile();
        playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        NameMusic_text.setText(audio.getName());
        NameArtist_text.setText(audio.getNameArtist());
        image.setImage(new Image("file:"+audio.getCover()));
    }

    @FXML
    void register_Action(ActionEvent event) throws IOException {
        try {
            register();
        }catch (InaccessibilityException e){
            error_text.setText(e.getMessage());
        }
    }

    @FXML
    void search_Action(ActionEvent event) throws IOException {
        search(search_Text.getText());
    }

    @FXML
    void mainRegister_Action(ActionEvent event) throws IOException {
        try {
            ArtistController.getArtistController().registration("S",username_text.getText(),password_text.getText(),name_text1.getText(),email_text.getText(),number_text.getText(),year_text.getText(),month_text.getText(),day_text.getText(),bio_text.getText());
            Detail.singer=true;
            Detail.login=true;
            Detail.lastScene.push(HelloApplication.getStage().getScene());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }catch (InvalidFormatException | OtherException | NumberFormatException e){
            error_text.setText(e.getMessage());
        }finally {
            error_text.setText(error_text.getText()+"\nHave a good day");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Detail.lastScene.empty())
            back_button.setTextFill(Paint.valueOf("ffffff81"));
        if(Detail.getDetail().play)
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        else
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/play.png")));
        next_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/next.png")));
        previous_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/previous.png")));
    }
}
