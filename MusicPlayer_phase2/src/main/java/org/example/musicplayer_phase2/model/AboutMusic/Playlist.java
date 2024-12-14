package org.example.musicplayer_phase2.model.AboutMusic;

import java.util.ArrayList;
import java.util.Iterator;

public class Playlist implements Iterable<Audio>{
    private final int identifier;
    private static int playlistNumber = 0;
    private final String playlistName;
    private final String personName;
    private int numberOfMusics = 0;
    private ArrayList<Audio> audioFiles = new ArrayList<>();
    public Playlist( String playlistName, String personName) {
        this.playlistName = playlistName;
        this.personName = personName;
        identifier = playlistNumber;
        playlistNumber++;
    }

    public int getIdentifier() {
        return identifier;
    }

    public static int getPlaylistNumber() {
        return playlistNumber;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getPersonName() {
        return personName;
    }

    public ArrayList<Audio> getAudioFiles() {
        return audioFiles;
    }

    public void setAudioFiles(Audio audio) {
        this.audioFiles.add(audio);
    }

    public int getNumberOfMusics() {
        return numberOfMusics;
    }

    public void setNumberOfMusics(int numberOfMusics) {
        this.numberOfMusics = numberOfMusics;
    }

    @Override
    public String toString()
    {
        return "identifier: " + identifier + "\nplaylists name: " + playlistName + "\n";
    }

    @Override
    public Iterator<Audio> iterator() {
        return new Iterator<Audio>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < audioFiles.size();
            }

            @Override
            public Audio next() {
                return audioFiles.get(index++);
            }
        };
    }
}
