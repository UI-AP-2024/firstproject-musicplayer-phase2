package org.example.phase2.Model.Database;

import java.io.IOException;

public interface GeneralOperation {
    void backTo () throws IOException;
    void logout () throws IOException;
    void login () throws IOException;
    void signup() throws IOException;
    void search() throws IOException;
}
