package org.example.musicplayer_phase2.View.SidebarItems.Slider;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.Informations.PlayMusicPage;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.Database;

import java.util.ArrayList;

import static org.example.musicplayer_phase2.View.Informations.PlayMusicPage.*;
import static org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic.*;

public class PutSlider{
    public static Slider getSlider() {
        return slider;
    }

    private static Slider slider = new Slider();
    private Label play_pauseMusicLabel = new Label("PLAY");
    private Label nextLabel = new Label("NEXT");
    private Label lastLabel = new Label("LAST");
    private HBox hBoxForLabels = new HBox(lastLabel , play_pauseMusicLabel , nextLabel);
    private VBox baseVBox = new VBox();
    public VBox getBaseVBox() {
        makingReady();
        return baseVBox;
    }

    private void makingReady(){
        hBoxForLabels.setSpacing(20);
        hBoxForLabels.setAlignment(Pos.CENTER);

        baseVBox.getChildren().addAll(slider , hBoxForLabels);

        nextLabel.setPrefSize(50 , 25);
        lastLabel.setPrefSize(50 , 25);
        play_pauseMusicLabel.setPrefSize(75 , 25);
        play_pauseMusicLabel.setAlignment(Pos.CENTER);
        nextLabel.setAlignment(Pos.CENTER);
        lastLabel.setAlignment(Pos.CENTER);

        if (getMediaPlayer() != null){
            if (getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING){
                play_pauseMusicLabel.setText("PAUSE");
            }
        }

        play_pauseMusicLabelActions();
        nextLabelActions();
        lastLabelActions();
    }

    private void play_pauseMusicLabelActions(){
        if (getMediaPlayer() != null) {
            play_pauseMusicLabel.setOnMouseClicked(e -> {
                if (getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                    play_pauseMusicLabel.setText("PLAY");
                    stopPlaying();
                } else {
                    play_pauseMusicLabel.setText("PAUSE");
                    startPlaying();
                }
            });
        }
        play_pauseMusicLabel.setOnMouseEntered(e -> {
            play_pauseMusicLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
        });
        play_pauseMusicLabel.setOnMouseExited(e -> {
            play_pauseMusicLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        });
    }

    private void nextLabelActions(){
        nextLabel.setOnMouseClicked(e -> {
            PlayMusic.nextMusic();
        });
        nextLabel.setOnMouseEntered(e -> {
            nextLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
        });
        nextLabel.setOnMouseExited(e -> {
            nextLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        });
    }

    private void lastLabelActions(){
        lastLabel.setOnMouseClicked(e -> {
            PlayMusic.lastMusic();
        });
        lastLabel.setOnMouseEntered(e -> {
            lastLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
        });
        lastLabel.setOnMouseExited(e -> {
            lastLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        });
    }

}
