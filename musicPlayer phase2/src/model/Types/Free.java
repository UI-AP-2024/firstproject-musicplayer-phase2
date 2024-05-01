package model.Types;

import model.AboutHumans.Listener;

public class Free extends Listener {

    public Free(String name, String username, String password, String email, String number, String birthday) {
        super(name, username, password, email, number, birthday);
    }

    private int numberOfPlaylists = 0;

    public int getNumberOfPlaylists() {
        return numberOfPlaylists;
    }

    public void setNumberOfPlaylists(int numberOfPlaylists) {
        this.numberOfPlaylists = numberOfPlaylists;
    }

    @Override
    public String toString()
    {
        return "you have " + numberOfPlaylists + " playlists" + "\n";
    }
}
