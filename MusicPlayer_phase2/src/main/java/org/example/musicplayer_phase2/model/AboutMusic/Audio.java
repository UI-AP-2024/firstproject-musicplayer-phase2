package org.example.musicplayer_phase2.model.AboutMusic;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public abstract class Audio implements Comparable<Audio>{
    private static int audioNumbers = 0;
    private long identifier;
    private final String audioName;
    private final String artistUsername;
    private int playsNum;
    private int likesNum;
    private LocalDate publicationDate;
    private final Genre genre;
    private final String audioLink;
    private final String cover;

    public Audio(String audioName, String artistUserName, LocalDate publicationDate, Genre genre, String audioLink, String cover) {
        this.audioName = audioName;
        this.artistUsername = artistUserName;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.audioLink = audioLink;
        this.cover = cover;

        String identifier = "";

        switch (genre) {
            case ROCK: {
                identifier = "1";
                break;
            }

            case POP: {
                identifier = "2";
                break;
            }

            case JAZZ: {
                identifier = "3";
                break;
            }

            case HIPHOP: {
                identifier = "4";
                break;
            }

            case COUNTRY: {
                identifier = "5";
                break;
            }

            case TRUECRIME: {
                identifier = "6";
                break;
            }

            case SOCIETY: {
                identifier = "7";
                break;
            }

            case INTERVIEW: {
                identifier = "8";
                break;
            }

            case HISTORY: {
                identifier = "9";
                break;
            }
        }

        identifier += String.format("%04d", audioNumbers);
        this.identifier = Integer.valueOf(identifier);

        Database.setAllAudios(this);
    }

    public static int getAudioNumbers() {
        return audioNumbers;
    }

    public long getIdentifier() {
        return identifier;
    }

    public String getAudioName() {
        return audioName;
    }

    public String getArtistUsername() {
        return artistUsername;
    }

    public int getPlaysNum() {
        return playsNum;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public LocalDate getPublicationDateName() {
        return publicationDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public String getCover() {
        return cover;
    }

    public static void setAudioNumbers(int audioNumbers) {
        Audio.audioNumbers = audioNumbers;
    }

    public void setPlaysNum(int playsNum) {
        this.playsNum = playsNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }

    @Override
    public String toString() {
        return "artists name: " + artistUsername +"\nidentifier: " + identifier + "\naudio name: "
                + audioName + "\nlink: " + audioLink + "\ngenre: " + genre + "\ncover: " + cover
                + "\npublication date: " + getPublicationDateName() + "\n";
    }

    @Override
    public int compareTo(Audio audio) {
        if(audio.audioName.compareTo(this.audioName) == 0){
            if (audio.likesNum == this.likesNum){
                if (audio instanceof Music && this instanceof Music){
                    if (audio.playsNum < this.playsNum)
                        return 1;
                    else if (audio.playsNum > this.playsNum)
                        return -1;
                }

                else {
                    if (audio instanceof Podcast && this instanceof Music)
                        return 1;
                    else
                        return -1;
                }
            }

            else {
                if (audio.likesNum < this.likesNum){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        }

        else {
            if (audio.audioName.compareTo(this.audioName) < 0)
                return 1;

            else if (audio.audioName.compareTo(this.audioName) > 0)
                return -1;
        }

        return 0;
    }
}
