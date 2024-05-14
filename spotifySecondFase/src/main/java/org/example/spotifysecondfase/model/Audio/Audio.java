package org.example.spotifysecondfase.model.Audio;

import org.example.spotifysecondfase.model.Genre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class Audio
{
    private static int i=0;
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
    private int playsCount;
    public int getPlaysCount() {
        return playsCount;
    }
    public void setPlaysCount(int playsCount) {
        this.playsCount = playsCount;
    }
    private int likesCount;
    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }
    private Date date ;
    private Genre genre;
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    private String audioLink;
    public String getAudioLink() {
        return audioLink;
    }
    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }
    private String cover;
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    String id;
    public Audio(String name,Genre genre,String artistName, Date date, String audioLink, String cover) {
        this.artistName = artistName;
        this.date = date;
        this.genre = genre;
        this.name = name;
        this.audioLink = audioLink;
        this.cover = cover;
        this.id = this.name + i++;
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public String toString()
    {
        return "Audio name : "+getName() + "Audio genre : "+getGenre()+"Audio artist name : "+getArtistName();
    }

}
