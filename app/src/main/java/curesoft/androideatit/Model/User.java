package curesoft.androideatit.Model;

/**
 * Created by Prabin kumar mallick on 08-10-2017.
 */

public class User
{
    String name;
    String password;

    public User()
    {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
