package org.example.musicplayer.model.DataBase;

import org.example.musicplayer.model.Audio.AudioModel;
import org.example.musicplayer.model.ReportModel;
import org.example.musicplayer.model.UserAccount.UserAccountModel;

import java.util.ArrayList;
import java.util.Map;

public class DataBaseModel {

    private ArrayList<UserAccountModel> users;
    private ArrayList<AudioModel> audios;
    private ArrayList<ReportModel> reports;

    private DataBaseModel() {
        this.users = new ArrayList<UserAccountModel>();
        this.audios = new ArrayList<AudioModel>();
        this.reports = new ArrayList<ReportModel>();
    }
    private static DataBaseModel dataBase;

    public static DataBaseModel getDataBase() {
        if (dataBase == null)
            dataBase = new DataBaseModel();
        return dataBase;
    }
    public ArrayList<UserAccountModel> getUsers() {
        return users;
    }

    public ArrayList<AudioModel> getAudios() {
        return audios;
    }

    public ArrayList<ReportModel> getReports() {
        return reports;
    }

    public void setUsers(ArrayList<UserAccountModel> users) {
        this.users = users;
    }

    public void setAudios(ArrayList<AudioModel> audios) {
        this.audios = audios;
    }

    public void setReports(ArrayList<ReportModel> reports) {
        this.reports = reports;
    }
}
