package org.example.musicap.Controllers;

import org.example.musicap.Models.Data.Database;
import Views.AccountView;

public abstract class UserController {

    public void logout()
    {
        Database.getInstance().setLogedInUser(null);
    }
    public String accountInfo()
    {
        return Database.getInstance().getLogedInUser().toString();
    }
}
