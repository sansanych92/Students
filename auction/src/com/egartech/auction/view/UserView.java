package com.egartech.auction.view;

import com.egartech.auction.controller.UserController;
import com.egartech.auction.model.AbstractUser;


/**
 * Created by Арсений on 30.10.2016.
 */

/**
 * Class needed for all users displays.
 */
public class UserView {


    /**
     *Prints statistics by user.
     * @param localUser User needed user.
     */
    public void printMyOwnStatistics(AbstractUser localUser) {

        UserController userController = new UserController();

        if (userController.getMyOwnStatistics(localUser).isEmpty())
            System.out.println("Отсутствует статистика по пользователю.");
        else
            System.out.println(userController.getMyOwnStatistics(localUser));

    }

}
