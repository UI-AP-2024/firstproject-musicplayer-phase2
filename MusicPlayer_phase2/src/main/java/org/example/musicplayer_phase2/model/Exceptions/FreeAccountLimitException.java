package org.example.musicplayer_phase2.model.Exceptions;

public class FreeAccountLimitException extends Exception{
    public FreeAccountLimitException() {
        super("free account limit");
    }

    public FreeAccountLimitException(String message) {
        super(message);
    }
}
