package org.example.spotifysecondfase.Exception;

public class WrongPassword extends FailedLoginException
{
    public WrongPassword()
    {
        super("Wrong password");
    }

}
