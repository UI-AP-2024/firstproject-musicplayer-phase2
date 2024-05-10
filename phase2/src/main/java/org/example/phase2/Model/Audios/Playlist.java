package org.example.phase2.Model.Audios;

import java.util.ArrayList;

public class Playlist{
    private long id;
    private static long playlistCounter=0;
    private String nameOfPlaylist;
    private String creatorName;
    private ArrayList<Audio> audioList;
    public Playlist(String nameOfPlaylist,String creatorName)
    {
        this.id=playlistCounter++;
        this.nameOfPlaylist=nameOfPlaylist;
        this.creatorName=creatorName;
        this.audioList=new ArrayList<Audio>();
    }

    public ArrayList<Audio> getAudioList() {
        return audioList;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public long getId() {
        return id;
    }

    public String getNameOfPlayList() {
        return nameOfPlaylist;
    }

    public void setAudioList(ArrayList<Audio> audioList) {
        this.audioList = audioList;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNameOfPlayList(String nameOfPlaylist) {
        this.nameOfPlaylist = nameOfPlaylist;
    }
    @Override
    public String toString()
    {
//        StringBuilder info=new StringBuilder("Playlist's information: \n");
        StringBuilder info=new StringBuilder();
        info.append("Name: "+nameOfPlaylist+"\t");
        info.append("ID: "+id+"\n");
        return info.toString();
    }
}

