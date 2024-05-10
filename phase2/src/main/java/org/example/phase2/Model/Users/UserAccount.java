package org.example.phase2.Model.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

abstract public class UserAccount {
    private String username;
    private String password;
    private String firstAndLastName;
    private String emailAddress;
    private String phoneNumber;
    private Date birthDate;
    public UserAccount(String username,String password,String firstAndLastName,String emailAddress,String phoneNumber,Date birthDate)  {
        this.username=username;
        this.password=password;
        this.firstAndLastName=firstAndLastName;
        this.emailAddress=emailAddress;
        this.phoneNumber=phoneNumber;
        this.birthDate=birthDate;
    }

    public String getBirthDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDateInStringFormat = dateFormat.format(birthDate);
        return birthDateInStringFormat;
    }
    public Date getBirthDate2(){
        return birthDate;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append("Name: "+firstAndLastName+"\n");
        info.append("Username: "+username+"\n");
        info.append("Email address: "+emailAddress+"\n");
        info.append("Phone number: "+phoneNumber+"\n");
        info.append("Birth date: "+getBirthDate()+"\n");
        return info.toString();
    }
}
