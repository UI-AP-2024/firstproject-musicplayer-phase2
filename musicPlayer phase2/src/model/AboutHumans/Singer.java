package model.AboutHumans;

import model.AboutMusic.Album;
import model.Database;

import java.util.ArrayList;

public class Singer extends Artist {
    public Singer(String name, String username, String password, String email, String number, String birthday, String biography) {
        super(name, username, password, email, number, birthday, biography);
        Database.setAllSingers(this);
    }

    ArrayList<Album> allAlbums = new ArrayList<>();
    public StringBuilder getAllAlbumsName()
    {
        StringBuilder allAlbums = new StringBuilder();
        for (Album a : this.allAlbums)
            allAlbums.append(a.getName() + "\n");
        return allAlbums;
    }

    public ArrayList<Album> getAllAlbums() {
        return allAlbums;
    }

    public void setAllAlbums(Album album) {
        this.allAlbums.add(album);
    }

    @Override
    public String toString()
    {
        return super.toString() + this.getAllAlbumsName();
    }
}
