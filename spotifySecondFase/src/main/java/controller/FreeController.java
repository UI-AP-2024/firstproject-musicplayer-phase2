package controller;

import model.UserAccount.Listener.Free;
import model.UserAccount.Listener.Listener;

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
