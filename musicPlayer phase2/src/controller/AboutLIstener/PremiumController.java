package controller.AboutLIstener;

import model.AboutHumans.Listener;
import model.AboutMusic.Audio;
import model.AboutMusic.Playlist;
import model.Types.PremiumType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PremiumController extends ListenerController {
    Playlist playlist;
    @Override
    public String makePlaylist(String name , Listener listener) {
        for (Playlist a : listener.getAllPlaylists())
        {
            if (a.getPlaylistName().equals(name))
                return "playlist's name is repeated";
        }
        playlist = new Playlist(name, listener.getName());
        listener.setOnePlaylists(playlist);
        playlist.setNumberOfMusics(playlist.getNumberOfMusics() + 1);
        return "Playlist add successfully. ";
    }
    @Override
    public String addMusicToPlaylist(Playlist playlist ,Audio audio , Listener listener) {
        Playlist playlist1 = null;
        for (Playlist a : listener.getAllPlaylists())
        {
            if (a.equals(playlist))
                playlist1 = a;
        }
        playlist1.setAudioFiles(audio);
        playlist1.setNumberOfMusics(playlist.getNumberOfMusics() + 1);
        return "Music added successfully";
    }
    @Override
    public String buySubscription (PremiumType type , Listener listener)
    {
        if (premiumListener.getCredit() >= type.price)
        {
            premiumListener.setRemainDays(premiumListener.getRemainDays() + type.value);
            LocalDate date =  LocalDate.now().plusDays(premiumListener.getRemainDays());
            Date end = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            premiumListener.setEndSubscription(end);
            return "days added successfully";
        }

        else
            return "your credit is not enough.";
    }
    public StringBuilder watchEndOfSubscription ()
    {
        premiumListener.setRemainDays(premiumListener.getRemainDays() - 1);
        LocalDate date =  LocalDate.now().plusDays(premiumListener.getRemainDays());
        Date end = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        premiumListener.setEndSubscription(end);
        return premiumListener.getEndSubscription();
    }
}