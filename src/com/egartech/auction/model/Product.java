package com.egartech.auction.model;

/**
 * Created by Арсений on 20.10.2016.
 */

/**
 * Class product of auction.
 */
public class Product {

    private String name;
    private String category;
    private int productId;
    private boolean isByed;
    private double price;
    private int count;
    private double volume;
    private double mass;
    private AbstractUser sailer;

    /*
     * Constructor with three parameters.
     * @param String name
     * @param String category
     * @param int id
     */
    public Product (String name, String category, int id){

        this.name = name;

        this.category = category;

        this.productId = id;
    }

    /**
     * Returns name of product.
     * @return String name of product.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns category of product.
     * @return String category of product.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set category of product.
     * @param category String category of product.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category+" "+name;
    }

    /**
     *Returns product id.
     * @return int id of product.
     */
    public int getProductId() {
        return productId;
    }

    /**
     *Sets product id.
     * @param productId int id of product.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean equals(Product obj) {
        return (obj.getProductId()==this.productId);
    }

    /**
     *Checks is this product byed or not.
     * @return true if product is byed.
     */
    public boolean isByed() {
        return isByed;
    }

    /**
     *Sets is this product byed or not.
     * @param byed boolean byed this product or not.
     */
    public void setByed(boolean byed) {
        isByed = byed;
    }

    /**
     *Returns byung-price for this product.
     * @return int price of byed product.
     */
    public double getPrice() {
        return price;
    }

    /**
     *Sets byung-price for this product.
     * @param price int price of byed product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *Returns count of products.
     * @return int count of products.
     */
    public int getCount() {
        return count;
    }

    /**
     *Sets count of products.
     * @param count int count of products.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *Returns volume of product.
     * @return double volume of product.
     */
    public double getVolume() {
        return volume;
    }

    /**
     *Sets volume of product.
     * @param volume double volume of product.
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     *Returns mass of product.
     * @return double mass of product.
     */
    public double getMass() {
        return mass;
    }

    /**
     *Sets mass of product.
     * @param mass double mass of product.
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     *Returns sailer of product.
     * @return AbstractUser sailer of product.
     */
    public AbstractUser getSailer() {
        return sailer;
    }

    /**
     *Sets sailer of product.
     * @param sailer AbstractUser sailer of product.
     */
    public void setSailer(AbstractUser sailer) {
        this.sailer = sailer;
    }
}
