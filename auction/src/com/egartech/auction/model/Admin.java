package com.egartech.auction.model;

/**
 * Created by Арсений on 20.10.2016.
 */

/**
 * Admin-class.
 */
public class Admin extends AbstractUser {

    private String login;
    private String password;
    private int id;
    private int latitude;
    private int longitude;

    /**
     * Returns login of administrator.
     * @return String Login of admin.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set login of administrator.
     * @param login String Login of admin.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns password of administrator.
     * @return String password of admin.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password of administrator.
     * @param password String password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns id of administrator.
     * @return int id of administrator.
     */
    public int getId() {
        return id;
    }

    /**
     * Set id of administrator.
     * @param id int id of administrator.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return id+" "+login+" "+password;
    }
}
