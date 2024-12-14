package model;
import model.Audio.Audio;
import model.UserAccount.UserAccount;

import java.util.ArrayList;

public class Database
{
    private static Database database;
    private ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();
    private ArrayList<Audio> audio = new ArrayList<Audio>();
    private ArrayList<Report> reports = new ArrayList<Report>();
    public ArrayList<UserAccount> getUserAccounts() {
        return userAccounts;
    }
    public void setUserAccounts(ArrayList<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }
    public ArrayList<Audio> getAudio() {
        return audio;
    }
    public void setAudio(ArrayList<Audio> audio) {
        this.audio = audio;
    }
    public ArrayList<Report> getReports() {
        return reports;
    }
    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
//    public static Database getDatabase() {
//        return database;
//    }
//    public static void setDatabase(Database database) {
//        Database.database = database;
//    }

    public Database()
    {
//        this.userAccounts = userAccounts;
//        this.audio = audio;
//        this.reports = reports;
        this.userAccounts = new ArrayList<>();
        this.audio = new ArrayList<>();
        this.reports = new ArrayList<>();
    }
    public static Database getDatabase()
    {
        if(database == null)
        {
            database = new Database();
        }
        return database;
    }
}
