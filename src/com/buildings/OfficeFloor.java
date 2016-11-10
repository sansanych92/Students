package com.buildings;

/**
 * Created by Арсений on 27.10.2016.
 */
public class OfficeFloor {

    private OfficeNode head;
    private OfficeNode tail;
    private int countOfOfficesOnTheFloor;

    public OfficeFloor(int countOfOfficesOnTheFloor){

        this.countOfOfficesOnTheFloor = countOfOfficesOnTheFloor;

        head = new OfficeNode();
        tail=new OfficeNode();

        for (int i = 0; i < countOfOfficesOnTheFloor; i++) {

            OfficeNode officeNode = new OfficeNode();

            if (i == countOfOfficesOnTheFloor - 1) {
                tail.setNext(head);
            }

            if (head.getNext()==null){
                head.setData(officeNode.getData());
                head.setNext(tail);
                tail.setNext(head);
            }
            else
            {
                tail.setNext(officeNode);
                tail= officeNode;
                tail.setNext(head);
            }

        }
    }

    public OfficeFloor(Office [] officesOnTheFloor){

        this.countOfOfficesOnTheFloor = officesOnTheFloor.length;

        head = new OfficeNode();
        tail=new OfficeNode();

        for (int i = 0; i < countOfOfficesOnTheFloor; i++) {

            OfficeNode officeNode = new OfficeNode();

            if (i == countOfOfficesOnTheFloor - 1) {
                tail.setData(officesOnTheFloor[i]);
                tail.setNext(head);
            }
            else {


                if (head.getNext() == null) {
                    head.setData(officesOnTheFloor[i]);
                    head.setNext(tail);
                    tail.setNext(head);
                } else {
                    tail.setData(officesOnTheFloor[i]);
                    tail.setNext(officeNode);
                    tail = officeNode;
                    tail.setNext(head);
                }
            }

        }
    }



    private OfficeNode getNodeByNumber(int number) {

        if (number < countOfOfficesOnTheFloor) {

            OfficeNode officeNode;
            officeNode = head;

            for (int i = 0; i <= number; i++) {

                if (i == number) {
                    break;
                }

                else {
                    officeNode = officeNode.getNext();
                }
            }
            return officeNode;
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    private void addNodeByNumber(int number, OfficeNode officeNode) {

        if (number <= countOfOfficesOnTheFloor) {

            OfficeNode newOfficeNode;
            newOfficeNode = head;

            for (int i = 0; i <= number; i++) {

                if (number == 0) {
                    officeNode.setNext(head);
                    head = officeNode;
                    tail.setNext(head);
                }
                else {
                    if (number == countOfOfficesOnTheFloor){
                        tail= officeNode;
                        tail.setNext(head);
                    }
                    if (i == number - 1) {

                        officeNode.setNext(newOfficeNode.getNext());
                        newOfficeNode.setNext(officeNode);
                    }
                    else {
                        newOfficeNode = newOfficeNode.getNext();
                    }
                }
            }

            countOfOfficesOnTheFloor++;
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    private void deleteNodeByNumber(int number){

        if(number<countOfOfficesOnTheFloor) {

            OfficeNode officeNode;
            officeNode = head;

            for (int i = 0; i <= number; i++) {

                if (number == 0) {
                    head = head.getNext();
                    tail.setNext(head);
                }
                else {



                    if (i == number - 1) {

                        if (number == countOfOfficesOnTheFloor-1){
                            tail= officeNode;
                            tail.setNext(head);
                        }
                        else

                            officeNode.setNext(officeNode.getNext().getNext());

                    } else {
                        officeNode = officeNode.getNext();
                    }
                }
            }
            countOfOfficesOnTheFloor--;
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public int getCountOfOfficesOnTheFloor(){

        return countOfOfficesOnTheFloor;
    }

    public double getSquareOnTheFloor(){

        double square=0;
        OfficeNode officeNode =head;

        for (int i = 0; i < countOfOfficesOnTheFloor; i++) {

            square+= officeNode.getData().getSquare();
            officeNode = officeNode.getNext();
        }

        return square;
    }

    public int getCountOfRoomsOnTheFloor(){

        int countOfRooms=0;
        OfficeNode officeNode =head;

        for (int i = 0; i < countOfOfficesOnTheFloor; i++) {

            countOfRooms+= officeNode.getData().getCountOfRooms();
            officeNode = officeNode.getNext();
        }

        return countOfRooms;
    }

    public Office[] getOfficesOnTheFloor(){

        Office [] officesOnTheFloor=new Office[countOfOfficesOnTheFloor];
        OfficeNode officeNode =head;

        for (int i = 0; i < countOfOfficesOnTheFloor; i++) {

            officesOnTheFloor[i]= officeNode.getData();
            officeNode = officeNode.getNext();
        }

        return officesOnTheFloor;
    }

    public Office getOfficeByNumberOnTheFloor(int number){

        return getNodeByNumber(number).getData();
    }

    public void editOffice(int number, Office office){

        OfficeNode newOfficeNode =new OfficeNode();
        newOfficeNode.setData(office);
        deleteNodeByNumber(number);
        addNodeByNumber(number, newOfficeNode);
    }

    public void addNewOffice(int number, Office office){

        OfficeNode newOfficeNode =new OfficeNode();
        newOfficeNode.setData(office);
        addNodeByNumber(number, newOfficeNode);
    }

    public void deleteOfficeByNumberOnTheFloor(int number){

        deleteNodeByNumber(number);
    }

    public Office getBestSpace(){

        Office biggestSquareOffice=head.getData();

        OfficeNode officeNode =head;

        for (int i = 0; i < countOfOfficesOnTheFloor; i++) {

            if (officeNode.getData().getSquare()>biggestSquareOffice.getSquare())
                biggestSquareOffice= officeNode.getData();
            else
                officeNode = officeNode.getNext();
        }

        return officeNode.getData();
    }
}
