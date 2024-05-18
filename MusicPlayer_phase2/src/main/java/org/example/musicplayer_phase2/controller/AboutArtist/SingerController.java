package org.example.musicplayer_phase2.controller.AboutArtist;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.model.AboutMusic.Album;
import org.example.musicplayer_phase2.model.AboutMusic.Music;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.time.LocalDate;

public class SingerController extends ArtistController {

    public void makeNewAlbum(Album album , Singer singer)
    {
        singer.setAllAlbums(album);
    }

    public void musicPublication(Singer singer , String name , LocalDate publicationDate , Genre genre , String link , String cover , String lyrics , String albumName){
        Music music = new Music(name , singer.getName() , publicationDate , genre , link , cover , lyrics);
        Album album = null;
        for (Album a : singer.getAllAlbums()){
            if (a.getName().equals(albumName)){
                album = a;
            }
        }
        if (album == null){
            album = new Album(albumName , singer.getName());
            makeNewAlbum(album , singer);
        }
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