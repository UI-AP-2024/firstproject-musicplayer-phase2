package org.example.musicplayer_phase2.controller.AboutArtist;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Podcaster;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.model.AboutMusic.Podcast;

public class PodcasterContrller extends ArtistController {
    Podcaster podcaster = super.podcaster;

    public void podcastPublication (Podcast podcast , Podcaster podcaster)
    {
        podcaster.setAllPodcasts(podcast);
    }

    public static Podcaster podcasterLogin(String username , String password){
        Podcaster podcaster1 = null;
        for (Podcaster a : Database.allPodcaster){
            if (a.getUsername().equals(username) && a.getPassword().equals(password))
                podcaster1 = a;
        }
        return podcaster1;
    }

    public String watchIncome (Podcaster podcaster)
    {
        double income = 0;
        for (Podcast a : podcaster.getAllPodcasts())
            income += a.getPlaysNum()*0.5;
        podcaster.setIncome(income);
        return "Your income: " + podcaster.getIncome();
    }

    public String watchInformation (Podcaster podcaster)
    {
        double income = 0;
        for (Podcast a : podcaster.getAllPodcasts())
            income += a.getPlaysNum()*0.5;
        podcaster.setIncome(income);
        return "your income: " + podcaster.getIncome() +"\n" + "username: "+podcaster.getUsername() + "\npassword: " +podcaster.getPassword() + "\n";
    }

    public StringBuilder watchPlaysNumber (Podcaster podcaster)
    {
        StringBuilder result = new StringBuilder();
        for (Podcast a : podcaster.getAllPodcasts())
        {
            result.append(a.getAudioName() + ": " + a.getPlaysNum() + "\n");
        }
        return result;
    }

    public StringBuilder watchFollowers (Podcaster podcaster)
    {
        return podcaster.getFollowers();
    }
}
