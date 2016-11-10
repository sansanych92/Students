package com.buildings;

/**
 * Created by Arsenii on 10.11.2016.
 */
public class OfficeFloorNode {

    private OfficeFloorNode prev;
    private OfficeFloorNode next;
    private OfficeFloor data;

    public OfficeFloorNode getPrev() {
        return prev;
    }


    public void setPrev(OfficeFloorNode prev) {
        this.prev = prev;
    }

    public OfficeFloorNode getNext() {
        return next;
    }

    public void setNext(OfficeFloorNode next) {
        this.next = next;
    }

    public OfficeFloor getData() {
        return data;
    }

    public void setData(OfficeFloor data) {
        this.data = data;
    }
}
