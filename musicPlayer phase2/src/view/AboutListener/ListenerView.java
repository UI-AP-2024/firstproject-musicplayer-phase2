package view.AboutListener;

import controller.AboutLIstener.FreeController;
import controller.AboutLIstener.ListenerController;
import controller.AdminController;
import controller.UserAccountController;
import model.AboutHumans.Artist;
import model.AboutHumans.Listener;
import model.AboutMusic.Audio;
import model.AboutMusic.Music;
import model.AboutMusic.Podcast;
import model.Database;
import model.Types.Free;
import model.Types.Premium;
import model.Types.PremiumType;
import view.Start;
import view.UserView;

import java.util.Scanner;

import static controller.UserAccountController.changeStringToDate;
import static controller.UserAccountController.changeStringToGenre;

public class ListenerView extends UserView {
    Scanner get = new Scanner(System.in);
    ListenerController listenerController = new ListenerController();
    Listener listener;
    Free freeUser;
    Premium premiumUser;

    public void login(String username, String password)
    {
        System.out.println(listenerController.login(username, password));
        if (!(listenerController.login(username, password).equals("Your panel founded ")))
            Start.start();
        listener = listenerController.listener;
        if (listener instanceof Free) {
            freeUser = (Free) listener;
            instructions(freeUser);
        }
        else if (listener instanceof Premium) {
            premiumUser = (Premium) listener;
            instructions(premiumUser);
        }
    }

    public void signup(String name, String username, String password, String email, String number, String birthday)
    {
        freeUser = new Free(name, username, password, email, number, birthday);
        listener = freeUser;
        checking(number, password, email, username, birthday , freeUser);
        listenerController.signup(freeUser);

        userFavoriteGenres(freeUser);
        System.out.println("welcome:)");
        instructions(freeUser);
    }

    public void userFavoriteGenres(Listener listener)
    {
        System.out.println("Genres: ROCK , POP , JAZZ , HIPHOP , COUNTRY , TRUECRIME , SOCIETY , INTERVIEW , HISTORY\nchoose your favorite genres (at list 1 and maximum 4)" +
                "\nwarning: if you don't enter a valid genre you will have problem later. please copy and paste genre");
        String favorite = get.nextLine();
        String[] favoriteGenres = favorite.split(" , ");
        while (favoriteGenres.length > 4 || favoriteGenres.length < 1)
        {
            System.out.println("please enter your favorite genres between 1 and 4");
            favorite = get.nextLine();
            favoriteGenres = favorite.split(" , ");
        }
        if (favoriteGenres.length == 1)
            listenerController.getFavoriteGenre(changeStringToGenre(favoriteGenres[0]) , listener);
        else if (favoriteGenres.length == 2)
            listenerController.getFavoriteGenre(changeStringToGenre(favoriteGenres[0]), changeStringToGenre(favoriteGenres[1]) , listener);
        else if (favoriteGenres.length == 3)
            listenerController.getFavoriteGenre(changeStringToGenre(favoriteGenres[0]), changeStringToGenre(favoriteGenres[1]) , changeStringToGenre(favoriteGenres[2]), listener);
        else if (favoriteGenres.length == 4)
            listenerController.getFavoriteGenre(changeStringToGenre(favoriteGenres[0]), changeStringToGenre(favoriteGenres[1]) , changeStringToGenre(favoriteGenres[2]) , changeStringToGenre(favoriteGenres[3]), listener);
    }

