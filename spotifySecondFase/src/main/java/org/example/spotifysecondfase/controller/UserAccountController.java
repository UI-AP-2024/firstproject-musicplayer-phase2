package org.example.spotifysecondfase.controller;

import org.example.spotifysecondfase.model.Database;
import org.example.spotifysecondfase.model.UserAccount.Admin;
import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;
import org.example.spotifysecondfase.model.UserAccount.Listener.Listener;
import org.example.spotifysecondfase.model.UserAccount.UserAccount;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserAccountController
{
    static UserAccountController userAccountController;
    private UserAccount userAccount;
    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    public UserAccount newUserAccount(String userName, String passWord, String name, String email, String phoneNumber, LocalDate dateOfBirth,String accountType)
    {
        userAccount = newUserAccount(userName,passWord,name,email,phoneNumber,dateOfBirth,accountType);
        Database.getDatabase().getUserAccounts().add(userAccount);
        return userAccount;
    }
    ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
    public void addUser(UserAccount account)
    {
        accounts.add(userAccount);
    }
    public boolean findUser(String userName,String passWord)
    {
        for (UserAccount userAccount : Database.getDatabase().getUserAccounts())
        {
            if(userName.equals(userAccount.getUserName()))
            {
                if(passWord.equals(userAccount.getPassWord()))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
