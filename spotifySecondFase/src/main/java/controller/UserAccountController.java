package controller;

import model.Database;
import model.UserAccount.Admin;
import model.UserAccount.Artist.Artist;
import model.UserAccount.Listener.Listener;
import model.UserAccount.UserAccount;
import org.example.spotifysecondfase.view.Exception.UserNotFound;
import org.example.spotifysecondfase.view.Exception.WrongPassword;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAccountController
{
    public boolean checkEmail(String email)
    {
        String regexEmail = "[a-zA-Z0-9.-]@(gmail|yahoo)\\.com$";
        Pattern pattern1 = Pattern.compile(regexEmail);
        Matcher matcher1 = pattern1.matcher(email);
        return matcher1.matches();
    }
    public boolean checkPhoneNumber(String phoneNumber)
    {
        String regexPhoneNumber = "0[0-9]{11,12}";
        Pattern pattern2 = Pattern.compile(regexPhoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        return matcher2.matches();
    }
    static UserAccountController userAccountController;
    private UserAccount userAccount;
    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    public UserAccount newUserAccount(String userName, String passWord, String name, String email, String phoneNumber, String year,String month,String day,String accountType)
    {
        userAccount = newUserAccount(userName,passWord,name,email,phoneNumber,year,month,day,accountType);
        Database.getDatabase().getUserAccounts().add(userAccount);
        return userAccount;
    }
    ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
    public void addUser(UserAccount account)
    {
        accounts.add(userAccount);
    }
    public boolean findUser(String userName,String passWord) throws WrongPassword, UserNotFound {
        for (UserAccount userAccount : Database.getDatabase().getUserAccounts())
        {
            if(userName.equals(userAccount.getUserName()))
            {
                if(passWord.equals(userAccount.getPassWord()))
                {
                    return true;
                }
                else {
                    throw new WrongPassword();
                }
            }
            try {
                throw new UserNotFound();
            } catch (UserNotFound e) {
                throw new UserNotFound();
            }
        }
        return false;
    }
}
