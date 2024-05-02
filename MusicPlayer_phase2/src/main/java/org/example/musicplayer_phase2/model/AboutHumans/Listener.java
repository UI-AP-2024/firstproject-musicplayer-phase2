package org.example.musicplayer_phase2.model.AboutHumans;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.util.*;

public class Listener extends UserAccount {
    public Listener(String name, String username, String password, String email, String number, String birthday) {
        super(name, username, password, email, number, birthday);
    }

    private double credit = 0;
    private Date endSubscription;
    private ArrayList<Playlist> allPlaylists = new ArrayList<>();
    private ArrayList<Genre> favoriteGenre = new ArrayList<>();
    private ArrayList<Artist> followingArtists = new ArrayList<>();
    private ArrayList<Audio> likedAudios = new ArrayList<>();
    private Map<Audio , Integer> filesNumber = new HashMap<>();
    //GETTERS.....................................................
    public double getCredit() {
        return credit;
    }

    public StringBuilder getEndSubscription() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endSubscription);
        StringBuilder str = new StringBuilder();
        str.append(calendar.get(Calendar.DAY_OF_MONTH));
        str.append("/");
        str.append(calendar.get(Calendar.MONTH ) + 1);
        str.append("/");
        str.append(calendar.get(Calendar.YEAR));
        return str;
    }

    public StringBuilder getAllPlaylistsName() {
        StringBuilder allPlaylists = new StringBuilder();
        for (Playlist a : this.allPlaylists)
            allPlaylists.append( a.getPlaylistName()+ "\n");
        return allPlaylists;
    }

    public StringBuilder getFavoriteGenreName() {
        StringBuilder favoriteGenre = new StringBuilder();
        for (Genre a : this.favoriteGenre)
            favoriteGenre.append(a + "\n");
        return favoriteGenre;
    }

    public StringBuilder getFilesNumberName() {
        StringBuilder filesNumber = new StringBuilder();
        for (Map.Entry<Audio , Integer> a : this.filesNumber.entrySet())
            filesNumber.append("file : " + a.getKey() + "\tnumber: " + a.getValue());
        return filesNumber;
    }

    public Map<Audio, Integer> getFilesNumber() {
        return filesNumber;
    }

    public ArrayList<Audio> getLikedAudios() {
        return likedAudios;
    }
    public ArrayList<Playlist> getAllPlaylists() {
        return allPlaylists;
    }

    public ArrayList<Artist> getFollowingArtists() {
        return followingArtists;
    }

    public ArrayList<Genre> getFavoriteGenre() {
        return favoriteGenre;
    }

    //setters.................................................................
    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setOneLikedAudios(Audio likedAudio) {
        this.likedAudios.add(likedAudio);
    }

    public void setOnePlaylists(Playlist playlists) {
        this.allPlaylists.add(playlists);
    }

    public void setOneFavoriteGenre(Genre favoriteGenre) {
        this.favoriteGenre.add(favoriteGenre);
    }

    public void setOneFilesNumber(Audio audio) {
        this.filesNumber.putIfAbsent(audio , 0);
        Integer currentValue = this.filesNumber.get(audio);
        currentValue++;
        this.filesNumber.put(audio , currentValue );
    }

    public void setOneFollowingArtists(Artist artist) {
        this.followingArtists.add(artist);
    }

    public void setAllPlaylists(ArrayList<Playlist> allPlaylists) {
        this.allPlaylists = allPlaylists;
    }

    public void setFavoriteGenre(ArrayList<Genre> favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public void setFollowingArtists(ArrayList<Artist> followingArtists) {
        this.followingArtists = followingArtists;
    }

    public void setLikedAudios(ArrayList<Audio> likedAudios) {
        this.likedAudios = likedAudios;
    }

    public void setFilesNumber(Map<Audio, Integer> filesNumber) {
        this.filesNumber = filesNumber;
    }

    public void setEndSubscription(Date endSubscription) {
        this.endSubscription = endSubscription;
    }
}
