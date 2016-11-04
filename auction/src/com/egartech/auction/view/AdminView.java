package com.egartech.auction.view;

import com.egartech.auction.controller.AdminColntroller;

/**
 * Created by Арсений on 30.10.2016.
 */
public class AdminView {

    /**
     *
     */
    public void printUsersStatistics(){

        AdminColntroller adminColntroller = new AdminColntroller();

        System.out.println(adminColntroller.getUsersStatistics());
    }
}
