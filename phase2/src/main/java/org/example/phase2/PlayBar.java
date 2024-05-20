package org.example.phase2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.example.phase2.Model.Audios.Audio;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayBar implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label audioName;

    @FXML
    private ImageView next;

    @FXML
    private ImageView playOrPause;

    @FXML
    private ImageView previous;
    private Media music1;
    private MediaPlayer mediaPlayer1;
    private static int index=0;

    private static boolean musicIsPlaying=false;

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        PlayBar.index = index;
    }

    private static ArrayList<Audio> audios;

    public static ArrayList<Audio> getAudios() {
        return audios;
    }

    public static void setAudios(ArrayList<Audio> audios) {
        PlayBar.audios = audios;
    }

    @FXML
    void nextAction(MouseEvent event) {
        mediaPlayer1.pause();
        if(index==audios.size()-1){
            index=0;
            MusicPageController.setAudio(audios.get(index));
            //MusicPageController.musicSetter();
            audioName.setText(audios.get(index).getName());
            music1=new Media(audios.get(index).getLinkOfAudioFile());
            mediaPlayer1=new MediaPlayer(music1);
            mediaPlayer1.play();
        }
        else{
            audioName.setText(audios.get(++index).getName());
            MusicPageController.setAudio(audios.get(index));
            //MusicPageController.musicSetter();
            music1=new Media(audios.get(index).getLinkOfAudioFile());
            mediaPlayer1=new MediaPlayer(music1);
            mediaPlayer1.play();
        }
    }

    @FXML
    void previousAction(MouseEvent event) {
        mediaPlayer1.pause();
        if(index==0){
            index=audios.size()-1;
            MusicPageController.setAudio(audios.get(index));
            //MusicPageController.musicSetter();
            audioName.setText(audios.get(index).getName());
            music1=new Media(audios.get(index).getLinkOfAudioFile());
            mediaPlayer1=new MediaPlayer(music1);
            mediaPlayer1.play();
        }
        else{
            audioName.setText(audios.get(--index).getName());
            //MusicPageController.musicSetter();
            MusicPageController.setAudio(audios.get(index));
            music1=new Media(audios.get(index).getLinkOfAudioFile());
            mediaPlayer1=new MediaPlayer(music1);
            mediaPlayer1.play();
        }
    }
    @FXML
    void playAction(MouseEvent event) {
        if(!musicIsPlaying){
            musicIsPlaying=true;
            audioName.setText(audios.get(index).getName());
            music1=new Media(audios.get(index).getLinkOfAudioFile());
            mediaPlayer1=new MediaPlayer(music1);
            mediaPlayer1.play();
            String photoAddress =PlayBar.class.getResource("photos/pause.jpg").toExternalForm();
            Image image=new Image(photoAddress);
            playOrPause.setImage(image);
        }
        else{
            musicIsPlaying=false;
            mediaPlayer1.pause();
            String photoAddress =PlayBar.class.getResource("photos/play icon.jpg").toExternalForm();
            Image image=new Image(photoAddress);
            playOrPause.setImage(image);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(musicIsPlaying){
            String photoAddress =PlayBar.class.getResource("photos/pause.jpg").toExternalForm();
            Image image=new Image(photoAddress);
            playOrPause.setImage(image);
        }else{
            String photoAddress =PlayBar.class.getResource("photos/play icon.jpg").toExternalForm();
            Image image=new Image(photoAddress);
            playOrPause.setImage(image);
        }
    }
}