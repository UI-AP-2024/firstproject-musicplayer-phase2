package org.example.phase2.Exceptions;

public class WrongPasswordException extends FailedLoginException{
    public WrongPasswordException(){
        super("WrongPasswordException");
    }
}
