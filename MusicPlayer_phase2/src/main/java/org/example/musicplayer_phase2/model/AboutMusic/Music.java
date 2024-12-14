package org.example.musicplayer_phase2.model.AboutMusic;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.time.LocalDate;

public class Music extends Audio {
    private String lyrics;
    public Music(String audioName, String artistName, LocalDate publicationDate, Genre genre, String audioLink, String cover, String lyrics) {
        super(audioName, artistName, publicationDate, genre, audioLink, cover);
        this.lyrics = lyrics;
        setAudioNumbers(getAudioNumbers() + 1);
        Database.setAllMusics(this);
    }

    public String getLyrics() {
        return lyrics;
    }

    @Override
    public String toString()
    {
        return super.toString() + "type: music\n";
    }
}
