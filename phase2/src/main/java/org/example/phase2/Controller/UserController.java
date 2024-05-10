package org.example.phase2.Controller;

import org.example.phase2.Model.Audios.*;
import org.example.phase2.Model.Users.*;
import org.example.phase2.Model.Database.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {
    private static UserController userController;
    private UserController(){

    }
    public static UserController getUserController(){
        if(userController==null)
        {
            userController=new UserController();
        }
        return userController;
    }

    public int registerUser(String userType,String username,String password,String firstAndLastname,String emailAddress,String phoneNumber,String birthDate) throws ParseException {
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        if(!users.contains(Admin.getAdmin()))
        {
            users.add(Admin.getAdmin());
        }
        for(UserAccount user:users)
        {
            if(Objects.equals(user.getUsername(), username))
            {
                return -1;
            }
        }
        String emailRegex="(\\w|[0-9]){1,25}@(gmail|yahoo|email).com";
        Pattern pattern1=Pattern.compile(emailRegex);
        Matcher matcher1=pattern1.matcher(emailAddress);
        if(!matcher1.matches())
            return -2;
        String phoneNumberRegex="^09[01239][0-9]{8}";
        Pattern pattern2=Pattern.compile(phoneNumberRegex);
        Matcher matcher2=pattern2.matcher(phoneNumber);
        if(!matcher2.matches())
            return-3;
        String passwordRegex="(?=.*[#@&*!])(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]){1}.{8,}";
        Pattern pattern3=Pattern.compile(passwordRegex);
        Matcher matcher3=pattern3.matcher(password);
        if(!matcher3.matches())
            return -4;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date birthDate2=sdf.parse(birthDate);
        FreeListener newListener=new FreeListener(username,password,firstAndLastname,emailAddress,phoneNumber,birthDate2);
        users.add(newListener);
        newListener.setCredit(newListener.getCredit()+50);
        return 1;
    }
    public int registerUser(String userType,String username,String password,String firstAndLastname,String emailAddress,String phoneNumber,String birthDate,String biography) throws ParseException {
        ArrayList<UserAccount> users= Database.getDatabase().getUsers();
        if(!users.contains(Admin.getAdmin()))
        {
            users.add(Admin.getAdmin());
        }
        for(UserAccount user:users)
        {
            if(Objects.equals(user.getUsername(), username))
            {
                return -1;
            }
        }
        String emailRegex="(\\w|[0-9]){1,25}@(gmail|yahoo|email).com";
        Pattern pattern1=Pattern.compile(emailRegex);
        Matcher matcher1=pattern1.matcher(emailAddress);
        if(!matcher1.matches())
            return -2;
        String phoneNumberRegex="^09[01239][0-9]{8}";
        Pattern pattern2=Pattern.compile(phoneNumberRegex);
        Matcher matcher2=pattern2.matcher(phoneNumber);
        if(!matcher2.matches())
            return-3;
        String passwordRegex="(?=.*[#@&*!])(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]){1}.{8,}";
        Pattern pattern3=Pattern.compile(passwordRegex);
        Matcher matcher3=pattern3.matcher(password);
        if(!matcher3.matches())
            return -4;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date birthDate2=sdf.parse(birthDate);
        if(Objects.equals(userType, "S"))
        {
            Singer newSinger=new Singer(username,password,firstAndLastname,emailAddress,phoneNumber,birthDate2,biography);
            users.add(newSinger);
        }
        if(Objects.equals(userType, "P"))
        {
            Podcaster newPodcaster =new Podcaster(username,password,firstAndLastname,emailAddress,phoneNumber,birthDate2,biography);
            users.add(newPodcaster);
        }
        return 1;
    }
    public String checkRegisterForListener(int checkNumber)
    {
        if(checkNumber==-1)
            return "This username already exists.";
        if(checkNumber==-2)
            return "Invalid email address";
        if(checkNumber==-3)
            return "Invalid phone number";
        if(checkNumber==-4)
            return "Your password is not strong enough.";
        if(checkNumber==1)
            return "You are registered successfully.\nNow if you wish you can first login and then choose at most four genres that you are interested in:\nGenres:\nROCK,POP,JAZZ,HIPHOP,COUNTRY,TRUECRIME,SOCIETY,INTERVIEW,HISTORY";
        return "Invalid check number";
    }
    public String checkRegisterForArtist(int checkNumber)
    {
        if(checkNumber==-1)
            return "This username already exists.";
        if(checkNumber==-2)
            return "Invalid email address";
        if(checkNumber==-3)
            return "Invalid phone number";
        if(checkNumber==-4)
            return "Your password is not strong enough.";
        if(checkNumber==1)
            return "You are registered successfully.";
        return "Invalid check number";
    }
    public int loginUser(String username,String password)
    {
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        if(!users.contains(Admin.getAdmin()))
        {
            users.add(Admin.getAdmin());
        }
        for(UserAccount user : users)
        {
            if(Objects.equals(username, user.getUsername()) && Objects.equals(password, user.getPassword()))
            {
                if(user instanceof Admin)
                {
                    AdminController.getAdminController().setAdmin();
                    return 1;
                }
                if(user instanceof Listener)
                {
                    ListenerController.getListenerController().findListener(user.getUsername());
                    return 2;
                }
                if(user instanceof Artist)
                {
                    ArtistController.getArtistController().findArtist(user.getUsername());
                    return 3;
                }
            }
        }
        return -1;
    }
    public String checkLogin(int checkNumber)
    {
        if(checkNumber==1 || checkNumber==2 || checkNumber==3)
            return "You are logged in successfully.";
        else
            return "Username or password is wrong.";
    }
}
