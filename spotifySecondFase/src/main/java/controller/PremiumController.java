package controller;
import model.UserAccount.Listener.Listener;

public abstract class PremiumController extends ListenerController
{
    Listener listener;
    @Override
    public void buyOrRenew(int money)
    {
        listener.setAccountCredit(listener.getAccountCredit() + money);
    }
}
