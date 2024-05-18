package org.example.spotifysecondfase.model.UserAccount.Artist;

import org.example.spotifysecondfase.model.Audio.Podcast;
import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Podcaster extends Artist {

    private ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
    public Podcaster(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day, String biography) {
        super(userName, passWord, name, email, phoneNumber, year,month,day, biography);
    }
    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }
    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
    @Override
    public String toString() {
        return "UserName: " + getUserName() + "\t" + "PassWord: " + getPassWord() + "\t" + "Name: " + getName() + "\t" + "Email: " + getEmail() + "\t" + "PhoneNumber: " + getPhoneNumber() + "\t" + "Birth Date: " + getDateOfBirth() + "\t" + "Biography: " + getBiography();
    }
}
