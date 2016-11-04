package com.buildings;

/**
 * Created by tyuly on 31.10.2016.
 */
public class NodeSingleLinkedList {
    public NodeSingleLinkedList next;
    public Office office;
    public int key;

    NodeSingleLinkedList(Office office) {
        this.office=office;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public void output(){
        System.out.println(key+" "+office.getRooms()+" "+office.getSquare());
    }
}
