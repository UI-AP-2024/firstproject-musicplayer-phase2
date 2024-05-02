package org.example.musicplayer_phase2.controller;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.AboutMusic.Music;
import org.example.musicplayer_phase2.model.AboutMusic.Podcast;
import org.example.musicplayer_phase2.model.Types.Genre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAccountController {
    public boolean checkEmail(String email) {
        String regex = "^(.+)@(gmail|yahoo|outlook|zoho)\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean checkNumber(String number) {
        String regex = "^09[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public boolean checkPassword(String password) {
        String regex = "(?=.*\\w)(?=.*\\W)[\\w \\W]{8,20}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean checkBirthday(String birthday) {
        String regex = "^([0-2]{1}[0-9]{1}|[3]{1}[0-1]{1})/([0]{1}[0-9]{1}|[1]{1}[0-2]{1})/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birthday);
        return matcher.matches();
    }

    public boolean checkUsername(String username) {
        for (int i = 0; i < Database.allUsers.size() - 1; i++) {
            if (Database.allUsers.get(i).getUsername().equals(username))
                return false;
        }
        return true;
    }

    public static Genre changeStringToGenre(String genre) {
        if (genre.equals("ROCK") || genre.equals("POP") || genre.equals("JAZZ") || genre.equals("HIPHOP")
                || genre.equals("COUNTRY") || genre.equals("TRUECRIME") || genre.equals("SOCIETY") || genre.equals("INTERVIEW")
                || genre.equals("HISTORY"))
            return Genre.valueOf(genre);
        else
            return Genre.valueOf("ROCK");
    }

    public static Date changeStringToDate(String strDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
        } catch (ParseException a) {
        }
        if (date == null)
            date = new Date();
        return date;
    }

    public static Audio findAudio (long ID)
    {
        Audio audio = null;
        for (Audio a : Database.allAudios)
        {
            if (a.getIdentifier() == ID)
            {
                audio = a;
            }
        }

        return audio;
    }

    public static Music findMusic (long ID)
    {
        Music music = null;
        for (Music a : Database.allMusics)
        {
            if (a.getIdentifier() == ID)
            {
                music = a;
            }
        }

        return music;
    }

    public static Podcast findPodcast (long ID)
    {
        Podcast podcast = null;
        for (Podcast a : Database.allPodcasts)
            if (a.getIdentifier() == ID)
                podcast = a;
        return podcast;
    }
}
