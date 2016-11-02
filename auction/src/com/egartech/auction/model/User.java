package com.egartech.auction.model;

/**
 * Created by Арсений on 20.10.2016.
 */

public class User extends AbstractUser{

    private String login;
    private String password;
    private int id;
    private int latitude;
    private int longitude;

    /**
     * Set users login.
     * @param name
     */
    public void setLogin(String name){
        this.login = name;
    }

    /**
     * Returns users login.
     * @return
     */
    public String getLogin(){
        return login;
    }

    /**
     * Returns users password.
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set users password.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id+" "+login+" "+password;
    }

}
