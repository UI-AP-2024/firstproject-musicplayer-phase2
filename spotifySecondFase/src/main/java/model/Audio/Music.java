package model.Audio;

import model.Audio.Audio;
import model.Genre;

import java.time.LocalDate;
import java.util.Date;

public abstract class Music extends Audio
{
    private String lyrics;
    public String getLyrics() {
        return lyrics;
    }
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
    public Music(String name, Genre genre, String artistName, Date date ,String lyrics, String audioLink, String cover) {
        super(name,genre,artistName,date,audioLink,cover);
        this.lyrics = lyrics;
    }
}
