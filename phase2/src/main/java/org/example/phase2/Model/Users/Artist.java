package org.example.phase2.Model.Users;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Artist extends UserAccount{

    private Double income;
    private ArrayList<UserAccount> followers;
    private String biography;
    public Artist(String userName, String password, String firstAndLastName, String emailAddress, String phoneNumber, Date birthDate, String biography) throws ParseException {
        super(userName, password, firstAndLastName, emailAddress, phoneNumber, birthDate);
        followers=new ArrayList<UserAccount>();
        this.biography=biography;
    }

    public String getBiography() {
        return biography;
    }

    public ArrayList<UserAccount> getFollowers() {
        return followers;
    }

    public Double getIncome() {
        return income;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setFollowers(ArrayList<UserAccount> followers) {
        this.followers = followers;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        info.append("Income: "+income+"\n");
        info.append("Biography: "+biography+"\n");
        return info.toString();
    }
}
