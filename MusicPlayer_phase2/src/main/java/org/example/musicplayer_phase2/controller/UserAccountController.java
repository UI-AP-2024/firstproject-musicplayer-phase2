package org.example.musicplayer_phase2.controller;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.*;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Music;
import org.example.musicplayer_phase2.model.AboutMusic.Podcast;
import org.example.musicplayer_phase2.model.Exceptions.FailedLoginException;
import org.example.musicplayer_phase2.model.Exceptions.InvalidFormat;
import org.example.musicplayer_phase2.model.Exceptions.UserNotFoundException;
import org.example.musicplayer_phase2.model.Exceptions.WrongPasswordException;
import org.example.musicplayer_phase2.model.Types.Free;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAccountController {
    public static Listener listener = null;
    public static Singer singer = null;
    public static Podcaster podcaster = null;
    public static boolean checkEmail(String email) throws InvalidFormat {
        String regex = "^(.+)@(gmail|yahoo|outlook|zoho)\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches())
            throw new InvalidFormat("your email is not valid");
        return matcher.matches();
    }

    public static boolean checkNumber(String number) throws InvalidFormat {
        String regex = "^09[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches())
            throw new InvalidFormat("your number is not valid");
        return matcher.matches();
    }

    public static boolean checkPassword(String password) throws InvalidFormat {
        String regex = "(?=.*\\w)(?=.*\\W)[\\w \\W]{8,20}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches())
            throw new InvalidFormat("your password is easy make a password with (@,#,!,....) and characters and at list 8 letter.");
        return matcher.matches();
    }

    public static boolean checkBirthday(String birthday) throws InvalidFormat {
        String regex = "^([0-2]{1}[0-9]{1}|[3]{1}[0-1]{1})/([0]{1}[0-9]{1}|[1]{1}[0-2]{1})/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birthday);
        if (!matcher.matches())
            throw new InvalidFormat("birthday format is incorrect enter your birthday whit dd/MM/YYYY format.");
        return matcher.matches();
    }

    public static boolean checkUsername(String username) throws InvalidFormat {
        for (int i = 0; i < Database.allUsers.size() - 1; i++) {
            if (Database.allUsers.get(i).getUsername().equals(username))
                throw new InvalidFormat("repeated username");
        }
        return true;
    }

    public static Audio findAudio(long ID) throws Exception {
        Audio audio = null;
        for (Audio a : Database.allAudios) {
            if (a.getIdentifier() == ID) {
                audio = a;
            }
        }
        if (audio == null){
            throw new Exception("audio with this identifier not exist");
        }
        return audio;
    }

    public static Music findMusic(long ID) {
        Music music = null;
        for (Music a : Database.allMusics) {
            if (a.getIdentifier() == ID) {
                music = a;
            }
        }

        return music;
    }

    public static Podcast findPodcast(long ID) {
        Podcast podcast = null;
        for (Podcast a : Database.allPodcasts)
            if (a.getIdentifier() == ID)
                podcast = a;
        return podcast;
    }

    public static UserAccount findPerson (String username , String password) throws FailedLoginException {

        boolean foundUsername = false;
        boolean foundPassword = false;
        for (UserAccount a : Database.allUsers){
            if (a.getUsername().equals(username) && a.getPassword().equals(password))
                return a;
            else if (a.getUsername().equals(username) && !a.getPassword().equals(password))
                foundUsername = true;
            else if (!a.getUsername().equals(username) && a.getPassword().equals(password))
                foundPassword = true;
        }

        if (foundPassword && !foundUsername)
            throw new UserNotFoundException();
        else if (foundUsername && !foundPassword)
            throw new WrongPasswordException();
        else
            throw new FailedLoginException("user not found");
    }

    public static ArrayList<Audio> searchInAudios (String name){
        ArrayList<Audio> results  = new ArrayList<>();
        for (Audio a : Database.allAudios){
            if (a.getAudioName().equals(name)){
                results.add(a);
            }
        }
        return results;
    }

    public static ArrayList<Artist> searchInArtists (String username){
        ArrayList<Artist> results  = new ArrayList<>();
        for (Artist a : Database.allArtists){
            if (a.getUsername().equals(username)){
                results.add(a);
            }
        }
        return results;
    }

}
