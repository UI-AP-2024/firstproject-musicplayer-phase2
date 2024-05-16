package org.example.musicplayer_phase2.controller.AboutLIstener;

import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.*;
import org.example.musicplayer_phase2.model.AboutMusic.*;
import org.example.musicplayer_phase2.model.Exceptions.*;
import org.example.musicplayer_phase2.model.Types.Free;
import org.example.musicplayer_phase2.model.Types.Genre;
import org.example.musicplayer_phase2.model.Types.Premium;
import org.example.musicplayer_phase2.model.Types.PremiumType;

import java.util.*;
import java.util.stream.Stream;

public class ListenerController extends UserAccountController {
    public static Listener listenerLogin(String username, String password) {
        Listener listener1 = null;
        for (Listener a : Database.allListener) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                listener1 = a;
                break;
            }
        }
        return new PremiumController().checkIfFinish(listener1);
    }

    public void signup(Free listener) {
        listener.setCredit(50);
    }

    public String playAudio(Audio audio) {
        for (Audio a : Database.allAudios) {
            if (a.equals(audio)) {
                audio.setPlaysNum(audio.getPlaysNum() + 1);
                return a.toString();
            }
        }
        return "Audio not found ";
    }

    public String likeAudio(Audio audio, Listener listener) {
        for (Audio b : listener.getLikedAudios()) {
            if (b == audio)
                return "you hava already liked this audio";
        }

        for (Audio a : Database.allAudios) {
            if (a.equals(audio)) {
                audio.setLikesNum(audio.getLikesNum() + 1);
                listener.setOneLikedAudios(audio);
            }
        }

        return "you liked this audio";
    }

    public void getFavoriteGenre(ArrayList<Genre> favoriteGenre, Listener listener) {
        for (Genre genre : favoriteGenre) {
            listener.setOneFavoriteGenre(genre);
        }
    }

    public void makePlaylist(String playlistName, Listener listener) throws Exception {
        if (listener instanceof Free) {
            new FreeController().makeFreePlaylist(playlistName, listener);
        } else if (listener instanceof Premium) {
            new PremiumController().makePremiumPlaylist(playlistName, listener);
        }
    }

    public void addMusicToPlaylist(Playlist playlist, Audio audio, Listener listener) throws FreeAccountLimitException {
        if (listener instanceof Free) {
            new FreeController().addMusicToPlaylistForFree(playlist, audio, listener);
        } else if (listener instanceof Premium) {
            new PremiumController().addMusicToPlaylistForPremium(playlist, audio, listener);
        }
    }

    public ArrayList<Audio> sortAudiosBasedOnLikes() {
        Collections.sort(Database.allAudios, new Comparator<Audio>() {
            @Override
            public int compare(Audio o1, Audio o2) {
                if (o1.getLikesNum() > o2.getLikesNum())
                    return -1;
                else if (o1.getLikesNum() < o2.getLikesNum())
                    return 1;
                else
                    return 0;
            }
        });
        return Database.allAudios;
    }

    public ArrayList<Audio> sortAudios() {
        Collections.sort(Database.allAudios);
        return Database.allAudios;
    }

    public StringBuilder sortAudiosBasedOnPlays() {
        StringBuilder result = new StringBuilder();

        Comparator<Audio> compare = Comparator
                .comparingInt((Audio a) -> a.getPlaysNum()).reversed();

        Database.allAudios.stream()
                .sorted(compare)
                .forEach(n -> result.append(n.toString() + "\n"));

        return result;
    }

    public StringBuilder filterAudios(Artist artist) {
        StringBuilder result = new StringBuilder();
        Database.allUsers.stream()
                .filter(n -> n.equals(artist) && n instanceof Artist)
                .forEach(n -> {
                    if (n instanceof Singer) {
                        result.append(((Singer) n).getAllAlbumsName());
                    } else if (n instanceof Podcaster) {
                        result.append(((Podcaster) n).getAllPodcasts());
                    }
                });
        return result;
    }

    public StringBuilder filterAudios(Genre genre) {
        StringBuilder result = new StringBuilder();

        Database.allAudios.stream()
                .filter(n -> n.getGenre().equals(genre))
                .forEach(n -> result.append(n.toString() + "\n"));

        return result;
    }

    public StringBuilder filterAudios(Date fromDate, Date toDate) {
        StringBuilder result = new StringBuilder();
        Database.allAudios.stream()
                .filter(n -> n.getPublicationDate().compareTo(fromDate) >= 0 && n.getPublicationDate().compareTo(toDate) <= 0)
                .forEach(n -> result.append(n.toString() + "\n"));

        return result;
    }

    public void reporting(UserAccount reporterPerson, UserAccount reportedArtist, String explanation) {
        new Report(reporterPerson, reportedArtist, explanation);
    }

    public void followingArtist(Artist artist, Listener listener) throws Exception {

        for (Artist a : listener.getFollowingArtists()) {
            if (a == artist)
                throw new Exception("you have already follow this artist");
        }

        artist.setFollowers(listener);
        listener.setOneFollowingArtists(artist);
    }

    public StringBuilder watchFollowings() {
        StringBuilder followings = new StringBuilder();
        for (Artist a : listener.getFollowingArtists()) {
            followings.append(a.toString() + "\n");
        }
        return followings;
    }

    public StringBuilder watchAllArtists() {
        StringBuilder allArtist = new StringBuilder();
        Database.allSingers.stream().forEach(n -> allArtist.append(n.toString() + "\n"));
        Database.allPodcaster.stream().forEach(n -> allArtist.append(n.toString() + "\n"));
        return allArtist;
    }

    public StringBuilder watchArtistCreation(Artist artist) {
        StringBuilder creations = new StringBuilder();
        if (artist instanceof Singer) {
            int index = Database.allSingers.lastIndexOf(artist);
            creations.append("albums: \n");
            Database.allSingers.get(index).getAllAlbums().stream().forEach(n -> creations.append(n.toString()));
            creations.append("\nmusics: \n");

            for (Album a : Database.allSingers.get(index).getAllAlbums()) {
                for (Music b : a.getAllMusics()) {
                    creations.append(b.toString() + "\n");
                }
            }
        } else if (artist instanceof Podcaster) {
            ((Podcaster) artist).getAllPodcasts().stream().forEach(n -> creations.append(n.toString() + "\n"));
        }

        return creations;
    }

    public StringBuilder watchAllPlaylists(Listener listener) {
        StringBuilder playlists = new StringBuilder();
        listener.getAllPlaylists().stream().forEach(n -> playlists.append(n.toString() + "\n"));
        return playlists;
    }

    public StringBuilder watchPlaylistInformation(String playlistName, Listener listener) {
        Playlist playlist = null;
        for (Playlist a : listener.getAllPlaylists()) {
            if (a.getPlaylistName().equals(playlistName))
                playlist = a;
        }
        StringBuilder watchPlaylist = new StringBuilder();
        int index = listener.getAllPlaylists().indexOf(playlist);
        watchPlaylist.append(listener.getAllPlaylists().get(index).getAudioFiles());
        return watchPlaylist;
    }

    public ArrayList<Audio> suggestMusic(int n, Listener listener) {
        ArrayList<Audio> suggestedAudios = new ArrayList<>();


        if (n > Database.allAudios.size()) {
            n = Database.allAudios.size();
        }

        for (Genre a : listener.getFavoriteGenre()) {
            for (Audio b : Database.allAudios) {
                if (b.getGenre() == a) {
                    suggestedAudios.add(b);
                    if (suggestedAudios.size() >= n)
                        break;
                }
            }
        }

        if (suggestedAudios.size() < n) {
            for (Artist a : listener.getFollowingArtists()) {
                if (a instanceof Singer) {
                    for (Album b : ((Singer) a).getAllAlbums()) {
                        for (Music c : b.getAllMusics()) {
                            boolean repeated = false;
                            for (Genre d : listener.getFavoriteGenre()) {
                                if (c.getGenre() == d)
                                    repeated = true;
                            }
                            if (suggestedAudios.size() >= n)
                                break;
                            if (!repeated) {
                                suggestedAudios.add(c);
                            }
                        }
                    }
                } else if (a instanceof Podcaster) {
                    for (Podcast b : ((Podcaster) a).getAllPodcasts()) {
                        boolean repeated = false;
                        for (Genre c : listener.getFavoriteGenre()) {
                            if (b.getGenre() == c)
                                repeated = true;
                        }
                        if (suggestedAudios.size() >= n)
                            break;
                        if (!repeated) {
                            suggestedAudios.add(b);
                            if (suggestedAudios.size() >= n)
                                break;

                        }
                    }
                }
            }
        }

        if (suggestedAudios.size() < n) {
            for (Audio a : Database.allAudios) {
                boolean repeated = false;
                for (Genre b : listener.getFavoriteGenre()) {
                    if (a.getGenre() == b) {
                        repeated = true;
                        break;
                    }
                }
                if (!repeated) {
                    for (Artist b : listener.getFollowingArtists()) {
                        if (a.getArtistUsername().equals(b.getUsername())) {
                            repeated = true;
                            break;
                        }
                    }
                }

                if (!repeated) {
                    suggestedAudios.add(a);
                    if (suggestedAudios.size() >= n)
                        break;
                }
            }
        }
        return suggestedAudios;
    }

    public String watchAccountInformation(Listener listener) {
        return listener.toString() + "number: " + listener.getNumber() + "\nusername: " + listener.getUsername() + "\npassword: " + listener.getPassword() + "\n";
    }

    public void increaseCredit(double money, Listener listener) {
        listener.setCredit(listener.getCredit() + money);
    }

    public Listener buySubscription(PremiumType type, Listener listener) throws NotEnoughCredit {
        if (listener instanceof Premium) {
            new PremiumController().buySubscriptionPremium(type, listener);
            UserAccountController.listener = listener;
            return listener;
        } else {
            Listener listener1 = new FreeController().buySubscriptionFree(type, listener);
            UserAccountController.listener = listener1;
            return listener1;
        }
    }

    public Playlist findPlaylist(String playlistName , Listener listener) throws Exception {
        for (Playlist p : listener.getAllPlaylists()){
            if (p.getPlaylistName().equals(playlistName))
                return p;
        }

        throw new Exception("you don't have a playlist with this name");
    }
}
