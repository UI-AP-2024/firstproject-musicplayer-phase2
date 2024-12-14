package model;
import model.Audio.Audio;
import model.UserAccount.UserAccount;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Playlist implements Iterable
{
    private StringBuilder id;
    public StringBuilder getId() {
        return id;
    }
    public void setId(StringBuilder id) {
        this.id = id;
    }
    private int i = 1;
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    private String playListName;
    public String getPlayListName() {
        return playListName;
    }
    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }
    private UserAccount userAccount;
    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    private String nameOfUserAccount;
    public String getNameOfUserAccount() {return nameOfUserAccount;}
    public void setNameOfUserAccount(String nameOfUserAccount) {
        this.nameOfUserAccount = nameOfUserAccount;
    }
    private ArrayList<Audio> playList = new ArrayList<Audio>();
    public ArrayList<Audio> getPlayList() {
        return playList;
    }
    public void setPlayList(ArrayList<Audio> playList) {
        this.playList = playList;
    }
    public Playlist(String name)
    {
        this.playListName = name;
        this.nameOfUserAccount = getUserAccount().getName();
        id = new StringBuilder(this.nameOfUserAccount);
        id.append(" Liked Songs");
        id.append(i++);
    }
    public String toString()
    {
        return "PlayList ID: "+getId()+"\t"+"PlayList name: "+getPlayListName();
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
//        for ()
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
