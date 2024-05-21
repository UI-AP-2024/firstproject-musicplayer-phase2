package org.example.musicplayer.model.UserAccount.Listener;

import java.time.LocalDate;

public class FreeListenerModel extends ListenerModel{
    private final static int musicsInPlaylistLimit = 3;
    private final static int playlistsLimit = 10;
    public FreeListenerModel(String username, String password, String name, String email, String phoneNumber, LocalDate birthday) {
        super(username, password, name, email, phoneNumber, birthday);
        this.setSubscriptionExpirationDate(null);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    public int getMusicsInPlaylistLimit() {
        return musicsInPlaylistLimit;
    }
    public int getPlaylistsLimit() {
        return playlistsLimit;
    }

}
