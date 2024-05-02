package org.example.musicplayer_phase2.view.AboutArtists;

import org.example.musicplayer_phase2.controller.AboutArtist.ArtistController;
import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutHumans.Podcaster;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.view.Start;
import org.example.musicplayer_phase2.view.UserView;

import java.util.Scanner;

public class ArtistView extends UserView {
    Artist artist;
    Podcaster podcaster;
    Singer singer;
    ArtistController artistController = new ArtistController();
    Scanner get = new Scanner(System.in);
    public void login(String username, String password) {
        System.out.println(artistController.login(username, password));
        PodcasterView podcasterView = new PodcasterView();
        SingerView singerView = new SingerView();
        if (!(artistController.login(username, password).equals("Your panel founded ")))
            Start.start();
        else
        {
            artist = artistController.artist;
            if (artist instanceof Podcaster) {
                podcaster = (Podcaster) artist;
                podcasterView.podcasterInstructions(podcaster);
            }
            else if (artist instanceof Singer) {
                singer = (Singer) artist;
                singerView.SingerInstructions (singer);
            }
        }
    }
    public void signupPodcaster(String name, String username, String password, String email, String number, String birthday, String biography) {
        PodcasterView podcasterView = new PodcasterView();
        podcaster = new Podcaster(name, username, password, email, number, birthday, biography);
        checking(number, password, email, username, birthday , podcaster);

        artistController.signup(podcaster);
        System.out.println(artistController.signup(podcaster) );

        podcasterView.podcasterInstructions(podcaster);
    }

    public void signupSinger(String name, String username, String password, String email, String number, String birthday, String biography) {
        SingerView singerView = new SingerView();
        singer = new Singer(name, username, password, email, number, birthday, biography);
        checking(number, password, email, username, birthday , singer);

        artistController.signup(singer);
        System.out.println(artistController.signup(singer));

        singerView.SingerInstructions (singer);
    }
}
