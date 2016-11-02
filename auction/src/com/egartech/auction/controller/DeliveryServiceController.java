package com.egartech.auction.controller;

import com.egartech.auction.model.AbstractUser;
import com.egartech.auction.model.*;
import com.egartech.auction.storage.Storage;

import java.util.Objects;

/**
 * Created by Арсений on 31.10.2016.
 */
public class DeliveryServiceController {

    /**
     *
     * @param latitude1
     * @param longitude1
     * @param latitude2
     * @param longitude2
     * @return
     */
    public double getDistance(int latitude1, int longitude1, int latitude2, int longitude2){

        double distance = Math.acos(Math.sin(latitude1)*Math.sin(latitude2)+
                (Math.cos(latitude1)*Math.cos(latitude2))*Math.abs(longitude1-longitude2))*6371000;

        return distance;

    }

    /**
     *
     * @param product
     * @param user1
     * @param service
     * @return
     */
    public double getCostOfDelivery(Product product, AbstractUser user1, DeliveryService service){

        double costOfDelivery = 0;

        if (product.isByed()){

            costOfDelivery = service.getDistanceCoeff()*getDistance(user1.getLatitude(),user1.getLongitude(),
                    product.getSailer().getLatitude(),product.getSailer().getLongitude())+
                    product.getVolume()*service.getVolcoeff()+product.getMass()*service.getMasscoeff();
        }

        return costOfDelivery;
    }

    /**
     *
     * @param product
     * @param user1
     * @param service
     * @return
     */
    public double getSummaryPriceForDelivery(Product product, AbstractUser user1, DeliveryService service){

        double summaryPriceForDelivery = 0;

        summaryPriceForDelivery = getCostOfDelivery(product, user1, service)+product.getCount()*product.getPrice();

        return summaryPriceForDelivery;
    }

    public DeliveryService getDeliveryServiceByName(String name){

        DeliveryService service = null;

        for (DeliveryService serv: Storage.getServices()) {

            if (Objects.equals(serv.getName(), name))
                service=serv;
        }

        return service;
    }
}
