package org.example.musicplayer_phase2.model.Exceptions;

public class InvalidFormat extends Exception{
    public InvalidFormat (){
        super("invalid format");
    }

    public InvalidFormat (String message){
        super(message);
    }
}
