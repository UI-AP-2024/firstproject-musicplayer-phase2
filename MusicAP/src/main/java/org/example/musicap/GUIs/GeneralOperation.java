package org.example.musicap.GUIs;

import javafx.scene.control.Alert;

import java.io.IOException;

public interface GeneralOperation {
    void backTo ();
    void logout () throws IOException;
    void login () throws IOException;
    void signup() throws IOException;
    void search() throws IOException;
    void navigateToSongPage();
}
