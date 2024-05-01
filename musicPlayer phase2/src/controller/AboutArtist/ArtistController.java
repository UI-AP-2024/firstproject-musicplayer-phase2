package controller.AboutArtist;

import controller.UserAccountController;
import model.AboutHumans.*;
import model.Database;

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
