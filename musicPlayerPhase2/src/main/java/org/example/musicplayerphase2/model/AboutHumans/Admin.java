package org.example.musicplayer_phase2.model.AboutHumans;

public class Admin extends UserAccount {
    private static Admin admin;

    private Admin(String name, String username, String password, String email, String number, String birthday) {
        super(name, username, password, email, number, birthday);
    }

    public static Admin getAdmin(String name,String username ,String password, String email, String number, String birthday)
    {
        if (admin == null)
            admin = new Admin(name,username ,password, email, number, birthday);
        return admin;
    }
    public static Admin getAdmin()
    {
        return admin;
    }
    @Override
    public String toString()
    {
        return "name: " + admin.getName() + "\nemail: " + admin.getEmail() + "\n";
    }
}
