package com.egartech.auction.model;

/**
 * Created by Артем Громовержец on 21.10.2016.
 */

/**
 * Class Bets in auction.
 */
public class Bet {

    private int productId;
    private int money;
    private AbstractUser user;

    /**
     *No-parameters constructor.
     * @param productId id of product for bet.
     * @param money money for bet.
     * @param user user, whom belongs this bet.
     */
    public Bet(int productId, int money, AbstractUser user){
        this.productId=productId;
        this.money=money;
        this.user=user;
    }

    /**
     *Returns id of product, for bet.
     * @return int product id.
     */
    public int getProductId() {
        return productId;
    }

    /**
     *Sets id of product, for bet.
     * @param productId int id of product.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     *Returns money, for bet.
     * @return int money.
     */
    public int getBet() {
        return money;
    }

    /**
     *Sets money for bet.
     * @param money int money for bet.
     */
    public void setBet(int money) {
        this.money = money;
    }

    /**
     *Returns user.
     * @return AbstractUser user.
     */
    public AbstractUser getUser() {
        return user;
    }

    /**
     *Sets user.
     * @param user AbstractUser user.
     */
    public void setUser(AbstractUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return user+" "+productId+" "+money;
    }
}
