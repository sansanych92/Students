package com.egartech.auction.controller;

import com.egartech.auction.model.*;
import com.egartech.auction.storage.*;
import java.util.*;

/**
 * Created by Артем Громовержец on 21.10.2016.
 */

public class UserController {

    /**
     * returns users statistics.
     * @param user AbstractUser user, which statistics need to get.
     * @return List<Bet> statistics by user.
     */
    public List<Bet> getMyOwnStatistics(AbstractUser user){

        List<Bet> neededInfo=new ArrayList<>();
        for (Bet bet:Storage.getBets()) {
            if (bet.getUser().getId()==(user.getId()))
                neededInfo.add(bet);
        }
        return neededInfo;
    }

    /**
     * returns user by login and password.
     * @param login String userlogin.
     * @param password String userpassword.
     * @return AbstractUser user.
     */
    public AbstractUser getUser(String login, String password){
        AbstractUser newUser = null;

        for (AbstractUser user:Storage.getUserList()) {
            if (Objects.equals(user.getPassword(), password) && Objects.equals(user.getLogin(), login))
               newUser = user;
        }
        return newUser;
    }
}
