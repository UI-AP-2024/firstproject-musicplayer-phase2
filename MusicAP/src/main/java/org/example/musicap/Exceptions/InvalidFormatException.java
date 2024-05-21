package org.example.musicap.Exceptions;

public class InvalidFormatException extends RuntimeException{
    public InvalidFormatException(String msg){
        super(msg);
    }
    InvalidFormatException(){
        super("Invalid format");
    }
}
