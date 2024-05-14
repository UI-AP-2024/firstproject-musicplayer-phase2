package org.example.spotifysecondfase.controller;

import org.example.spotifysecondfase.model.Audio.Podcast;
import org.example.spotifysecondfase.model.Genre;
import org.example.spotifysecondfase.controller.ArtistController;

public class PodcasterController extends ArtistController {
    Podcast podcast;
    public Podcast publishPodcast(String name, Genre genre, String caption, String link, String cover)
    {
        podcast =publishPodcast(name,genre,caption,link,cover);
        return podcast;
    }
}
