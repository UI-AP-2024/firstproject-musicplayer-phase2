package org.example.spotifysecondfase.model.UserAccount;

import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;
import org.example.spotifysecondfase.model.UserAccount.Listener.Listener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class UserAccount
{
    private String userName;
    private String passWord;
    private String name;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    public UserAccount(String userName, String passWord, String name, String email, String phoneNumber, Date date)
    {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = date;
        this.userName = userName;
        this.passWord = passWord;
    }
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassWord() {return passWord;}
    public void setPassWord(String passWord) {this.passWord = passWord;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public Date getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    @Override
    public String toString()
    {
        return "UserName: " + getUserName()+"\t"+"PassWord: "+getPassWord()+"\t"+"Name: "+getName()+"\t"+"Email: "+getEmail()+"\t"+"PhoneNumber: "+getPhoneNumber()+"\t"+"Birth Date: "+getDateOfBirth();
    }

}
