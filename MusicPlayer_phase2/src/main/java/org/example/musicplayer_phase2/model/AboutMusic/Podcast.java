package org.example.musicplayer_phase2.model.AboutMusic;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.Types.Genre;

public class Podcast extends Audio {
    String caption = "";
    public Podcast(String audioName, String artistName, String publicationDate, Genre genre, String audioLink, String cover , String caption) {
        super(audioName, artistName, publicationDate, genre, audioLink, cover);
        this.caption = caption;
        setAudioNumbers(getAudioNumbers() + 1);
        Database.setAllPodcasts(this);
    }

    public String getCaption() {
        return caption;
    }

    @Override
    public String toString()
    {
        return super.toString() + "type: podcast\n";
    }
}
