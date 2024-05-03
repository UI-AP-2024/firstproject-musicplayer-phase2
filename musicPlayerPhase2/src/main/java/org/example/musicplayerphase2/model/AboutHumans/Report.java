package org.example.musicplayerphase2.model.AboutHumans;

import org.example.musicplayerphase2.model.*;
import org.example.musicplayerphase2.model.AboutHumans;
public class Report {
    private UserAccount reporterPerson;
    private UserAccount reportedArtist;
    private String explanation;

    public Report(UserAccount reporterPerson, UserAccount reportedArtist, String explanation) {
        this.reporterPerson = reporterPerson;
        this.reportedArtist = reportedArtist;
        this.explanation = explanation;
        Database.setAllReports(this);
    }

    public UserAccount getReporterPerson() {
        return reporterPerson;
    }

    public UserAccount getReportedArtist() {
        return reportedArtist;
    }

    public String getExplanation() {
        return explanation;
    }

    @Override
    public String toString()
    {
        return "reporter person: " + reporterPerson.getUsername() + "\nreported artist: " + reportedArtist + "report: " + explanation;
    }
}
