package org.example.prj.view;


import  java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.example.prj.HelloApplication;
import org.example.prj.controller.ArtistController;
import org.example.prj.controller.ListenerController;
import org.example.prj.controller.MediaController;
import org.example.prj.model.Audio;
import org.example.prj.model.Database;

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
        if(!Detail.lastScene.empty())
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Audio> audios;
        if(!Detail.login)
            audios = ListenerController.getListenerController().sortAudioFile("L");
        else
            audios = ListenerController.getListenerController().suggestions();
        int j=0;
        for (Audio audio : audios) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("slotOfGridPinAudio-view.fxml"));
            try {
                SlotOfGridPinAudioView controller = fxmlLoader.getController();
                try {
                    controller.setData(audio.getNameArtist(), audio.getName(),"file:" + audio.getCover());
                }catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }
                Node node = fxmlLoader.load();
                gridPain.add(node, 0, j++);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            gridPain.getChildren().getLast().setOnMouseClicked(e ->{
                if(Detail.getDetail().random){
                    Detail.getDetail().play=true;
                    Detail.getDetail().pause=false;
                    Detail.getDetail().random=true;
                    Detail.getDetail().playList=false;
                    Detail.getDetail().countRandom= Database.getDataBase().getAudio().indexOf(audio);
                }else {
                    Detail.getDetail().play=true;
                    Detail.getDetail().pause=false;
                    Detail.getDetail().random=false;
                    Detail.getDetail().playList=true;
                    Detail.getDetail().countPlayList= (int) audio.getId();
                    Detail.getDetail().countPlayList = ListenerController.getListenerController().selectPlaylist(Detail.selectPlayList).indexOf(audio);
                }
                Detail.lastScene.push(HelloApplication.getStage().getScene());
                FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("playMusic-view.fxml"));
                Detail.selectAudio = audio;
                try {
                    HelloApplication.getStage().setScene(new Scene(fxmlLoader1.load()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
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