    public void instructions (Listener listener)
    {
        String works;

        boolean finish = true;
        while (finish) {
            works = get.nextLine();
            String[] allWorks = works.split(" - ");

            if (works.equals("logout"))
            {
                finish = false;
                Start.start();
            }

            else if (allWorks[0].equals("favoriteGenres"))
            {
                userFavoriteGenres(listener);
            }

            else if (allWorks[0].equals("getSuggestion") && allWorks.length == 2)
            {
                System.out.println(listenerController.suggestMusic(Integer.parseInt(allWorks[1]) , listener));
            }

            else if (allWorks[0].equals("accountInfo"))
            {
                System.out.println(listenerController.watchAccountInformation(listener));
            }

            else if (allWorks[0].equals("artists") && allWorks.length == 1)
            {
                System.out.println(listenerController.watchAllArtists());
            }

            else if (allWorks[0].equals("artist") && allWorks.length == 2)
            {
                boolean found = false;
                for (Artist a : Database.allArtists)
                {
                    if (a.getUsername().equals(allWorks[1])) {
                        System.out.println(listenerController.watchArtistCreation(a));
                        found = true;
                        break;
                    }
                }
                if (!found )
                {
                    System.out.println("artist with this username not exist");
                }
            }

            else if (allWorks[0].equals("follow") && allWorks.length == 2)
            {
                System.out.println(listenerController.followingArtist(allWorks[1], listener));
            }

            else if (allWorks[0].equals("search") && allWorks.length == 2)
            {
                System.out.println(listenerController.searchInAudios(allWorks[1]));
            }

            else if (allWorks[0].equals("sort") && allWorks[1].equals("likes") && allWorks.length == 2)
            {
                System.out.println(listenerController.sortAudiosBasedOnLikes());
            }

            else if (allWorks[0].equals("sort") && allWorks[1].equals("plays") && allWorks.length == 2)
            {
                System.out.println(listenerController.sortAudiosBasedOnPlays());
            }

            else if (allWorks[0].equals("filter") && allWorks[1].equals("artist") && allWorks.length == 3)
            {
                boolean found = false;
                for (Artist a : Database.allArtists)
                {
                    if (a.getUsername().equals(allWorks[2])) {
                        System.out.println(listenerController.filterAudios(a));
                        found = true;
                        break;
                    }
                }

                if (!found)
                    System.out.println("artist dose not exist");
            }

            else if (allWorks[0].equals("filter") && allWorks[1].equals("genre") && allWorks.length == 3)
            {
                System.out.println(listenerController.filterAudios(changeStringToGenre(allWorks[2])));
            }

            else if (allWorks[0].equals("filter") && allWorks[1].equals("date") && allWorks.length == 4)
            {
                System.out.println(listenerController.filterAudios(changeStringToDate(allWorks[2]) , changeStringToDate(allWorks[3])));
            }

            else if (allWorks[0].equals("add") && allWorks.length == 3)
            {
                if (listener instanceof Free)
                {
                    FreeView freeView = new FreeView();
                    freeView.addMusicToPlaylist(allWorks[1], Integer.parseInt(allWorks[2]) , listener);
                }

                else if (listener instanceof Premium)
                {
                    PremiumView premiumView = new PremiumView();
                    premiumView.addMusicToPlaylist(allWorks[1], Integer.parseInt(allWorks[2]) , premiumUser);
                }
            }

            else if (allWorks[0].equals("play") && allWorks.length == 2)
            {
                Audio audio = UserAccountController.findAudio(Integer.parseInt(allWorks[1]));
                if (audio == null)
                    System.out.println("audio not exist");
                else
                {
                    System.out.println(listenerController.playAudio(audio));
                }
            }

            else if (allWorks[0].equals("like") && allWorks.length == 2)
            {
                Audio audio = UserAccountController.findAudio(Integer.parseInt(allWorks[1]));
                if (audio == null)
                    System.out.println("audio not found");
                else
                {
                    System.out.println(listenerController.likeAudio(audio , listener));
                }
            }

            else if (allWorks[0].equals("lyrics") && allWorks.length == 2)
            {
                Music music = UserAccountController.findMusic(Integer.parseInt(allWorks[1]));
                if (music == null)
                    System.out.println("audio not found");
                else
                {
                    System.out.println(music.getLyrics());
                }
            }

            else if (allWorks[0].equals("caption") && allWorks.length == 2)
            {
                Podcast podcast = UserAccountController.findPodcast(Integer.parseInt(allWorks[1]));
                if (podcast == null)
                {
                    System.out.println("podcast not found");
                }

                else
                    System.out.println(podcast.getCaption());
            }

            else if (allWorks[0].equals("showPlaylists") && allWorks.length == 1)
            {
                System.out.println(listenerController.watchAllPlaylists(listener));
            }

            else if (allWorks[0].equals("selectPlaylist") && allWorks.length == 2)
            {
                System.out.println(listenerController.watchPlaylistInformation(allWorks[1], listener));
            }

            else if (allWorks[0].equals("followings") && allWorks.length == 1)
            {
                System.out.println(listenerController.watchFollowings());
            }

            else if (allWorks[0].equals("report") && allWorks.length == 3)
            {
                Artist artist = null;
                boolean found = false;
                for (Artist a : Database.allArtists)
                {
                    if (a.getUsername().equals(allWorks[1]))
                    {
                        artist = a;
                        found = true;
                    }
                }

                if (!found)
                    System.out.println("artist not found");
                else
                {
                    listenerController.reporting(listener , artist , allWorks[2]);
                    System.out.println("your report send to the admin");
                }
            }

            else if (allWorks[0].equals("newPlaylist") && allWorks.length == 2)
            {
                if (listener instanceof Free)
                {
                    FreeView freeView = new FreeView();
                    freeView.newPlaylist(allWorks[1] , listener);
                }

                else if (listener instanceof Premium)
                {
                    PremiumView premiumView = new PremiumView();
                    premiumView.newPlaylist(allWorks[1] , listener);
                }
            }

            else if (allWorks[0].equals("increaseCredit") && allWorks.length == 2)
            {
                listenerController.increaseCredit(Integer.parseInt(allWorks[1]) , listener);
                System.out.println("your credit: " + listener.getCredit());
            }

            else if (allWorks[0].equals("getPremium") && allWorks.length == 2)
            {
                PremiumType premiumType = null;
                if (allWorks[1].equals("30"))
                    premiumType = PremiumType.valueOf("THIRTY");
                else if (allWorks[1].equals("60"))
                    premiumType = PremiumType.valueOf("SIXTY");
                else if (allWorks[1].equals("180"))
                    premiumType = PremiumType.valueOf("ONEHUNDREDEIGHTY");
                else {
                    System.out.println("invalid package");
                }
                //.......................................................
                if (listener instanceof Free && premiumType != null)
                {
                    FreeController freeController = new FreeController();
                    System.out.println(freeController.buySubscription(premiumType , listener));
                    listener = freeController.listener;
                    premiumUser = (Premium) freeController.listener;
                    freeUser = null;
                }

                else if (listener instanceof Premium && premiumType != null)
                {
                    PremiumView premiumView = new PremiumView();
                    premiumView.getPremium(premiumType , listener);
                }
            }

            else if (allWorks[0].equals("premiumExpiration") && allWorks.length == 1)
            {
                if (listener instanceof Free)
                    System.out.println("you aren't premium");
                else
                {
                    PremiumView premiumView = new PremiumView();
                    premiumView.endPremium(premiumUser);
                }
            }

            else if (allWorks[0].equals("audios") && allWorks.length == 1)
            {
                AdminController adminController = new AdminController();
                System.out.println(adminController.watchAllAudiosInformation());
            }

            else
            {
                System.out.println("invalid instruction");
            }
        }
    }
}