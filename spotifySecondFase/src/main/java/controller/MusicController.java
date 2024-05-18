package controller;

import model.Audio.Music;
import model.Audio.Podcast;
import model.Genre;

public class MusicController extends ArtistController
{
    Music music;
    public Music publishMusic(String name, Genre genre, String caption, String link, String cover)
    {
        music =publishMusic(name,genre,caption,link,cover);
        return music;
    }
}
