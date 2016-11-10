package com.buildings;

/**
 * Created by Арсений on 27.10.2016.
 */
public class OfficeBuilding {

    private OfficeFloorNode head;
    private OfficeFloorNode tail;

    int countOfFloors;


    private OfficeFloorNode getNodeByNumber(int number) {

        if (number < countOfFloors) {

            OfficeFloorNode officeFloorNode;
            officeFloorNode = head;

            for (int i = 0; i <= number; i++) {

                if (i == number) {
                    break;
                }

                else {
                    officeFloorNode = officeFloorNode.getNext();
                }
            }
            return officeFloorNode;
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    private void addNodeByNumber(int number, OfficeFloorNode officeNode) {

        if (number <= countOfFloors) {

            OfficeFloorNode newOfficeNode;
            newOfficeNode = head;

            for (int i = 0; i <= number; i++) {

               if (i==number){


               }
                    else {
                        newOfficeNode = newOfficeNode.getNext();
                    }
                }

            countOfFloors++;
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    private void deleteNodeByNumber(int number){

        if(number<countOfFloors) {

            OfficeFloorNode officeNode;
            officeNode = head;

            for (int i = 0; i <= number; i++) {

                if (number == 0) {
                    head = head.getNext();
                    tail.setNext(head);
                }
                else {



                    if (i == number - 1) {

                        if (number == countOfFloors-1){
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
            countOfFloors--;
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

public OfficeBuilding(OfficeFloor [] floors){

    head=new OfficeFloorNode();
    tail=new OfficeFloorNode();

    for (int i = 0; i < floors.length; i++) {

        addNodeByNumber(i,new OfficeFloorNode());
    }
}
}
