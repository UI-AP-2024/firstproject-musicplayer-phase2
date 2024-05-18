package org.example.musicap.GUIs;

import java.io.IOException;

public interface GeneralOperation {
    void backTo ();
    void logout ();
    void login () throws IOException;
    void signup();
    void search();
    void navigateToSongPage();
}
