package model.AboutHumans;

import model.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class UserAccount {
    private String username;
    private String password;
    private final String name;
    private String email;
    private String number;
    private Date birthday;
    public UserAccount(String name, String username, String password, String email, String number, String birthday) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.number = number;
        this.username = username;
        try {
            this.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
        }
        catch (ParseException ignore){}
        if (this.birthday == null)
            this.birthday = new Date();

        Database.setAllUsers(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public StringBuilder getBirthday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        StringBuilder str = new StringBuilder();
        str.append(calendar.get(Calendar.DAY_OF_MONTH));
        str.append("/");
        str.append(calendar.get(Calendar.MONTH ) + 1);
        str.append("/");
        str.append(calendar.get(Calendar.YEAR));
        return str;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthday(String birthday) {
        try {
            this.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
        }
        catch (ParseException a){}
        if (this.birthday == null)
            this.birthday = new Date();
    }

    @Override
    public String toString()
    {
        return "name: " + this.getName() +"\nusername: " + this.getUsername() + "\nemail: " + this.getEmail() + "\n";
    }

}
