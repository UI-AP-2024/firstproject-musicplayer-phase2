package controller;
import javafx.scene.control.Alert;
import model.Audio.Audio;
import model.Database;
import model.Playlist;
import model.Report;
import model.UserAccount.Artist.Artist;
import model.UserAccount.Listener.Free;
import model.UserAccount.Listener.Listener;
import model.UserAccount.UserAccount;
import org.example.spotifysecondfase.Exception.InvalidFormat;
import org.example.spotifysecondfase.Exception.NotEnoughCredit;

import java.util.*;

public class ListenerController extends UserAccountController
{
    private Listener listener;
    public Listener getListener() {return listener;}
    public void setListener(Listener listener) {this.listener = listener;}
    public Listener newListener(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day)
    {
            listener = newListener(userName,passWord,name,email,phoneNumber,year,month,day);
//            Database.getDatabase().getUserAccounts().add(listener);
            Database.getDatabase().getUserAccounts().add(listener);
            return listener;
    }
//    public boolean check()
//    {
//       return userAccountController.findUser(listener.getUserName(),listener.getPassWord());
//    }
//    public boolean checkEmail()
//    {
//        return userAccountController.checkEmail(listener.getEmail());
//    }
//    public boolean checkPhone()
//    {
//        return userAccountController.checkPhoneNumber(listener.getPhoneNumber());
//    }
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
        boolean b = listener instanceof Free;
        if (b)
        {
            //freeLimit
        }
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
    public void follow(String artistName)
    {
        for (Artist i:artistArrayList)
        {
            if (i.getName().equals(artistName))
            {
                i.getFollowers().add(userAccount);
//                listener.setFollowing(new StringBuilder(artistName + " ,"));
//                listener.getFollowing().append(artistName).append(" ,");
                listener.getFollowing().add(i);
            }
        }
    }
    public ArrayList<Artist> showFollowing()
    {
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
    public void buyOrRenew(int money) throws NotEnoughCredit
    {
        boolean b = listener instanceof Free;
        if (b)
        {
            if (listener.getAccountCredit() >= money)
            {
                listener.setAccountCredit(listener.getAccountCredit() - money);
                b = false;
            }
            else {
                try {
                    throw new NotEnoughCredit("Credit is not enough");
                } catch (NotEnoughCredit e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
        }
        else {
            if (listener.getAccountCredit() >= money)
            {
                listener.setAccountCredit(listener.getAccountCredit() - money);
            }
            else {
                try {
                    throw new NotEnoughCredit("Credit is not enough");
                } catch (NotEnoughCredit e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }            }
        }

    }
//    private ArrayList<String> search = new ArrayList<String>();
//    public ArrayList<String> getSearch() {return search;}
//    public void setSearch(ArrayList<String> search) {this.search = search;}
    private ArrayList<String> search;
    public ArrayList<String> getSearch() {return search;}
    public void setSearch(ArrayList<String> search) {this.search = search;}
    public ArrayList<String> searching(String string)
    {
        for(int i=0; i<Database.getDatabase().getAudio().size();i++)
        {
            if(string.contains((Database.getDatabase().getAudio().get(i).getName())))
            {
                getSearch().add(Database.getDatabase().getAudio().get(i).getName());
//                search = new StringBuilder(Database.getDatabase().getAudio().get(i).getName());
//                search.append(Database.getDatabase().getAudio().get(i).getName());
//                search.append("\n");
            }
        }
        for(int i=0; i<getArtistArrayList().size();i++)
        {
            if(string.contains(getArtistArrayList().get(i).getName()))
            {
                getSearch().add(getArtistArrayList().get(i).getName());
//                search = new StringBuilder(getArtistArrayList().get(i).getName());
//                search.append(getArtistArrayList().get(i).getName());
//                search.append("\n");
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
