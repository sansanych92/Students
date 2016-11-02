package com.egartech.auction.storage;

import com.egartech.auction.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем Громовержец on 21.10.2016.
 */
public class Storage {
    public static List <Product> products;
    public static List <Bet> bets;
    public static List <AbstractUser> users;
    public static List <DeliveryService> servises;

    public Storage(){

        products = new ArrayList<>();

        Product product1 = new Product("Kia Sportage","cars",11);
        Product product2 = new Product("Range rover","cars",12);
        Product product3 = new Product("Realty","house",13);
        Product product4 = new Product("Realty","office",14);
        Product product5 = new Product("Wear","jacket",15);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        users=new ArrayList<>();

        Admin admin = new Admin();
        admin.setId(1);
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setAccessRight("admin");

        users.add(admin);

        User user = new User();

        user.setId(2);
        user.setLogin("user");
        user.setPassword("user");
        user.setAccessRight("user");

        users.add(user);

        Guest guest = new Guest();
        guest.setId(3);
        guest.setAccessRight("guest");

        users.add(guest);

        bets = new ArrayList<>();
        Bet bet = new Bet(12,100,getUserList().get(0));
        bets.add(bet);

        servises=new ArrayList<>();

        DeliveryService service=new DeliveryService(1,2,"pec",3);

        servises.add(service);
    }

    /**
     *
     * @return
     */
    public static List<AbstractUser> getUserList(){
        return users;
    }

    /**
     *
     * @return
     */
    public static List<Bet> getBets() {
        return bets;
    }

    /**
     *
     * @return
     */
    public static List<Product> getProducts(){
        return products;
    }

    /**
     *
     * @return
     */
    public static List<DeliveryService> getServices(){
        return servises;
    }

}

