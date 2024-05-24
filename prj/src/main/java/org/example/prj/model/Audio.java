package org.example.prj.model;

import java.util.Date;

public abstract class Audio implements Comparable<Audio> {
    private long id;
    private String name;
    private String nameArtist;
    private int numberOfPlays;
    private int numberOfLikes;
    private Date dateOfRelease;
    private Gener gener;
    private String audioLink;
    private String cover;
    private static int countId=0;

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        Audio.countId = countId;
    }

    @Override
    public String toString(){
        String result = "";
        result += "Audio Id: "+getId()+"\tAudio Name: "+getName()+"\tArtist name: "+getNameArtist()+"\tPlays: "+getNumberOfPlays()+"\tLike: "+getNumberOfLikes()+"\tDate of release: "+String.valueOf(getDateOfRelease())+"\tGener: "+String.valueOf(getGener())+"\tLink: "+getAudioLink()+"\tCover: "+getCover();
        return result;
    }

    @Override
    public int compareTo(Audio secAudio){
//        int result = this.getName().compareTo(secAudio.getName());
//        if(result!=0)
//            return result;
        int result = this.getNumberOfLikes()-secAudio.getNumberOfLikes();
        if(result!=0)
            return result;
        if(this instanceof Music && secAudio instanceof Podcast)
            return 1;
        else if(this instanceof Podcast && secAudio instanceof Music)
            return -1;
        result = this.getNumberOfPlays() - secAudio.getNumberOfPlays();
        return result;
    }

    public Audio(long id, String name, String nameArtist, Date dateOfRelease, Gener gener, String audioLink, String cover) {
        this.id = id;
        this.name = name;
        this.nameArtist = nameArtist;
        this.numberOfPlays = 0;
        this.numberOfLikes = 0;
        this.dateOfRelease = dateOfRelease;
        this.gener = gener;
        this.audioLink = audioLink;
        this.cover = cover;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public int getNumberOfPlays() {
        return numberOfPlays;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public Gener getGener() {
        return gener;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public String getCover() {
        return cover;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public void setNumberOfPlays(int numberOfPlays) {
        this.numberOfPlays = numberOfPlays;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        dateOfRelease = dateOfRelease;
    }

    public void setGener(Gener gener) {
        this.gener = gener;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}

