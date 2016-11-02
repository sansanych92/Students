package com.egartech.auction.model;

/**
 * Created by Арсений on 20.10.2016.
 */

//view->model
//controller->model
//view->controller
//controller->storage
//storage->model

/**
 * Class-parent for authorizated users.
 */
public class Guest extends AbstractUser{

    private int id;

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

}
