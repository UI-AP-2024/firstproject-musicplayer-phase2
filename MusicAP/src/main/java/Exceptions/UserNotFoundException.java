package Exceptions;

public class UserNotFoundException extends FailedLoginException{
    public UserNotFoundException(String msg){
        super(msg);
    }
    public UserNotFoundException(){
        super("User not found!");
    }
}
