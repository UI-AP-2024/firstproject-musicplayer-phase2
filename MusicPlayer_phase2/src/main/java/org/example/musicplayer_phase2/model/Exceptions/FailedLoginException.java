package org.example.musicplayer_phase2.model.Exceptions;

public class FailedLoginException extends Exception{
    public FailedLoginException() {
        super("failed login");
    }

    public FailedLoginException(String message) {
        super(message);
    }
}
