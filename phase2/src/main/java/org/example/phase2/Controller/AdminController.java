package org.example.phase2.Controller;

import org.example.phase2.Model.Audios.*;
import org.example.phase2.Model.Users.*;
import org.example.phase2.Model.Database.*;
import org.example.phase2.Model.Users.UserAccount;
import org.example.phase2.Model.Users.Singer;
import java.util.ArrayList;

public class AdminController{

    private static AdminController adminController;
    private Admin admin;
    private AdminController(){

    }
    public static AdminController getAdminController()
    {
        if(adminController==null)
        {
            adminController=new AdminController();
        }
        return adminController;
    }
    public void setAdmin()
    {
        admin=Admin.getAdmin();
    }
    public void logout(){
        admin=null;
    }
    public ArrayList<Audio> showPopularAudios()
    {
        Audio temp;
        ArrayList<Audio> audios= Database.getDatabase().getAudios();
        for(int i=0;i< audios.size()-1;i++)
        {
            for(int j=i+1;j<audios.size();j++)
            {
                if(audios.get(i).getLikes()<audios.get(j).getLikes())
                {
                    temp=audios.get(i);
                    audios.set(i,audios.get(j));
                    audios.set(j,temp);
                }
            }
        }
        //StringBuilder info=new StringBuilder();
        for(int i=0;i< audios.size();i++)
        {
//            info.append("Name: "+audios.get(i).getName()+"\t");
//            info.append("Artist: "+audios.get(i).getArtist()+"\t");
//            info.append("Genre: "+audios.get(i).getGenre()+"\t");
//            info.append("Likes: "+audios.get(i).getLikes()+"\t");
//            info.append("ID: "+audios.get(i).getId()+"\n");
            //info.append(audios.get(i).toString());
        }
        return audios;
    }
    public String showListOfArtists(){
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        StringBuilder info = new StringBuilder();
        for(UserAccount user : users)
        {
            if(user instanceof Artist)
            {
                info.append("Name: "+user.getFirstAndLastName()+"\tUsername: "+user.getUsername()+"\n");
            }
        }
        return info.toString();
    }
    public String showInfoOfAnArtist(String username)
    {
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        StringBuilder info = new StringBuilder("Artist's information: \n");
        for(UserAccount user : users)
        {
            if(username.equals(user.getUsername()) && user instanceof Artist)
            {
                Artist artist=(Artist)user;
//                info.append("Name: "+artist.getFirstAndLastName()+"\n");
//                info.append("Birth date: "+artist.getBirthDate()+"\n");
//                info.append("Phone number: "+artist.getPhoneNumber()+"\n");
//                info.append("Email address: "+artist.getEmailAddress()+"\n");
//                info.append("Username: "+artist.getUsername()+"\n");
//                info.append("Password: "+artist.getPassword()+"\n");
                ArrayList<Audio> audios = Database.getDatabase().getAudios();
                double income=0;
                for(Audio audio:audios)
                {
                    if(audio.getArtist().equals(artist.getFirstAndLastName()) && artist instanceof Podcaster)
                    {
                        income+=0.5;
                        artist.setIncome(income);
                    }
                    if(audio.getArtist().equals(artist.getFirstAndLastName()) && artist instanceof Singer)
                    {
                        income+=0.4;
                        artist.setIncome(income);
                    }
                }
//                info.append("Income: "+income+"\n");
//                info.append("Biography: "+artist.getBiography()+"\n");
                info.append(artist.toString());
                break;
            }
        }
        return info.toString();
    }
    public String showAudios()
    {
        ArrayList<Audio> audios= Database.getDatabase().getAudios();
        StringBuilder info = new StringBuilder();
        for(Audio audio : audios)
        {
            info.append("Name: "+audio.getName()+"\tID: "+audio.getId()+"\n");
        }
        return info.toString();
    }
    public String showInformationOfAnAudio(long audioId)
    {
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        StringBuilder info = new StringBuilder();
        for(Audio audio : audios)
        {
            if(audio.getId()==audioId)
            {
//                info.append("Name: "+audio.getName()+"\n");
//                info.append("ID: "+audio.getId()+"\n");
//                info.append("Genre: "+audio.getGenre().name()+"\n");
//                info.append("Artist: "+audio.getArtist()+"\n");
//                info.append("Published on: "+audio.getLaunchDate()+"\n");
//                info.append("Likes: "+audio.getLikes()+"\n");
//                info.append("Plays: "+audio.getNumberOfListening()+"\n");
//                info.append("Link: "+audio.getLinkOfAudioFile()+"\n");
//                info.append("Cover: "+audio.getCover()+"\n");
                info.append(audio.toString());
                break;
            }
        }
        return info.toString();
    }
    public String showReports()
    {
        ArrayList<Report> reports = Database.getDatabase().getReports();
        StringBuilder info = new StringBuilder("Reports:\n");
        for(Report report : reports)
        {
//            info.append("Reporter: "+report.getReporter().getFirstAndLastName()+"\n");
//            info.append("Reported artist: "+report.getReportedArtist().getFirstAndLastName()+"\n");
//            info.append("Description: "+report.getDescription()+"\n\n");
            info.append(report.toString());
        }
        return info.toString();
    }
    public String showAccountInfo()
    {
        StringBuilder info = new StringBuilder();
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        for(UserAccount user : users)
        {
            if(user.getUsername().equals(admin.getUsername()))
            {
//                info.append("Name: "+user.getFirstAndLastName()+"\n");
//                info.append("Birth date: "+user.getBirthDate()+"\n");
//                info.append("Email address: "+user.getEmailAddress()+"\n");
//                info.append("Phone number: "+user.getPhoneNumber()+"\n");
                info.append(user.toString());
                break;
            }
        }
        return info.toString();
    }
    public String help()
    {
        StringBuilder commands=new StringBuilder();
        commands.append("1. Login -[username] -[password]\n");
        commands.append("2. Logout\n");
        commands.append("3. AccountInfo\n");
        commands.append("4. Statistics\n");
        commands.append("5. Audios\n");
        commands.append("6. Audio -[audio’s ID]\n");
        commands.append("7. Artists\n");
        commands.append("8. Artist -[username]\n");
        commands.append("9. Reports\n");
        return commands.toString();
    }
}
