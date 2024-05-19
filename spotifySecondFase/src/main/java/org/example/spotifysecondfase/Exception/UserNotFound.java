package org.example.spotifysecondfase.Exception;

public class UserNotFound extends FailedLoginException{
    public UserNotFound()
    {
        super("AccountNotFound");
    }

}
