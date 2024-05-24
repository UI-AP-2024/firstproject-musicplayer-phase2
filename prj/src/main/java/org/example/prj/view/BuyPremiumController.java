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
import org.example.prj.exception.CreditExeption;
import org.example.prj.exception.InaccessibilityException;
import org.example.prj.model.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BuyPremiumController implements Initializable , GeneralOperations {

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
    private ImageView image;

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

    private String typeBuy = "";

    @FXML
    void selectOne_Action(ActionEvent event) {
        typeBuy = "ONE_MONTH";
        selectOne_button.setStyle("-fx-background-color: #00c4c8");
        selectTwo_button.setStyle("-fx-background-color: #012c2c");
        selectThree_button.setStyle("-fx-background-color: #012c2c");
    }

    @FXML
    void selectThree_Action(ActionEvent event) {
        typeBuy = "SIX_MONTH";
        selectThree_button.setStyle("-fx-background-color: #00c4c8");
        selectTwo_button.setStyle("-fx-background-color: #012c2c");
        selectOne_button.setStyle("-fx-background-color: #012c2c");
    }

    @FXML
    void selectTwo_Action(ActionEvent event) {
        typeBuy = "TWO_MONTH";
        selectTwo_button.setStyle("-fx-background-color: #00c4c8");
        selectOne_button.setStyle("-fx-background-color: #012c2c");
        selectThree_button.setStyle("-fx-background-color: #012c2c");
    }

    @FXML
    void buy_Action(ActionEvent event) throws IOException {
        try {
            String result = ListenerController.getListenerController().getPremium(typeBuy);
            Detail.lastScene.push(HelloApplication.getStage().getScene());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("accountInfo-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }catch (CreditExeption e){
            error_text.setText(e.getMessage());
        }finally {
            error_text.setText(error_text.getText()+"\nHave a good day");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectOne_button.setStyle("-fx-background-color: #012c2c");
        selectTwo_button.setStyle("-fx-background-color: #012c2c");
        selectThree_button.setStyle("-fx-background-color: #012c2c");
        selectOne_button.setTextFill(Paint.valueOf("white"));
        selectTwo_button.setTextFill(Paint.valueOf("white"));
        selectThree_button.setTextFill(Paint.valueOf("white"));
        ArrayList<String> al = ListenerController.getListenerController().showPremium();
        pkgOneName_text.setText(al.get(0));
        priceOne_text.setText(al.get(1)+"$");
        pkgTwoName_text.setText(al.get(2));
        priceTwo_text.setText(al.get(3)+"$");
        pkgThreeName_text.setText(al.get(4));
        priceThree_text.setText(al.get(5)+"$");
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
