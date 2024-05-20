package org.example.phase2.Exceptions;

public class FailedLoginException extends Exception{
    public FailedLoginException(String message){
        super(message);
    }
    public FailedLoginException (){
        super("FailedLoginException");
    }
}
