package org.example.phase2.Model.Users;

import java.text.ParseException;
import java.util.Date;

public class FreeListener extends Listener{

    private final static int numberOfPlaylistAudios=10;
    private final static int numberOfPlaylists=3;
    public FreeListener(String username, String password, String firstAndLastName, String emailAddress, String phoneNumber, Date birthDate) throws ParseException {
        super(username, password, firstAndLastName, emailAddress, phoneNumber, birthDate);
    }
    public int getNumberOfPlaylistAudios(){
        return numberOfPlaylistAudios;
    }
    public int getNumberOfPlaylists(){
        return numberOfPlaylists;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        return info.toString();
    }
}
