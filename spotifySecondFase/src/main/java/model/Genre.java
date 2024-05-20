package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.spotifysecondfase.HelloApplication;

import java.util.ArrayList;

public enum Genre {
    ROCK("image/rock.jpeg"),POP("image/pop.jpeg"),JAZZ("image/jazz.jpeg"),HIPHOP("image/hiphop.jpeg"),COUNTRY("image/country.jpeg"),TRUECRIME("image/truecrime.jpeg"),SOCIETY("image/society.jpeg"),INTERVIEW("image/interview.jpeg"),HISTORY("image/history.jpeg");
    private ImageView imageView;
    public ImageView getImageView() {return imageView;}
    public void setImageView(ImageView imageView) {this.imageView = imageView;}
    private Genre(String str)
    {
        String path = HelloApplication.class.getResource(str).toExternalForm();
        Image image = new Image(path);
        imageView = new ImageView(image);
    }
    private static ArrayList<Genre> genres = new ArrayList<>();
    public static ArrayList<Genre> getGenres() {return genres;}
    public void setGenres(ArrayList<Genre> genres) {this.genres = genres;}

    private static ArrayList<Genre> favoriteGenres = new ArrayList<Genre>(4);

    public ArrayList<Genre> getFavoriteGenres() {
        return favoriteGenres;
    }
    public void setFavoriteGenres(ArrayList<Genre> favoriteGenres) {
        Genre.favoriteGenres = favoriteGenres;
    }
    public static void addgenres(Genre genre)
    {
        favoriteGenres.add(genre);
    }
    public static void removegenres(Genre genre)
    {
        favoriteGenres.remove(genre);
    }

    public static ArrayList<Genre> genresArray()
    {
       getGenres().add(0,ROCK);
        getGenres().add(1,POP);
        getGenres().add(2,JAZZ);
        getGenres().add(3,HIPHOP);
        getGenres().add(4,COUNTRY);
        getGenres().add(5,TRUECRIME);
        getGenres().add(6,SOCIETY);
        getGenres().add(7,INTERVIEW);
        getGenres().add(8,HISTORY);
        return getGenres();
    }
}
