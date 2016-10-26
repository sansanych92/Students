package com.buildings;

import java.util.ArrayList;

/**
 * Created by Арсений on 19.10.2016.
 */
public class Dwelling {
    private DwellingFloor [] dwellingFloors;
    private int countOfFloors;

    public Dwelling(int countOfFloors, int [] flats){
        this.countOfFloors=countOfFloors;

        dwellingFloors=new DwellingFloor[flats.length];

        for (int i = 0; i <flats.length; i++) {
            dwellingFloors[i]=new DwellingFloor(flats[i]);

        }
    }

    public Dwelling(DwellingFloor [] dwellingFloors){
        this.dwellingFloors=dwellingFloors;
        countOfFloors=dwellingFloors.length;
    }

    public int getCountOfFloors(){
        return countOfFloors;
    }

    public int getCountOfFlats(){
        int countOfFlats=0;

        for (int i = 0; i <dwellingFloors.length ; i++) {
            countOfFlats+=dwellingFloors[i].getCountOfFlats();

        }

        return countOfFlats;
    }

    public int getSquare(){

        int square=0;

        for (int i = 0; i <dwellingFloors.length ; i++) {
            square+=dwellingFloors[i].getFlatsSquare();

        }

        return square;
    }

    public int getRooms(){

        int countOfRooms=0;

        for (int i = 0; i <dwellingFloors.length ; i++) {
            countOfRooms+=dwellingFloors[i].getFlatsRooms();

        }

        return countOfRooms;
    }

    public DwellingFloor [] getDwellingFloors(){
        return dwellingFloors;

    }

    public DwellingFloor getDfellingFloor(int number){
        return dwellingFloors[number];

    }

    public void editDwellingFloor(int number, DwellingFloor dwellingfloor){
        dwellingFloors[number]=dwellingfloor;

    }

    public Flat getFlat(int number){
        int count=0;
        Flat flat=null;

        for (int i = 0; i <dwellingFloors.length; i++) {
            for (int j = 0; j <dwellingFloors[i].getFlats().length; j++) {
                if (count==number){
                    flat=dwellingFloors[i].getFlats()[j];

                }

                count++;
            }
        }
        return flat;
    }

    public void editFlat(int number, Flat flat){
        int count=0;

        for (int i = 0; i <dwellingFloors.length; i++) {
            for (int j = 0; j <dwellingFloors[i].getFlats().length; j++) {
                if (count==number){
                    dwellingFloors[i].getFlats()[j]=flat;

                }

                count++;
            }
        }

    }

    public void addNewFlat(int number, Flat flat) {
        int count=0;
        int floor=0;
        int numberOnFloor=0;

        if (number<=getCountOfFlats()+1) {
            for (int i = 0; i <dwellingFloors.length; i++) {
                for (int j = 0; j <dwellingFloors[i].getFlats().length; j++) {
                    count++;
                    if (count<=number) {
                        floor=i;
                        numberOnFloor=j;
                    }
                }
            }

            dwellingFloors[floor].addNewFlat(numberOnFloor,flat);
        }
    }

    public void deleteFlat(int number){

        int count=0;

        for (int i = 0; i <dwellingFloors.length; i++) {
            for (int j = 0; j <dwellingFloors[i].getFlats().length; j++) {
                if (count==number){
                    dwellingFloors[i].deleteFlat(j);

                }

                count++;
            }
        }

    }

    public Flat getBestSpace(){
        Flat bigestSquareFlat=dwellingFloors[0].getFlats()[0];

        for (int i = 0; i <dwellingFloors.length; i++) {
            for (int j = 0; j <dwellingFloors[i].getFlats().length; j++) {
                if (dwellingFloors[i].getFlats()[j].getSquare()>bigestSquareFlat.getSquare()){
                    bigestSquareFlat=dwellingFloors[i].getFlats()[j];
                }
            }
        }
        return bigestSquareFlat;
    }

    public Flat [] getSortedFlats( ){
        int count=0;
        Flat [] flats=new Flat[getCountOfFlats()];

        Flat [] flats2=new Flat[getCountOfFlats()];

        for (int i = 0; i <dwellingFloors.length; i++) {
            for (int j = 0; j < dwellingFloors[i].getFlats().length; j++) {
                flats2[count]=dwellingFloors[i].getFlats()[j];
                count++;
            }
        }

        for (int j = 0; j <flats2.length; j++) {
            for (int i = 0; i <flats2.length-1; i++) {
                if (flats2[i].getSquare()>flats2[i+1].getSquare()) {
                    Flat bufferFlat=flats2[i];
                    flats2[i]=flats2[i+1];
                    flats2[i+1]=bufferFlat;
                }
            }
        }

        return flats2;

    }

}
