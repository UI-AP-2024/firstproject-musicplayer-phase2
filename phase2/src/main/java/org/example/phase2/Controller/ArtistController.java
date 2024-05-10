package org.example.phase2.Controller;

import org.example.phase2.Model.Audios.*;
import org.example.phase2.Model.Users.*;
import org.example.phase2.Model.Database.*;

import java.util.ArrayList;

public class ArtistController{
    private static ArtistController artistController;
    Artist artist;
    private ArtistController(){

    }
    public static ArtistController getArtistController()
    {
        if(artistController==null)
        {
            artistController=new ArtistController();
        }
        return artistController;
    }
    public void findArtist(String username)
    {
        ArrayList<UserAccount> users= Database.getDatabase().getUsers();
        for(UserAccount user:users)
        {
            if(username.equals(user.getUsername()))
            {
                setArtist((Artist) user);
            }
        }
    }
    public void setArtist(Artist artist)
    {
        this.artist=artist;
    }
    public String showFollowers()
    {
        StringBuilder info = new StringBuilder("Your followers\n");
        for(UserAccount user : artist.getFollowers())
        {
            info.append("Name: "+user.getFirstAndLastName()+"\t\tUsername: "+user.getUsername()+"\n");
        }
        return info.toString();
    }
    public String showMyAudios()
    {
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        StringBuilder info = new StringBuilder();
        for(Audio audio:audios)
        {
            if(audio.getArtist().equals(artist.getFirstAndLastName()))
            {
                info.append("Name: "+audio.getName()+"\tPlays: "+audio.getNumberOfListening()+"\tLikes: "+audio.getLikes()+"\n");
            }
        }
        return info.toString();
    }
    public Double calculateIncome()
    {
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        double income=0;
        for(Audio audio:audios)
        {
            if(audio.getArtist().equals(artist.getFirstAndLastName()) && artist instanceof Podcaster)
            {
                income+=0.5;
            }
            if(audio.getArtist().equals(artist.getFirstAndLastName()) && artist instanceof Singer)
            {
                income+=0.4;
            }
        }
        return income;
    }
    public String showAccountInfo()
    {
        StringBuilder info = new StringBuilder();
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        for(UserAccount user : users)
        {
            if(user.getUsername().equals(artist.getUsername()))
            {
                info.append("Name: "+user.getFirstAndLastName()+"\n");
                info.append("Birth date: "+user.getBirthDate()+"\n");
                info.append("Email address: "+user.getEmailAddress()+"\n");
                info.append("Phone number: "+user.getPhoneNumber()+"\n");
                info.append("Income: "+calculateIncome()+"\n");
                break;
            }
        }
        return info.toString();
    }
    public String publishPodcast(String title,String genre,String caption,String link,String cover)
    {
        Podcast newPodcast=new Podcast(title, artist.getFirstAndLastName(), Genre.valueOf(genre),link,cover,caption);
        Database.getDatabase().getAudios().add(newPodcast);
        return "New podcast published successfully.";
    }
    public String createNewAlbum(String nameOfAlbum)
    {
        Album newAlbum = new Album(nameOfAlbum, artist.getFirstAndLastName());
        Singer singer=(Singer) artist;
        singer.getAlbum().add(newAlbum);
        return "New album created successfully.";
    }
    public String publishMusic(String title,String genre,String lyric,String link,String cover,long albumId)
    {
        Music newMusic=new Music(title,artist.getFirstAndLastName(),Genre.valueOf(genre),link,cover,lyric);
        Database.getDatabase().getAudios().add(newMusic);
        Singer singer=(Singer) artist;
        for(Album album : singer.getAlbum())
        {
            if(album.getId()==albumId)
            {
                album.getMusicArrayList().add(newMusic);
            }
        }
        return "New music published successfully.";
    }
    public String help()
    {
        StringBuilder commands=new StringBuilder();
        commands.append("1. Signup -L|S|P -[username] -[password] -[name] -[email] -[phone number]" +
                "-[birth date] -[bio]\n");
        commands.append("3. Login -[username] -[password]\n");
        commands.append("4. Logout\n");
        commands.append("5. AccountInfo\n");
        commands.append("6. Followers\n");
        commands.append("7. ViewsStatistics\n");
        commands.append("8. CalculateEarnings\n");
        commands.append("9. NewAlbum -[name]\n");
        if(artist instanceof Podcaster)
        {
            commands.append("10. Publish -M|P -[title] -[genre] -[lyric|caption] -[link] -[cover]\n");
        }
        if(artist instanceof Singer)
        {
            commands.append("10. Publish -M|P -[title] -[genre] -[lyric|caption] -[link] -[cover] -[album ID]\n");
        }
        return commands.toString();
    }
}
