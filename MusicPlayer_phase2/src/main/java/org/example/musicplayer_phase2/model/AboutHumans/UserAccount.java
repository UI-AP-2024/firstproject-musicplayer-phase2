package org.example.musicplayer_phase2.model.AboutHumans;

import org.example.musicplayer_phase2.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public abstract class UserAccount {
    private String username;
    private String password;
    private final String name;
    private String email;
    private String number;
    private LocalDate birthday;
    public UserAccount(String name, String username, String password, String email, String number, LocalDate birthday) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.number = number;
        this.username = username;
        this.birthday = birthday;
        Database.setAllUsers(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        return "name: " + this.getName() +"\nusername: " + this.getUsername() + "\nemail: " + this.getEmail() + "\n";
    }

}
