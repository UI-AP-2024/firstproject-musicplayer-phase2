package view.AboutListener;

import controller.AboutLIstener.PremiumController;
import controller.UserAccountController;
import model.AboutHumans.Listener;
import model.AboutMusic.Audio;
import model.AboutMusic.Playlist;
import model.Types.Premium;
import model.Types.PremiumType;

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
