package model.AboutMusic;

import model.Database;

public class Music extends Audio {
    private String lyrics;
    public Music(String audioName, String artistName, String publicationDate, String genre, String audioLink, String cover, String lyrics) {
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
