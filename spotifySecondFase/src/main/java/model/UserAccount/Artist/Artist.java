package model.UserAccount.Artist;


import model.Album;
import model.UserAccount.UserAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Artist extends UserAccount
{
    double income;
    String biography;
    ArrayList<UserAccount> followers = new ArrayList<UserAccount>();
    public Artist(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day, String biography)
    {
        super(userName,passWord,name,email,phoneNumber,year,month,day);
        this.biography = biography;
    }
    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }
    public ArrayList<UserAccount> getFollowers() {
        return followers;
    }
    public void setFollowers(ArrayList<UserAccount> followers) {
        this.followers = followers;
    }
    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString()
    {
        return "Name: "+getName()+"\t"+"Birth Date: "+getDateOfBirth()+"\t"+"Biography: "+getBiography();
    }
}
