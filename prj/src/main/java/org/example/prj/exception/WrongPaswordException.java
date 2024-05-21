package org.example.prj.exception;

public class WrongPaswordException extends FailedLoginException{
    public WrongPaswordException (String msg){
        super(msg);
    }
    public WrongPaswordException (){
        super("wrong password !!");
    }
}
