package org.example.phase2.Model.Users;
import org.example.phase2.Model.Audios.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Podcaster extends Artist{
    private ArrayList<Podcast> podcasts;

    public Podcaster(String username, String password, String firstAndLastName, String emailAddress, String phoneNumber, Date birthDate, String biography) throws ParseException {
        super(username, password, firstAndLastName, emailAddress, phoneNumber, birthDate,biography);
        podcasts=new ArrayList<Podcast>();
    }

    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        return info.toString();
    }
}
