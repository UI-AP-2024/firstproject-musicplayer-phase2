package org.example.phase2.Model.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Admin extends UserAccount{
    static Date birthDate=new Date(2005,3,23);
    private static Admin admin=new Admin("abolfazl","1384ABcd@","Abolfazl Bayati","abolfazl@gmail.com","09134378922",birthDate);
    private Admin(String userName, String password, String firstAndLastName, String emailAddress, String phoneNumber, Date birthDate)  {
        super(userName, password, firstAndLastName, emailAddress, phoneNumber, birthDate);
    }
    public static Admin getAdmin()
    {
        return admin;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        return info.toString();
    }
}
