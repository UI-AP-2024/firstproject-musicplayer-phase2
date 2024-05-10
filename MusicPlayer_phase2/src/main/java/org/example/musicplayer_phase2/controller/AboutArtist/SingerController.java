package org.example.musicplayer_phase2.controller.AboutArtist;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.model.AboutMusic.Album;
import org.example.musicplayer_phase2.model.AboutMusic.Music;

public class SingerController extends ArtistController {

    public void makeNewAlbum(Album album , Singer singer)
    {
        singer.setAllAlbums(album);
    }

    public void musicPublication(Music music , Album album , Singer singer)
    {
        album.setAllMusics(music);
    }

    public static Singer singerLogin(String username , String password){
        Singer singer1 = null;
        for (Singer a : Database.allSingers){
            if (a.getUsername().equals(username) && a.getPassword().equals(password))
                singer1 = a;
        }
        return singer1;
    }

    public String watchIncome (Singer singer)
    {
        double income = 0;
        for (Album a : singer.getAllAlbums())
        {
            for (Music b : a.getAllMusics())
            {
                income += b.getPlaysNum() * 0.4;
            }
        }
        singer.setIncome(income);
        return "Your income: " + singer.getIncome();
    }

    public String watchInformation (Singer singer)
    {
        double income = 0;
        for (Album a : singer.getAllAlbums())
        {
            for (Music b : a.getAllMusics())
            {
                income += b.getPlaysNum() * 0.4;
            }
        }
        singer.setIncome(income);
        return "your income: " + singer.getIncome() +"\n" + "username: "+singer.getUsername() + "\npassword: " +singer.getPassword();
    }

    public StringBuilder watchPlaysNumber (Singer singer)
    {
        StringBuilder result = new StringBuilder();
        for (Album a : singer.getAllAlbums())
        {
            result.append("album: " + a.getName() + "\tidentifier: " + a.getIdentifier() + "\n");
            for (Music b : a.getAllMusics())
            {
                result.append(b.getAudioName() + ": " + b.getPlaysNum() + "\n");
            }
        }

        return result;
    }

    public StringBuilder watchFollowers (Singer singer)
    {
        return singer.getFollowers();
    }
}