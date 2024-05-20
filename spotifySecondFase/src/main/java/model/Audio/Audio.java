package model.Audio;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.spotifysecondfase.HelloApplication;
import model.Genre;

import java.util.Date;

public abstract class Audio implements Comparable
{
    private static int i=0;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String artistName;
    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    private int playsCount;
    public int getPlaysCount() {
        return playsCount;
    }
    public void setPlaysCount(int playsCount) {
        this.playsCount = playsCount;
    }
    private int likesCount;
    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }
    private Date date ;
    private Genre genre;
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    private String audioLink;
    public String getAudioLink() {
        return audioLink;
    }
    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }
    private String cover;
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    String id;
    private Image image;
    public Image getImage() {return image;}
    public void setImage(Image image) {this.image = image;}
    private ImageView coverImageView;
    public  ImageView getCoverImageView() {return coverImageView;}
    public  void setCoverImageView(ImageView coverImageView) {this.coverImageView = coverImageView;}
    public Audio(String name,Genre genre,String artistName, Date date, String audioLink, String cover) {
        this.artistName = artistName;
        this.date = date;
        this.genre = genre;
        this.name = name;
        this.audioLink = audioLink;
        this.cover = cover;
        this.id = this.name + i++;
        String path = HelloApplication.class.getResource(cover).toExternalForm();
        image = new Image(path);
        coverImageView = new ImageView(image);
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public String toString()
    {
        return "Audio name : "+getName() + "Audio genre : "+getGenre()+"Audio artist name : "+getArtistName();
    }
//    public int CompareTo(Audio audio1,Audio audio2)
//    {
//        audio1.name.compareTo(audio2.name);
//    }

}
