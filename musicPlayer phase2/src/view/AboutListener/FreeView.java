package view.AboutListener;

import controller.AboutLIstener.FreeController;
import controller.UserAccountController;
import model.AboutHumans.Listener;
import model.AboutMusic.Audio;
import model.AboutMusic.Playlist;

public class FreeView extends ListenerView {
    FreeController freeController = new FreeController();
    public void addMusicToPlaylist (String playlistName , long audioID , Listener listener)
    {
        Playlist playlist = null;
        Audio audio = null;
        boolean foundPlaylist = false;
        for (Playlist a : listener.getAllPlaylists())
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
            freeController.addMusicToPlaylist(playlist , audio , listener);
            System.out.println("you add the music to "+ playlistName);
        }
    }

    public void newPlaylist(String name , Listener listener)
    {
        System.out.println(freeController.makePlaylist(name , listener));
    }
}
