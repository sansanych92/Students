package com.egartech.auction.view;

import com.egartech.auction.controller.UserController;


/**
 * Created by Арсений on 30.10.2016.
 */
public class UserView {


    /**
     *
     * @param login
     * @param password
     */
    public void printMyOwnStatistics(String login, String password) {

        UserController userController = new UserController();

        if (userController.getMyOwnStatistics(userController.getUser(login, password)).isEmpty())
            System.out.println("Отсутствует статистика по пользователю.");
        else
            System.out.println(userController.getMyOwnStatistics(userController.getUser(login, password)));

    }

}
