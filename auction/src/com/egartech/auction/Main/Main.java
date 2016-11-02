package com.egartech.auction.Main;

import com.egartech.auction.storage.Storage;
import com.egartech.auction.view.View;
import java.io.IOException;

/**
 * Created by Артем Громовержец on 21.10.2016.
 */

/**
 * Main-class.
 */
public class Main {
    /**
     * Main-method.
     * @param args
     */
    public static void main(String[] args) throws IOException {

        Storage storage = new Storage();

        View view = new View();

        view.mainMenu();
    }
}