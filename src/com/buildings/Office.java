package com.buildings;

/**
 * Created by Арсений on 27.10.2016.
 */
public class Office {

    public Office next;
    private double square;
    private int countOfRooms;
    private static final double C_SQUARE=250;
    private static final int C_ROOMS=1;

    public Office(){

        this.square=C_SQUARE;
        this.countOfRooms=C_ROOMS;
    }

    public Office(double square){

        this.countOfRooms=C_ROOMS;
        this.square=square;
    }

    public Office(int rooms, double square){

        this.countOfRooms=rooms;
        this.square=square;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getCountOfRooms() {
        return countOfRooms;
    }

    public void setCountOfRooms(int countOfRooms) {
        this.countOfRooms = countOfRooms;
    }
}
