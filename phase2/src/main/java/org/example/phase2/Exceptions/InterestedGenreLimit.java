package org.example.phase2.Exceptions;

public class InterestedGenreLimit extends Exception {
    public InterestedGenreLimit()
    {
        super("You can't choose more than 4 genre.");
    }
}
