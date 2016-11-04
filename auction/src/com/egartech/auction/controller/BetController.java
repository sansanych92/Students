package com.egartech.auction.controller;

import com.egartech.auction.model.*;
import com.egartech.auction.storage.Storage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем Громовержец on 23.10.2016.
 */
public class BetController {

    /**
     * returns list of bets by productid.
     * @param productId int id of product.
     * @return List<Bet> list of bets by productid.
     */
    public List<Bet> getBetsByLot(int productId) {

        List<Bet> betsNeeded = new ArrayList<>();

        for (Bet bet: Storage.getBets()) {

            if (bet.getProductId() == (productId))
                betsNeeded.add(bet);
        }

        return betsNeeded;
    }

    /**
     * adds bet to the list of bets.
     * @param productId int id of product.
     * @param user user whom need to add bet.
     * @param money value of bet.
     */
    public void addBet(int productId, AbstractUser user, int money){

        Bet newBet = new Bet(productId, money, user);

        Storage.getBets().add(newBet);
    }
}
