package org.example.musicplayerphase2.model.AboutHumans;

import org.example.musicplayerphase2.model.*;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;

import java.util.ArrayList;

public class Artist extends org.example.musicplayer_phase2.model.AboutHumans.UserAccount {
    public Artist(String name,String username ,String password, String email, String number, String birthday , String biography) {
        super(name,username ,password, email, number, birthday);
        this.biography = biography;
        org.example.musicplayer_phase2.model.Database.setAllArtists(this);
    }
    private double income = 0;
    private ArrayList<org.example.musicplayer_phase2.model.AboutHumans.UserAccount> followers = new ArrayList<>();
    private String biography;
    private ArrayList<Audio> allAudios = new ArrayList<>();
    public double getIncome() {
        return income;
    }

    public StringBuilder getFollowers() {
        StringBuilder followers = new StringBuilder();
        for (org.example.musicplayer_phase2.model.AboutHumans.UserAccount a : this.followers)
            followers.append(a.getName() + "\n");
        return followers;
    }

    public String getBiography() {
        return biography;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setFollowers(UserAccount follower) {
        this.followers.add(follower);
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString()
    {
        return super.toString() + "biography: " + this.biography + "\n";
    }
}
