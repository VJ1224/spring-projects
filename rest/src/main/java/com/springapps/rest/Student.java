package com.springapps.rest;

public class Student {
    private int uid;
    private String name;
    private int rollNo;

    public Student() {

    }

    public Student(int uid, String name, int rollNo) {
        this.uid = uid;
        this.name = name;
        this.rollNo = rollNo;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
