package model.UserAccount.Listener;

import model.Audio.Audio;
import model.Genre;
import model.Playlist;
import model.UserAccount.Listener.Listener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Free extends Listener
{
    private final ArrayList<Playlist> playlists = new ArrayList<Playlist>(3);
    private final ArrayList<Audio> audio = new ArrayList<Audio>(10);
    public Free(String userName, String passWord, String name, String email, String phoneNumber,String year,String month,String day ,Genre[] genres,String type) {
        super(userName,passWord,name,email,phoneNumber,year,month,day);
    }
    @Override
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
    public ArrayList<Audio> getAudio() {
        return audio;
    }
    @Override
    public String toString()
    {
        return "UserName: " + getUserName()+"\t"+"PassWord: "+getPassWord()+"\t"+"Name: "+getName()+"\t"+"Email: "+getEmail()+"\t"+"PhoneNumber: "+getPhoneNumber()+"\t"+"Birth Date: "+getDateOfBirth()+"\t"+"Favorite Genres: "+getGenres();
    }
}
