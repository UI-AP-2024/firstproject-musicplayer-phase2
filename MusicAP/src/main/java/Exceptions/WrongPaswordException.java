package Exceptions;

public class WrongPaswordException extends FailedLoginException{
    public WrongPaswordException (String msg){
        super(msg);
    }
    public WrongPaswordException (){
        super("Wrong password!");
    }
}
