package org.example.prj.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Playlist implements Iterable<Audio> {
    private long id;
    private String nameOfPlaylist;
    private String nameOfCreator;
    private ArrayList<Audio> listAudio;

    @Override
    public String toString(){
        String result = "";
        result += "Playlist Id: "+getId()+"\tPlaylist Name: "+getNameOfPlaylist()+"\tCreator Name: "+getNameOfCreator();
        String result2 = "";
        for ( Audio audio : getListAudio()){
            result2 += audio+"\n";
        }
        if ( result2.equals(""))
            result += "\nAudios: empty";
        else
            result += "\nAudios:\n "+result2;
        return result;
    }



    private int current = 0;
    private int element = 0;
    @Override
    public Iterator iterator(){
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return element < listAudio.size();
            }
            @Override
            public Audio next() {
                Audio x =listAudio.get(current);
                current = (current + 1) ;
                element++;
                return x;
            }
        };
    }

    public Playlist(long id, String nameOfPlaylist, String nameOfCreator/*, ArrayList<Audio> listAudio*/) {
        this.id = id;
        this.nameOfPlaylist = nameOfPlaylist;
        this.nameOfCreator = nameOfCreator;
//        this.listAudio = listAudio;
        this.listAudio = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getNameOfPlaylist() {
        return nameOfPlaylist;
    }

    public String getNameOfCreator() {
        return nameOfCreator;
    }

    public ArrayList<Audio> getListAudio() {
        return listAudio;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNameOfPlaylist(String nameOfPlaylist) {
        this.nameOfPlaylist = nameOfPlaylist;
    }

    public void setNameOfCreator(String nameOfCreator) {
        this.nameOfCreator = nameOfCreator;
    }

    public void setListAudio(ArrayList<Audio> listAudio) {
        this.listAudio = listAudio;
    }
}
