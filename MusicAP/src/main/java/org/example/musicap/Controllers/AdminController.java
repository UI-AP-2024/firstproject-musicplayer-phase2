package org.example.musicap.Controllers;

import org.example.musicap.Exceptions.NotFoundExeption;
import org.example.musicap.Exceptions.UserNotFoundException;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Report;
import org.example.musicap.Models.User.Admin;
import org.example.musicap.Models.User.Artist;
import org.example.musicap.Models.User.User;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AdminController extends UserController{
    private static AdminController adminController;
    private Database database;
    private Admin adminModel;
    private AdminController()
    {
        database = Database.getInstance();
        adminModel = Admin.getInstance();
    }
    public static AdminController getAdminController()
    {
        if(adminController == null) adminController = new AdminController();
        return adminController;
    }
    public ArrayList<Audio> showMostLiked(int pages, int pageNumber)
    {
        ArrayList<Audio> result = database.getAudios();
        result = result.stream().sorted((aud1, aud2) -> aud1.getLikesCount() - aud2.getLikesCount())
                .collect(Collectors.toCollection(ArrayList::new));
        return paging(pages, pageNumber, result);
    }
    private Artist findArtistByUserName(String userName)
    {
        Artist selectedArtist = null;
        for(User tmpUser : database.getUsers()) if(tmpUser instanceof Artist)
        {
            Artist tmpArtist = (Artist) tmpUser;
            if(tmpArtist.getUsername().equals(userName)) selectedArtist = tmpArtist;
            break;
        }
        return selectedArtist;
    }
    public String showArtistInfo(String artistUserName)
    {
        Artist selectedArtist = findArtistByUserName(artistUserName);
        if(selectedArtist == null) throw new UserNotFoundException("No artist found");
        return selectedArtist.toString();
    }

    private Audio findAudioById(int audioId)
    {
        Audio selectedAudio = null;
        for(Audio tmpAudio : database.getAudios())
        {
            if(tmpAudio.getId() == audioId) selectedAudio = tmpAudio;
            break;
        }
        return selectedAudio;
    }
    public String showAudioInfo(int audioId) throws NotFoundExeption {
        Audio selectedAudio = findAudioById(audioId);
        if(selectedAudio == null) throw new NotFoundExeption("No audio found");
        return selectedAudio.toString();
    }
    public ArrayList<Artist> showArtists()
    {
        ArrayList<Artist> result = new ArrayList<>();
        for(User tmpUser : database.getUsers())
        {
            if(tmpUser instanceof Artist) result.add((Artist)tmpUser);
        }
        return result;
    }

    private ArrayList<Audio> paging(int pages, int pageNumber, ArrayList<Audio> audios)
    {
        ArrayList<Audio> result = new ArrayList<>();
        if(audios.size()==0) return result;
        int audiosPerPage = audios.size() / pages;
        int audiosLeft = audiosPerPage % pages;
        int startIndex,endIndex;
        if (pageNumber <= audiosLeft)
        {
            startIndex = (audiosPerPage + 1) * (pageNumber - 1);
            endIndex = startIndex + audiosPerPage + 1;
        }
        else
        {
            startIndex = (audiosPerPage + 1) * audiosLeft + audiosPerPage * (pageNumber - audiosLeft - 1);
            endIndex = startIndex + audiosPerPage;
        }
        for(int i=startIndex; i<endIndex; i++) result.add(audios.get(i));
        return result;
    }
    public ArrayList<Report> showReports()
    {
        return database.getReports();
    }
    public ArrayList<Audio> showAudios(int pages, int pageNumber)
    {
        return paging(pages, pageNumber, database.getAudios());
    }
    public String showAdminInfo()
    {
        return adminModel.toString();
    }
}
