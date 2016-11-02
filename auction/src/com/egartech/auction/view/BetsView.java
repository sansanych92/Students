package com.egartech.auction.view;

import com.egartech.auction.controller.BetController;
import com.egartech.auction.controller.UserController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Арсений on 30.10.2016.
 */
public class BetsView {

    private BetController betController = new BetController();
    private UserController userController = new UserController();
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @throws IOException
     */
    public void printBetsByLot() throws IOException {

        System.out.println("Введите id товара.");
        int productid=Integer.parseInt(in.readLine());

        if (betController.getBetsByLot(productid).isEmpty())
            System.out.println("Ставок по данному лоту нет.");
        else
            System.out.println(betController.getBetsByLot(productid));
    }

    /**
     *
     * @param loginPass
     * @throws IOException
     */
    public void printAddBetMenu(String [] loginPass) throws IOException {

        System.out.println("Введите id продукта и ставку через пробел.");
        String[] idAndMoney=in.readLine().split(" ");
        betController.addBet(Integer.parseInt(idAndMoney[0]),userController.getUser(loginPass[0],loginPass[1]),Integer.parseInt(idAndMoney[1]));
        System.out.println("Ставка добавлена.");
    }

}
