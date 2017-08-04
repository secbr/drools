package com.secbro.drools.model;

/**
 * Created by zhuzs on 2017/8/4.
 */
public class Customer {

    private double discount;

    private int age;

    private String type;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
