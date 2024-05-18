package model.Audio;

import model.Audio.Audio;
import model.Genre;

import java.time.LocalDate;
import java.util.Date;

public abstract class Podcast extends Audio
{
    private String caption;
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public Podcast(String name, Genre genre, String artistName, Date date, String caption, String audioLink, String cover) {
        super(name,genre,artistName,date,audioLink,cover);
        this.caption = caption;
    }
}
