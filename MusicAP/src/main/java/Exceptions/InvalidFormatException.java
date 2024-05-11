package Exceptions;

public class InvalidFormatException extends RuntimeException{
    InvalidFormatException(String msg){
        super(msg);
    }
    InvalidFormatException(){
        super("Invalid format");
    }
}
