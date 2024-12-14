package org.example.spotifysecondfase.view.Exception;

public class FreeAccountLimit extends Exception{
    public FreeAccountLimit(String massage)
    {
        super("Free account limit");
    }
}
