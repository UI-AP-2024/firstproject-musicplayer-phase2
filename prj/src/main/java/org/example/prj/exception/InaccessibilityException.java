package org.example.prj.exception;

public class InaccessibilityException extends RuntimeException{
    public InaccessibilityException() {
        super("Inaccessibility");
    }

    public InaccessibilityException(String message) {
        super(message);
    }
}
