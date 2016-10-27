package com.buildings;

/**
 * Created by Арсений on 27.10.2016.
 */
public class OfficeBuilding {

    private OfficeFloor head;

    int countOfFloors;

    OfficeFloor [] officeFloors;

    public OfficeBuilding(int countOfFloors, int [] officefloors){

        this.countOfFloors=countOfFloors;

        for (int i = 0; i <countOfFloors; i++) {

            officeFloors[i]=new OfficeFloor(officefloors[i]);
        }

        head=officeFloors[0];

        officeFloors[0].prev=officeFloors[countOfFloors-1];

        officeFloors[0].next=officeFloors[1];

        officeFloors[countOfFloors-1].next=head;

        officeFloors[countOfFloors-1].prev=officeFloors[countOfFloors-2];

        for (int i = 1; i <countOfFloors-2; i++) {

            officeFloors[i].prev=officeFloors[i-1];

            officeFloors[i].next=officeFloors[i+1];
        }
    }

    public OfficeBuilding(OfficeFloor [] officefloors){

        this.countOfFloors=officefloors.length;

        this.officeFloors=officefloors;

        head=officeFloors[0];

        officeFloors[0].prev=officeFloors[countOfFloors-1];

        officeFloors[0].next=officeFloors[1];

        officeFloors[countOfFloors-1].next=head;

        officeFloors[countOfFloors-1].prev=officeFloors[countOfFloors-2];

        for (int i = 1; i <countOfFloors-2; i++) {

            officeFloors[i].prev=officeFloors[i-1];

            officeFloors[i].next=officeFloors[i+1];
        }
    }

    private OfficeFloor getNodeByNumber(int number){

        return officeFloors[number];

    }

    private void addNodeByNumber(int number, OfficeFloor node){

        if (number<=countOfFloors){

            OfficeFloor [] newOfficeFloors = new OfficeFloor[countOfFloors+1];

            for (int i = 0; i <number; i++) {

                newOfficeFloors[i] = officeFloors[i];
            }

            newOfficeFloors[number]=node;

            for (int i = number+1; i < newOfficeFloors.length; i++) {

                newOfficeFloors[i] = officeFloors[i-1];
            }

            officeFloors=newOfficeFloors;

            head=officeFloors[0];

            officeFloors[0].prev=officeFloors[countOfFloors-1];

            officeFloors[0].next=officeFloors[1];

            officeFloors[countOfFloors-1].next=head;

            officeFloors[countOfFloors-1].prev=officeFloors[countOfFloors-2];

            for (int i = 1; i <countOfFloors-2; i++) {

                officeFloors[i].prev=officeFloors[i-1];

                officeFloors[i].next=officeFloors[i+1];
            }
        }
    }

    private void deleteNodeByNumber(int number){

        if (number<=countOfFloors-1){

            OfficeFloor [] newOfficeFloors=new OfficeFloor[countOfFloors-1];

            for (int i = 0; i <number; i++) {

                newOfficeFloors[i]=officeFloors[i];
            }


            for (int i = number; i <newOfficeFloors.length; i++) {

                newOfficeFloors[i]=officeFloors[i+1];
            }

            officeFloors=newOfficeFloors;

            head=officeFloors[0];

            officeFloors[0].prev=officeFloors[countOfFloors-1];

            officeFloors[0].next=officeFloors[1];

            officeFloors[countOfFloors-1].next=head;

            officeFloors[countOfFloors-1].prev=officeFloors[countOfFloors-2];

            for (int i = 1; i <countOfFloors-2; i++) {

                officeFloors[i].prev=officeFloors[i-1];

                officeFloors[i].next=officeFloors[i+1];
            }
        }
    }

    public int getCountOfFloors(){

        return countOfFloors;
    }

    public int getCountOfOfficesInTheBuilding(){

        int countOfOfficesInTheBuilding=0;

        for (int i = 0; i <countOfFloors; i++) {

            countOfOfficesInTheBuilding+=officeFloors[i].getCountOfOfficesOnTheFloor();
        }

        return countOfOfficesInTheBuilding;
    }

