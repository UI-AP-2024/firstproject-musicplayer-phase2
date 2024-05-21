package org.example.musicplayer.model;

import org.example.musicplayer.model.Audio.AudioModel;
import java.util.ArrayList;

public class PlaylistModel {
    private static int tempID = 0;
    private final int id;
    private String playlistName;
    private String creatorName;
    private ArrayList<AudioModel> audios;

    public PlaylistModel(String playlistName, String creatorName) {
        this.id = ++tempID;
        this.playlistName = playlistName;
        this.creatorName = creatorName;
        this.audios = new ArrayList<AudioModel>();
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", playlistName = " + playlistName;
    }

    public int getId() {
        return id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public ArrayList<AudioModel> getAudios() {
        return audios;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setAudios(ArrayList<AudioModel> audios) {
        this.audios = audios;
    }

}
