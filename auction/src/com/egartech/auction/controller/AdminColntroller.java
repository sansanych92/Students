package com.egartech.auction.controller;

import com.egartech.auction.model.*;
import com.egartech.auction.storage.*;
import java.util.*;

/**
 * Created by Артем Громовержец on 21.10.2016.
 */

/**
 * class controller of Admin-midel.
 */
public class AdminColntroller {

    /**
     * returns statistics by allusers.
     * @return list of bets of all users.
     */
    public List<Bet> getUsersStatistics () {

        return Storage.getBets();
    }
}
