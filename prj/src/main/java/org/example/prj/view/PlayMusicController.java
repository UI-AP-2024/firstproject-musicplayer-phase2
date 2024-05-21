package org.example.prj.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.example.prj.HelloApplication;
import org.example.prj.controller.ListenerController;
import org.example.prj.model.Audio;
import org.example.prj.model.Music;
import org.example.prj.model.Podcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayMusicController implements Initializable {

    @FXML
    private Button addTo_button;

    @FXML
    private Button back_button;

    @FXML
    private Text caption_text;

    @FXML
    private Circle image_circle;

    @FXML
    private ImageView likeRed_image;

    @FXML
    private ImageView likeWhite_image;

    @FXML
    private Text nameArtist_text;

    @FXML
    private Text name_text;

    @FXML
    private Circle next_button;

    @FXML
    private Circle playPause_button;

    @FXML
    private Circle previous_button;

    @FXML
    private ProgressBar progressBar;

    @FXML
    void back_Action(ActionEvent event) {
        if(!Detail.lastScene.empty())
            HelloApplication.getStage().setScene(Detail.lastScene.pop());
    }

    @FXML
    void likeRed_Action(MouseEvent event) {
        //nothing
    }

    @FXML
    void likeWhite_Action(MouseEvent event) {
        likeRed_image.setVisible(true);
        ListenerController.getListenerController().likeAudioFile(Detail.selectAudio.getId());
    }

    @FXML
    void next_Action(MouseEvent event) {
        Audio audio = ListenerController.getListenerController().nextAudioFile();
        playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        name_text.setText(audio.getName());
        nameArtist_text.setText(audio.getNameArtist());
        image_circle.setFill(new ImagePattern(new Image("file:"+audio.getCover())));
    }

    @FXML
    void playPause_Action(MouseEvent event) {
        if (Detail.getDetail().pause)
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        else
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/play.png")));
        Audio audio = ListenerController.getListenerController().playPauseAudioFile();
        name_text.setText(audio.getName());
        nameArtist_text.setText(audio.getNameArtist());
        image_circle.setFill(new ImagePattern(new Image("file:"+audio.getCover())));
    }

    @FXML
    void previous_Action(MouseEvent event) {
        Audio audio = ListenerController.getListenerController().previousAudioFile();
        playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        name_text.setText(audio.getName());
        nameArtist_text.setText(audio.getNameArtist());
        image_circle.setFill(new ImagePattern(new Image("file:"+audio.getCover())));
    }

    @FXML
    void addTo_Action(ActionEvent event) throws IOException {
        Detail.lastScene.push(HelloApplication.getStage().getScene());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addToPlayList-view.fxml"));
        HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Detail.selectAudio instanceof Music){
            caption_text.setText(((Music) Detail.selectAudio).getMusicText());
        }else{
            caption_text.setText(((Podcast) Detail.selectAudio).getCaption());
        }
        name_text.setText(Detail.selectAudio.getName());
        nameArtist_text.setText(Detail.selectAudio.getNameArtist());
        image_circle.setFill(new ImagePattern(new Image("file:"+Detail.selectAudio.getCover())));
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
