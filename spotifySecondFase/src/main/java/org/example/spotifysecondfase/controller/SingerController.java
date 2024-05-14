package org.example.spotifysecondfase.controller;

import org.example.spotifysecondfase.model.Album;

public class SingerController extends ArtistController
{
    Album album;
    public Album newAlbums(String name)
    {
        album = newAlbums(name);
        return album;
    }
}
