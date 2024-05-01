package model.AboutMusic;

import controller.UserAccountController;
import model.Database;
import model.Types.Genre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Audio {
    private static int audioNumbers = 0;
    private long identifier;
    private final String audioName;
    private final String artistUsername;
    private int playsNum;
    private int likesNum;
    private Date publicationDate;
    private final Genre genre;
    private final String audioLink;
    private final String cover;

    public Audio(String audioName, String artistUserName, String publicationDate, String genre, String audioLink, String cover) {
        this.audioName = audioName;
        this.artistUsername = artistUserName;

        try {
            this.publicationDate = new SimpleDateFormat("dd/MM/yyyy").parse(publicationDate);
        } catch (ParseException a) {
        }
        if (this.publicationDate == null)
            this.publicationDate = new Date();

        this.genre = UserAccountController.changeStringToGenre(genre);
        this.audioLink = audioLink;
        this.cover = cover;

        String identifier = "";

        switch (genre) {
            case "ROCK": {
                identifier = "1";
                break;
            }

            case "POP": {
                identifier = "2";
                break;
            }

            case "JAZZ": {
                identifier = "3";
                break;
            }

            case "HIPHOP": {
                identifier = "4";
                break;
            }

            case "COUNTRY": {
                identifier = "5";
                break;
            }

            case "TRUECRIME": {
                identifier = "6";
                break;
            }

            case "SOCIETY": {
                identifier = "7";
                break;
            }

            case "INTERVIEW": {
                identifier = "8";
                break;
            }

            case "HISTORY": {
                identifier = "9";
                break;
            }
        }

        identifier += String.format("%04d", audioNumbers);
        this.identifier = Integer.valueOf(identifier);

        Database.setAllAudios(this);
    }

    public static int getAudioNumbers() {
        return audioNumbers;
    }

    public long getIdentifier() {
        return identifier;
    }

    public String getAudioName() {
        return audioName;
    }

    public String getArtistUsername() {
        return artistUsername;
    }

    public int getPlaysNum() {
        return playsNum;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public StringBuilder getPublicationDateName() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(publicationDate);
        StringBuilder str = new StringBuilder();
        str.append(calendar.get(Calendar.DAY_OF_MONTH));
        str.append("/");
        str.append(calendar.get(Calendar.MONTH) + 1);
        str.append("/");
        str.append(calendar.get(Calendar.YEAR));
        return str;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public String getCover() {
        return cover;
    }

    public static void setAudioNumbers(int audioNumbers) {
        Audio.audioNumbers = audioNumbers;
    }

    public void setPlaysNum(int playsNum) {
        this.playsNum = playsNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }

    @Override
    public String toString() {
        return "artists name: " + artistUsername +"\nidentifier: " + identifier + "\naudio name: "
                + audioName + "\nlink: " + audioLink + "\ngenre: " + genre + "\ncover: " + cover
                + "\npublication date: " + getPublicationDateName() + "\n";
    }
}
