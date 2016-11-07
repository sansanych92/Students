package com.egartech.auction.model;

/**
 * Created by Арсений on 20.10.2016.
 */

/**
 * Class of auction guests.
 */
public class Guest extends AbstractUser{

    private int id;

    /**
     *returns id of guest.
     * @return int guest id.
     */
    public int getId() {
        return id;
    }

    /**
     *Sets id of guest.
     * @param id int guests id.
     */
    public void setId(int id) {
        this.id = id;
    }

}
