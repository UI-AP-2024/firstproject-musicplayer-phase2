package controller;

import model.Album;
import model.Audio.Audio;
import model.Database;
import model.UserAccount.Artist.Artist;
import model.UserAccount.Artist.Podcaster;
import model.UserAccount.UserAccount;

import java.util.ArrayList;
import java.util.Date;

public class ArtistController extends UserAccountController
{
    public static Artist artist;
    private static ArtistController artistController;
    public Artist artist(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day, String biography)
    {
        artist = new Artist(userName,passWord,name,email,phoneNumber,year,month,day,biography);
        Database.getDatabase().getUserAccounts().add(artist);
        return artist;
    }

    public static ArtistController getArtistController()
    {
        if (artistController == null)
        {
            artistController = new ArtistController();
        }
        return artistController;
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
    ArrayList<Audio> audios = new ArrayList<>();
    public ArrayList<Audio> artistAudios(Artist artist)
    {
        for (Audio a : Database.getDatabase().getAudio())
        {
            if (a.getArtistName().equals(artist.getName()))
            {
                audios.add(a);
            }
        }
        return audios;
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
