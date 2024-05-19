package org.example.musicap.Controllers;

import javafx.geometry.Pos;
import org.example.musicap.Models.Audio.Podcast;
import org.example.musicap.Models.Genre;
import org.example.musicap.Models.User.Podcaster;

import java.time.LocalDate;
import java.util.ArrayList;

public class PodcasterController extends ArtistController{

    public PodcasterController(Podcaster podcasterModel)
    {
        super(podcasterModel);
    }
    public void publishPodcast(String title, Genre genre, String caption, String link, String cover)
    {
        Podcaster podcasterModel = (Podcaster) this.getArtistModel();
        Podcast podcast = new Podcast(title, this.getArtistModel().getName(), 0, 0, LocalDate.now(), genre, link, cover, caption);
        ArrayList<Podcast> podcasts = podcasterModel.getPodcasts();
        podcasts.add(podcast);
        this.getDatabase().getAudios().add(podcast);
    }

    public double calculateIncome()
    {
        int playedCount = getPlayedCount();
        this.getArtistModel().setIncome(0.5 * playedCount);
        return this.getArtistModel().getIncome();
    }
}
