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
import org.example.prj.controller.AdminController;
import org.example.prj.controller.ArtistController;
import org.example.prj.controller.ListenerController;
import org.example.prj.controller.LoginController;
import org.example.prj.model.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginVController implements Initializable {

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
    private Button home_button;

    @FXML
    private ImageView image;

    @FXML
    private Button library_button;

    @FXML
    private Button mainLogin_Button;

    @FXML
    private Button login_button;

    @FXML
    private Button logout_button;

    @FXML
    private TextField name_text;

    @FXML
    private Circle next_button;

    @FXML
    private TextField pass_text;

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
        HelloApplication.getStage().setScene(Detail.lastScene.pop());
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
            //exception
        }
    }

    @FXML
    void login_Action(ActionEvent event) throws IOException {
        if(Detail.login) {
            //exception
        }
        else{
            Detail.lastScene.push(HelloApplication.getStage().getScene());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }
    }

    @FXML
    void logout_Action(ActionEvent event) throws IOException {
        if(Detail.login) {
            Detail.lastScene.removeAllElements();
            Detail.login = false;
            if (Detail.listener){
                Detail.listener=false;
                ListenerController.getListenerController().setUserAccount(null);
            }
            else if (Detail.podcaster){
                Detail.podcaster=false;
                ArtistController.getArtistController().setUserAccount(null);
            }
            else if (Detail.singer){
                Detail.singer=false;
                ArtistController.getArtistController().setUserAccount(null);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }
        else {
            //exception
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
        if(Detail.login){
            //exception
        }else {
            Detail.lastScene.push(HelloApplication.getStage().getScene());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerType-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }
    }

    @FXML
    void search_Action(ActionEvent event) throws IOException {
        Detail.getDetail().search = ListenerController.getListenerController().searchAudioFile(search_Text.getText());
        Detail.lastScene.push(HelloApplication.getStage().getScene());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("search-view.fxml"));
        HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
    }

    @FXML
    void mainLogin_Action() throws IOException {
        String type = LoginController.getLoginController().typeLog(name_text.getText());
        String result;
        if(type.equals("Admin")){
            result = AdminController.getAdminController().login(name_text.getText(),pass_text.getText());
            if (result.equals("Login successfully")){
                Detail.login=true;
                Detail.admin=true;
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
                Detail.lastScene.push(HelloApplication.getStage().getScene());
                HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
            }
            else {
                //exception
            }
        }
        else if(type.equals("Artist")){
            result = ArtistController.getArtistController().login(name_text.getText(),pass_text.getText());
            if (result.equals("Login successfully singer")){
                Detail.login=true;
                Detail.singer=true;
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
                Detail.lastScene.push(HelloApplication.getStage().getScene());
                HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
            }
            else if (result.equals("Login successfully podcaster")){
                Detail.login=true;
                Detail.podcaster=true;
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
                Detail.lastScene.push(HelloApplication.getStage().getScene());
                HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
            }
            else {
                //exception
            }
        }
        else if(type.equals("Listener")){
            result = ListenerController.getListenerController().login(name_text.getText(),pass_text.getText());
            if (result.equals("Login successfully")){
                Detail.login=true;
                Detail.listener=true;
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
                Detail.lastScene.push(HelloApplication.getStage().getScene());
                HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
            }
            else {
                //exception
            }
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




