package org.example.spotifysecondfase.controller;

import org.example.spotifysecondfase.model.Audio.Music;
import org.example.spotifysecondfase.model.Audio.Podcast;
import org.example.spotifysecondfase.model.Genre;

public class MusicController extends ArtistController
{
    Music music;
    public Music publishMusic(String name, Genre genre, String caption, String link, String cover)
    {
        music =publishMusic(name,genre,caption,link,cover);
        return music;
    }
}
