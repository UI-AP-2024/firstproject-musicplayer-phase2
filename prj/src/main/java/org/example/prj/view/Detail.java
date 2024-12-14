package org.example.prj.view;

import javafx.scene.Scene;
import org.example.prj.controller.MediaController;
import org.example.prj.model.Album;
import org.example.prj.model.Artist;
import org.example.prj.model.Audio;
import org.example.prj.model.Playlist;

import java.util.ArrayList;
import java.util.Stack;

public class Detail {
    private static Detail detail;

    private Detail() {
    }

    public static Detail getDetail() {
        if (detail == null)
            detail = new Detail();
        return detail;
    }


    public static Boolean login = false;
    public static Stack<Scene> lastScene = new Stack<>();
    public static Boolean podcaster = false;
    public static Boolean listener = false;
    public static Boolean singer = false;
    public static Boolean admin = false;
    public static Audio selectAudio;
    public static String selectPlayList;
    public static Artist selectArtist;
    public static Album selectAlbum;
    public Boolean play=false;
    public Boolean pause=true;
    public Boolean playList=false;
    public Boolean random=true;
    public int countPlayList=0;
    public int countRandom=0;
    public ArrayList<Audio> search = new ArrayList<>();

}
