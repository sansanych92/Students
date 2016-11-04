package com.egartech.auction.view;

import com.egartech.auction.controller.ProductController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Арсений on 30.10.2016.
 */
public class ProductView {

    private ProductController productController = new ProductController();
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @throws IOException
     */
    public void printLotsByCategory() throws IOException {

        System.out.println("Введите название категории.");
        String category = in.readLine();

        if (productController.getLotsByCategory(category).isEmpty())
            System.out.println("Товаров в данной категории нет.");
        else
            System.out.println(productController.getLotsByCategory(category));
    }
}
