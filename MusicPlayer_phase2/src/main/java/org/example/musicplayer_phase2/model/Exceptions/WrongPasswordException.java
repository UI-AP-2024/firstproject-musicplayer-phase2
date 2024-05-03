package org.example.musicplayer_phase2.model.Exceptions;

public class WrongPasswordException extends FailedLoginException{
    public WrongPasswordException() {
        super ("password is incorrect");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
