package org.example.musicap.Controllers;

import org.example.musicap.Models.Album;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.User.Artist;
import org.example.musicap.Models.User.Listener;
import org.example.musicap.Models.User.User;

import java.util.ArrayList;
import java.util.Map;

public abstract class ArtistController extends UserController{
    public ArtistController(Artist artistModel)
    {
        database = Database.getInstance();
        this.artistModel = artistModel;
    }
    private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    private Artist artistModel;

    public Artist getArtistModel() {
        return artistModel;
    }

    public void setArtistModel(Artist artistModel) {
        this.artistModel = artistModel;
    }

    public abstract double calculateIncome();
    public int getPlayedCount()
    {
        Artist artist = this.getArtistModel();
        Database tmpDatabase = Database.getInstance();
        int playedCount = 0;
        for(User tmpUser : tmpDatabase.getUsers())
        {
            if(tmpUser instanceof Listener)
            {
                Listener tmpListener = (Listener) tmpUser;
                for(Map.Entry tmpEntry : tmpListener.getAudiosPlayed().entrySet())
                {
                    Audio tmpAudio = (Audio)tmpEntry.getKey();
                    if(tmpAudio.getArtistName().equals(artist.getName()))
                    {
                        playedCount += (Integer) tmpEntry.getValue();
                    }
                }
            }
        }
        return playedCount;
    }

    public ArrayList<User> showFollowers()
    {
        return this.getArtistModel().getFollowers();
    }

    public String showArtistInfo()
    {
        return this.getArtistModel().toString();
    }
    public ArrayList<Audio> showAudios()
    {
        ArrayList<Audio> result = new ArrayList<>();
        for(Audio tmpAudio : database.getAudios())
        {
            if(tmpAudio.getArtistName().equals(artistModel.getUsername()))
                result.add(tmpAudio);
        }
        return result;
    }
    public void followArtist(User followingUser)
    {
        // following and unfollowing artist
        if(isFollowedBy(followingUser)) artistModel.getFollowers().remove(followingUser);
        else artistModel.getFollowers().add(followingUser);
    }
    public boolean isFollowedBy(User followingUser)
    {
        boolean flag = false;
        for(User tmpUser : artistModel.getFollowers())
        {
            if(tmpUser.equals(followingUser)) flag = true;
            break;
        }
        return flag;

    }
}
