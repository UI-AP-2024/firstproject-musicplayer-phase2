package org.example.musicap.Exceptions;

public class NotFoundExeption extends Exception{
    public NotFoundExeption(String msg) { super(msg); }
    public NotFoundExeption(){
        super("Not found!");
    }
}
