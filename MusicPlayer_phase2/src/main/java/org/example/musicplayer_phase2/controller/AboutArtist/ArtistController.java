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

}
