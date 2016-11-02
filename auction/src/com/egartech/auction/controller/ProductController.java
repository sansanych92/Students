package com.egartech.auction.controller;

import com.egartech.auction.model.Product;
import com.egartech.auction.storage.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Артем Громовержец on 21.10.2016.
 */
public class ProductController {

    /**
     * returns all lots by needed category.
     * @param category String category of product.
     * @return list of needed products.
     */
    public List<Product> getLotsByCategory(String category){

        List<Product> productsNeeded = new ArrayList<>();

        for (Product product:Storage.getProducts()) {

            if (Objects.equals(product.getCategory(), category))
                productsNeeded.add(product);
        }

        return productsNeeded;
    }

    /**
     *
     * @param id
     * @return
     */
    public Product getProductById(int id){

        Product product=null;

        for (Product product1: Storage.getProducts()) {

            if (product1.getProductId() == id)

                product = product1;
        }

        return product;
    }
}
