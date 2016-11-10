package com.buildings;

/**
 * Created by Арсений on 09.10.2016.
 */
public class Flat {
    private static final double C_SQUARE=50;
    private static final int C_ROOMS=2;


    private double square;
    private int rooms;

    public Flat() {
        square=C_SQUARE;
        rooms=C_ROOMS;
    }

    public Flat(int square) {
        this.square=square;
        rooms=C_ROOMS;
    }

    public Flat(int square, int rooms) {
        this.square=square;
        this.rooms=rooms;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRooms() {
        return rooms;
    }
}
