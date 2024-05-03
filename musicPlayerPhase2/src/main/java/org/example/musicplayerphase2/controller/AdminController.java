package org.example.musicplayer_phase2.controller;

import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.model.AboutHumans.Admin;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.Exceptions.FailedLoginException;
import org.example.musicplayer_phase2.model.Exceptions.UserNotFoundException;
import org.example.musicplayer_phase2.model.Exceptions.WrongPasswordException;
import org.example.musicplayer_phase2.model.*;

import java.util.Comparator;

public class AdminController {
    static Admin admin;
    public static String login (String username , String password) throws FailedLoginException {
        if (HelloApplication.admin.getUsername().equals(username) && HelloApplication.admin.getPassword().equals(password)) {
            admin = Admin.getAdmin();
            return "welcome :)";
        }
        else if (HelloApplication.admin.getUsername().equals(username))
            throw new UserNotFoundException();
        else if (HelloApplication.admin.getPassword().equals(password))
            throw new WrongPasswordException();
        else
            throw new FailedLoginException("user not exist");
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
