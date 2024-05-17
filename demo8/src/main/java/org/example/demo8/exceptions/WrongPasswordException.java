package org.example.demo8.exceptions;

public class WrongPasswordException extends FailedLoginException
{
    public WrongPasswordException(String message)
    {
        super("wrong password "+message);
    }
    public WrongPasswordException()
    {
        this("");
    }
}
