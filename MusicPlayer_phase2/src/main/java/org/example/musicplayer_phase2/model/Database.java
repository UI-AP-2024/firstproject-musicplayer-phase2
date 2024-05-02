package org.example.musicplayer_phase2.model;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.*;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Music;
import org.example.musicplayer_phase2.model.AboutMusic.Podcast;

import java.util.ArrayList;

public class Database {
    private static Database database;
    private Database(){}
    public static Database getDatabase()
    {
        if (database == null)
            database = new Database();
        return database;
    }

    public static ArrayList<Audio> allAudios= new ArrayList<>();
    public static ArrayList<Report> allReports = new ArrayList<>();
    public static ArrayList<UserAccount> allUsers = new ArrayList<>();
    public static ArrayList<Singer> allSingers = new ArrayList<>();
    public static ArrayList<Podcaster> allPodcaster = new ArrayList<>();
    public static ArrayList<Artist> allArtists = new ArrayList<>();
    public static ArrayList<Music> allMusics = new ArrayList<>();
    public static ArrayList<Podcast> allPodcasts = new ArrayList<>();

    public String getAllAudiosName() {
        String allAudios = "";
        for (Audio a : this.allAudios)
            allAudios += a.toString();
        return allAudios;
    }

    public String getAllReportsName() {
        String allReports = "";
        for (Report a : this.allReports)
            allReports += a.toString();
        return allReports;
    }

    public String getAllUsersName() {
        String allUsers = "";
        for (UserAccount a : this.allUsers)
            allUsers = a.toString();
        return allUsers;
    }

    public static void setAllAudios(Audio audio) {
        allAudios.add(audio);
    }
    public static void setAllReports(Report report) {
        allReports.add(report);
    }
    public static void setAllUsers(UserAccount users) {
        allUsers.add(users);
    }
    public static void setAllSingers(Singer singer) {
        Database.allSingers.add(singer);
    }
    public static void setAllPodcaster(Podcaster podcaster) {
        Database.allPodcaster.add(podcaster);
    }
    public static void setAllArtists(Artist artist) {
        Database.allArtists.add(artist);
    }
    public static void setAllMusics(Music music) {
        Database.allMusics.add(music);
    }
    public static void setAllPodcasts(Podcast podcast) {
        Database.allPodcasts.add(podcast);
    }
}
