package org.example.phase2.Model.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.example.phase2.Model.Audios.*;

public class PremiumListener extends Listener{

    private long leftDays=0;
    public PremiumListener(String userName, String password, String firstAndLastName, String emailAddress, String phoneNumber, Date birthDate,PremiumTypes premiumType) throws ParseException {
        super(userName, password, firstAndLastName, emailAddress, phoneNumber, birthDate);
        if(premiumType.equals(PremiumTypes.ONEMONTH))
            this.leftDays=this.leftDays+30;
        if(premiumType.equals(PremiumTypes.TWOMONTHS))
            this.leftDays=this.leftDays+60;
        if(premiumType.equals(PremiumTypes.SIXMONTHS))
            this.leftDays=this.leftDays+180;
        this.setEndOfAccount(LocalDate.now());
        this.setEndOfAccount(this.getEndOfAccount().plusDays(this.leftDays));
    }

    public long getLeftDays() {
        this.leftDays-=1;
        return leftDays;
    }

    public void setLeftDays(long leftDays) {
        this.leftDays = leftDays;
    }
    @Override
    public String toString()
    {
        StringBuilder info=new StringBuilder();
        info.append(super.toString());
        info.append("Left days: "+leftDays+"\n");
        return info.toString();
    }
}
