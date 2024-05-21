package org.example.musicap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicap.Controllers.AdminController;
import org.example.musicap.Models.Audio.Song;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Genre;
import org.example.musicap.Models.User.Listener;
import org.example.musicap.Models.User.NormalListener;
import org.example.musicap.Models.User.Singer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Database database = Database.getInstance();
        Singer singer = new Singer("s", "SFDG#45XFfdfg2", "s", "si@si.cim", "09131063421", LocalDate.now(), 234.24, "sdfg");
        Listener listener = new NormalListener("dry", "sdf", "sdf", "sdf", "0098765", LocalDate.now(), 3, LocalDate.now(), new ArrayList<>());
        Listener listener1 = new NormalListener("2ry", "sdf", "sdf", "sdf", "0098765", LocalDate.now(), 12, LocalDate.now(), new ArrayList<>());
        database.getUsers().add(singer);
        database.getUsers().add(listener);
        database.getUsers().add(listener1);
        Song song1 = new Song("hi 2", "hub", 23, 21, LocalDate.now(), Genre.COUNTRY, "11111", "example.jpg", "sdfdsgfb");
        Song song2 = new Song("Melody Maker", "Jingle Jams", 195, 42, LocalDate.of(2022, 3, 15), Genre.POP, "22222", "example.jpg", "xyzabc123");
        Song song3 = new Song("Rhythmic Rhapsody", "Beat Street", 211, 31, LocalDate.of(2021, 9, 28), Genre.ROCK, "33333", "example.jpg", "qwerty456");
        Song song4 = new Song("Harmonic Harmony", "Chord City", 167, 27, LocalDate.of(2023, 5, 3), Genre.JAZZ, "44444", "example.jpg", "asdfgh789");
        Song song5 = new Song("Lyrical Lullaby", "Verse Village", 183, 19, LocalDate.of(2020, 11, 12), Genre.POP, "55555", "example.jpg", "zxcvbn012");
        Song song6 = new Song("Sonic Symphony", "Tune Towers", 209, 38, LocalDate.of(2022, 7, 22), Genre.ROCK, "66666", "example.jpg", "poiuyt345");
        Song song7 = new Song("Melodic Masterpiece", "Note Nook", 173, 25, LocalDate.of(2021, 2, 6), Genre.ROCK, "77777", "example.jpg", "lkjhgf678");
        Song song8 = new Song("Rhythmic Reverie", "Beat Blvd", 191, 33, LocalDate.of(2023, 10, 18), Genre.ROCK, "88888", "example.jpg", "mnbvcx901");
        Song song9 = new Song("Harmonic Hymn", "Chord Cove", 205, 29, LocalDate.of(2020, 4, 30), Genre.ROCK, "99999", "example.jpg", "234567890");
        Song song10 = new Song("Lyrical Lullaby", "Verse Valley", 179, 22, LocalDate.of(2022, 12, 25), Genre.COUNTRY, "00000", "example.jpg", "abcdefghi");
        Song song11 = new Song("Lyrical Lullaby", "Verse Valley", 179, 22, LocalDate.of(2022, 12, 25), Genre.COUNTRY, "00000", "example.jpg", "abcdefghi");
        database.getAudios().add(song1);
        database.getAudios().add(song2);
        database.getAudios().add(song3);
        database.getAudios().add(song4);
        database.getAudios().add(song5);
        database.getAudios().add(song6);
        database.getAudios().add(song7);
        database.getAudios().add(song8);
        database.getAudios().add(song9);
        database.getAudios().add(song10);
        database.getAudios().add(song11);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("layout-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 600);
        stage.setTitle("MusicAP");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}