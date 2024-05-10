package org.example.phase2.Model.Database;
import org.example.phase2.Model.Audios.*;
import org.example.phase2.Model.Users.*;

import java.util.ArrayList;
import java.util.Date;

public class Database {

    private ArrayList<UserAccount> users;
    private ArrayList<Audio> audios;
    private ArrayList<Report> reports;
    private static Database database=new Database();
    private Database(){
        users=new ArrayList<UserAccount>();
        audios=new ArrayList<Audio>();
        reports=new ArrayList<Report>();
    }
    public static Database getDatabase(){
        if(database==null){
            database=new Database();
        }
        return database;
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
