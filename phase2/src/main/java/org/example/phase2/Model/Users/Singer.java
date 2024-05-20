package org.example.phase2.Model.Users;

import org.example.phase2.Model.Audios.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Singer extends Artist{

    private ArrayList<Album> album;
    public Singer(String userName, String password, String firstAndLastName, String emailAddress, String phoneNumber, Date birthDate, String biography) throws ParseException {
        super(userName, password, firstAndLastName, emailAddress, phoneNumber, birthDate,biography);
        album=new ArrayList<Album>();
    }

    public ArrayList<Album> getAlbum() {
        return album;
    }

    public void setAlbum(ArrayList<Album> album) {
        this.album = album;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        return info.toString();
    }
}
