package org.example.spotifysecondfase.model;

import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;
import org.example.spotifysecondfase.model.UserAccount.UserAccount;

public class Report
{
    private UserAccount reportingUser;
    private Artist reportedArtist;
    private String description;
    public Report(UserAccount reportingUser, Artist reportedArtist, String description) {
        this.reportingUser = reportingUser;
        this.reportedArtist = reportedArtist;
        this.description = description;
    }
    public UserAccount getReportingUser() {
        return reportingUser;
    }
    public void setReportingUser(UserAccount reportingUser) {
        this.reportingUser = reportingUser;
    }
    public Artist getReportedArtist() {
        return reportedArtist;
    }
    public void setReportedArtist(Artist reportedArtist) {
        this.reportedArtist = reportedArtist;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString()
    {
        return "ReportingUser: "+getReportingUser()+"\t"+"ReportedArtist: "+getReportedArtist()+"\t"+"Report: "+getDescription();
    }
}
