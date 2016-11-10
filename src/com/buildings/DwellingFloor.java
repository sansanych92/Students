package com.buildings;

/**
 * Created by Арсений on 09.10.2016.
 */
public class DwellingFloor {

    private int countOfFlats;
    private Flat [] flats;

    public DwellingFloor(int countOfFlats){
        flats=new Flat[countOfFlats];
        for (int i = 0; i < countOfFlats; i++) {
            flats[i]=new Flat();
        }
        this.countOfFlats=countOfFlats;
    }

    public DwellingFloor(Flat [] flats){
        this.flats=flats;
        countOfFlats= flats.length;
    }

    public int getCountOfFlats() {
        return flats.length;
    }

    public int getFlatsSquare(){
        int i=0;

        for (Flat flat:flats) {
            i+=flat.getSquare();
        }
        return i;
    }

    public int getFlatsRooms(){
        int i=0;

        for (Flat flat:flats) {
            i+=flat.getRooms();
        }
        return i;
    }

    public Flat[] getFlats() {
        return flats;
    }

    public Flat onNumber(int number) {
        return flats[number];
    }

    public void editFlat(int number, Flat flat) {
        flats[number]=flat;

    }

    public void addNewFlat(int number, Flat flat) {

        if (number<=flats.length) {

            Flat [] newFlats=new Flat[flats.length+1];

            for (int j = 0; j < number; j++) {
                newFlats[j]=flats[j];
            }

            newFlats[number]=flat;

            for (int j = number+1; j < newFlats.length; j++) {
                newFlats[j]=flats[j-1];
            }




            newFlats[newFlats.length-1]=flat;

            flats=newFlats;

            countOfFlats++;
        }
    }

    public void deleteFlat(int number){

        Flat [] newFlats = new Flat[countOfFlats-1];

        if (number<=countOfFlats-1){
            for (int i = 0; i <number; i++) {
                newFlats[i]=flats[i];
            }
            for (int i = number; i <newFlats.length; i++) {
                newFlats[i]=flats[i+1];
            }

            flats=newFlats;
            countOfFlats--;
        }
    }

    public Flat getBestSpace(){

        Flat bigestSquareFlat=flats[0];

        for (int i = 0; i <flats.length ; i++) {

            if (flats[i].getSquare()>bigestSquareFlat.getSquare()){
                bigestSquareFlat=flats[i];

            }
        }

        return bigestSquareFlat;
    }

}
