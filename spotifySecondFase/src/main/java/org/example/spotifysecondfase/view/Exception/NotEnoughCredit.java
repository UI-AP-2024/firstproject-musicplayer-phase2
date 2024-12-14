package org.example.spotifysecondfase.view.Exception;

public class NotEnoughCredit extends Exception
{
    public NotEnoughCredit(String massage)
    {
        super("Not enough credit");
    }
}
