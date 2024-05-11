package Exceptions;

public class PasswordStrengthException extends Exception{
    public PasswordStrengthException(String msg) { super(msg); }
    public PasswordStrengthException() { super("Password's not strong enough!"); }

}
