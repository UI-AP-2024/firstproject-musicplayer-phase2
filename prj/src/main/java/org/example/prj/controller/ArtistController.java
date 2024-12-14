package org.example.prj.controller;

import org.example.prj.exception.InvalidFormatException;
import org.example.prj.exception.OtherException;
import org.example.prj.exception.WrongPaswordException;
import org.example.prj.model.*;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArtistController {
    private static ArtistController artistController;

    public ArtistController() {
    }

    public static ArtistController getArtistController(){
        if ( artistController == null)
            artistController = new ArtistController();
        return artistController;
    }

    private Artist userAccount;

    public Artist getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Artist userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserNameView(){
        return getUserAccount().getUserName();
    }

    public String getNameView(){
        return getUserAccount().getName();
    }

    public String getEmailView(){
        return getUserAccount().getEmail();
    }

    public String getdateView(){
        return getUserAccount().getDateOfBirth().getYear()+1900 + "/" + getUserAccount().getDateOfBirth().getMonth() + "/" + getUserAccount().getDateOfBirth().getDay();
    }

    public String getBioView(){
        return getUserAccount().getBio();
    }


    public String viewFollowers(){
        String result = "";
        if ( getUserAccount() instanceof Artist){
            for ( UserAccount userAccount1 : ((Artist) getUserAccount()).getListFollowers()){
                result += userAccount1.getUserName()+"\n";
            }
        }
        if ( result.equals(""))
            result += "empty";
        return result;
    }

    public String viewNumberPlay(){
        String result = "";
        if ( getUserAccount() instanceof Podcaster){
            int count=0;
            for ( Podcast podcast : ((Podcaster) getUserAccount()).getPodcastList()){
                result += "Audio Id: "+podcast.getId()+"\tAudio Name: "+podcast.getName()+"\tplay: "+podcast.getNumberOfPlays()+"\n";
                count += podcast.getNumberOfPlays();
            }
            if ( result.equals(""))
                result += "empty";
            else
                result += "Total number of plays: "+String.valueOf(count);
            return result;
        }
        else if ( getUserAccount() instanceof Singer){
            int count=0;
            for ( Album album : ((Singer) getUserAccount()).getAlbumList() ){
                for ( Music music : album.getMusicList()) {
                    result += "Audio Id: " + music.getId() + "\tAudio Name: " + music.getName() + "\tplay: " + music.getNumberOfPlays() + "\n";
                    count += music.getNumberOfPlays();
                }
            }
            if ( result.equals(""))
                result += "empty";
            else
                result += "Total number of plays: "+String.valueOf(count);
            return result;
        }
        return "ERORR viewNumberPlay";
    }

    public String registration(String type,String userName, String password, String name, String email, String number/*, Date birth*/,String year,String month,String day,String bio) {
        for (UserAccount tmp : Database.getDataBase().getUserAccounts()) {
            if (tmp.getUserName().equals(userName))
                throw new OtherException("Username is duplicated. Please try again");
//                return "Username is duplicated. Please try again";
        }
        String regex = "^([\\w-\\.]+[@]{1}[\\w]+[\\.]{1}[\\w]{2,4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == false)
            throw new InvalidFormatException("The email entered is not valid");
//            return "The email entered is not valid";
        regex = "^([0]{1}[9]{1}[0-9]{9})$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(number);
        if (matcher.matches() == false)
            throw new InvalidFormatException("The phone number entered is not valid");
//            return "The phone number entered is not valid";
        Date birth;
        try {
            birth = new Date(Integer.valueOf(year)-1900,Integer.valueOf(month)-1,Integer.valueOf(day));
        }catch (NumberFormatException e){
            throw new NumberFormatException("The format entered for date of birth is not valid");
        }

        if ( type.equals("S")){
            Singer singer = new Singer(userName,password,name,email,number,birth,bio);
            Database.getDataBase().getUserAccounts().add(singer);
            setUserAccount(singer);
            SingerController.getSingerController().setUserAccount(singer);
        }
        else{
            Podcaster podcaster = new Podcaster(userName,password,name,email,number,birth,bio);
            Database.getDataBase().getUserAccounts().add(podcaster);
            setUserAccount(podcaster);
            PodcasterController.getPodcasterController().setUserAccount(podcaster);
        }
        return "Account created successfully";
    }

    public String login(String userName, String password) {
        for (UserAccount tmp : Database.getDataBase().getUserAccounts()) {
            if (tmp.getUserName().equals(userName) && tmp.getPassword().equals(password)) {
                setUserAccount((Artist) tmp);
                if ( tmp instanceof Singer) {
                    SingerController.getSingerController().setUserAccount((Singer) tmp);
                    return "Login successfully singer";
                }
                else if ( tmp instanceof Podcaster) {
                    PodcasterController.getPodcasterController().setUserAccount((Podcaster) tmp);
                    return "Login successfully podcaster";
                }

            }
        }
        throw new WrongPaswordException();
//        return "The username does not exist or the password is incorrect";
    }

    public String viewInfoacc(){
        calculateEarnings();
        String result = "";
        if ( getUserAccount() instanceof Singer)
            result += (Singer)getUserAccount();
        else
            result += (Podcaster)getUserAccount();
        return result;
    }

    public String calculateEarnings(){
        double count=0;
        if ( getUserAccount() instanceof Singer){
            for ( Album album : ((Singer) getUserAccount()).getAlbumList()){
                for ( Music music : album.getMusicList()){
                    count+=music.getNumberOfPlays();
                }
            }
            count = count*0.4;
            ((Singer) getUserAccount()).setIncome(count);
        }
        else{
            for ( Podcast podcast : ((Podcaster)getUserAccount()).getPodcastList()){
                count += podcast.getNumberOfPlays();
            }
            count = count * 0.5;
            ((Podcaster) getUserAccount()).setIncome(count);
        }
        return "Your income is $"+String.valueOf(count);
    }

    public void logoutArtist(){
        if ( getUserAccount() instanceof Podcaster)
            PodcasterController.getPodcasterController().setUserAccount(null);
        else if ( getUserAccount() instanceof Singer)
            SingerController.getSingerController().setUserAccount(null);
        ArtistController.getArtistController().setUserAccount(null);
    }
}
