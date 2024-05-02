package org.example.musicplayer_phase2.view;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Admin;
import org.example.musicplayer_phase2.view.AboutArtists.ArtistView;
import org.example.musicplayer_phase2.view.AboutListener.ListenerView;

import java.util.Scanner;

public class Start {
    public static Admin admin = Admin.getAdmin("Fatemeh" , "FtmFahim" , "@fatemeh18" , "fatemefahimpoour1399@gmail.com" , "09131111111" , "06/09/2005");

    static Scanner get = new Scanner(System.in);
    public static void start ()
    {
        System.out.println("pleas enter:\nname - username - password - email - number - birthday - " +
                "biography(if you are artist): to signup\nusername - password: to login");
        String enter = get.nextLine();
        String[] instructions = enter.split(" - ");
        if (instructions[0].equals("login"))
        {
            if (instructions.length < 4)
            {
                System.out.println("arguments aren't enough");
                start();
            }
            else if (instructions[1].equals("admin"))
            {
                AdminView adminView = new AdminView();
                adminView.login(instructions[2] , instructions[3]);
            }
            else if (instructions[1].equals("artist"))
            {
                ArtistView artistView = new ArtistView();
                artistView.login(instructions[2] , instructions[3]);
            }
            else if (instructions[1].equals("listener"))
            {
                ListenerView listenerView = new ListenerView();
                listenerView.login(instructions[2] , instructions[3]);
            }
            else
            {
                System.out.println("invalid instruction ");
                start();
            }
        }

        else if (instructions[0].equals("signup"))
        {
            if (instructions[1].equals("listener")) {
                if (instructions.length < 8) {
                    System.out.println("arguments aren't enough");
                    start();
                }
                else {
                    ListenerView listenerView = new ListenerView();
                    listenerView.signup(instructions[2] , instructions[3] , instructions[4] , instructions[5] , instructions[6] ,instructions[7]);
                }
            }
            else if (instructions[1].equals("podcaster")) {
                if (instructions.length < 9) {
                    System.out.println("arguments aren't enough");
                    start();
                }
                else {
                    ArtistView artistView = new ArtistView();
                    artistView.signupPodcaster(instructions[2] , instructions[3] , instructions[4] , instructions[5] , instructions[6] ,instructions[7] , instructions[8]);
                }
            }
            else if (instructions[1].equals("singer")) {
                if (instructions.length < 9) {
                    System.out.println("arguments aren't enough");
                    start();
                }
                else {
                    ArtistView artistView = new ArtistView();
                    artistView.signupSinger(instructions[2] , instructions[3] , instructions[4] , instructions[5] , instructions[6] ,instructions[7] , instructions[8]);
                }
            }
            else {
                System.out.println("invalid instruction are you a listener , singer or podcaster? ");
                start();;
            }
        }

        else if (instructions[0].equals("exit"))
        {
            System.exit(0);
        }

        else
        {
            System.out.println("invalid instruction: you have to login or signup.");
            start();
        }
    }
}

