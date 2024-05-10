package org.example.phase2.Model.Users;
import org.example.phase2.Model.Audios.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Listener extends UserAccount{

    private long credit;
    private ArrayList<Playlist> playlists;
    private Map<Audio,Integer> numberOfPlayingEachAudio;
    private LocalDate endOfAccount=null;
    private ArrayList<Genre> interestedGenres;
    private int numberOfInterestedGenres=0;
    private ArrayList<Audio> likedAudios;
    private ArrayList<Artist> followings;
    private ArrayList<Audio> playedAudios;
    public Listener(String username, String password, String firstAndLastName, String emailAddress, String phoneNumber, Date birthDate) throws ParseException {
        super(username, password, firstAndLastName, emailAddress, phoneNumber, birthDate);
        numberOfPlayingEachAudio=new HashMap<>();
        interestedGenres=new ArrayList<Genre>();
        playlists=new ArrayList<Playlist>();
        likedAudios=new ArrayList<Audio>();
        followings=new ArrayList<Artist>();
        playedAudios=new ArrayList<Audio>();
    }

    public long getCredit() {
        return credit;
    }

    public LocalDate getEndOfAccount() {
        return endOfAccount;
    }

    public ArrayList<Genre> getInterestedGenres() {
        return interestedGenres;
    }

    public Map<Audio, Integer> getNumberOfPlayingEachAudio() {
        return numberOfPlayingEachAudio;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public int getNumberOfInterestedGenres() {
        return numberOfInterestedGenres;
    }

    public ArrayList<Audio> getLikedAudios() {
        return likedAudios;
    }

    public ArrayList<Artist> getFollowings() {
        return followings;
    }

    public ArrayList<Audio> getPlayedAudios() {
        return playedAudios;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public void setEndOfAccount(LocalDate endOfAccount) {
        this.endOfAccount = endOfAccount;
    }

    public void setInterestedGenres(ArrayList<Genre> interestedGenres) {
        this.interestedGenres = interestedGenres;
    }

    public void setNumberOfPlayingEachAudio(Map<Audio, Integer> numberOfPlayingEachAudio) {
        this.numberOfPlayingEachAudio = numberOfPlayingEachAudio;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void setNumberOfInterestedGenres(int numberOfInterestedGenres) {
        this.numberOfInterestedGenres = numberOfInterestedGenres;
    }

    public void setLikedAudios(ArrayList<Audio> likedAudios) {
        this.likedAudios = likedAudios;
    }

    public void setFollowings(ArrayList<Artist> followings) {
        this.followings = followings;
    }

    public void setPlayedAudios(ArrayList<Audio> playedAudios) {
        this.playedAudios = playedAudios;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        info.append("Credit: "+credit+"\t");
        info.append("Interested genres: "+interestedGenres+"\n");
        return info.toString();
    }
}
