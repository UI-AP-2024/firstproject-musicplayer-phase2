package org.example.phase2.Model.Audios;

public class Podcast extends Audio{
    private String caption;

    public Podcast(String name, String artist, Genre genre, String linkOfAudioFile, String cover,String caption) {
        super(name,artist, genre, linkOfAudioFile, cover);
        this.caption=caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        info.append(caption);
        return info.toString();
    }
}

