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
     * Constructor with two parameters.
     * @param name
     * @param category
     */
    public Product (String name, String category, int id){

        this.name = name;

        this.category = category;

        this.productId = id;
    }

    /**
     * Returns name of product.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns category of product.
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set category of product.
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return category+" "+name;
    }

    /**
     *
     * @return
     */
    public int getProductId() {
        return productId;
    }

    /**
     *
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     *
     * @param obj
     * @return
     */
    public boolean equals(Product obj) {
        return (obj.getProductId()==this.productId);
    }

    /**
     *
     * @return
     */
    public boolean isByed() {
        return isByed;
    }

    /**
     *
     * @param byed
     */
    public void setByed(boolean byed) {
        isByed = byed;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @return
     */
    public double getVolume() {
        return volume;
    }

    /**
     *
     * @param volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     *
     * @return
     */
    public double getMass() {
        return mass;
    }

    /**
     *
     * @param mass
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     *
     * @return
     */
    public AbstractUser getSailer() {
        return sailer;
    }

    /**
     *
     * @param sailer
     */
    public void setSailer(AbstractUser sailer) {
        this.sailer = sailer;
    }
}
