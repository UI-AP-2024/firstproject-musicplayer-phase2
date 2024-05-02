package org.example.musicplayer_phase2.view.AboutListener;

import org.example.musicplayer_phase2.controller.AboutLIstener.PremiumController;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;
import org.example.musicplayer_phase2.model.Types.Premium;
import org.example.musicplayer_phase2.model.Types.PremiumType;

public class PremiumView extends ListenerView {
    PremiumController premiumController = new PremiumController();
    public void addMusicToPlaylist (String playlistName , long audioID , Premium premiumUser)
    {
        Playlist playlist = null;
        Audio audio;
        boolean foundPlaylist = false ;
        for (Playlist a : premiumUser.getAllPlaylists())
        {
            if (a.getPlaylistName().equals(playlistName))
            {
                foundPlaylist = true;
                playlist = a;
            }
        }
        audio = UserAccountController.findAudio(audioID);
        if (!foundPlaylist)
            System.out.println("Playlist not found");
        else if (audio == null)
            System.out.println("audio not found");
        else
        {
            premiumController.addMusicToPlaylist(playlist , audio , premiumUser);
            System.out.println("you add the music to " + playlistName);
        }
    }

    public void newPlaylist(String name , Listener listener)
    {
        System.out.println(premiumController.makePlaylist(name , listener));
    }

    public void getPremium (PremiumType premiumType , Listener listener)
    {
        System.out.println(premiumController.buySubscription(premiumType , listener));
    }

    public void endPremium (Listener listener)
    {
        System.out.println(premiumController.watchEndOfSubscription());
    }
}
