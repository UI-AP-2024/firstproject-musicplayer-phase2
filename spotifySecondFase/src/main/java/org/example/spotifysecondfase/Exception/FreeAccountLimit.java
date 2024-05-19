package org.example.spotifysecondfase.Exception;

public class FreeAccountLimit extends Exception{
    public FreeAccountLimit(String massage)
    {
        super("Free account limit");
    }
}
