package org.example.prj.exception;

public class FailedLoginException extends RuntimeException{
    public FailedLoginException(){
        super("login faild");
    }
    public FailedLoginException(String msg){
        super(msg);
    }
}
