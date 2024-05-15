package org.example.spotifysecondfase.controller;
import org.example.spotifysecondfase.model.Audio.Audio;
import org.example.spotifysecondfase.model.Database;
import org.example.spotifysecondfase.model.Playlist;
import org.example.spotifysecondfase.model.Report;
import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;
import org.example.spotifysecondfase.model.UserAccount.Listener.Free;
import org.example.spotifysecondfase.model.UserAccount.Listener.Listener;
import org.example.spotifysecondfase.model.UserAccount.UserAccount;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ListenerController extends UserAccountController
{
    static ListenerController listenerController;
    private Listener listener;
    public Listener getListener() {return listener;}
    public void setListener(Listener listener) {this.listener = listener;}
    public Listener newListener(String email, String name, String phoneNumber, Date dateOfBirth, String userName, String passWord)
    {
        listener = newListener(email,name,phoneNumber,dateOfBirth,userName,passWord);
        Database.getDatabase().getUserAccounts().add(listener);
        return listener;
    }

    public boolean checkEmail(String email)
    {
        String regexEmail = "[a-zA-Z0-9.-]@(gmail|yahoo)\\.com$";
        Pattern pattern1 = Pattern.compile(regexEmail);
        Matcher matcher1 = pattern1.matcher(email);
        return matcher1.matches();
    }
    public boolean checkPhoneNumber(String phoneNumber)
    {
        String regexPhoneNumber = "0[0-9]{11,12}";
        Pattern pattern2 = Pattern.compile(regexPhoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        return matcher2.matches();
    }
    public void listenerType()
    {
        Boolean bool = listener instanceof Free;
        if (bool.equals(true))
        {
            listener.getPlaylists().ensureCapacity(3);
            playlist.getPlayList().ensureCapacity(10);
        }
    }
    private Playlist playlist;
    public Playlist getPlaylist() {
        return playlist;
    }
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
    public void makePlaylist(String name)
    {
        playlist = new Playlist(name);
        getListener().getPlaylists().add(getPlaylist());
    }
    private Audio audio ;
    public Audio getAudio() {
        return audio;
    }
    public void setAudio(Audio audio) {
        this.audio = audio;
    }
    public void addAudioToPlaylist(String audioName)
    {
        for (Audio i : Database.getDatabase().getAudio())
        {
            if(i.getName().equals(audioName))
            {
                getPlaylist().getPlayList().add(getAudio());
            }
        }
    }
    public void playAudio(String audioName)
    {
        for (Audio i : Database.getDatabase().getAudio())
        {
            if(i.getName().equals(audioName))
            {
                listener.getMap().put(audioName,i.getPlaysCount()+1);
            }
        }
    }
    public void likeAudio(String audioName)
    {
        for (Audio i : Database.getDatabase().getAudio())
        {
            if(i.getName().equals(audioName))
            {
                audio.setLikesCount(audio.getLikesCount()+1);
            }
        }
    }
//    private ArrayList<String> artists = new ArrayList<String>();
//    public ArrayList<String> getArtists() {
//        return artists;
//    }
//    public void setArtists(ArrayList<String> artists) {
//        this.artists = artists;
//    }
    private UserAccount userAccount;
    public UserAccount getUserAccount() {return userAccount;}
    public void setUserAccount(UserAccount userAccount) {this.userAccount = userAccount;}
    private Artist artist;
    public Artist getArtist() {return artist;}
    public void setArtist(Artist artist) {this.artist = artist;}
//    private ArrayList<Artist> following = new ArrayList<Artist>();
//    public ArrayList<Artist> getFollowing() {return following;}
//    public void setFollowing(ArrayList<Artist> following) {this.following = following;}
    private ArrayList<Artist> artistArrayList = new ArrayList<Artist>();
    public ArrayList<Artist> getArtistArrayList() {return artistArrayList;}
    public void setArtistArrayList(ArrayList<Artist> artistArrayList) {this.artistArrayList = artistArrayList;}
    public void artistsList(Artist artist) {getArtistArrayList().add(artist);}
    public StringBuilder showFollowing(String artistName)
    {
        for (Artist i:artistArrayList)
        {
            if (i.getName().equals(artistName))
            {
                i.getFollowers().add(userAccount);
//                listener.setFollowing(new StringBuilder(artistName + " ,"));
                listener.getFollowing().append(artistName).append(" ,");
            }
        }
        return listener.getFollowing();
    }
    public ArrayList<Artist> showArtists()
    {
        return getArtistArrayList();
    }
    public StringBuilder showArtistInfo(String artistName) {
        StringBuilder info = null;
        for (Artist i : artistArrayList) {
            if (i.getName().equals(artistName)) {
                info = new StringBuilder(i.toString());
                info.append("\n");
            }
        }
        return info;
    }
    private Report report;
    public Report getReport() {return report;}
    public void setReport(Report report) {this.report = report;}
    public void description(String description, String artistName)
    {
        for (Artist i : artistArrayList)
        {
            if (i.getName().equals(artistName))
            {
                getReport().setDescription(description);
                getReport().getReportingUser().setName(userAccount.getName());
                getReport().getReportedArtist().setName(artistName);
                Database.getDatabase().getReports().add(getReport());
            }
        }
    }
    public ArrayList<Playlist> showPlaylist() {return listener.getPlaylists();}
    public String playListInfo(String playListName)
    {
        String info = null;
        for (Playlist p : listener.getPlaylists())
        {
            if (p.getPlayListName().equals(playListName))
            {
//                info = String.valueOf(getPlaylist().getPlayList());
                info = p.toString();

            }
        }
        return info;
    }
    public String userInfo()
    {
        return listener.toString();
    }
    public abstract void buyOrRenew(int money);
//    private ArrayList<String> search = new ArrayList<String>();
//    public ArrayList<String> getSearch() {return search;}
//    public void setSearch(ArrayList<String> search) {this.search = search;}
    private StringBuilder search;
    public StringBuilder getSearch() {return search;}
    public void setSearch(StringBuilder search) {this.search = search;}
    public StringBuilder searching(String string)
    {
        for(int i=0; i<Database.getDatabase().getAudio().size();i++)
        {
            if(string.contains((Database.getDatabase().getAudio().get(i).getName())))
            {
//                getSearch().add(Database.getDatabase().getAudio().get(i).getName());
//                search = new StringBuilder(Database.getDatabase().getAudio().get(i).getName());
                search.append(Database.getDatabase().getAudio().get(i).getName());
                search.append("\n");
            }
        }
        for(int i=0; i<getArtistArrayList().size();i++)
        {
            if(string.contains(getArtistArrayList().get(i).getName()))
            {
//                getSearch().add(getArtistArrayList().get(i).getName());
//                search = new StringBuilder(getArtistArrayList().get(i).getName());
                search.append(getArtistArrayList().get(i).getName());
                search.append("\n");
            }
        }
        return search;
    }
    public void ordering()
    {
//        if (str.equals("like"))
//        {
           for (int i=0; i<Database.getDatabase().getAudio().size()-1; i++)
           {
               for (int j=0; j<Database.getDatabase().getAudio().size()-1; j++)
               {
                   if(Database.getDatabase().getAudio().get(j).getLikesCount() < Database.getDatabase().getAudio().get(j+1).getLikesCount())
                   {
                       Audio temp = Database.getDatabase().getAudio().get(j);
                       Database.getDatabase().getAudio().set(j,Database.getDatabase().getAudio().get(j+1));
                       Database.getDatabase().getAudio().set(j+1,temp);
                   }
               }
           }
//        }
//        if (str.equals("play"))
//        {
//            int j;
//            for (int i=0; i<Database.getDatabase().getAudio().size()-1; i++)
//            {
//                for (j=1; j<Database.getDatabase().getAudio().size(); j++)
//                {
//                    if(Database.getDatabase().getAudio().get(i).getPlaysCount() < Database.getDatabase().getAudio().get(j).getPlaysCount())
//                    {
//                        Audio temp = Database.getDatabase().getAudio().get(i);
//                        Database.getDatabase().getAudio().set(i,Database.getDatabase().getAudio().get(j));
//                        Database.getDatabase().getAudio().set(j,temp);
//                    }
//                }
//                j = 1;
//            }
//        }
    }
    public String filter(String filteringMethod,Object obj)
    {
        ArrayList<Audio> audios = new ArrayList<>();
        if (Objects.equals(filteringMethod,"artist"))
        {
            for (Audio a : Database.getDatabase().getAudio())
            {
                if (a.getArtistName().equals(obj))
                {
                    audios.add(a);
                }
            }
        }
        else if (Objects.equals(filteringMethod,"genre"))
        {
            for (Audio a : Database.getDatabase().getAudio())
            {
                if (a.getGenre().name().equals(obj))
                {
                    audios.add(a);
                }
            }
        }
        return String.valueOf(audios);
    }
}
