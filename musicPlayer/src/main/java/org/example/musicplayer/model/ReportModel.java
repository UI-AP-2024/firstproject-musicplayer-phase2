package org.example.musicplayer.model;

import org.example.musicplayer.model.UserAccount.Artist.ArtistModel;
import org.example.musicplayer.model.UserAccount.UserAccountModel;

public class ReportModel {
    private UserAccountModel reporterUser;
    private ArtistModel reportedArtist;
    private String reportDescription;

    public ReportModel(UserAccountModel reporterUser, ArtistModel reportedArtist, String reportDescription) {
        this.reporterUser = reporterUser;
        this.reportedArtist = reportedArtist;
        this.reportDescription = reportDescription;
    }

    @Override
    public String toString() {
        return "reporterUser = " + reporterUser.getUsername() +
                ", reportedArtist = " + reportedArtist.getUsername() +
                ", reportDescription = " + reportDescription;
    }

    public UserAccountModel getReporterUser() {
        return reporterUser;
    }

    public ArtistModel getReportedArtist() {
        return reportedArtist;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReporterUser(UserAccountModel reporterUser) {
        this.reporterUser = reporterUser;
    }

    public void setReportedArtist(ArtistModel reportedArtist) {
        this.reportedArtist = reportedArtist;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }
}
