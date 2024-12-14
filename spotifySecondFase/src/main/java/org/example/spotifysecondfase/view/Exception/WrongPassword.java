package org.example.spotifysecondfase.view.Exception;

public class WrongPassword extends FailedLoginException
{
    public WrongPassword()
    {
        super("Wrong password");
    }

}
