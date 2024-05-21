package org.example.musicap.GUIs;

import javafx.scene.control.Alert;

import java.io.IOException;

public interface GeneralOperation {
    void backTo () throws IOException;
    void logout () throws IOException;
    void login () throws IOException;
    void signup() throws IOException;
    void search() throws IOException;
    void navigateToSongPage();
}
