package com.buildings;

/**
 * Created by tyuly on 31.10.2016.
 */


public class OfficeFloor {
    private NodeSingleLinkedList first;
    private NodeSingleLinkedList tail;

    OfficeFloor(int i) { //принимает количество офисов
        //int key=0;
        for (int j = 0; j < i; j++) {
            int key=i;
            newNodeBack(new Office(),key);

        }
    }


    OfficeFloor(Office [] officies) { //принимает массив офисов
        for (int i = 0; i <officies.length ; i++) {
            int key=i;
            newNodeBack(officies[i],key);

        }
    }

    public  NodeSingleLinkedList getFirst() {
        return first;
    }

    public void setFirst(NodeSingleLinkedList n) {
        first=n;
    }

    public boolean isEmpty(){
        return first==null;
    }

  /*  public void newNode(Office office) {  //добавление в начало
        NodeSingleLinkedList nodeSingleLinkedList = new NodeSingleLinkedList(office);
        nodeSingleLinkedList.next = first;
        first = nodeSingleLinkedList;
    } */

    public void newNodeBack(Office office, int key) {
        NodeSingleLinkedList nodeSingleLinkedList = new NodeSingleLinkedList(office);
        if (tail == null) {
            first = nodeSingleLinkedList;
            tail = nodeSingleLinkedList;
        } else {
            tail.next = nodeSingleLinkedList;
            tail = nodeSingleLinkedList;

        }
        tail.setKey(key);

    }

    private NodeSingleLinkedList find(int key) {
        NodeSingleLinkedList current = first;
        while (current.key!=key) {
            if (current.next==null) {
                System.out.println("Нет такого узла");
                return null;
            }
            else {
                current=current.next;
            }
        }
        return current;
    }

    private void delete(int key) {
        NodeSingleLinkedList current=first;
        NodeSingleLinkedList previous=first;
        while (current.key!=key) {
            if (current.next == null) {
                System.out.println("Нет такого узла");
                break;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current==first) {
            first=first.next;

        }
        else {
            previous.next=current.next;
        }
        while (current!=null) {  //изменяем номер узлов за удаленным
           // current.next.setKey(current.next.getKey() - 1);
            current.setKey(current.getKey() - 1);
            current=current.next;
        }
    }

    public void add(Office office,int key) {
        NodeSingleLinkedList current=first;
        NodeSingleLinkedList previous=first;
        NodeSingleLinkedList add=new NodeSingleLinkedList(office);
        while (current.key!=key) {
            if (current.next == null) {
                newNodeBack(office,key);
            } else {
                previous=current;
                current=current.next;
            }
        }
        if(current.key==key) {
            previous = current;
            while (current.next != null) {
                current.next = current;

            }
        }



    }


    public void output() {
        NodeSingleLinkedList f = first;
        while (f != null) {
            f.output();
            f = f.next;
        }
    }
}

