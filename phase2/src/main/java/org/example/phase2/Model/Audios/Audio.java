package org.example.phase2.Model.Audios;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

abstract public class Audio implements Comparable{
    private long id;
    private static long audioCounter=0;
    private String name;
    private String artist;
    private long numberOfListening=0;
    private long likes=0;
    private LocalDate launchDate;
    private Genre genre;
    private String linkOfAudioFile;
    private String cover;
    public Audio(String name,String artist,Genre genre,String linkOfAudioFile,String cover){
        this.name=name;
        this.id=audioCounter++;
        this.artist=artist;
        this.genre=genre;
        this.linkOfAudioFile=linkOfAudioFile;
        this.cover=cover;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.launchDate=LocalDate.now();
    }

    public String getArtist() {
        return artist;
    }

    public String getCover() {
        return cover;
    }

    public Genre getGenre() {
        return genre;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public long getId() {
        return id;
    }

    public long getLikes() {
        return likes;
    }

    public String getLinkOfAudioFile() {
        return linkOfAudioFile;
    }

    public String getName() {
        return name;
    }

    public long getNumberOfListening() {
        return numberOfListening;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public void setLinkOfAudioFile(String linkOfAudioFile) {
        this.linkOfAudioFile = linkOfAudioFile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfListening(long numberOfListening) {
        this.numberOfListening = numberOfListening;
    }
    @Override
    public String toString()
    {
//        StringBuilder info=new StringBuilder("Audio's information: \n");
        StringBuilder info=new StringBuilder();
        info.append("Name: "+name+"\t");
        info.append("Artist: "+artist+"\t");
        info.append("Genre: "+genre.name()+"\t");
        info.append("ID: "+id+"\t");
        info.append("Plays: "+numberOfListening+"\t");
        info.append("Likes: "+likes+"\t");
        info.append("Link: "+linkOfAudioFile+"\t");
        info.append("Cover: "+cover+"\n");
        return info.toString();
    }
    @Override
    public int compareTo(Object o){
        Audio audio=(Audio) o;
        if(this.name.compareTo(audio.name)<0)
            return 1;
        if(this.name.compareTo(audio.name)>0)
            return -1;
        if(this.likes>audio.likes)
            return 1;
        if(this.likes<audio.likes)
            return -1;
        if(this instanceof Music && audio instanceof Podcast)
            return 1;
        if(this instanceof Podcast && audio instanceof Music)
            return -1;
        return Long.compare(this.numberOfListening, audio.numberOfListening);
    }
}
