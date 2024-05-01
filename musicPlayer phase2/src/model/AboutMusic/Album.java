package model.AboutMusic;

import java.util.ArrayList;

public class Album {
    private final String identifier;
    private static int albumNumber = 0 ;
    private final String albumName ;
    private final String singerName;
    private ArrayList<Music> allMusics = new ArrayList<>();

    public Album(String name, String singerName) {
        this.albumName = name;
        this.singerName = singerName;
        identifier = albumName + String.format("%03d" , albumNumber);
        ++albumNumber;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return albumName;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getAllMusicsName() {
        String allMusics = "";
        for (Music a : this.allMusics)
            allMusics += a.getAudioName() + "\n";
        return allMusics;
    }

    public ArrayList<Music> getAllMusics() {
        return allMusics;
    }

    public void setAllMusics(Music music) {
        this.allMusics.add(music);
    }

    @Override
    public String toString()
    {
        return "identifier: " + identifier +"\nalbum name: " + albumName + "\nsingers name: "+ singerName + "\n";
    }
}
