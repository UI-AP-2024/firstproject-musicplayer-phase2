package org.example.musicplayer_phase2.controller.AboutArtist;

import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutHumans.Podcaster;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.model.AboutHumans.UserAccount;

public class ArtistController extends UserAccountController {
    public Artist artist;
    Podcaster podcaster;
    Singer singer;
    public String login (String username , String password)
    {
        boolean found = false;
        boolean foundUsername = false;
        boolean foundPassword = false;
        for (UserAccount a : Database.allUsers)
        {
            if (a.getUsername().equals(username) && a.getPassword().equals(password) && a instanceof Artist)
            {
                artist = (Artist) a;
                found = true;
                break;
            }

            else if (a.getPassword().equals(password) && !a.getUsername().equals(username)&& a instanceof Artist)
            {
                foundPassword = true;
            }

            else if (a.getUsername().equals(username) && !a.getPassword().equals(password) && a instanceof Artist) {
                foundUsername = true;
            }
        }

        if (found)
            return "Your panel founded ";
        else
        {
            if (foundPassword && !foundUsername)
                return "Username is incorrect ";
            else if (foundUsername && !foundPassword)
                return "Password is incorrect ";
            else
                return "This panel is not exist ";
        }
    }

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
