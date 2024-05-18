package org.example.musicplayer_phase2.controller.AboutLIstener;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;
import org.example.musicplayer_phase2.model.Exceptions.NotEnoughCredit;
import org.example.musicplayer_phase2.model.Types.Free;
import org.example.musicplayer_phase2.model.Types.Premium;
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

    public String addMusicToPlaylistForPremium(Playlist playlist , Audio audio , Listener listener) {
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
    public void buySubscriptionPremium (PremiumType type , Listener listener) throws NotEnoughCredit {
        if (listener.getCredit() >= type.price)
        {
            listener.setRemainDays(listener.getRemainDays() + type.value);
            listener.setEndSubscription(LocalDate.now().plusDays(listener.getRemainDays()));
            listener.setCredit(listener.getCredit() - type.price);
        }

        else
            throw new NotEnoughCredit();
    }

    public Listener checkIfFinish(Listener listener){
        if (listener instanceof Premium){
            if (listener.getEndSubscription().compareTo(LocalDate.now()) <= 0){
                Free free = new Free(listener.getName() , listener.getUsername() , listener.getPassword() , listener.getEmail() , listener.getNumber() , listener.getBirthday());
                free.setAllPlaylists(listener.getAllPlaylists());
                free.setFavoriteGenre(listener.getFavoriteGenre());
                free.setLikedAudios(listener.getLikedAudios());
                free.setFilesNumber(listener.getFilesNumber());
                free.setEndSubscription(LocalDate.now());
                Database.allUsers.remove(listener);
                Database.allListener.remove(listener);
                return free;
            }
        }
        return listener;
    }
}