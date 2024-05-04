package org.example.musicplayer_phase2.model.AboutHumans;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutMusic.Podcast;

import java.time.LocalDate;
import java.util.ArrayList;

public class Podcaster extends Artist {
    public Podcaster(String name, String username, String password, String email, String number, LocalDate birthday, String biography) {
        super(name, username, password, email, number, birthday, biography);
        Database.setAllPodcaster(this);
    }

    private ArrayList<Podcast> allPodcasts = new ArrayList<>();

    public StringBuilder getAllPodcastsName() {
        StringBuilder allPodcasts = new StringBuilder();
        for (Podcast a : this.allPodcasts)
            allPodcasts.append(a.getAudioName() + "\n");
        return allPodcasts;
    }

    public ArrayList<Podcast> getAllPodcasts() {
        return allPodcasts;
    }

    public void setAllPodcasts(Podcast podcast) {
        this.allPodcasts.add(podcast);
    }

    @Override
    public String toString()
    {
        return super.toString() + this.getAllPodcastsName();
    }
}
