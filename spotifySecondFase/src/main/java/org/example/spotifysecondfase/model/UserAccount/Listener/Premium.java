package org.example.spotifysecondfase.model.UserAccount.Listener;

import org.example.spotifysecondfase.model.Genre;
import org.example.spotifysecondfase.model.UserAccount.Listener.Listener;

import java.time.LocalDate;
import java.util.Date;

import static java.lang.Character.getName;

public class Premium extends Listener
{
    private int remainingDays;
    public Premium(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day, Genre[] genres) {
        super(userName,passWord,name,email,phoneNumber,year,month,day,genres);
    }
    public int getRemainingDays() {return remainingDays;}
    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }
    @Override
    public String toString()
    {
        return "UserName: " + getUserName()+"\t"+"PassWord: "+getPassWord()+"\t"+"Name: "+getName()+"\t"+"Email: "+getEmail()+"\t"+"PhoneNumber: "+getPhoneNumber()+"\t"+"Birth Date: "+getDateOfBirth()+"\t"+"Favorite Genres: "+getGenres();
    }
}
