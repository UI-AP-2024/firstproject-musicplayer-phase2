package org.example.spotifysecondfase.model.UserAccount;

import java.time.LocalDate;
import java.util.Date;

public class Admin extends UserAccount
{
    private static Admin admin;
    private Admin(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day)
    {
        super(userName,passWord,name,email,phoneNumber,year,month,day);
    }
    public static synchronized Admin getAdmin(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day)
    {
        if (admin == null)
        {
            admin = new Admin(userName,passWord,name,email,phoneNumber,year,month,day);
        }
        return admin;
    }
    @Override
    public String toString()
    {
        return "UserName: " + getUserName()+"\t"+"PassWord: "+getPassWord()+"\t"+"Name: "+getName()+"\t"+"Email: "+getEmail()+"\t"+"PhoneNumber: "+getPhoneNumber()+"\t"+"Birth Date: "+getDateOfBirth();
    }
}
