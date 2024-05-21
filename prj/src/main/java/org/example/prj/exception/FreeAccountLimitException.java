package org.example.prj.exception;

public class FreeAccountLimitException extends RuntimeException{
    public FreeAccountLimitException (){
        super("play list limit error . buy premium");
    }
    public FreeAccountLimitException (String msg){
        super(msg);
    }
}
