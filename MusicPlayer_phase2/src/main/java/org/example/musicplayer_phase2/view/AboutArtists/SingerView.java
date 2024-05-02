package org.example.musicplayer_phase2.view.AboutArtists;

import org.example.musicplayer_phase2.controller.AboutArtist.SingerController;
import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Singer;
import org.example.musicplayer_phase2.model.AboutMusic.Album;
import org.example.musicplayer_phase2.model.AboutMusic.Music;
import org.example.musicplayer_phase2.view.Start;

import java.util.Scanner;

public class SingerView extends ArtistView {
    Scanner get = new Scanner(System.in);
    public void SingerInstructions (Singer singer)
    {
        String works = "";
        boolean finish = true;
        while (finish)
        {
            SingerController singerContrller = new SingerController();
            works = get.nextLine();
            String[] allWorks = works.split(" - ");
            if (works.equals("logout"))
            {
                finish = false;
                Start.start();
            }

            else if (allWorks[0].equals("accountInfo"))
            {
                System.out.println(singerContrller.watchInformation(singer));
            }

            else if (allWorks[0].equals("followers") && allWorks.length == 1)
            {
                System.out.println(singerContrller.watchFollowers(singer));
            }

            else if (allWorks[0].equals("viewsStatistics") && allWorks.length == 1)
            {
                System.out.println(singerContrller.watchPlaysNumber(singer));
            }

            else if (allWorks[0].equals("calculateEarnings") && allWorks.length == 1)
            {
                System.out.println(singerContrller.watchIncome(singer));
            }

            else if (allWorks[0].equals("newAlbum") && allWorks.length == 2)
            {
                Album album = new Album(allWorks[1], singer.getName());
                singerContrller.makeNewAlbum(album , singer);
                System.out.println("album made successfuly");
            }

            else if (allWorks[0].equals("publish") && allWorks.length == 8)
            {
                Album album = null;
                for (Album a : singer.getAllAlbums())
                {
                    if (a.getName().equals(allWorks[6]))
                        album = a;
                }
                if (album == null)
                    System.out.println("album not found");
                else {
                    Music music = new Music(allWorks[1], singer.getUsername(), allWorks[7], allWorks[2], allWorks[4], allWorks[5], allWorks[3]);
                    singerContrller.musicPublication(music , album , singer);
                    System.out.println("music published successfully");
                }
            }

            else
            {
                System.out.println("invalid instruction");
            }
        }
    }
}
