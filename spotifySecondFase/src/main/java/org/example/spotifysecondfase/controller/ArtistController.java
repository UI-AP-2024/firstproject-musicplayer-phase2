package org.example.spotifysecondfase.controller;

import org.example.spotifysecondfase.model.Album;
import org.example.spotifysecondfase.model.Audio.Audio;
import org.example.spotifysecondfase.model.Database;
import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;
import org.example.spotifysecondfase.model.UserAccount.Artist.Podcaster;
import org.example.spotifysecondfase.model.UserAccount.UserAccount;

import java.util.ArrayList;
import java.util.Date;

public class ArtistController extends UserAccountController
{
    Artist artist;
    public Artist artist(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day, String biography)
    {
        artist = new Artist(userName,passWord,name,email,phoneNumber,year,month,day,biography);
        Database.getDatabase().getUserAccounts().add(artist);
        return artist;
    }
    public String showFollowers()
    {
        return String.valueOf(artist.getFollowers());
    }
    public String showPlaysAudio()
    {
        ArrayList<String> info = new ArrayList<>();
        for (Audio a : Database.getDatabase().getAudio())
        {
            if (a.getArtistName().equals(artist.getName()))
            {
                info.add(a.getName() + a.getPlaysCount());
            }
        }
        return String.valueOf(info);
    }
    Album album;
    public void newAlbum(String albumName)
    {
        album = new Album(albumName,artist.getName());
    }
    public String tostring(){
    return artist.getName()+"\t"+artist.getUserName()+"\t"+artist.getPassWord()+"\t"+artist.getEmail()+"\t"+artist.getPhoneNumber()+"\t"+artist.getDateOfBirth()+"\t"+artist.getBiography();
    }


}
