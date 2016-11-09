package com.egartech.auction.view;

import com.egartech.auction.controller.BetController;
import com.egartech.auction.controller.ProductController;
import com.egartech.auction.controller.UserController;
import com.egartech.auction.model.AbstractUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Арсений on 30.10.2016.
 */

/**
 * Class needed for all bets displays.
 */
public class BetsView {

    private BetController betController = new BetController();
    private ProductController productController = new ProductController();
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /**
     *Prints bets by lot.
     * @throws IOException
     */
    public void printBetsByLot() throws IOException {

        String responce;

        System.out.println("Введите id товара.");
        int productid=Integer.parseInt(in.readLine());

        if (productController.checkProductForExistance(productid)){

            if (betController.getBetsByLot(productid).isEmpty())
                responce = "Ставок по данному лоту нет.";
            else
                responce = betController.getBetsByLot(productid).toString();
        }

        else
            responce = "Несуществующий лот.";

        System.out.println(responce);


    }

    /**
     *Prints menu of adding bet.
     * @param localUser AbstractUser user for whom needs to add bet.
     * @throws IOException
     */
    public void printAddBetMenu(AbstractUser localUser) throws IOException {

        System.out.println("Введите id продукта и ставку через пробел.");

        String[] idAndMoney = in.readLine().split(" ");

        betController.addBet(Integer.parseInt(idAndMoney[0]), localUser, Integer.parseInt(idAndMoney[1]));

        System.out.println("Ставка добавлена.");
    }

}