    public double getSquareOfOfficesInTheBuilding(){

        double square=0;

        for (int i = 0; i <countOfFloors; i++) {

            square+=officeFloors[i].getSquareOnTheFloor();
        }

        return square;
    }

    public int getRoomsOfTheBuilding(){

        int roomsOfTheBuilding=0;

        for (int i = 0; i <countOfFloors; i++) {

            roomsOfTheBuilding+=officeFloors[i].getCountOfRoomsOnTheFloor();
        }

        return roomsOfTheBuilding;
    }

    public OfficeFloor [] getOfficeFloorsOnTheBuilding(){

        return officeFloors;
    }

    public void egitFloor(int number, OfficeFloor newOfficeFloor){

        officeFloors[number]=newOfficeFloor;
    }

    public Office getOfficeIntheBuilding(int number){

        int count=0;

        int numberOnFloor=0;

        int numberOfFloor=0;

        for (int i = 0; i <countOfFloors; i++) {

            for (int j = 0; j <officeFloors[i].getCountOfOfficesOnTheFloor(); j++) {

                if (count==number){

                    numberOnFloor=j;

                    numberOfFloor=i;
                }

                count++;
            }
        }

        return officeFloors[numberOfFloor].getOfficeByNumberOnTheFloor(numberOnFloor);
    }

    public void editOfficeOnBuilding(int number, Office office){

        int count=0;

        int numberOnFloor=0;

        int numberOfFloor=0;

        for (int i = 0; i <countOfFloors; i++) {

            for (int j = 0; j <officeFloors[i].getCountOfOfficesOnTheFloor(); j++) {

                if (count==number){

                    numberOnFloor=j;

                    numberOfFloor=i;
                }

                count++;
            }
        }

        officeFloors[numberOfFloor].editOffice(numberOnFloor,office);
    }

    public void addOfficeInBuilding(int number, Office office){

        int count=0;

        int numberOnFloor=0;

        int numberOfFloor=0;

        for (int i = 0; i <countOfFloors; i++) {

            for (int j = 0; j <officeFloors[i].getCountOfOfficesOnTheFloor(); j++) {

                if (count==number){

                    numberOnFloor=j;

                    numberOfFloor=i;
                }

                count++;
            }
        }

        officeFloors[numberOfFloor].addNewOffice(numberOnFloor,office);
    }

    public void deleteOfficeInBuilding(int number){

        int count=0;

        int numberOnFloor=0;

        int numberOfFloor=0;

        for (int i = 0; i <countOfFloors; i++) {

            for (int j = 0; j <officeFloors[i].getCountOfOfficesOnTheFloor(); j++) {

                if (count==number){

                    numberOnFloor=j;

                    numberOfFloor=i;
                }

                count++;
            }
        }

        officeFloors[numberOfFloor].deleteOfficeByNumberOnTheFloor(numberOnFloor);
    }

    public Office getBestSpace(){

        Office biggestSquareOffice=officeFloors[0].getBestSpace();

        for (OfficeFloor officeFloor:officeFloors) {

            if (officeFloor.getBestSpace().getSquare()>biggestSquareOffice.getSquare())
                biggestSquareOffice=officeFloor.getBestSpace();
        }

        return biggestSquareOffice;
    }

    public Office [] getSortedOffices( ){
        int count=0;

        Office [] offices=new Office[getCountOfOfficesInTheBuilding()];

        Office [] offices2=new Office[getCountOfOfficesInTheBuilding()];

        for (int i = 0; i <officeFloors.length; i++) {
            for (int j = 0; j < officeFloors[i].getOfficesOnTheFloor().length; j++) {
                offices2[count]=officeFloors[i].getOfficesOnTheFloor()[j];
                count++;
            }
        }

        for (int j = 0; j <offices2.length; j++) {
            for (int i = 0; i <offices2.length-1; i++) {
                if (offices2[i].getSquare()>offices2[i+1].getSquare()) {
                    Office bufferOffice=offices2[i];
                    offices2[i]=offices2[i+1];
                    offices2[i+1]=bufferOffice;
                }
            }
        }

        return offices2;

    }


}
