package org.example.musicplayer_phase2.view.AboutArtists;

import org.example.musicplayer_phase2.controller.AboutArtist.PodcasterContrller;
import org.example.musicplayer_phase2.model.AboutHumans.Podcaster;
import org.example.musicplayer_phase2.model.AboutMusic.Podcast;
import org.example.musicplayer_phase2.view.Start;

import java.util.Scanner;

public class PodcasterView extends ArtistView {
    Scanner get = new Scanner(System.in);
    public void podcasterInstructions (Podcaster podcaster)
    {
        String works = "";
        boolean finish = true;
        while (finish)
        {
            PodcasterContrller podcasterContrller = new PodcasterContrller();
            works = get.nextLine();
            String[] allWorks = works.split(" - ");
            if (works.equals("logout"))
            {
                finish = false;
                Start.start();
            }

            else if (allWorks[0].equals("accountInfo"))
            {
                System.out.println(podcasterContrller.watchInformation(podcaster));
            }

            else if (allWorks[0].equals("followers") && allWorks.length == 1)
            {
                System.out.println(podcasterContrller.watchFollowers(podcaster));
            }

            else if (allWorks[0].equals("viewsStatistics") && allWorks.length == 1)
            {
                System.out.println(podcasterContrller.watchPlaysNumber(podcaster));
            }

            else if (allWorks[0].equals("calculateEarnings") && allWorks.length == 1)
            {
                System.out.println(podcasterContrller.watchIncome(podcaster));
            }

            else if (allWorks[0].equals("publish") && allWorks.length == 7)
            {
                Podcast podcast = new Podcast(allWorks[1], podcaster.getUsername() , allWorks[6], allWorks[2], allWorks[4],allWorks[5],allWorks[3] );
                podcasterContrller.podcastPublication(podcast , podcaster);
                System.out.println("podcast published successfully");
            }

            else
            {
                System.out.println("invalid instruction");
            }

        }
    }
}
