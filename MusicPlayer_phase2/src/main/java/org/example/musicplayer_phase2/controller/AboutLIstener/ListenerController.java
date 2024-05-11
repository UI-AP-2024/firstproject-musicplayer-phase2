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
    public Listener listener;
    public static Free freeListener;
    public static Premium premiumListener;
    Report report;

    public static Listener listenerLogin(String username , String password){
        Listener listener1 = null;
        for (Listener a : Database.allListener){
            if (a.getUsername().equals(username) && a.getPassword().equals(password)){
                listener1 = a;
            }
        }
        return listener1;
    }

    public void signup(Free listener) {
        this.listener = listener;
        freeListener = listener;
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
        for (Genre genre : favoriteGenre){
            listener.setOneFavoriteGenre(genre);
        }
    }

    public String makePlaylist(String playlistName, Listener listener) throws FreeAccountLimitException {
        return "";
    }

    public String addMusicToPlaylist(Playlist playlist, Audio audio, Listener listener) throws FreeAccountLimitException {
        return "";
    }

//    public StringBuilder searchInAudios(String searchBasedOn) {
//        Stream<Audio> audioStream = Database.allAudios.stream().filter(n -> n.getArtistUsername().equals(searchBasedOn) || n.getAudioName().equals(searchBasedOn));
//        StringBuilder results = new StringBuilder();
//        audioStream.forEach(n -> results.append(n.toString() + "\n"));
//        return results;
//    }

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
        report = new Report(reporterPerson, reportedArtist, explanation);
    }

    public String followingArtist(String username, Listener listener) {
        Artist artist = null;
        for (Artist a : Database.allArtists) {
            if (a.getUsername().equals(username)) {
                artist = Database.allArtists.get(Database.allArtists.indexOf(a));
                for (Artist b : listener.getFollowingArtists()) {
                    if (b == artist)
                        return "you have already follow this artist";
                }
            }
        }
        if (artist == null)
            return "artist not found";

        artist.setFollowers(listener);
        listener.setOneFollowingArtists(artist);
        return "you are following this artist";
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

    public StringBuilder suggestMusic(int n, Listener listener) {
        StringBuilder musics = new StringBuilder();
        int numberOfMusics = 0;

        if (n > Database.allAudios.size()) {
            n = Database.allAudios.size();
        }

        for (Genre a : listener.getFavoriteGenre()) {
            for (Audio b : Database.allAudios) {
                if (b.getGenre() == a) {
                    musics.append(b + "\n");
                    numberOfMusics++;
                    if (numberOfMusics >= n)
                        break;
                }
            }
        }

        if (numberOfMusics < n) {
            for (Artist a : listener.getFollowingArtists()) {
                if (a instanceof Singer) {
                    for (Album b : ((Singer) a).getAllAlbums()) {
                        for (Music c : b.getAllMusics()) {
                            boolean repeated = false;
                            for (Genre d : listener.getFavoriteGenre()) {
                                if (c.getGenre() == d)
                                    repeated = true;
                            }
                            if (numberOfMusics >= n)
                                break;
                            if (!repeated) {
                                musics.append(c + "\n");
                                numberOfMusics++;
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
                        if (numberOfMusics >= n)
                            break;
                        if (!repeated) {
                            musics.append(b + "\n");
                            numberOfMusics++;
                            if (numberOfMusics >= n)
                                break;

                        }
                    }
                }
            }
        }

        if (numberOfMusics < n) {
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
                    musics.append(a + "\n");
                    numberOfMusics++;
                    if (numberOfMusics >= n)
                        break;
                }
            }
        }
        return musics;
    }

    public String watchAccountInformation(Listener listener) {
        return listener.toString() + "number: " + listener.getNumber() + "\nusername: " + listener.getUsername() + "\npassword: " + listener.getPassword() + "\n";
    }

    public void increaseCredit(double money, Listener listener) {
        listener.setCredit(listener.getCredit() + money);
    }

    public String buySubscription(PremiumType type, Listener listener) throws NotEnoughCredit {
        return "";
    }
}
