package org.example.musicplayer_phase2.model.Exceptions;

public class UserNotFoundException extends FailedLoginException{
    public UserNotFoundException() {
        super("username not found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
