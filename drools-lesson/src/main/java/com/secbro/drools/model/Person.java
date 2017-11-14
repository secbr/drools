package com.secbro.drools.model;

import java.util.Date;

/**
 * Created by zhuzs on 2017/8/12.
 */
public class Person {

    private int age;

    private String name;

    private Date bornDate;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }
}
