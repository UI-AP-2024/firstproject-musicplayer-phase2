package model.Types;

import model.AboutHumans.Listener;

public class Premium extends Listener {
    public Premium(String name, String username, String password, String email, String number, String birthday) {
        super(name, username, password, email, number, birthday);
    }

    private int remainDays;

    public int getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(int remainDays) {
        this.remainDays = remainDays;
    }

    @Override
    public String toString()
    {
        return "remain days: " + remainDays + "\n";
    }
}
