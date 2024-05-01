package controller;

import model.AboutHumans.Admin;
import model.AboutHumans.Artist;
import model.AboutMusic.Audio;
import model.Database;
import view.Start;

import java.util.Comparator;

public class AdminController {
    static Admin admin;
    public static String login (String username , String password)
    {
        if (Start.admin.getUsername().equals(username) && Start.admin.getPassword().equals(password)) {
            admin = Admin.getAdmin();
            return "welcome :)";
        }
        else
            return "You aren't admin ";
    }

    public StringBuilder watchFavoriteAudios ()
    {
        StringBuilder favoriteAudios = new StringBuilder();
        Comparator<Audio> compare = Comparator
                        .comparingInt((Audio a) -> a.getLikesNum()).reversed();

        Database.allAudios.stream().sorted(compare).forEach(n -> favoriteAudios.append( "view: "+ n.getPlaysNum() + "\n" + n.toString() + "\n"));

        return favoriteAudios;
    }

    public StringBuilder watchAllArtistInformation()
    {
        StringBuilder artists = new StringBuilder();
        Database.allArtists.stream().forEach(n -> artists.append(n.toString() + "\n"));
        return artists;
    }

    public StringBuilder artistInformation(String username)
    {
        StringBuilder info = new StringBuilder();
        Artist artist = null;
        for (Artist a : Database.allArtists)
        {
            if (a.getUsername().equals(username))
                artist = a;
        }

        if (artist == null)
            info.append("artist not found");
        else
            info.append(artist);

        return info;
    }

    public StringBuilder watchAllAudiosInformation()
    {
        StringBuilder audios = new StringBuilder();
        Database.allAudios.stream().forEach(n -> audios.append(n.getAudioName() + "\n" + n.getIdentifier() + "\n"));
        return audios;
    }

    public StringBuilder audioInformation(long ID)
    {
        StringBuilder audioInfo = new StringBuilder();
        Audio audio = UserAccountController.findAudio(ID);
        if (audio == null)
            audioInfo.append("audio not found");
        else
        {
            audioInfo.append(audio.toString());
        }
        return audioInfo;
    }

    public StringBuilder watchReports()
    {
        StringBuilder reports = new StringBuilder();
        Database.allReports.stream().forEach(n -> reports.append(n.toString() + "\n"));
        return reports;
    }

    public String watchAccountInformation()
    {
        return admin.toString() + "number: " +admin.getNumber() + "\nusername: " + admin.getUsername()+ "\npassword: " + admin.getPassword() + "\n";
    }
}
