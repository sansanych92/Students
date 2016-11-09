package com.egartech.auction.view;

import com.egartech.auction.controller.ProductController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Арсений on 30.10.2016.
 */

/**
 * Class needed for all products displays.
 */
public class ProductView {

    private ProductController productController = new ProductController();
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /**
     *Prints all products by category.
     * @throws IOException
     */
    public void printLotsByCategory() throws IOException {

        String responce;

        System.out.println("Введите название категории.");
        String category = in.readLine();

        if (productController.checkProductCategoryForExistance(category)) {

            if (productController.getLotsByCategory(category).isEmpty())
                responce = "Товаров в данной категории нет.";
            else
                responce = productController.getLotsByCategory(category).toString();
        }

        else responce="Несуществующая категория.";

        System.out.println(responce);
    }
}
