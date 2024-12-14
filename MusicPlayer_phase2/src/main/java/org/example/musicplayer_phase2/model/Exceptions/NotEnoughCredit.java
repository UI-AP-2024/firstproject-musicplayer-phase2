package org.example.musicplayer_phase2.model.Exceptions;

import java.util.concurrent.ExecutionException;

public class NotEnoughCredit extends Exception {
    public NotEnoughCredit() {
        super("your credit is not enough :(");
    }

    public NotEnoughCredit(String message) {
        super(message);
    }
}
