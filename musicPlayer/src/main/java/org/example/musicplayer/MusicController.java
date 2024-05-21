package org.example.musicplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

public class MusicController implements Initializable {

    //MediaPlayer mediaPlayer = new MediaPlayer(HelloApplication.currentMusic = HelloApplication.musics.get(0));
    @FXML
    private Label artist;

    @FXML
    private Button btn_addTo;

    @FXML
    private ToggleButton btn_like;

    @FXML
    private Circle btn_next;

    @FXML
    private Circle btn_pp;

    @FXML
    private Circle btn_pre;

    @FXML
    private ImageView cover;

    @FXML
    private Slider slider;

    @FXML
    private Label text;

    @FXML
    private Label title;

    @FXML
    void addTo_action(ActionEvent event) {

    }

    @FXML
    void like_action(ActionEvent event) {

    }



    @FXML
    void next_event(MouseEvent event) {
//        if (HelloApplication.index == 3)
//            HelloApplication.index = 0;
//        else HelloApplication.index++;
//        if (HelloApplication.index == 0)
//            lbl_name.setText("MUSIC 1");
//        else if (HelloApplication.index == 1)
//            lbl_name.setText("MUSIC 2");
//        else if (HelloApplication.index == 2)
//            lbl_name.setText("MUSIC 3");
//        else
//            lbl_name.setText("MUSIC 4");
        //HelloApplication.currentMusic = HelloApplication.musics.get(HelloApplication.index);
//        if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED || mediaPlayer.getStatus() == MediaPlayer.Status.READY) {
//            mediaPlayer = new MediaPlayer(HelloApplication.currentMusic);
//        }
//        else {
//            mediaPlayer.stop();
//            mediaPlayer = new MediaPlayer(HelloApplication.currentMusic);
//            mediaPlayer.play();
//            String path = HelloApplication.class.getResource("images/pause.png").toExternalForm();
//            Image image = new Image(path);
//            ImagePattern imagePattern = new ImagePattern(image);
//            play_cicrle.setFill(imagePattern);
//        }

    }

    @FXML
    void play_event(MouseEvent event) {
//        if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED || mediaPlayer.getStatus() == MediaPlayer.Status.READY) {
//            mediaPlayer.play();
//            String path = HelloApplication.class.getResource("images/pause.png").toExternalForm();
//            Image image = new Image(path);
//            ImagePattern imagePattern = new ImagePattern(image);
//            play_cicrle.setFill(imagePattern);
//            isPlaying = false;
//        }
//        else {
//            mediaPlayer.pause();
//            String path = HelloApplication.class.getResource("images/play.jpg").toExternalForm();
//            Image image = new Image(path);
//            ImagePattern imagePattern = new ImagePattern(image);
//            play_cicrle.setFill(imagePattern);
//        }
    }

    @FXML
    void pre_event(MouseEvent event) {
//        if (HelloApplication.index == 0)
//            HelloApplication.index = 3;
//        else HelloApplication.index--;
//        if (HelloApplication.index == 0)
//            lbl_name.setText("MUSIC 1");
//        else if (HelloApplication.index == 1)
//            lbl_name.setText("MUSIC 2");
//        else if (HelloApplication.index == 2)
//            lbl_name.setText("MUSIC 3");
//        else
//            lbl_name.setText("MUSIC 4");
//        HelloApplication.currentMusic = HelloApplication.musics.get(HelloApplication.index);
//        if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED || mediaPlayer.getStatus() == MediaPlayer.Status.READY) {
//            mediaPlayer = new MediaPlayer(HelloApplication.currentMusic);
//        }
//        else {
//            mediaPlayer.stop();
//            mediaPlayer = new MediaPlayer(HelloApplication.currentMusic);
//            mediaPlayer.play();
//            String path = HelloApplication.class.getResource("images/pause.png").toExternalForm();
//            Image image = new Image(path);
//            ImagePattern imagePattern = new ImagePattern(image);
//            play_cicrle.setFill(imagePattern);
//        }
//        isPlaying = false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path1 = HelloApplication.class.getResource("images/play.jpg").toExternalForm();
        Image image1 = new Image(path1);
        ImagePattern imagePattern1 = new ImagePattern(image1);
        btn_pp.setFill(imagePattern1);
        String path2 = HelloApplication.class.getResource("images/next.png").toExternalForm();
        Image image2 = new Image(path2);
        ImagePattern imagePattern2 = new ImagePattern(image2);
        btn_next.setFill(imagePattern2);
        String path3 = HelloApplication.class.getResource("images/pre.png").toExternalForm();
        Image image3 = new Image(path3);
        ImagePattern imagePattern3 = new ImagePattern(image3);
        btn_pre.setFill(imagePattern3);
        //----------------------------------------
        title.setText("");
        //--------------------------------------
    }
}
