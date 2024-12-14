package org.example.prj.exception;

public class InvalidFormatException extends RuntimeException{
    public InvalidFormatException(String msg){
        super(msg);
    }
    public InvalidFormatException(){
        super("wrong format for phone number or email");
    }
}
