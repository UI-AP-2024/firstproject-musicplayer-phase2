package view;

import controller.AboutLIstener.ListenerController;
import model.AboutHumans.UserAccount;

import java.util.Scanner;

public class UserView {
    public void checking (String number , String password , String email , String username , String birthday , UserAccount user)
    {
        Scanner get = new Scanner(System.in);
        ListenerController listenerController = new ListenerController();

        while (!listenerController.checkNumber(number))
        {
            System.out.println("your number is not valid please enter a valid number. ");
            number = get.nextLine();
            user.setNumber(number);
        }
        while (!listenerController.checkPassword(password))
        {
            System.out.println("your password is easy make a password with (@,#,!,....) and characters and at list 8 letter. ");
            password = get.nextLine();
            user.setPassword(password);
        }
        while (!listenerController.checkEmail(email))
        {
            System.out.println("Your email is not valid enter a valid email. ");
            email = get.nextLine();
            user.setEmail(email);
        }
        while (!listenerController.checkUsername(username))
        {
            System.out.println("your username is repeated please choose another one. ");
            username = get.nextLine();
            user.setUsername(username);
        }
        while (!listenerController.checkBirthday(birthday))
        {
            System.out.println("birthday format is incorrect enter your birthday whit dd/MM/YYYY format. ");
            birthday = get.nextLine();
            user.setBirthday(birthday);
        }
    }
}
