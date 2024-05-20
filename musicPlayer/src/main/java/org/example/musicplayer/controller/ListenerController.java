package org.example.musicplayer.controller;

import org.example.musicplayer.model.Audio.AudioModel;
import org.example.musicplayer.model.Audio.MusicModel;
import org.example.musicplayer.model.Audio.PodcastModel;
import org.example.musicplayer.model.DataBase.DataBaseModel;
import org.example.musicplayer.model.GenreModel;
import org.example.musicplayer.model.PlaylistModel;
import org.example.musicplayer.model.PremiumPackagesModel;
import org.example.musicplayer.model.ReportModel;
import org.example.musicplayer.model.UserAccount.Artist.ArtistModel;
import org.example.musicplayer.model.UserAccount.Listener.FreeListenerModel;
import org.example.musicplayer.model.UserAccount.Listener.ListenerModel;
import org.example.musicplayer.model.UserAccount.Listener.PremiumListenerModel;
import org.example.musicplayer.model.UserAccount.UserAccountModel;


import java.time.LocalDate;
import java.util.*;


public class ListenerController {
    private ListenerModel listener;

    public ListenerModel getListener() {
        return listener;
    }
    public void setListener(ListenerModel listener) {
        this.listener = listener;
    }

    private static ListenerController listenerController;

