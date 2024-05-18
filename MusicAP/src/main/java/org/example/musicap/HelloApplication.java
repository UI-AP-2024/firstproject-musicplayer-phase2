package org.example.musicap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicap.Controllers.AdminController;
import org.example.musicap.Models.Audio.Song;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Genre;
import org.example.musicap.Models.User.Singer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Database dbInstance = Database.getInstance();
        Singer singer = new Singer("s", "SFDG#45XFfdfg2", "s", "si@si.cim", "09131063421", LocalDate.now(), 234.24, "sdfg");
        dbInstance.getUsers().add(singer);
        Song song1 = new Song("hi 2", "hub", 23, 21, LocalDate.now(), Genre.COUNTRY, "11111", "svs", "sdfdsgfb");
        Song song2 = new Song("Melody Maker", "Jingle Jams", 195, 42, LocalDate.of(2022, 3, 15), Genre.POP, "22222", "Tune Town", "xyzabc123");
        Song song3 = new Song("Rhythmic Rhapsody", "Beat Street", 211, 31, LocalDate.of(2021, 9, 28), Genre.ROCK, "33333", "Groove Grooves", "qwerty456");
        Song song4 = new Song("Harmonic Harmony", "Chord City", 167, 27, LocalDate.of(2023, 5, 3), Genre.JAZZ, "44444", "Melody Makers", "asdfgh789");
        Song song5 = new Song("Lyrical Lullaby", "Verse Village", 183, 19, LocalDate.of(2020, 11, 12), Genre.POP, "55555", "Rhyme Rhythms", "zxcvbn012");
        Song song6 = new Song("Sonic Symphony", "Tune Towers", 209, 38, LocalDate.of(2022, 7, 22), Genre.ROCK, "66666", "Harmony Hills", "poiuyt345");
        Song song7 = new Song("Melodic Masterpiece", "Note Nook", 173, 25, LocalDate.of(2021, 2, 6), Genre.ROCK, "77777", "Beat Boulevard", "lkjhgf678");
        Song song8 = new Song("Rhythmic Reverie", "Beat Blvd", 191, 33, LocalDate.of(2023, 10, 18), Genre.ROCK, "88888", "Melody Meadows", "mnbvcx901");
        Song song9 = new Song("Harmonic Hymn", "Chord Cove", 205, 29, LocalDate.of(2020, 4, 30), Genre.ROCK, "99999", "Rhythm Ridge", "234567890");
        Song song10 = new Song("Lyrical Lullaby", "Verse Valley", 179, 22, LocalDate.of(2022, 12, 25), Genre.COUNTRY, "00000", "Rhyme River", "abcdefghi");
        Song song11 = new Song("Lyrical Lullaby", "Verse Valley", 179, 22, LocalDate.of(2022, 12, 25), Genre.COUNTRY, "00000", "Rhyme River", "abcdefghi");
        dbInstance.getAudios().add(song1);
        dbInstance.getAudios().add(song2);
        dbInstance.getAudios().add(song3);
        dbInstance.getAudios().add(song4);
        dbInstance.getAudios().add(song5);
        dbInstance.getAudios().add(song6);
        dbInstance.getAudios().add(song7);
        dbInstance.getAudios().add(song8);
        dbInstance.getAudios().add(song9);
        dbInstance.getAudios().add(song10);
        dbInstance.getAudios().add(song11);
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