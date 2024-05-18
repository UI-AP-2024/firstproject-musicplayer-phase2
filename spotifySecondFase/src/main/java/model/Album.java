package model;

import model.Audio.Music;

import java.util.ArrayList;

public class Album
{
    private static int j = 0;
    public static int getJ() {return j;}
    public static void setJ(int j) {Album.j = j;}
    private String id;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String artistName;
    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    ArrayList<Music> album = new ArrayList<Music>();
    public ArrayList<Music> getAlbum() {
        return album;
    }
    public void setAlbum(ArrayList<Music> album) {
        this.album = album;
    }
    public Album(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
        this.id = this.name + j++;
    }
    @Override
    public String toString()
    {
        return "AlbumName: "+getName()+"\t"+"Artist of album: "+getArtistName();
    }
}

