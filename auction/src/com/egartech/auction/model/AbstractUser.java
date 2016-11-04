package com.egartech.auction.model;

/**
 * Created by Артем Громовержец on 21.10.2016.
 */

public abstract class AbstractUser {

    private int id;
    private String login;
    private String password;
    private String accessRight;
    private int latitude;
    private int longitude;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getAccessRight() {
        return accessRight;
    }

    /**
     *
     * @param accessRight
     */
    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }

    /**
     *
     * @return
     */
    public int getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     */
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     */
    public int getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     */
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
