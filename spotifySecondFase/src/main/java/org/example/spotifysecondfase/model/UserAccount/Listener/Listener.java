package org.example.spotifysecondfase.model.UserAccount.Listener;

import org.example.spotifysecondfase.model.Genre;
import org.example.spotifysecondfase.model.Playlist;
import org.example.spotifysecondfase.model.UserAccount.UserAccount;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Listener extends UserAccount
{
    private int accountCredit;
    private Date expirationDate;
    private Genre[] genres = new Genre[4];
    private ArrayList<Playlist> playlists = new ArrayList<Playlist>();
    private Map<String,Integer> map = new HashMap<>();
    private StringBuilder following = new StringBuilder();
    public Listener(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day,Genre[] genres) {
        super(userName,passWord,name,email,phoneNumber,year,month,day);
        this.genres = genres;
    }
    public int getAccountCredit() {
        return accountCredit;
    }
    public void setAccountCredit(int accountCredit) {
        this.accountCredit = accountCredit;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public Genre[] getGenres() {
        return genres;
    }
    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }
    public Map<String, Integer> getMap() {
        return map;
    }
    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
    public StringBuilder getFollowing() {
        return following;
    }
    public void setFollowing(String following) {
        this.following = new StringBuilder(following);
    }
    @Override
    public String toString()
    {
        return "UserName: " + getUserName()+"\t"+"PassWord: "+getPassWord()+"\t"+"Name: "+getName()+"\t"+"Email: "+getEmail()+"\t"+"PhoneNumber: "+getPhoneNumber()+"\t"+"Birth Date: "+getDateOfBirth()+"\t"+"Favorite Genres: "+getGenres();
    }
}
