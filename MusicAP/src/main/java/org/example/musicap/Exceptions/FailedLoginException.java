package org.example.musicap.Exceptions;

public class FailedLoginException extends RuntimeException{
    public FailedLoginException(){
        super("Login failed!");
    }
    public FailedLoginException(String msg){
        super(msg);
    }
}
