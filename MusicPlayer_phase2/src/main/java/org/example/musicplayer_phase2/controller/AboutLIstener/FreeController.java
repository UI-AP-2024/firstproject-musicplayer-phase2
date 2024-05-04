package org.example.musicplayer_phase2.controller.AboutLIstener;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;
import org.example.musicplayer_phase2.model.Exceptions.FreeAccountLimitException;
import org.example.musicplayer_phase2.model.Exceptions.NotEnoughCredit;
import org.example.musicplayer_phase2.model.Types.Premium;
import org.example.musicplayer_phase2.model.Types.PremiumType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FreeController extends ListenerController {
    Playlist playlist;
    @Override
    public String makePlaylist(String name , Listener listener) throws FreeAccountLimitException {
        for (Playlist a : listener.getAllPlaylists())
        {
            if (a.getPlaylistName().equals(name))
                return "playlist's name is repeated";
        }
        if (listener.getAllPlaylists().size() == 3)
            throw new FreeAccountLimitException("You have already 3 playlists for more playlist buy premium version. ");
        else {
            playlist = new Playlist(name, listener.getName());
            listener.setOnePlaylists(playlist);
            return "Playlist add successfully. ";
        }
    }
    @Override
    public String addMusicToPlaylist(Playlist playlist , Audio audio , Listener listener) throws FreeAccountLimitException {

        Playlist playlist1 = null;
        for (Playlist a : listener.getAllPlaylists())
        {
            if (a.equals(playlist))
                playlist1 = a;
        }
        if (playlist1.getNumberOfMusics() == 10)
            throw new FreeAccountLimitException("You have already 10 musics in this playlist for more musics buy premium version.");
        else
        {
            playlist1.setAudioFiles(audio);
            playlist1.setNumberOfMusics(playlist.getNumberOfMusics() + 1);
            return "Music added successfully";
        }
    }
    @Override
    public String buySubscription (PremiumType type , Listener listener) throws NotEnoughCredit {
        if (listener.getCredit() >= type.price)
        {
            premiumListener = new Premium(listener.getName() , listener.getUsername() , listener.getPassword() , listener.getEmail() , listener.getNumber() , listener.getBirthday());
            premiumListener.setCredit(listener.getCredit() - type.price);
            premiumListener.setAllPlaylists(listener.getAllPlaylists());
            premiumListener.setFavoriteGenre(listener.getFavoriteGenre());
            premiumListener.setFollowingArtists(listener.getFollowingArtists());
            premiumListener.setLikedAudios(listener.getLikedAudios());
            premiumListener.setFilesNumber(listener.getFilesNumber());
            premiumListener.setRemainDays(type.value);
            LocalDate date =  LocalDate.now().plusDays(premiumListener.getRemainDays());
            Date end = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            premiumListener.setEndSubscription(end);
            this.listener = premiumListener;
            Database.allUsers.remove(freeListener);
            freeListener = null;

            return "you are a premium user now :)";
        }

        else
            throw new NotEnoughCredit();
    }
}