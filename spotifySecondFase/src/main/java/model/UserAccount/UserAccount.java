package model.UserAccount;

import model.UserAccount.Artist.Artist;
import model.UserAccount.Listener.Listener;

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
    private LocalDate dateOfBirth;
    public UserAccount(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day)
    {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        dateOfBirth = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
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
    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    @Override
    public String toString()
    {
        return "UserName: " + getUserName()+"\t"+"PassWord: "+getPassWord()+"\t"+"Name: "+getName()+"\t"+"Email: "+getEmail()+"\t"+"PhoneNumber: "+getPhoneNumber()+"\t"+"Birth Date: "+getDateOfBirth();
    }

}
