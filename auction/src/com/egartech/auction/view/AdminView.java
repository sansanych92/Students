package com.egartech.auction.view;

import com.egartech.auction.controller.AdminColntroller;

/**
 * Created by Арсений on 30.10.2016.
 */

/**
 * Class needed for all admin displays.
 */
public class AdminView {

    /**
     *Prints statistics by all users.
     */
    public void printUsersStatistics(){

        AdminColntroller adminColntroller = new AdminColntroller();

        System.out.println(adminColntroller.getUsersStatistics());
    }
}
