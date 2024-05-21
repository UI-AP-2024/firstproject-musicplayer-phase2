package org.example.prj.exception;

public class FailedLoginException extends Exception{
    public FailedLoginException(){
        super("login faild");
    }
    public FailedLoginException(String msg){
        super(msg);
    }
}
