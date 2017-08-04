package com.secbro.drools.model;

/**
 * Created by zhuzs on 2017/8/4.
 */
public class Car {

    private boolean freeParking;

    private Customer owner;

    public boolean isFreeParking() {
        return freeParking;
    }

    public void setFreeParking(boolean freeParking) {
        this.freeParking = freeParking;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
