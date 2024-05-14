package org.example.spotifysecondfase.controller;

import org.example.spotifysecondfase.model.UserAccount.Listener.Free;
import org.example.spotifysecondfase.model.UserAccount.Listener.Listener;

public abstract class FreeController extends ListenerController
{
    Listener listener;
    @Override
    public void buyOrRenew(int money)
    {
        listener.setAccountCredit(listener.getAccountCredit() + money);
//        listener.setListenerType("Premium");

    }
}
