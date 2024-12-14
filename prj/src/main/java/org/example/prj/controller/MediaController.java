package org.example.prj.controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.example.prj.model.Database;
import org.example.prj.view.Detail;

public class MediaController {

    private static MediaController mediaController;

    private MediaController() {
    }

    public static MediaController getMediaController() {
        if (mediaController == null)
            mediaController = new MediaController();
        return mediaController;
    }


    public MediaPlayer mediaPlayer = new MediaPlayer(new Media(Database.getDataBase().getAudio().get(Detail.getDetail().countRandom).getAudioLink()));
}
