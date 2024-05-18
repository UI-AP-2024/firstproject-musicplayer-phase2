package org.example.musicap.Controllers;
import org.example.musicap.Extra.RegexValidator;
import org.example.musicap.Models.Audio.Audio;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Genre;
import org.example.musicap.Models.User.*;
import Views.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class AccountController {
    // Made this class follow the Singleton pattern cuz we only need one instance
    private Database database;
    private static AccountController accountController;

    public static AccountController getAccountController()
    {
        if(accountController == null) accountController = new AccountController();
        return accountController;
    }
    private AccountController()
    {
        this.database = Database.getInstance();
    }

    private boolean checkName(String artistName)
    {
        for(User tmpUser : database.getUsers())
        {
            if(tmpUser instanceof Artist)
            {
                if(tmpUser.getName().equals(artistName)) return true;
            }
        }
        return false;
    }

    public String signUp(String userType, String userName, String password, String name, String email, String phoneNumber, LocalDate dateOfBirth, String bio, Scanner jin)
    {
        for(User tmpUser : database.getUsers())
        {
            if(tmpUser.getUsername().equals(userName))
            {
                return "Username already taken";
            }
        }
        if(!RegexValidator.emailValidator(email)) return "Invalid email format";
        if(!RegexValidator.phoneValidator(phoneNumber)) return "Invalid phone number format";
        if(!RegexValidator.passwordValidator(password)) return "weak password pattern";
        String switchResult = "User added successfully";
        switch (userType)
        {
            case "L":
                ArrayList<Genre> genres = AccountView.getUserView().getGenres(jin);
                database.addUser(new NormalListener(userName, password, name, email, phoneNumber, dateOfBirth, 50, null, genres));
                break;
            case "S":
                // since each Audio has an artistName property, artistNames must be unique
                if(checkName(name))
                {
                    switchResult = "An artist with the same name already exists";
                    break;
                }
                database.addUser(new Singer(userName, password, name, email, phoneNumber, dateOfBirth, 0, bio));
                break;
            case "P":
                // since each Audio has an artistName property, artistNames must be unique
                if(checkName(name))
                {
                    switchResult = "An artist with the same name already exists";
                    break;
                }
                database.addUser(new Podcaster(userName, password, name, email, phoneNumber, dateOfBirth, 0, bio));
                break;
            default:
                switchResult = "Invalid User Type";
                break;
        }
        return switchResult;
    }

    public String login(String userName, String password)
    {
        if(database.getLogedInUser() != null) return "You are already in your account!";
        boolean flg = false;

        for(User tmpUser : database.getUsers())
        {
            if(tmpUser.getUsername().equals(userName))
            {
                if(tmpUser.getPassword().equals(password))
                {
                    flg = true;
                    database.setLogedInUser(tmpUser);
                    return  "Welcome to your account";
                }
                else return "Wrong password";
            }
        }
        if(!flg) return "Wrong username";
        return "";
    }
    public ArrayList<Audio> showMostLiked()
    {
        return database.getAudios();
    }
    public String showAccountInfo()
    {
        return database.getLogedInUser().toString();
    }
}
