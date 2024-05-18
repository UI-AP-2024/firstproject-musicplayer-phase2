package org.example.musicplayer_phase2.controller.PlayingAudios;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.example.musicplayer_phase2.View.Informations.PlayMusicPage;
import org.example.musicplayer_phase2.View.SidebarItems.Slider.PutSlider;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;

import java.util.ArrayList;

import static org.example.musicplayer_phase2.View.Informations.PlayMusicPage.*;

public class PlayMusic {
    public static Audio audio;
    private static Media media;
    private static MediaPlayer mediaPlayer;

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    private static ArrayList<Audio> allMedias = new ArrayList<>();

    public static void setAllMedias(ArrayList<Audio> allMedias1) {
        allMedias = allMedias1;
    }

    public static void setAudio(Audio getAudio) {
        if (mediaPlayer != null){
            if (getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING){
                mediaPlayer.stop();
            }
        }

        audio = getAudio;
        media = new Media(audio.getAudioLink());
        musicNumber = allMedias.indexOf(audio);
        mediaPlayer = new MediaPlayer(media);
    }

    public static void startPlaying(){
        if (media != null) {
            try {
                getMediaPlayer().play();
                getMediaPlayer().currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                    PutSlider.getSlider().setValue(newValue.toSeconds());
                });

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("fail in playing");
                alert.setContentText("audio not found");
                alert.showAndWait();
            }
        }

        getMediaPlayer().setOnEndOfMedia( () -> {
            nextMusic();
        });
    }

    public static void stopPlaying(){
        mediaPlayer.pause();
    }

    private static int musicNumber;

    public static void nextMusic(){
        musicNumber++;
        if (allMedias.size() <= musicNumber){
            musicNumber %= allMedias.size();
        }

        else if (musicNumber < 0){
            musicNumber = allMedias.size() + musicNumber % allMedias.size();
        }

        setAudio(allMedias.get(musicNumber));
        startPlaying();
    }

    public static void lastMusic (){
        musicNumber--;
        if (allMedias.size() <= musicNumber){
            musicNumber %= allMedias.size();
        }

        else if (musicNumber < 0){
            musicNumber = allMedias.size() + musicNumber % allMedias.size();
        }

        setAudio(allMedias.get(musicNumber));
        startPlaying();
    }

    public static Audio getAudio() {
        return audio;
    }

    public static Media getMedia() {
        return media;
    }

    public static void setMedia(Media media) {
        PlayMusic.media = media;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        PlayMusic.mediaPlayer = mediaPlayer;
    }

    public static ArrayList<Audio> getAllMedias() {
        return allMedias;
    }

    public static int getMusicNumber() {
        return musicNumber;
    }

    public static void setMusicNumber(int musicNumber) {
        PlayMusic.musicNumber = musicNumber;
    }
}
