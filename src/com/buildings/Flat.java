package com.buildings;


public class Flat {
    private static final int C_SQUARE=50;
    private static final int C_ROOMS=2;

    private int square;
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

    public int getSquare() {
        return square;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRooms() {
        return rooms;
    }

    public static void info(Flat flat){
        System.out.println("square: "+flat.square+" "+"rooms: "+flat.rooms);
    }
}
