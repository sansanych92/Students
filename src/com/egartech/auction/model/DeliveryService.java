package com.egartech.auction.model;


/**
 * Created by Арсений on 31.10.2016.
 */
public class DeliveryService {

    private String name;
    private double volcoeff;
    private double masscoeff;
    private double distanceCoeff;
    private int radiusOfEarth = 6371000;

    /**
     *
     * @param volcoeff
     * @param masscoeff
     * @param name
     * @param distanceCoeff
     */
    public DeliveryService(double volcoeff, double masscoeff, String name, double distanceCoeff){

        this.volcoeff = volcoeff;
        this.masscoeff = masscoeff;
        this.distanceCoeff = distanceCoeff;
        this.name = name;

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public double getVolcoeff() {
        return volcoeff;
    }

    /**
     *
     * @return
     */
    public double getMasscoeff() {
        return masscoeff;
    }

    /**
     *
     * @return
     */
    public double getDistanceCoeff() {
        return distanceCoeff;
    }
}
