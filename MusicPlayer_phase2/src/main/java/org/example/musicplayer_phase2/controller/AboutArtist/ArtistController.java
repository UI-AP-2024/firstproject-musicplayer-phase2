package org.example.musicplayer_phase2.controller.AboutArtist;

import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutHumans.Podcaster;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.model.AboutHumans.UserAccount;
import org.example.musicplayer_phase2.model.Exceptions.FailedLoginException;
import org.example.musicplayer_phase2.model.Exceptions.UserNotFoundException;
import org.example.musicplayer_phase2.model.Exceptions.WrongPasswordException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArtistController extends UserAccountController {
    public Artist artist;
    Podcaster podcaster;
    Singer singer;

    public String signup (Artist artist)
    {
        this.artist = artist;
        if (artist instanceof Podcaster)
        {
            podcaster = (Podcaster) artist;
        }

        else if (artist instanceof Singer)
        {
            singer = (Singer) artist;
        }
        return "welcome:)";
    }

    public static ArrayList<Artist> sortArtistsBasedOnFollowers (){
        Collections.sort(Database.allArtists, new Comparator<Artist>() {
            @Override
            public int compare(Artist o1, Artist o2) {
                if (o1.getArraylistOfFollowers().size() > o2.getArraylistOfFollowers().size())
                    return -1;
                else if (o1.getArraylistOfFollowers().size() < o2.getArraylistOfFollowers().size())
                    return 1;
                else
                    return 0;
            }
        });
        return Database.allArtists;
    }

}
