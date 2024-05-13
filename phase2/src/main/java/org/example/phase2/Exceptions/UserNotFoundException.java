package org.example.phase2.Exceptions;

public class UserNotFoundException extends FailedLoginException{
    public UserNotFoundException(){
        super("UserNotFoundException");
    }
}
