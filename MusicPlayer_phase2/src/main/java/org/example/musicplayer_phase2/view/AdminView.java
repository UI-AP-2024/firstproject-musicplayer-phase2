package org.example.musicplayer_phase2.view;

import org.example.musicplayer_phase2.controller.AdminController;

import java.util.Scanner;

public class AdminView {
    Scanner get = new Scanner(System.in);
    AdminController adminController = new AdminController();
    public void login (String username , String password)
    {
        System.out.println(AdminController.login(username , password));
        if (!(AdminController.login(username, password).equals("welcome :)")))
            Start.start();
        else
        {
            adminInstructions();
        }
    }

    public void adminInstructions() {
        String works = "";

        boolean finish = true;
        while (finish) {
            works = get.nextLine();
            String[] allWorks = works.split(" - ");

            if (works.equals("logout"))
            {
                finish = false;
                Start.start();
            }

            else if (allWorks[0].equals("accountInfo") && allWorks.length == 1)
            {
                System.out.println(adminController.watchAccountInformation());
            }

            else if (allWorks[0].equals("statistics") && allWorks.length == 1)
            {
                System.out.println(adminController.watchFavoriteAudios());
            }

            else if (allWorks[0].equals("audios") && allWorks.length == 1)
            {
                System.out.println(adminController.watchAllAudiosInformation());
            }

            else if (allWorks[0].equals("audio") && allWorks.length == 2)
            {
                System.out.println(adminController.audioInformation(Integer.parseInt(allWorks[1])));
            }

            else if (allWorks[0].equals("artists") && allWorks.length == 1)
            {
                System.out.println(adminController.watchAllArtistInformation());
            }

            else if (allWorks[0].equals("artist") && allWorks.length == 2)
            {
                System.out.println(adminController.artistInformation(allWorks[1]));
            }

            else if (allWorks[0].equals("reports") && allWorks.length == 1)
            {
                System.out.println(adminController.watchReports());
            }

            else
            {
                System.out.println("invalid instruction");
            }
        }
    }
}
