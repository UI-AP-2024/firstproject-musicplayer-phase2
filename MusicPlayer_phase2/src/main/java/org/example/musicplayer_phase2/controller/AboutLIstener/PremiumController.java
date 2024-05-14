package org.example.musicplayer_phase2.controller.AboutLIstener;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;
import org.example.musicplayer_phase2.model.Exceptions.NotEnoughCredit;
import org.example.musicplayer_phase2.model.Types.PremiumType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PremiumController extends ListenerController {
    Playlist playlist;

    public String makePremiumPlaylist(String name , Listener listener) throws Exception {
        for (Playlist a : listener.getAllPlaylists())
        {
            if (a.getPlaylistName().equals(name))
                throw new Exception("playlist's name is repeated");
        }
        playlist = new Playlist(name, listener.getName());
        listener.setOnePlaylists(playlist);
        playlist.setNumberOfMusics(playlist.getNumberOfMusics() + 1);
        return "Playlist add successfully. ";
    }
    @Override
    public String addMusicToPlaylist(Playlist playlist , Audio audio , Listener listener) {
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
    public String buySubscription (PremiumType type , Listener listener) throws NotEnoughCredit {
        if (premiumListener.getCredit() >= type.price)
        {
            premiumListener.setRemainDays(premiumListener.getRemainDays() + type.value);
            LocalDate date =  LocalDate.now().plusDays(premiumListener.getRemainDays());
            Date end = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            premiumListener.setEndSubscription(end);
            return "days added successfully";
        }

        else
            throw new NotEnoughCredit();
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