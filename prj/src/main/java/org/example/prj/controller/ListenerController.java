package org.example.prj.controller;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import org.example.prj.model.*;
import org.example.prj.view.Detail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListenerController {
    private static ListenerController listenerController;

    private ListenerController() {
    }

    public static ListenerController getListenerController() {
        if (listenerController == null)
            listenerController = new ListenerController();
        return listenerController;
    }

    private Listener userAccount;

    public Listener getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Listener userAccount) {
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

    public String getPhoneView(){
        return getUserAccount().getPhoneNumber();
    }

    public String getDateView(){
        return String.valueOf(getUserAccount().getDateOfBirth().getYear()+1900) + "/" + String.valueOf(getUserAccount().getDateOfBirth().getMonth()+1) + "/" +String.valueOf(getUserAccount().getDateOfBirth().getDay());
    }

    public String getDaySubView(){
        if (getUserAccount() instanceof Free)
            return "0";
        else
            return String.valueOf(((Premium) getUserAccount()).getDaysOfSubs());
    }

    public String getCreditView(){
        return String.valueOf(getUserAccount().getAccountCredit());
    }

    public String getFavoriteGenreView(){
        String result = "";
        for (Gener gener : getUserAccount().getFavoriteGener())
            result+= gener.name() + " ";
        return result;
    }

    public String registration(String userName, String password, String name, String email, String number/*, Date birth*/,String year,String month,String day) {
        for (UserAccount tmp : Database.getDataBase().getUserAccounts()) {
            if (tmp.getUserName().equals(userName))
                return "Username is duplicated. Please try again";
        }
        String regex = "^([\\w-\\.]+[@]{1}[\\w]+[\\.]{1}[\\w]{2,4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == false)
            return "The email entered is not valid";
        regex = "^([0]{1}[9]{1}[0-9]{9})$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(number);
        if (matcher.matches() == false)
            return "The phone number entered is not valid";

        Date birth = new Date(Integer.valueOf(year)-1900,Integer.valueOf(month)-1,Integer.valueOf(day));

        Free free = new Free(userName, password, name, email, number, birth, 50);
        Database.getDataBase().getUserAccounts().add(free);
        setUserAccount(free);
        return "Account created successfully";
    }

    public ArrayList<String> showGener(){
        ArrayList<String> al = new ArrayList<>();
        for (Gener gener : Gener.values())
            al.add(gener.name());
        return al;
    }

    public String login(String userName, String password) {
        for (UserAccount tmp : Database.getDataBase().getUserAccounts()) {
            if (tmp.getUserName().equals(userName) && tmp.getPassword().equals(password)) {
                setUserAccount((Listener) tmp);
                return "Login successfully";
            }
        }
        return "The username does not exist or the password is incorrect";
    }

    public String createPlaylist(String name) {
        if (getUserAccount() instanceof Free) {
            ((Free) getUserAccount()).setCountNumberPlaylist(((Free) getUserAccount()).getCountNumberPlaylist()+1);
            if (((Free) getUserAccount()).getCountNumberPlaylist() <= ((Free) getUserAccount()).getLimitNumberPlaylist()) {
                Playlist playlist = new Playlist(((Free) getUserAccount()).getCountNumberPlaylist(), name, getUserAccount().getUserName());
                ((Free) getUserAccount()).getPlaylists().add(playlist);
                return "The playlist was created successfully";
            } else {
                ((Free) getUserAccount()).setCountNumberPlaylist(((Free) getUserAccount()).getCountNumberPlaylist()-1);
                return "You are allowed to create 3 playlists";
            }

        } else if (getUserAccount() instanceof Premium) {
            ((Premium) getUserAccount()).setCountNumberPlaylistP(((Premium) getUserAccount()).getCountNumberPlaylistP()+1);
            Playlist playlist = new Playlist(((Premium) getUserAccount()).getCountNumberPlaylistP(), name, getUserAccount().getUserName());
            ((Premium) getUserAccount()).getPlaylists().add(playlist);
            return "The playlist was created successfully";
        } else
            return "ERORR create playlist";
    }

    public ArrayList<UserAccount> getArtistFollowers(String userName){
        for(UserAccount userAccount1 : Database.getDataBase().getUserAccounts()){
            if (userAccount1.getUserName().equals(userName)){
                return (((Artist)userAccount1).getListFollowers());
            }
        }
        return new ArrayList<UserAccount>();
    }

    public String addAudioToPlaylist(String nameOfPlaylist, long id) {
        if (getUserAccount() instanceof Free) {
            for (Playlist playlist : ((Free) getUserAccount()).getPlaylists()) {
                if (playlist.getNameOfPlaylist().equals(nameOfPlaylist) && ((Free) getUserAccount()).getCountAddSong() < ((Free) getUserAccount()).getLimitAddSong()) {
                    for (Audio audio : Database.getDataBase().getAudio()) {
                        if (audio.getId() == id ) {
                            for ( Audio audio1 : playlist.getListAudio()){
                                if ( audio1.getId()==id)
                                    return "You have this audio file in the playlist";
                            }
                            ((Free) getUserAccount()).setCountAddSong(((Free) getUserAccount()).getCountAddSong()+1);
                            playlist.getListAudio().add(audio);
//                            ((Free) getUserAccount()).getPlaylists().remove(playlist);
//                            ((Free) getUserAccount()).getPlaylists().add(playlist);
                            return "The audio file(" + id + ") was successfully entered into the playlist(" + nameOfPlaylist + ")";
                        }
                    }
                }
            }
            if (((Free) getUserAccount()).getCountAddSong() >= ((Free) getUserAccount()).getLimitAddSong())
                return "You are allowed to add only 10 audio files";
            else
                return "The name of the playlist or the ID of the audio file is wrong";
        } else if (getUserAccount() instanceof Premium) {
            for (Playlist playlist : ((Premium) getUserAccount()).getPlaylists()) {
                if (playlist.getNameOfPlaylist().equals(nameOfPlaylist)) {
                    for (Audio audio : playlist.getListAudio()) {
                        if (audio.getId() == id) {
                            for ( Audio audio1 : playlist.getListAudio()){
                                if ( audio1.getId()==id)
                                    return "You have this audio file in the playlist";
                            }
                            playlist.getListAudio().add(audio);
//                            ((Premium) getUserAccount()).getPlaylists().remove(playlist);
//                            ((Premium) getUserAccount()).getPlaylists().add(playlist);
                            return "The audio file(" + id + ") was successfully entered into the playlist(" + nameOfPlaylist + ")";
                        }
                    }
                }
            }
            return "The name of the playlist or the ID of the audio file is wrong";
        }
        return "ERORR add audio to playlist";
    }

    public Audio nextAudioFile(){
        Detail.getDetail().play=true;
        Detail.getDetail().pause=false;
        MediaController.getMediaController().mediaPlayer.pause();
        Audio audio;
        if(Detail.getDetail().random){
            if (Detail.getDetail().countRandom==Database.getDataBase().getAudio().size()-1)
                Detail.getDetail().countRandom=0;
            else
                Detail.getDetail().countRandom++;
            audio = Database.getDataBase().getAudio().get(Detail.getDetail().countRandom);
            MediaController.getMediaController().mediaPlayer = new MediaPlayer(new Media(audio.getAudioLink()));

        }
        else {
            if (Detail.getDetail().countPlayList==ListenerController.getListenerController().selectPlaylist(Detail.selectPlayList).size()-1)
                Detail.getDetail().countPlayList=0;
            else
                Detail.getDetail().countPlayList++;
            audio = ListenerController.getListenerController().selectPlaylist(Detail.selectPlayList).get(Detail.getDetail().countPlayList);
            MediaController.getMediaController().mediaPlayer = new MediaPlayer(new Media(audio.getAudioLink()));
        }
        MediaController.getMediaController().mediaPlayer.play();
        return audio;
    }

    public Audio previousAudioFile(){
        Detail.getDetail().play=true;
        Detail.getDetail().pause=false;
        MediaController.getMediaController().mediaPlayer.pause();
        Audio audio;
        if(Detail.getDetail().random){
            if (Detail.getDetail().countRandom==0)
                Detail.getDetail().countRandom=Database.getDataBase().getAudio().size()-1;
            else
                Detail.getDetail().countRandom--;
            audio = Database.getDataBase().getAudio().get(Detail.getDetail().countRandom);
            MediaController.getMediaController().mediaPlayer = new MediaPlayer(new Media(audio.getAudioLink()));

        }
        else {
            if (Detail.getDetail().countPlayList==0)
                Detail.getDetail().countPlayList=ListenerController.getListenerController().selectPlaylist(Detail.selectPlayList).size()-1;
            else
                Detail.getDetail().countPlayList--;
            audio = ListenerController.getListenerController().selectPlaylist(Detail.selectPlayList).get(Detail.getDetail().countPlayList);
            MediaController.getMediaController().mediaPlayer = new MediaPlayer(new Media(audio.getAudioLink()));
        }
        MediaController.getMediaController().mediaPlayer.play();
        return audio;
    }

    public Audio playPauseAudioFile() {
        if (Detail.getDetail().pause) {
            MediaController.getMediaController().mediaPlayer.play();
            Detail.getDetail().pause=false;
            Detail.getDetail().play=true;
        }
        else {
            MediaController.getMediaController().mediaPlayer.pause();
            Detail.getDetail().pause=true;
            Detail.getDetail().play=false;
        }
        Audio audio;
        if(Detail.getDetail().random)
            audio = Database.getDataBase().getAudio().get(Detail.getDetail().countRandom);
        else
            audio = ListenerController.getListenerController().selectPlaylist(Detail.selectPlayList).get(Detail.getDetail().countPlayList);
        return audio;
    }

    public String likeAudioFile(long id){
        for (Audio audio : Database.getDataBase().getAudio()){
            if (audio.getId() == id){
                audio.setNumberOfLikes(audio.getNumberOfLikes()+1);
                return "The audio file was liked";
            }
        }
        return "The desired audio file was not found";
    }

    public ArrayList<Audio> searchAudioFile(String name){
        ArrayList<Audio> al = new ArrayList<>();
        for ( Audio audio : Database.getDataBase().getAudio()){
            if ( audio.getName().equals(name) || audio.getNameArtist().equals(name)){
                al.add(audio);
            }
        }
        return al;
    }

    public ArrayList<Audio> sortAudioFile(String type){
        if (type.equals("L")){
            for (int i = 0; i < Database.getDataBase().getAudio().size()-1 ; i++) {
                for (int j = 0; j < Database.getDataBase().getAudio().size()-i-1 ; j++) {
                    if ( Database.getDataBase().getAudio().get(j).getNumberOfLikes() < Database.getDataBase().getAudio().get(j+1).getNumberOfLikes() ){
                        Collections.swap(Database.getDataBase().getAudio(),j,j+1);
                    }
                }
            }
            return new ArrayList<>(Database.getDataBase().getAudio());
        }
        else{ //if (type.equals("P")){
            for (int i = 0; i < Database.getDataBase().getAudio().size()-1 ; i++) {
                for (int j = 0; j < Database.getDataBase().getAudio().size()-i-1 ; j++) {
                    if ( Database.getDataBase().getAudio().get(j).getNumberOfPlays() < Database.getDataBase().getAudio().get(j+1).getNumberOfPlays() ){
                        Collections.swap(Database.getDataBase().getAudio(),j,j+1);
                    }
                }
            }
            return new ArrayList<>(Database.getDataBase().getAudio());
        }
    }

    public String filterAudioFile(String type,String detail){
        if (type.equals("A")){
            String result = "";
            for ( Audio audio : Database.getDataBase().getAudio() ){
                if ( detail.equals(audio.getNameArtist()) ){
                    result += "\n"+audio;
                }
            }
            return result;
        }
        else if ( type.equals("G")){
            String result = "";
            for ( Audio audio : Database.getDataBase().getAudio() ){
                if ( detail.equals( String.valueOf(audio.getGener()) )){
                    result += "\n"+audio;
                }
            }
            return result;
        }
        else if ( type.equals("D")){
            String result = "";
            String[] str = detail.split("-");
            Date date = new Date(Integer.valueOf(str[0])-1900,Integer.valueOf(str[1])-1,Integer.valueOf(str[2]));
            for ( Audio audio : Database.getDataBase().getAudio() ){
                if ( audio.getDateOfRelease().getYear()==date.getYear() && audio.getDateOfRelease().getMonth()==date.getMonth() && audio.getDateOfRelease().getDay()==date.getDay()){
                    result += "\n"+audio;
                }
            }
            return result;
        }
        return "The desired filter type or detail is not valid";
    }

    public ArrayList<UserAccount> viewFollowing(){
        return getUserAccount().getFollowings();
    }

    public String reportArtist(String userName, String description){
        for (UserAccount userAccount1 : Database.getDataBase().getUserAccounts()){
            if ( userAccount1.getUserName().equals(userName)){
                if ( userAccount1 instanceof Artist){
                    Report report = new Report(getUserAccount(),(Artist) userAccount1,description);
                    Database.getDataBase().getReports().add(report);
                    return "The desired artist was successfully reported";
                }
            }
        }
        return "No artist was found with the entered username";
    }

    public String viewListArtist(){
        String result = "";
        for ( UserAccount userAccount1 : Database.getDataBase().getUserAccounts()){
            if ( userAccount1 instanceof Artist){
                result += "\nUsername: "+userAccount1.getUserName()+"\tName: "+userAccount1.getName();
            }
        }
        if ( result.equals(""))
            result = "empty";
        return result;
    }

    public ArrayList<Album> AllAlbumSinger(String userName){
        for( UserAccount userAccount1 : Database.getDataBase().getUserAccounts()){
            if ( userAccount1.getUserName().equals(userName)) {
                if (userAccount1 instanceof Artist) {
                    if ( userAccount1 instanceof Singer)
                        return ((Singer) userAccount1).getAlbumList();
                }
            }
        }
        return new ArrayList<Album>();
    }

    public String viewInfoArtist(String userName){
        String result = "";
        for ( UserAccount userAccount1 : Database.getDataBase().getUserAccounts()){
            if ( userAccount1.getUserName().equals(userName)){
                if ( userAccount1 instanceof Artist){
                    if ( userAccount1 instanceof Podcaster)
                        result += (Podcaster)userAccount1;
                    else if ( userAccount1 instanceof Singer)
                        result += (Singer)userAccount1;
                }
                break;
            }
        }
        if ( result.equals(""))
            return "The username entered is not valid";
        else
            return result;
    }

    public String followArtist(String userName){
        for ( UserAccount userAccount1 : Database.getDataBase().getUserAccounts()){
            if ( userAccount1.getUserName().equals(userName)){
                if ( userAccount1 instanceof Artist ){
                    ((Artist) userAccount1).getListFollowers().add(getUserAccount());
                    if ( getUserAccount() instanceof Listener){
                        ((Listener) getUserAccount()).getFollowings().add(userAccount1);
                    }
                    return "The desired artist was followed";
                }
            }
        }
        return "The username entered is not valid";
    }

    public ArrayList<Playlist> showAllPlayList(){
        return getUserAccount().getPlaylists();
    }

    public String viewPLaylists(){
        String result = "";
        if ( getUserAccount() instanceof Listener){
            String result1 = "";
            for ( Playlist playlist : ((Listener) getUserAccount()).getPlaylists()){
                result1 += playlist+"\n";
            }
            if ( result1.equals(""))
                result = "you do not have playlist";
            else
                result = result1;
        }
        return result;
    }

    public ArrayList<Audio> selectPlaylist(String playlistName){
        if (getUserAccount() instanceof Listener) {
            for ( Playlist playlist : ((Listener) getUserAccount()).getPlaylists()){
                if ( playlist.getNameOfPlaylist().equals(playlistName))
                    return playlist.getListAudio();
            }
        }
        return new ArrayList<Audio>();
    }

    public ArrayList<UserAccount> getAllArtists(){
        ArrayList<UserAccount> al = new ArrayList<>();
        for(UserAccount userAccount1 : Database.getDataBase().getUserAccounts()){
            if (userAccount1 instanceof Artist){
                al.add(userAccount1);
            }
        }
        return al;
    }

    public ArrayList<Audio> suggestions(){
        ArrayList<Audio> audios = new ArrayList<>();
        sortAudioFile("L");
        int count = 0;
        for ( Audio audio : Database.getDataBase().getAudio()){
            labale1:
            for ( Gener gener : getUserAccount().getFavoriteGener() ) {
                for (UserAccount userAccount1 : getUserAccount().getFollowings()){
                    if ( audio.getNameArtist().equals(   userAccount1.getName()   ) || audio.getGener()==gener ){
                        if ( count<10){
                            audios.add(audio);
                            count++;
                            break labale1;
                        }
                        else
                            return audios;
                    }
                }
            }
        }
            return audios;
//        Audio[] audioArr = new Audio[10];
//        int i=0;
//        int num=0;
//        int count =0;
//        if ( getUserAccount() instanceof Listener ) {
////            String result2 = "";
//            for (Gener gener : ((Listener) getUserAccount()).getFavoriteGener()) {
//                if ( num > 5)
//                    break;
//                for ( Audio audio : Database.getDataBase().getAudio()){
//                    if ( num > 5)
//                        break;
//                    if ( audio.getGener().equals(gener)){
//                        for ( Audio audio1 : audioArr){
//                            if ( audio1 == null)
//                                break;
//                            else if ( audio1.getId()==audio.getId()) {
//                                count = -1;
//                                break;
//                            }
//                        }
//                        if ( count==0) {
//                            audioArr[i]=audio;
//                            i++;
//                            num++;
//                        }
//                        else
//                            count=0;
////                        result2 += audio+"\n";
//                    }
//                }
//            }
//
//            for ( UserAccount userAccount1 : ((Listener) getUserAccount()).getFollowings()){
//                if ( num > 10)
//                    break;
//                if ( userAccount1 instanceof Artist){
//                    for ( Audio audio : Database.getDataBase().getAudio()){
//                        if ( num > 10)
//                            break;
//                        if ( audio.getNameArtist().equals(userAccount1.getName())){
//                            for ( Audio audio1 : audioArr){
//                                if ( audio1 == null)
//                                    break;
//                                if ( audio1.getId()==audio.getId()) {
//                                    count = -1;
//                                    break;
//                                }
//                            }
//                            if ( count==0) {
//                                audioArr[i]=audio;
//                                i++;
//                                num++;
//                            }
//                            else
//                                count=0;
////                            result2 += audio+"\n";
//                        }
//                    }
//                }
//            }
//            if ( audioArr.length==0 )
//                result += "empty";
//            else {
//                for ( Audio audio : audioArr )
//                    result += audio+"\n";
//            }
//        }
//        return result;
    }

    public String accountInfo(){
        String result = "";
        if ( getUserAccount() instanceof Free)
            result += (Free)getUserAccount();
        else {
            ((Premium) getUserAccount()).setDaysOfSubs( ((Premium) getUserAccount()).getDaysOfSubs()-1 );
            result += (Premium) getUserAccount();
        }
        return result;
    }

    public ArrayList<Audio> getAllAudios(){
        return Database.getDataBase().getAudio();
    }

    public String increaseCredit(String value){
        ((Listener) getUserAccount()).setAccountCredit( ((Listener) getUserAccount()).getAccountCredit() + Integer.valueOf(value) );
        return "Account balance is $"+String.valueOf(((Listener) getUserAccount()).getAccountCredit());
    }

    public String getPremium(String type) {
        if (type.equals(String.valueOf(PremiumPkg.ONE_MONTH))) {
            if (((Listener) getUserAccount()).getAccountCredit() < PremiumPkg.ONE_MONTH.getCount())
                return "Your account balance is insufficient";
            ((Listener) getUserAccount()).setAccountCredit(((Listener) getUserAccount()).getAccountCredit() - PremiumPkg.ONE_MONTH.getCount());
            if (getUserAccount() instanceof Premium) {
                ((Premium) getUserAccount()).setDaysOfSubs(((Premium) getUserAccount()).getDaysOfSubs() + 30);
                Date date = new Date(((Premium) getUserAccount()).getExpirationDate().getYear(), ((Premium) getUserAccount()).getExpirationDate().getMonth(), ((Premium) getUserAccount()).getExpirationDate().getDate() + 30);
                ((Premium) getUserAccount()).setExpirationDate(date);
                return "Your account has been renewed";
            }
            else {
                Date now = new Date();
                Date date = new Date(now.getYear(), now.getMonth(), now.getDate() + 30);
                Premium premium = new Premium(getUserAccount().getUserName(), getUserAccount().getPassword(), getUserAccount().getName(), getUserAccount().getEmail(), getUserAccount().getPhoneNumber(), getUserAccount().getDateOfBirth(), ((Listener) getUserAccount()).getAccountCredit(), date, 30);
                premium.setCountNumberPlaylistP(((Free) getUserAccount()).getCountNumberPlaylist());
                premium.setPlaylists(((Free) getUserAccount()).getPlaylists());
                premium.setNumberPlays(((Free) getUserAccount()).getNumberPlays());
                premium.setFavoriteGener(((Free) getUserAccount()).getFavoriteGener());
                premium.setFollowings(((Free) getUserAccount()).getFollowings());
                Database.getDataBase().getUserAccounts().remove(getUserAccount());
                Database.getDataBase().getUserAccounts().add(premium);
                setUserAccount(premium);
                return "Your account has become premium";
            }
        }

        else if (type.equals(String.valueOf(PremiumPkg.TWO_MONTH))) {
            if (((Listener) getUserAccount()).getAccountCredit() < PremiumPkg.TWO_MONTH.getCount())
                return "Your account balance is insufficient";
            ((Listener) getUserAccount()).setAccountCredit(((Listener) getUserAccount()).getAccountCredit() - PremiumPkg.TWO_MONTH.getCount());
            if (getUserAccount() instanceof Premium) {
                ((Premium) getUserAccount()).setDaysOfSubs(((Premium) getUserAccount()).getDaysOfSubs() + 60);
                Date date = new Date(((Premium) getUserAccount()).getExpirationDate().getYear(), ((Premium) getUserAccount()).getExpirationDate().getMonth(), ((Premium) getUserAccount()).getExpirationDate().getDate() + 60);
                ((Premium) getUserAccount()).setExpirationDate(date);
                return "Your account has been renewed";
            }
            else {
                Date now = new Date();
                Date date = new Date(now.getYear(), now.getMonth(), now.getDate() + 60);
                Premium premium = new Premium(getUserAccount().getUserName(), getUserAccount().getPassword(), getUserAccount().getName(), getUserAccount().getEmail(), getUserAccount().getPhoneNumber(), getUserAccount().getDateOfBirth(), ((Listener) getUserAccount()).getAccountCredit(), date, 60);
                premium.setCountNumberPlaylistP(((Free) getUserAccount()).getCountNumberPlaylist());
                premium.setPlaylists(((Free) getUserAccount()).getPlaylists());
                premium.setNumberPlays(((Free) getUserAccount()).getNumberPlays());
                premium.setFavoriteGener(((Free) getUserAccount()).getFavoriteGener());
                premium.setFollowings(((Free) getUserAccount()).getFollowings());
                Database.getDataBase().getUserAccounts().remove(getUserAccount());
                Database.getDataBase().getUserAccounts().add(premium);
                setUserAccount(premium);
                return "Your account has become premium";
            }
        }

        else if (type.equals(String.valueOf(PremiumPkg.SIX_MONTH))) {
            if (((Listener) getUserAccount()).getAccountCredit() < PremiumPkg.SIX_MONTH.getCount())
                return "Your account balance is insufficient";
            ((Listener) getUserAccount()).setAccountCredit(((Listener) getUserAccount()).getAccountCredit() - PremiumPkg.SIX_MONTH.getCount());
            if (getUserAccount() instanceof Premium) {
                ((Premium) getUserAccount()).setDaysOfSubs(((Premium) getUserAccount()).getDaysOfSubs() + 180);
                Date date = new Date(((Premium) getUserAccount()).getExpirationDate().getYear(), ((Premium) getUserAccount()).getExpirationDate().getMonth(), ((Premium) getUserAccount()).getExpirationDate().getDate() + 180);
                ((Premium) getUserAccount()).setExpirationDate(date);
                return "Your account has been renewed";
            }
            else {
                Date now = new Date();
                Date date = new Date(now.getYear(), now.getMonth(), now.getDate() + 180);
                Premium premium = new Premium(getUserAccount().getUserName(), getUserAccount().getPassword(), getUserAccount().getName(), getUserAccount().getEmail(), getUserAccount().getPhoneNumber(), getUserAccount().getDateOfBirth(), ((Listener) getUserAccount()).getAccountCredit(), date, 180);
                premium.setCountNumberPlaylistP(((Free) getUserAccount()).getCountNumberPlaylist());
                premium.setPlaylists(((Free) getUserAccount()).getPlaylists());
                premium.setNumberPlays(((Free) getUserAccount()).getNumberPlays());
                premium.setFavoriteGener(((Free) getUserAccount()).getFavoriteGener());
                premium.setFollowings(((Free) getUserAccount()).getFollowings());
                Database.getDataBase().getUserAccounts().remove(getUserAccount());
                Database.getDataBase().getUserAccounts().add(premium);
                setUserAccount(premium);
                return "Your account has become premium";
            }
        }

        else
            return "The imported package is not valid";
    }

    public String getGener(ArrayList<String> al){
        if ( al.size()>4)
            return "You can only choose 4 genres";
        else if (al.isEmpty()){
            return "Choose at least one genre";
        }
        else if ( al.size() == 1){
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(0)));
        }
        else if ( al.size() == 2){
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(0)));
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(1)));
        }
        else if ( al.size() == 3){
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(0)));
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(1)));
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(2)));
        }
        else if ( al.size() == 4){
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(0)));
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(1)));
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(2)));
            ((Listener)getUserAccount()).getFavoriteGener().add(Gener.valueOf(al.get(3)));
        }
        return "done successfully";
    }

    public String lyricAudio(String audioId){
        for ( Audio audio : Database.getDataBase().getAudio()){
            if ( audio.getId() == Integer.valueOf(audioId)){
                if ( audio instanceof Music)
                    return ((Music) audio).getMusicText();
                else if ( audio instanceof Podcast)
                    return ((Podcast) audio).getCaption();
            }
        }
        return "The entered ID is not valid";
    }

    public ArrayList<String> showPremium(){
        ArrayList<String> al = new ArrayList<>();
        al.add("ONE MONTH");
        al.add(String.valueOf(PremiumPkg.ONE_MONTH.getCount()));
        al.add("TWO MONTH");
        al.add(String.valueOf(PremiumPkg.TWO_MONTH.getCount()));
        al.add("SIX MONTH");
        al.add(String.valueOf(PremiumPkg.SIX_MONTH.getCount()));
        return al;
    }
}