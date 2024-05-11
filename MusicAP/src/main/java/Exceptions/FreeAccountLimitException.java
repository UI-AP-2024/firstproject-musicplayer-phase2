package Exceptions;

public class FreeAccountLimitException extends Exception{
    public FreeAccountLimitException (){
        super("Playlist's audio count limit! Upgrade to premium.");
    }
    public FreeAccountLimitException (String msg){
        super(msg);
    }
}
