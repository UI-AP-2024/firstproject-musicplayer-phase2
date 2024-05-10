package org.example.phase2.Model.Audios;
import org.example.phase2.Model.*;
import java.util.ArrayList;

public class Album{
    private long id;
    private static long albumCounter=0;
    private String name;
    private String artistName;
    private ArrayList<Music> musicArrayList;
    public Album(String name,String artistName){
        this.name=name;
        this.artistName=artistName;
        this.id=albumCounter++;
        musicArrayList=new ArrayList<Music>();
    }

    public static long getAlbumCounter() {
        return albumCounter;
    }

    public String getArtistName() {
        return artistName;
    }

    public long getId() {
        return id;
    }

    public ArrayList<Music> getMusicArrayList() {
        return musicArrayList;
    }

    public String getName() {
        return name;
    }

    public static void setAlbumCounter(long albumCounter) {
        Album.albumCounter = albumCounter;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMusicArrayList(ArrayList<Music> musicArrayList) {
        this.musicArrayList = musicArrayList;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder("Information of album: \n");
        info.append("Name: "+name+"\n");
        info.append("Artist: "+artistName+"\n");
        info.append("ID: "+id+"\n");
        return info.toString();
    }
}

