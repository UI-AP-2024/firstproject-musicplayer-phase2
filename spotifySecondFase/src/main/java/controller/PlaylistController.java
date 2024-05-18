package controller;

import model.Audio.Audio;
import model.Database;
import model.Playlist;

import java.util.ArrayList;

public class PlaylistController
{
    private StringBuilder playLists;
    public StringBuilder getPlayLists() {return playLists;}
    public void setPlayLists(StringBuilder playLists) {this.playLists = playLists;}
    private ArrayList<Audio> audioArrayList = new ArrayList<Audio>();
    public ArrayList<Audio> getAudioArrayList() {return audioArrayList;}
    public void setAudioArrayList(ArrayList<Audio> audioArrayList) {this.audioArrayList = audioArrayList;}
    public ArrayList<Audio> addAudioToPlaylist(String audio)
    {
        for(int i=0; i<Database.getDatabase().getAudio().size();i++)
        {
            if(Database.getDatabase().getAudio().get(i).getName().equals(audio))
            {
                getAudioArrayList().add(Database.getDatabase().getAudio().get(i));
            }
        }
        return getAudioArrayList();
    }
    public void addPlaylist(Playlist playlist)
    {
        playLists.append(playlist);
        playLists.append("  ");
    }
    public StringBuilder showPlaylist()
    {
        return playLists;
    }
}
