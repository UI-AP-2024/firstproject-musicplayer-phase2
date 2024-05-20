package org.example.spotifysecondfase.view.Exception;

public class UserNotFound extends FailedLoginException{
    public UserNotFound()
    {
        super("AccountNotFound");
    }

}
