package com.buildings;

/**
 * Created by Арсений on 27.10.2016.
 */
public class OfficeFloor {

    private Office [] officesOnTheFloor;

    private int countOfOfficesOnTheFloor;

    private Office head;

    public OfficeFloor prev;

    public OfficeFloor next;

    public OfficeFloor(int countOfOfficesOnTheFloor){

        this.countOfOfficesOnTheFloor=countOfOfficesOnTheFloor;

        officesOnTheFloor=new Office[countOfOfficesOnTheFloor];

        for (int i = 0; i <countOfOfficesOnTheFloor; i++) {

            officesOnTheFloor[i]=new Office();
        }

        head=officesOnTheFloor[0];

        officesOnTheFloor[countOfOfficesOnTheFloor-1].next=head;

        for (int i = 0; i <countOfOfficesOnTheFloor-2; i++) {

            officesOnTheFloor[i].next=officesOnTheFloor[i+1];
        }


    }

    public OfficeFloor(Office [] officesOnTheFloor){

        this.officesOnTheFloor=officesOnTheFloor;

        this.countOfOfficesOnTheFloor=officesOnTheFloor.length;

        head=officesOnTheFloor[0];

        officesOnTheFloor[countOfOfficesOnTheFloor-1].next=head;

        for (int i = 0; i <countOfOfficesOnTheFloor-2; i++) {

            officesOnTheFloor[i].next=officesOnTheFloor[i+1];
        }
    }



    private Office getNodeByNumber(int number){

        return officesOnTheFloor[number];

    }

    private void addNodeByNumber(int number,Office node){

        if (number<=countOfOfficesOnTheFloor){

            Office [] newOfficesOnTheFloor=new Office[countOfOfficesOnTheFloor+1];

            for (int i = 0; i <number; i++) {

                newOfficesOnTheFloor[i]=officesOnTheFloor[i];
            }

            newOfficesOnTheFloor[number]=node;

            for (int i = number+1; i <newOfficesOnTheFloor.length; i++) {

                newOfficesOnTheFloor[i]=officesOnTheFloor[i-1];
            }

            officesOnTheFloor=newOfficesOnTheFloor;

            head=officesOnTheFloor[0];

            officesOnTheFloor[countOfOfficesOnTheFloor-1].next=head;

            for (int i = 0; i <countOfOfficesOnTheFloor-2; i++) {

                officesOnTheFloor[i].next=officesOnTheFloor[i+1];
            }
        }
    }

    private void deleteNodeByNumber(int number){

        if (number<=countOfOfficesOnTheFloor-1){

            Office [] newOfficesOnTheFloor=new Office[countOfOfficesOnTheFloor-1];

            for (int i = 0; i <number; i++) {

                newOfficesOnTheFloor[i]=officesOnTheFloor[i];
            }


            for (int i = number; i <newOfficesOnTheFloor.length; i++) {

                newOfficesOnTheFloor[i]=officesOnTheFloor[i+1];
            }

            officesOnTheFloor=newOfficesOnTheFloor;

            head=officesOnTheFloor[0];

            officesOnTheFloor[countOfOfficesOnTheFloor-1].next=head;

            for (int i = 0; i <countOfOfficesOnTheFloor-2; i++) {

                officesOnTheFloor[i].next=officesOnTheFloor[i+1];
            }
        }
    }

    public int getCountOfOfficesOnTheFloor(){

        return countOfOfficesOnTheFloor;
    }

    public double getSquareOnTheFloor(){

        double square=0;

        for (Office office:officesOnTheFloor) {
            square+=office.getSquare();
        }

        return square;
    }

    public int getCountOfRoomsOnTheFloor(){

        int countOfRooms=0;

        for (Office office:officesOnTheFloor) {
            countOfRooms+=office.getCountOfRooms();
        }

        return countOfRooms;
    }

    public Office[] getOfficesOnTheFloor(){

        return officesOnTheFloor;
    }

    public Office getOfficeByNumberOnTheFloor(int number){

        return getNodeByNumber(number);
    }

    public void editOffice(int number, Office office){

        deleteNodeByNumber(number);

        addNodeByNumber(number,office);
    }

    public void addNewOffice(int number, Office office){

        addNodeByNumber(number,office);
    }

    public void deleteOfficeByNumberOnTheFloor(int number){

        deleteNodeByNumber(number);
    }

    public Office getBestSpace(){

        Office biggestSquareOffice=officesOnTheFloor[0];

        for (Office office:officesOnTheFloor) {

            if (office.getSquare()>biggestSquareOffice.getSquare())
                biggestSquareOffice=office;
        }

        return biggestSquareOffice;
    }
}
