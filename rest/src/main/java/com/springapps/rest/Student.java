package com.springapps.rest;

public class Student {
    private int uid;
    private String name;
    private int rollNo;
    private String course;

    public Student() {}

    public Student(int uid, String name, int rollNo, String course) {
        this.uid = uid;
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