    public static ListenerController getListenerController() {
        if (listenerController == null)
                listenerController = new ListenerController();
        return listenerController;
    }
    public String favoriteGenres(String g1, String g2, String g3, String g4) {
        listener.getFavoriteGenres().add(GenreModel.valueOf(g1));
        listener.getFavoriteGenres().add(GenreModel.valueOf(g2));
        listener.getFavoriteGenres().add(GenreModel.valueOf(g3));
        listener.getFavoriteGenres().add(GenreModel.valueOf(g4));
        return "Favorite genres added";
    }
    public String report(String artistUsername, String description) {
        for (UserAccountModel userAccount : DataBaseModel.getDataBase().getUsers())
            if (Objects.equals(userAccount.getUsername(), artistUsername)) {
                ReportModel report = new ReportModel(listener,(ArtistModel)userAccount, description);
                DataBaseModel.getDataBase().getReports().add(report);
                return "The report was successfully registered";
            }
        return "Artist not found";
    }
    public StringBuilder showPlaylists() {
        StringBuilder str = new StringBuilder();
        for (PlaylistModel playlist : listener.getPlaylists()) {
            str.append(playlist.toString()).append("\n");
        }
        return str;
    }
    public StringBuilder showPlaylist(String name) {
        StringBuilder str = new StringBuilder();
        for (PlaylistModel playlist : listener.getPlaylists())
            if (Objects.equals(playlist.getPlaylistName(), name)) {
                for (AudioModel audio : playlist.getAudios())
                    str.append(audio.toString());
                return str;
            }
        str.append("Playlist not found");
        return str;
    }
    public String playAudio(int id) {
        for (AudioModel audio : DataBaseModel.getDataBase().getAudios())
            if (audio.getId() == id) {
                for (UserAccountModel userAccount : DataBaseModel.getDataBase().getUsers())
                    if (userAccount instanceof ArtistModel)
                        if (Objects.equals(userAccount.getName(), audio.getArtistName())) {
                            System.out.println("**********");
                            double p = ((ArtistModel) userAccount).getPlaysCount() + 1;
                            ((ArtistModel) userAccount).setPlaysCount(p);
                            audio.setPlaysCount(audio.getPlaysCount() + 1);
                        }
                return audio.toString();
            }
        return "Audio not found";
    }
    public String newPlaylist(String name) {
        //-----------------
        if (listener instanceof FreeListenerModel)
            if (listener.getPlaylists().size() == 10)
                return "You can just have 10 playlists";
        //------------------
        for (PlaylistModel playlist : listener.getPlaylists())
            if (Objects.equals(playlist.getPlaylistName(), name))
                return "This name already exists";
        PlaylistModel playlist = new PlaylistModel(name, listener.getName());
        listener.getPlaylists().add(playlist);
        return "Playlist added successfully";
    }
    public StringBuilder showFollowings() {
        StringBuilder str = new StringBuilder();
        for (ArtistModel artist : listener.getFollowings())
            str.append(artist.toString());
        return str;
    }
    public String followArtist(String username) {
        for (UserAccountModel userAccount : DataBaseModel.getDataBase().getUsers())
            if (userAccount instanceof ArtistModel)
                if (Objects.equals(userAccount.getUsername(), username)) {
                    if (((ArtistModel) userAccount).getFollowers().contains(listener))
                        return "You are currently following this artist";
                    listener.getFollowings().add((ArtistModel)userAccount);
                    ((ArtistModel) userAccount).getFollowers().add(listener);
                    return "You are now following this artist";
                }
        return "Username not found";
    }
    public String addAudioToPlaylist(String playlistName, int audioID) {

        for (AudioModel audioModel : DataBaseModel.getDataBase().getAudios())
            if (audioModel.getId() == audioID) {
                for (PlaylistModel playlist : listener.getPlaylists())
                    if (Objects.equals(playlist.getPlaylistName(), playlistName)) {
                        //--------------
                        if (listener instanceof FreeListenerModel)
                            if (playlist.getAudios().size() == 3)
                                return "You can just add 3 audios to playlist";
                        //--------------
                        else for (AudioModel audio : playlist.getAudios())
                                if (audio.getId() == audioID) return "This audio is currently in this playlist";
                        playlist.getAudios().add(audioModel);
                        return "The audio was added to the playlist";
                    }
                return "Playlist not found";
            }
        return "Audio not found";
    }
    public String likeAudio(int audioID) {
        for (AudioModel audio : DataBaseModel.getDataBase().getAudios())
            if (audio.getId() == audioID) {
                audio.setLikesCount(audio.getLikesCount() + 1);
                return "The audio was liked";
            }
        return "Audio not found";
    }
    public String showLyrics(int audioID) {
        for (AudioModel audio : DataBaseModel.getDataBase().getAudios())
            if (audio.getId() == audioID) {
                if (audio instanceof PodcastModel)
                    return ((PodcastModel) audio).getCaption();
                else if (audio instanceof MusicModel)
                    return ((MusicModel) audio).getLyrics();
            }
        return "Audio not found";
    }
    public String increaseCredit(double value) {
        listener.setAccountCredit(listener.getAccountCredit() + value);
        return "Value added to the accountCredit";

    }
    public StringBuilder showArtists() {
        StringBuilder str = new StringBuilder();
        for (UserAccountModel userAccount : DataBaseModel.getDataBase().getUsers())
            if (userAccount instanceof ArtistModel)
                str.append("\nName : ").append(userAccount.getName())
                        .append(", username : ").append(((ArtistModel) userAccount).getUsername());
        return str;
    }
    public String showArtist(String username) {
        for (UserAccountModel userAccount : DataBaseModel.getDataBase().getUsers())
            if (userAccount instanceof ArtistModel)
                if (Objects.equals(userAccount.getUsername(), username))
                    return userAccount.toString();
        return "Artist not found";
    }
    public String showAccountInfo() {
        if (listener instanceof PremiumListenerModel) {
            ((PremiumListenerModel) listener).setRemainingSubscriptionDays(((PremiumListenerModel) listener).getRemainingSubscriptionDays() - 1);
            if (((PremiumListenerModel) listener).getRemainingSubscriptionDays() == 0) {
                FreeListenerModel freeListener = new FreeListenerModel(listener.getUsername(), listener.getPassword(), listener.getName(), listener.getEmail(), listener.getPhoneNumber(), listener.getBirthday());
                DataBaseModel.getDataBase().getUsers().remove(listener);
                DataBaseModel.getDataBase().getUsers().add(freeListener);
                listener = freeListener;
                return "You are not premium listener anymore!\n" + listener.toString();
            }
        }
        return listener.toString();
    }
    public ArrayList<AudioModel> searchAudioOrArtist(String name) {
        ArrayList<AudioModel> audios = new ArrayList<>();
        //StringBuilder str = new StringBuilder();
        for (AudioModel audio : DataBaseModel.getDataBase().getAudios())
            if (Objects.equals(audio.getAudioTitle(), name) || Objects.equals(audio.getArtistName(), name))
            {
                audios.add(audio);
            }
                //str.append(audio.toString()).append("\n");
//        for (UserAccountModel userAccount : DataBaseModel.getDataBase().getUsers())
//            if (userAccount instanceof ArtistModel)
//                if (Objects.equals(userAccount.getName(), name))
//                    str.append(userAccount.toString()).append("\n");
        //return str;
        return audios;
    }
    public ArrayList<AudioModel> sortAudios(String sortBy) {
        StringBuilder str = new StringBuilder();
        ArrayList<AudioModel> audios = DataBaseModel.getDataBase().getAudios();
        if (Objects.equals(sortBy, "L")) {
            for (int i = 0; i < audios.size(); i++) {
                for (int j = i + 1; j < audios.size(); j++) {
                    if (audios.get(i).getLikesCount() > audios.get(j).getLikesCount()) {
                        AudioModel tmp = audios.get(i);
                        audios.set(i, audios.get(j));
                        audios.set(j, tmp);
                    }
                }
            }
        }
        else {
            for (int i = 0; i < audios.size(); i++) {
                for (int j = i + 1; j < audios.size(); j++) {
                    if (audios.get(i).getPlaysCount() > audios.get(j).getPlaysCount()) {
                        AudioModel tmp = audios.get(i);
                        audios.set(i, audios.get(j));
                        audios.set(j, tmp);
                    }
                }
            }
        }
//        for (AudioModel audio : audios)
//            str.append(audio.toString());
        return audios;
    }
    public String getPremiumPackage(int days) {
        PremiumPackagesModel premiumPackage;
        if (days == 30) {
            premiumPackage = PremiumPackagesModel.FIRST;
            if (listener.getAccountCredit() < premiumPackage.getCash())
                return "Your credit is not enough";
            if (listener instanceof PremiumListenerModel) {
                ((PremiumListenerModel) listener).setRemainingSubscriptionDays(30);
                ((PremiumListenerModel) listener).setSubscriptionExpirationDate(((PremiumListenerModel) listener).getStartPremium().plusDays(30));
                return "Remaining Subscription Days Updated";
            }
            PremiumListenerModel premiumListener = new PremiumListenerModel(listener.getUsername(), listener.getPassword(), listener.getName(), listener.getEmail(), listener.getPhoneNumber(), listener.getBirthday(), LocalDate.now());
            premiumListener.setRemainingSubscriptionDays(premiumPackage.getDays());
            premiumListener.setSubscriptionExpirationDate(premiumListener.getStartPremium().plusDays(30));
            DataBaseModel.getDataBase().getUsers().remove(listener);
            DataBaseModel.getDataBase().getUsers().add(premiumListener);
            listener = premiumListener;
            return "Premium pack applied";
        }
        if (days == 60) {
            premiumPackage = PremiumPackagesModel.FIRST;
            if (listener.getAccountCredit() < premiumPackage.getCash())
                return "Your credit is not enough";
            if (listener instanceof PremiumListenerModel) {
                ((PremiumListenerModel) listener).setRemainingSubscriptionDays(60);
                ((PremiumListenerModel) listener).setSubscriptionExpirationDate(((PremiumListenerModel) listener).getStartPremium().plusDays(60));

                return "Remaining Subscription Days Updated";
            }
            PremiumListenerModel premiumListener = new PremiumListenerModel(listener.getUsername(), listener.getPassword(), listener.getName(), listener.getEmail(), listener.getPhoneNumber(), listener.getBirthday(), LocalDate.now());
            premiumListener.setRemainingSubscriptionDays(premiumPackage.getDays());
            premiumListener.setSubscriptionExpirationDate(premiumListener.getStartPremium().plusDays(60));
            DataBaseModel.getDataBase().getUsers().remove(listener);
            DataBaseModel.getDataBase().getUsers().add(premiumListener);
            listener = premiumListener;

            return "Premium pack applied";
        }
        if (days == 180) {
            premiumPackage = PremiumPackagesModel.FIRST;
            if (listener.getAccountCredit() < premiumPackage.getCash())
                return "Your credit is not enough";
            if (listener instanceof PremiumListenerModel) {
                ((PremiumListenerModel) listener).setRemainingSubscriptionDays(180);
                ((PremiumListenerModel) listener).setSubscriptionExpirationDate(((PremiumListenerModel) listener).getStartPremium().plusDays(180));
                return "Remaining Subscription Days Updated";
            }
            PremiumListenerModel premiumListener = new PremiumListenerModel(listener.getUsername(), listener.getPassword(), listener.getName(), listener.getEmail(), listener.getPhoneNumber(), listener.getBirthday(), LocalDate.now());
            premiumListener.setRemainingSubscriptionDays(premiumPackage.getDays());
            premiumListener.setSubscriptionExpirationDate(premiumListener.getStartPremium().plusDays(180));
            DataBaseModel.getDataBase().getUsers().remove(listener);
            DataBaseModel.getDataBase().getUsers().add(premiumListener);
            listener = premiumListener;
            return "Premium pack applied";
        }
        return "Premium pack not found";
    }
    public StringBuilder filterAudios(String filter, String filterBy) {
        StringBuilder str = new StringBuilder();
        ArrayList<AudioModel> audios = DataBaseModel.getDataBase().getAudios();
        if (Objects.equals(filter, "A")) {
            for (AudioModel audio : audios)
                if (Objects.equals(audio.getArtistName(), filterBy))
                    str.append("\nName : ").append(audio.getAudioTitle())
                            .append(", id : ").append(audio.getId());
        }
        else if (Objects.equals(filter, "G")) {
            for (AudioModel audio : audios)
                if (audio.getGenre() == GenreModel.valueOf(filterBy))
                    str.append("\nName : ").append(audio.getAudioTitle())
                            .append(", id : ").append(audio.getId());
        }
        else {
            LocalDate date = LocalDate.parse(filterBy);
            for (AudioModel audio : audios)
                if (audio.getReleaseDate().getDayOfMonth() == date.getDayOfMonth() && audio.getReleaseDate().getMonth() == date.getMonth() && audio.getReleaseDate().getYear() == date.getYear())
                    str.append("\nName : ").append(audio.getAudioTitle())
                            .append(", id : ").append(audio.getId());
        }
        return str;
    }

    public ArrayList<AudioModel> suggestions() {
        ArrayList<AudioModel> audios = new ArrayList<>();
        ArrayList<AudioModel> data = sortAudios("L");
        int count = 0;
        for (AudioModel audioModel : data) {
            lable1:
            for (GenreModel genreModel : listener.getFavoriteGenres()) {
                for (UserAccountModel userAccountModel : listener.getFollowings()) {
                    if ((Objects.equals(audioModel.getArtistName(), userAccountModel.getName())) || (audioModel.getGenre() == genreModel)) {
                        if (count < 10) {
                            audios.add(audioModel);
                            count++;
                            break lable1;
                        }
                        else {
                            return audios;
                        }
                    }
                }
            }
        }
        return audios;
    }
}
