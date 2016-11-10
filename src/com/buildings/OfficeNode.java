package com.buildings;

/**
 * Created by Arsenii on 10.11.2016.
 */
public class OfficeNode {
    private OfficeNode next;
    private Office data;

    public OfficeNode(){
        this.data=new Office();

    }

    public OfficeNode getNext() {
        return next;
    }

    public void setNext(OfficeNode next) {
        this.next = next;
    }

    public Office getData() {
        return data;
    }

    public void setData(Office data) {
        this.data = data;
    }
}
