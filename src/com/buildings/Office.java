package com.buildings;


public class Office {
    private static final int C_SQUARE=250;
    private static final int C_ROOMS=1;

    private int square;
    private int rooms;

    public Office() {
        square=C_SQUARE;
        rooms=C_ROOMS;
    }

    public Office(int square) {
        this.square=square;
        rooms=C_ROOMS;
    }

    public Office(int square, int rooms) {
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

}
