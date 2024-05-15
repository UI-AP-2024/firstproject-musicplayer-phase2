package org.example.musicplayer.model.Audio;

import org.example.musicplayer.model.GenreModel;
import java.time.LocalDate;

public abstract class AudioModel {
    private static int tempID = 0;
    private final int id;
    private String audioTitle;
    private String artistName;
    private int playsCount;
    private int likesCount;
    private final LocalDate releaseDate;
    private GenreModel genre;
    private String audioLink;
    private String cover;

    public AudioModel(String audioTitle, String artistName, LocalDate releaseDate, GenreModel genre, String audioLink, String cover) {
        this.id = ++tempID;
        this.audioTitle = audioTitle;
        this.artistName = artistName;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.audioLink = audioLink;
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", AudioTitle = " + audioTitle +
                ", ArtistName = " + artistName +
                ", PlaysCount = " + playsCount +
                ", LikesCount = " + likesCount +
                ", ReleaseDate = " + releaseDate +
                ", Genre = " + genre +
                ", AudioLink = " + audioLink +
                ", Cover = " + cover;
    }

    public int getId() {
        return id;
    }

    public String getAudioTitle() {
        return audioTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getPlaysCount() {
        return playsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public GenreModel getGenre() {
        return genre;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public String getCover() {
        return cover;
    }

    public void setPlaysCount(int playsCount) {
        this.playsCount = playsCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public void setAudioTitle(String audioTitle) {
        this.audioTitle = audioTitle;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setGenre(GenreModel genre) {
        this.genre = genre;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
