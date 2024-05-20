package org.example.phase2.Controller;

import org.example.phase2.Exceptions.FreeAccountLimitException;
import org.example.phase2.Exceptions.InterestedGenreLimit;
import org.example.phase2.Exceptions.NotEnoughMoney;
import org.example.phase2.Model.Audios.*;
import org.example.phase2.Model.Users.*;
import org.example.phase2.Model.Database.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


public class ListenerController{

    private static ListenerController listenerController;
    private Listener listener;
    private ListenerController(){

    }
    public static ListenerController getListenerController()
    {
        if(listenerController==null)
        {
            listenerController=new ListenerController();
        }
        return listenerController;
    }
    public void logout(){
        listener=null;
    }
    public void findListener(String username)
    {
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        for(UserAccount user : users)
        {
            if(user.getUsername().equals(username))
            {
                setListener((Listener) user);
            }
        }
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener)
    {
        this.listener=listener;
    }

    public void chooseFavouriteGenres(String interestedGenres) throws InterestedGenreLimit {
        String[] genres=interestedGenres.split(",");
        for(String genre : genres)
        {
            if(listener.getNumberOfInterestedGenres()<4)
            {
                listener.getInterestedGenres().add(Genre.valueOf(genre));
                listener.setNumberOfInterestedGenres(listener.getNumberOfInterestedGenres() + 1);
            }
            else{
                throw new InterestedGenreLimit();
            }
        }
    }
    public int addMusicToPlaylist(String playlistName,String audioId2) throws FreeAccountLimitException {
        long audioId=Long.parseLong(audioId2);
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        Audio selectedAudio = null;
        for (Audio audio : audios) {
            if (audio.getId() == audioId) {
                selectedAudio = audio;
            }
        }
        if(listener instanceof PremiumListener) {
            int count = 0;
            ArrayList<Playlist> playlists = listener.getPlaylists();
            for (Playlist playlist : playlists) {
                if (playlist.getNameOfPlayList().equals(playlistName)) {
                    playlist.getAudioList().add(selectedAudio);
                    count++;
                }
            }
            if(count == 0) {
                Playlist newPlaylist = new Playlist(playlistName, listener.getFirstAndLastName());
                newPlaylist.getAudioList().add(selectedAudio);
                listener.getPlaylists().add(newPlaylist);
            }
            //return "Audio is added to the playlist successfully.";
            return 1;
        }
        if(listener instanceof FreeListener)
        {
            FreeListener freeListener = (FreeListener)listener;
            int count = 0;
            ArrayList<Playlist> playlists = listener.getPlaylists();
            for (Playlist playlist : playlists) {
                if (playlist.getNameOfPlayList().equals(playlistName)) {
                    if(playlist.getAudioList().size()<freeListener.getNumberOfPlaylistAudios()) {
                        playlist.getAudioList().add(selectedAudio);
                        count++;
                        //return "Audio is added to the playlist successfully.";
                        return 1;
                    }
                    throw new FreeAccountLimitException();
                    //`return "To add music to the playlist make your account Premium and try again.";
                }
            }
            if(count==0){
                if(freeListener.getPlaylists().size()<freeListener.getNumberOfPlaylists())
                {
                    Playlist newPlaylist = new Playlist(playlistName, listener.getFirstAndLastName());
                    newPlaylist.getAudioList().add(selectedAudio);
                    listener.getPlaylists().add(newPlaylist);
                    //return "Audio is added to the playlist successfully.";
                    return 1;
                }
                //return "To create a new playlist make your account Premium and try again.";
                throw new FreeAccountLimitException();
            }
        }
        //return "There was a problem in creating or finding the playlist. Please try again.";
        return -1;
    }
    public int createPlaylist(String playlistName) throws FreeAccountLimitException {
        if(listener instanceof PremiumListener)
        {
            Playlist newPlaylist = new Playlist(playlistName, listener.getFirstAndLastName());
            listener.getPlaylists().add(newPlaylist);
            //return "Playlist is created successfully.";
            return 1;
        }
        if(listener instanceof FreeListener)
        {
            FreeListener freeListener = (FreeListener)listener;
            if(freeListener.getPlaylists().size()<freeListener.getNumberOfPlaylists())
            {
                Playlist newPlaylist = new Playlist(playlistName, listener.getFirstAndLastName());
                listener.getPlaylists().add(newPlaylist);
                //return "New playlist is created successfully.";
                return 1;
            }
            throw new FreeAccountLimitException();
            //return "To create a new playlist make your account Premium and try again.";
        }
        //return "There was a problem in creating or finding the playlist. Please try again.";
        return -1;
    }
    public String playAudio(String audioId2)
    {
        long audioId=Long.parseLong(audioId2);
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        for(Audio audio : audios)
        {
            if(audio.getId()==audioId)
            {
                audio.setNumberOfListening(audio.getNumberOfListening() + 1);
                listener.getPlayedAudios().add(audio);
                listener.getNumberOfPlayingEachAudio().putIfAbsent(audio, 0);
                listener.getNumberOfPlayingEachAudio().replace(audio,listener.getNumberOfPlayingEachAudio().get(audio)+1);
                if(audio instanceof Podcast)
                {
                    Podcast podcast=(Podcast) audio;
                    return podcast.getCaption();
                }
                return "Music played successfully.";
            }
        }
        return "Something was wrong. Please try again.";
    }
    public String showText(String audioId2)
    {
        long audioId=Long.parseLong(audioId2);
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        for(Audio audio : audios)
        {
            if(audio.getId()==audioId && audio instanceof Music)
            {
                Music music=(Music) audio;
                return music.getLyric();
            }
        }
        return "Something was wrong. Please try again.";
    }
    public void likeAudio(String audioId2)
    {
        long audioId=Long.parseLong(audioId2);
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        int count=0;
        for(Audio audio1 : audios)
        {
            if(audio1.getId()==audioId)
            {
                for(Audio audio2 : listener.getLikedAudios())
                {
                    if(audio2.getId()==audio1.getId())
                    {
                        count++;
                    }
                }
                if(count==0)
                {
                    audio1.setLikes(audio1.getLikes() + 1);
                }
            }
        }
    }
    public String search(String word)
    {
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        StringBuilder info = new StringBuilder("");
        for(UserAccount user : users)
        {
            if(user.getFirstAndLastName().equals(word) && user instanceof Artist)
            {
                Artist artist = (Artist) user;
                info.append("Artist's information: \n");
//                info.append("Name: "+ artist.getFirstAndLastName()+"\n");
//                info.append("Birth date: "+ artist.getBirthDate()+"\n");
//                info.append("Biography: "+ artist.getBiography()+"\n");
//                info.append("Username: "+artist.getUsername()+"\n");
                info.append(artist.toString());
            }
        }
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        for(Audio audio : audios)
        {
            if(audio.getName().equals(word))
            {
                info.append("Audio's information: \n");
//                info.append("Name: "+audio.getName()+"\n");
//                info.append("Artist: "+audio.getArtist()+"\n");
//                info.append("Genre: "+audio.getGenre()+"\n");
//                info.append("Likes: "+audio.getLikes()+"\n");
//                info.append("ID: "+audio.getId()+"\n");
                info.append(audio.toString());
            }
        }
        if(info.toString().equals(""))
            return "Couldn't find the word";
        return info.toString();
    }
    public ArrayList<Audio> sortBasedOnLike(){
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        Audio temp;
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
        return audios;
    }
    public ArrayList<Audio> sortBasedOnPlay(){
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        Audio temp;
        for(int i=0;i< audios.size()-1;i++)
        {
            for(int j=i+1;j<audios.size();j++)
            {
                if(audios.get(i).getNumberOfListening()<audios.get(j).getNumberOfListening())
                {
                    temp=audios.get(i);
                    audios.set(i,audios.get(j));
                    audios.set(j,temp);
                }
            }
        }
        return audios;
    }
    public ArrayList<Audio> sort(){
        ArrayList<Audio> audios=Database.getDatabase().getAudios();
        Collections.sort(audios,Audio::compareTo);
        return audios;
    }
    public String sort(String sortType)
    {
        //ArrayList<Audio> audios = Database.getDatabase().getAudios();
        ArrayList<Audio> audios;
        if(sortType.equals("L"))
        {
//            Audio temp;
//            for(int i=0;i< audios.size()-1;i++)
//            {
//                for(int j=i+1;j<audios.size();j++)
//                {
//                    if(audios.get(i).getLikes()<audios.get(j).getLikes())
//                    {
//                        temp=audios.get(i);
//                        audios.set(i,audios.get(j));
//                        audios.set(j,temp);
//                    }
//                }
//            }
            audios=sortBasedOnLike();
            StringBuilder info = new StringBuilder();
            info.append("Audios: \n");
            for(Audio audio : audios)
            {
                info.append("Audio's name: "+audio.getName()+"\n");
                info.append("Audio's ID: "+audio.getId()+"\n");
                info.append("Likes: "+audio.getLikes()+"\n\n");
            }
            return info.toString();
        }
        if(sortType.equals("P"))
        {
//            Audio temp;
//            for(int i=0;i< audios.size()-1;i++)
//            {
//                for(int j=i+1;j<audios.size();j++)
//                {
//                    if(audios.get(i).getNumberOfListening()<audios.get(j).getNumberOfListening())
//                    {
//                        temp=audios.get(i);
//                        audios.set(i,audios.get(j));
//                        audios.set(j,temp);
//                    }
//                }
//            }
            audios=sortBasedOnPlay();
            StringBuilder info = new StringBuilder();
            info.append("Audios: \n");
            for(Audio audio : audios)
            {
                info.append("Audio's name: "+audio.getName()+"\n");
                info.append("Audio's ID: "+audio.getId()+"\n");
                info.append("Plays: "+audio.getNumberOfListening()+"\n\n");
            }
            return info.toString();
        }
        return "There is a problem. Please try again.";
    }
    public String filterAudios(String filteredBy,String name)
    {
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        StringBuilder info = new StringBuilder();
        if(filteredBy.equals("A"))
        {
            for(Audio audio : audios)
            {
                if(audio.getArtist().equals(name))
                {
                    info.append("Audio's name: "+audio.getName()+"\n");
                    info.append("Audio's ID: "+audio.getId()+"\n");
                    info.append("Likes: "+audio.getLikes()+"\n\n");
                }
            }
            return info.toString();
        }
        if(filteredBy.equals("G"))
        {
            for(Audio audio : audios)
            {
                if(audio.getGenre().name().equals(name))
                {
                    info.append("Audio's name: "+audio.getName()+"\n");
                    info.append("Audio's ID: "+audio.getId()+"\n");
                    info.append("Likes: "+audio.getLikes()+"\n\n");
                }
            }
            return info.toString();
        }
        return "There is a problem. Please try again.";
    }
    public String filterAudios(String filteredBy,String firstDate,String secondDate) throws ParseException {
        ArrayList<Audio> audios = Database.getDatabase().getAudios();
        StringBuilder info = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date1= sdf.parse(firstDate);
        Date date2= sdf.parse(secondDate);
        LocalDate startDate = LocalDate.of(date1.getYear()+1900, date1.getMonth()+1, date1.getDate());
        LocalDate endDate = LocalDate.of(date2.getYear()+1900, date2.getMonth()+1, date2.getDate());
        if(filteredBy.equals("D")) {
            for (Audio audio : audios) {
                LocalDate mainDate = audio.getLaunchDate();
                if (mainDate.isAfter(startDate) && mainDate.isBefore(endDate)) {
                    info.append("Audio's name: " + audio.getName() + "\n");
                    info.append("Audio's ID: " + audio.getId() + "\n");
                    info.append("Likes: " + audio.getLikes() + "\n\n");
                }
            }
            return info.toString();
        }
        return "There is a problem. Please try again.";
    }
    public void followArtist(String artistUsername)
    {
        ArrayList<UserAccount>users=Database.getDatabase().getUsers();
        Artist artist = null;
        for(UserAccount user : users)
        {
            if(user.getUsername().equals(artistUsername))
            {
                artist = (Artist) user;
            }
        }
        int count=0;
        for(UserAccount user2 : artist.getFollowers())
        {
            if(user2.getUsername().equals(listener.getUsername()))
            {
                count++;
            }
        }
        if(count == 0)
        {
            artist.getFollowers().add(listener);
            listener.getFollowings().add(artist);
        }
    }
    public String showFollowings()
    {
        StringBuilder info =new StringBuilder("Followed artists: \n\n");
        for(Artist artist : listener.getFollowings())
        {
            info.append("Name: "+artist.getFirstAndLastName()+"\n");
            info.append("Birth date: "+artist.getBirthDate()+"\n");
            info.append("Biography: "+artist.getBiography()+"\n\n");
        }
        return info.toString();
    }
    public void report(String artistUsername,String description)
    {
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        Artist artist = null;
        for(UserAccount user : users)
        {
            if(user.getUsername().equals(artistUsername))
            {
                artist = (Artist) user;
            }
        }
        Report newReport=new Report(listener,artist,description);
        Database.getDatabase().getReports().add(newReport);
    }
    public String showListOfArtists()
    {
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        ArrayList<Artist> artists = new ArrayList<>();
        for(UserAccount user : users)
        {
            if(user instanceof Artist)
            {
                Artist artist = (Artist) user;
                artists.add(artist);
            }
        }
        StringBuilder info =new StringBuilder();
        for(Artist artist : artists)
        {
            info.append("Name: "+artist.getFirstAndLastName()+"\t"+"Username: "+artist.getUsername()+"\n");
        }
        return info.toString();
    }
    public String showInformationOfArtist(String username)
    {
        Artist artist=null;
        StringBuilder info = new StringBuilder();
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        ArrayList<Audio> audios=Database.getDatabase().getAudios();
        for(UserAccount user : users)
        {
            if(user.getUsername().equals(username) && user instanceof Artist)
            {
                artist = (Artist) user;
                break;
            }
        }
        if(artist==null)
        {
            return "Something is wrong. Make sure that username is correct.";
        }
        info.append("Artist's information: \n");
//        info.append("Name: "+artist.getFirstAndLastName()+"\n");
//        info.append("Birth date: "+artist.getBirthDate()+"\n");
//        info.append("Email address: "+artist.getEmailAddress()+"\n");
//        info.append("Biography: "+artist.getBiography()+"\n");
        info.append(artist.toString());
        info.append("Audios published by the artist: \n");
        for(Audio audio : audios)
        {
            if(audio.getArtist().equals(artist.getFirstAndLastName()))
            {
//                info.append("Audio's name: "+audio.getName()+"\t");
//                info.append("Audio's ID: "+audio.getId()+"\t");
//                info.append("Likes: "+audio.getLikes()+"\n");
                info.append(audio.toString());
            }
        }
        return info.toString();
    }
    public String showMyPlaylists()
    {
        StringBuilder info = new StringBuilder("Your playlists: \n");
        for(Playlist playlist : listener.getPlaylists())
        {
//            info.append("Name: "+playlist.getNameOfPlayList()+"\t");
//            info.append("ID: "+playlist.getId()+"\n");
            info.append(playlist.toString());
        }
        return info.toString();
    }
    public String showInformationOfOnePlaylist(String playlistName)
    {
        //long playlistId=Long.parseLong(playlistId2);
        Playlist selectedPlaylist = null;
        for(Playlist playlist : listener.getPlaylists())
        {
            if(playlist.getNameOfPlayList().equals(playlistName))
            {
                selectedPlaylist=playlist;
            }
        }
        StringBuilder info=new StringBuilder("The playlist includes below audios: \n");
        for(Audio audio : selectedPlaylist.getAudioList())
        {
//            info.append("Audio's name: "+audio.getName()+"\t");
//            info.append("Audio's ID: "+audio.getId()+"\t");
//            info.append("Likes: "+audio.getLikes()+"\n");
            info.append(audio.toString());
        }
        return info.toString();
    }
    public ArrayList<Audio> showSuggestions(long number)
    {
        ArrayList<Audio> audios=Database.getDatabase().getAudios();
        ArrayList<Audio> suggestedAudios=new ArrayList<Audio>();
        for(Audio audio : audios)
        {
            for(Genre genre : listener.getInterestedGenres())
            {
                if(audio.getGenre().equals(genre))
                {
                    suggestedAudios.add(audio);
                    break;
                }
            }
        }
        Map.Entry<Audio,Integer>[] audioMap = listener.getNumberOfPlayingEachAudio().entrySet().toArray(new Map.Entry[listener.getNumberOfPlayingEachAudio().size()]);
        Map.Entry<Audio,Integer> temp;
        for(int i=0; i<listener.getNumberOfPlayingEachAudio().size()-1;i++)
        {
            for(int j = i+1; j<listener.getNumberOfPlayingEachAudio().size();j++)
            {
                if(audioMap[i].getValue() < audioMap[j].getValue())
                {
                    temp=audioMap[i];
                    audioMap[i]=audioMap[j];
                    audioMap[j]=temp;
                }
            }
        }
        for(int i=0;i<listener.getNumberOfPlayingEachAudio().size();i++)
        {
            if(!suggestedAudios.contains(audioMap[i].getKey()))
            {
                for(Audio audio2 : audios)
                {
                    if(audio2.getGenre().equals(audioMap[i].getKey().getGenre()))
                    {
                        suggestedAudios.add(audio2);
                    }
                }
            }
        }
        for(Audio audio : listener.getLikedAudios())
        {
            if(!suggestedAudios.contains(audio))
            {
                for(Audio audio2 : audios)
                {
                    if(audio2.getGenre().equals(audio.getGenre()))
                    {
                        suggestedAudios.add(audio2);
                    }
                }
            }
        }
        for(Artist artist : listener.getFollowings())
        {
            for(Audio audio : audios)
            {
                if(audio.getArtist().equals(artist.getFirstAndLastName()) && !suggestedAudios.contains(audio))
                {
                    suggestedAudios.add(audio);
                }
            }
        }
        int count=0;
        //StringBuilder info = new StringBuilder("Suggested audios: \n");
        for(Audio audio : suggestedAudios)
        {
            if(count<number)
            {
//                info.append("Name: "+audio.getName()+"\t\t");
//                info.append("Artist: "+audio.getArtist()+"\t\t");
//                info.append("Genre: "+audio.getGenre()+"\t\t");
//                info.append("ID: "+audio.getId()+"\n");
                //info.append(audio.toString());
                count++;
            }
        }
        Audio temp2;
        if(count<number)
        {
            for(int i=0;i< audios.size()-1;i++)
            {
                for(int j=i+1;j<audios.size();j++)
                {
                    if(audios.get(i).getLikes()<audios.get(j).getLikes())
                    {
                        temp2=audios.get(i);
                        audios.set(i,audios.get(j));
                        audios.set(j,temp2);
                    }
                }
            }
            for(Audio popularAudio : audios)
            {
//                info.append("Name: "+popularAudio.getName()+"\t\t");
//                info.append("Artist: "+popularAudio.getArtist()+"\t\t");
//                info.append("Genre: "+popularAudio.getGenre()+"\t\t");
//                info.append("ID: "+popularAudio.getId()+"\n");
                //info.append(popularAudio.toString());
                if(!suggestedAudios.contains(popularAudio)){
                    suggestedAudios.add(popularAudio);
                }
                count++;
                if(count==number)
                {
                    break;
                }
            }
        }
        //return info.toString();
        return suggestedAudios;
    }
    public String showListenerInformation() throws ParseException {
        StringBuilder info = new StringBuilder();
//        info.append("Name: "+listener.getFirstAndLastName()+"\n");
//        info.append("Birth date: "+listener.getBirthDate()+"\n");
//        info.append("Email address: "+listener.getEmailAddress()+"\n");
//        info.append("Phone number: "+listener.getPhoneNumber()+"\n");
//        info.append("Your credit: "+listener.getCredit()+"\n");
        info.append(listener.toString());
        if(listener instanceof PremiumListener)
        {
            PremiumListener premiumListener=(PremiumListener)listener;
            info.append("Left days of your premium account: "+premiumListener.getLeftDays()+"\n");
            if(premiumListener.getLeftDays()==-1)
            {
                FreeListener newFreelistener = new FreeListener(premiumListener.getUsername(),premiumListener.getPassword(),premiumListener.getFirstAndLastName(),premiumListener.getEmailAddress(),premiumListener.getPhoneNumber(),premiumListener.getBirthDate2());
                newFreelistener.setCredit(listener.getCredit());
                newFreelistener.setPlaylists(listener.getPlaylists());
                newFreelistener.setNumberOfPlayingEachAudio(listener.getNumberOfPlayingEachAudio());
                newFreelistener.setInterestedGenres(listener.getInterestedGenres());
                newFreelistener.setNumberOfInterestedGenres(listener.getNumberOfInterestedGenres());
                newFreelistener.setLikedAudios(listener.getLikedAudios());
                newFreelistener.setFollowings(listener.getFollowings());
                newFreelistener.setPlayedAudios(listener.getPlayedAudios());
                Database.getDatabase().getUsers().remove(listener);
                Database.getDatabase().getUsers().add(newFreelistener);
                ListenerController.getListenerController().setListener(newFreelistener);
            }
            else
            {
                premiumListener.setLeftDays(premiumListener.getLeftDays()+2);
            }
        }

        return info.toString();
    }
    public String increaseCredit(String value2)
    {
        long value = Long.parseLong(value2);
        listener.setCredit(listener.getCredit()+value);
        return "Your credit increased successfully.";
    }
    public int getPremium(String pickedPackage) throws ParseException, NotEnoughMoney {
        PremiumTypes pickedType=PremiumTypes.valueOf(pickedPackage);
        ArrayList<UserAccount> users = Database.getDatabase().getUsers();
        if(pickedType.getPrice()<=listener.getCredit())
        {
            listener.setCredit(listener.getCredit()-pickedType.getPrice());
        }
        else
        {
            throw new NotEnoughMoney();
            //return "Your credit is not enough.";
        }
        if(listener instanceof FreeListener) {
//            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            PremiumListener newPremiumListener = new PremiumListener(listener.getUsername(), listener.getPassword(), listener.getFirstAndLastName(), listener.getEmailAddress(), listener.getPhoneNumber(), listener.getBirthDate2(), pickedType);
            newPremiumListener.setCredit(listener.getCredit());
            newPremiumListener.setPlaylists(listener.getPlaylists());
            newPremiumListener.setNumberOfPlayingEachAudio(listener.getNumberOfPlayingEachAudio());
            newPremiumListener.setInterestedGenres(listener.getInterestedGenres());
            newPremiumListener.setNumberOfInterestedGenres(listener.getNumberOfInterestedGenres());
            newPremiumListener.setLikedAudios(listener.getLikedAudios());
            newPremiumListener.setFollowings(listener.getFollowings());
            newPremiumListener.setPlayedAudios(listener.getPlayedAudios());
            users.remove(listener);
            users.add(newPremiumListener);
            ListenerController.getListenerController().setListener(newPremiumListener);
            return 1;
        }
        if(listener instanceof PremiumListener)
        {
            PremiumListener premiumListener=(PremiumListener) listener;
            if(pickedType.equals(PremiumTypes.ONEMONTH))
            {
                premiumListener.setLeftDays(premiumListener.getLeftDays()+31);
            }
            if(pickedType.equals(PremiumTypes.TWOMONTHS))
            {
                premiumListener.setLeftDays(premiumListener.getLeftDays()+61);
            }
            if(pickedType.equals(PremiumTypes.SIXMONTHS))
            {
                premiumListener.setLeftDays(premiumListener.getLeftDays()+181);
            }
            //return "Your account is extended successfully.";
            return 2;
        }
        //return "Something was wrong. Please try again.";
        return -1;
    }
    public String help()
    {
        StringBuilder commands=new StringBuilder("Commands: \n");
        commands.append("1. Signup -L|S|P -[username] -[password] -[name] -[email] -[phone number] " +
                "-[birth date]\n");
        commands.append("2. FavouriteGenres -[favourite genres separated with comma(,)]\n");
        commands.append("3. Login -[username] -[password]\n");
        commands.append("4. Logout\n");
        commands.append("5. AccountInfo\n");
        commands.append("6. GetSuggestions +n\n");
        commands.append("7. Artists\n");
        commands.append("8. Artist -[username]\n");
        commands.append("9. Follow -[username]\n");
        commands.append("10. Search -[artist name OR audio’s title]\n");
        commands.append("11. Sort -L|P\n");
        commands.append("12. Filter -A|G|D -[filter by]\n");
        commands.append("13. Add -[playlist’s name] -[audio’s ID]\n");
        commands.append("14. ShowPlaylists\n");
        commands.append("15. SelectPlaylist -[playlist’s name]\n");
        commands.append("16. Play -[audio’s ID]\n");
        commands.append("17. Like -[audio’s ID]\n");
        commands.append("18. Lyric -[audio’s ID]\n");
        commands.append("19. NewPlaylist -[playlist’s name]\n");
        commands.append("20. Followings\n");
        commands.append("21. Report -[artist’s username] -[explanation]\n");
        commands.append("22. IncreaseCredit -[value]\n");
        commands.append("23. GetPremium -[package]\n");
        return commands.toString();
    }
}