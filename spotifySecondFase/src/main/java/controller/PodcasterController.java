package controller;

import model.Audio.Podcast;
import model.Genre;
import controller.ArtistController;

public class PodcasterController extends ArtistController {
    Podcast podcast;
    public Podcast publishPodcast(String name, Genre genre, String caption, String link, String cover)
    {
        podcast =publishPodcast(name,genre,caption,link,cover);
        return podcast;
    }
}
