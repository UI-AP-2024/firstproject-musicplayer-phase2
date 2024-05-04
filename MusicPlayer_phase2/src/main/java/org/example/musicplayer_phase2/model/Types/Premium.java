package org.example.musicplayer_phase2.model.Types;

import org.example.musicplayer_phase2.model.*;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;

import java.time.LocalDate;

public class Premium extends Listener {
    public Premium(String name, String username, String password, String email, String number, LocalDate birthday) {
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
