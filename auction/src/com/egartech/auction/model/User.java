package com.egartech.auction.model;

/**
 * Created by Арсений on 20.10.2016.
 */

/**
 * User-class. Extends AbstractUser.
 */
public class User extends AbstractUser{

    private String login;
    private String password;
    private int id;
    private int latitude;
    private int longitude;

    /**
     * Set users login.
     * @param name String name of user.
     */
    public void setLogin(String name){
        this.login = name;
    }

    /**
     * Returns users login.
     * @return String users login.
     */
    public String getLogin(){
        return login;
    }

    /**
     * Returns users password.
     * @return String password of user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set users password.
     * @param password String password of user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns id of user.
     * @return int id of user.
     */
    public int getId() {
        return id;
    }

    /**
     * Set id of user.
     * @param id int id of user.
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id+" "+login+" "+password;
    }

}
