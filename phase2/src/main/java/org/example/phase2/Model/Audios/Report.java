package org.example.phase2.Model.Audios;

import org.example.phase2.Model.Users.Artist;
import org.example.phase2.Model.Users.Listener;

public class Report{
    private Listener reporter;
    private Artist reportedArtist;
    private String description;
    public Report(Listener reporter,Artist reportedArtist,String description){
        this.reporter=reporter;
        this.reportedArtist=reportedArtist;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public Artist getReportedArtist() {
        return reportedArtist;
    }

    public Listener getReporter() {
        return reporter;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReportedArtist(Artist reportedArtist) {
        this.reportedArtist = reportedArtist;
    }

    public void setReporter(Listener reporter) {
        this.reporter = reporter;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append("Reporter: "+reporter+"\n");
        info.append("Reported artist: "+reportedArtist+"\n");
        info.append("Description: "+description+"\n\n");
        return info.toString();
    }
}
