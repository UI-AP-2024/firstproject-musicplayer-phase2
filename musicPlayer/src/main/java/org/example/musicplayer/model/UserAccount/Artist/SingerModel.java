package org.example.musicplayer.model.UserAccount.Artist;

import org.example.musicplayer.model.AlbumModel;

import java.time.LocalDate;
import java.util.ArrayList;


public class SingerModel extends ArtistModel{
    private ArrayList<AlbumModel> albums;
    public SingerModel(String username, String password, String name, String email, String phoneNumber, LocalDate birthday, String biography) {
        super(username, password, name, email, phoneNumber, birthday, biography);
        this.albums = new ArrayList<AlbumModel>();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public ArrayList<AlbumModel> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<AlbumModel> albums) {
        this.albums = albums;
    }
}
