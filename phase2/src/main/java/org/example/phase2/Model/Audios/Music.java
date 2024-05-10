package org.example.phase2.Model.Audios;

public class Music extends Audio{
    private String lyric;

    public Music(String name, String artist, Genre genre, String linkOfAudioFile, String cover,String lyric) {
        super(name, artist, genre, linkOfAudioFile, cover);
        this.lyric=lyric;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        info.append("Lyric: "+lyric+"\n");
        return info.toString();
    }
}
