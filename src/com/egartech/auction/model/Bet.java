package com.egartech.auction.model;

/**
 * Created by Артем Громовержец on 21.10.2016.
 */
public class Bet {

    private int productId;
    private int money;
    private AbstractUser user;

    /**
     *
     * @param productId
     * @param money
     * @param user
     */
    public Bet(int productId, int money, AbstractUser user){
        this.productId=productId;
        this.money=money;
        this.user=user;
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
     * @return
     */
    public int getBet() {
        return money;
    }

    /**
     *
     * @param money
     */
    public void setBet(int money) {
        this.money = money;
    }

    /**
     *
     * @return
     */
    public AbstractUser getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(AbstractUser user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return user+" "+productId+" "+money;
    }
}
