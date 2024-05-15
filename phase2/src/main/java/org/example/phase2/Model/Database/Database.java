package org.example.phase2.Model.Database;
import javafx.fxml.FXMLLoader;
import org.example.phase2.Model.Audios.*;
import org.example.phase2.Model.Users.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class Database {

    private ArrayList<UserAccount> users;
    private ArrayList<Audio> audios;
    private ArrayList<Report> reports;
    private Stack<FXMLLoader> scenes;
    private Stack<String> titles;
    private static Database database=new Database();
    private Database(){
        users=new ArrayList<UserAccount>();
        audios=new ArrayList<Audio>();
        reports=new ArrayList<Report>();
        scenes=new Stack<>();
        titles=new Stack<>();
    }
    public static Database getDatabase(){
        if(database==null){
            database=new Database();
        }
        return database;
    }

    public Stack<FXMLLoader> getScenes() {
        return scenes;
    }

    public void setScenes(Stack<FXMLLoader> scenes) {
        this.scenes = scenes;
    }

    public Stack<String> getTitles() {
        return titles;
    }

    public void setTitles(Stack<String> titles) {
        this.titles = titles;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public ArrayList<UserAccount> getUsers() {
        return users;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public void setUsers(ArrayList<UserAccount> users) {
        this.users = users;
    }
}
