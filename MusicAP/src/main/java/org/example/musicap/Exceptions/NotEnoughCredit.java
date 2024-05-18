package org.example.musicap.Exceptions;

public class NotEnoughCredit extends RuntimeException{
    public NotEnoughCredit(String msg){
        super(msg);
    }
    public NotEnoughCredit(){
        super("Not enough credit in your account!");
    }
}
