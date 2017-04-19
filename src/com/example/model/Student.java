package com.example.model;


import java.sql.Date;

/**
 * Created by Banty on 18/04/17.
 */
public class Student {

    private int id;
    private String name;
    private int age;
    private String mobile;
    private java.sql.Date dob;
    private String stream;

    public Student(int id, String name, int age, String mobile, Date dob, String stream) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.dob = dob;
        this.stream = stream;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }

    public Date getDob() {
        return dob;
    }

    public String getStream() {
        return stream;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
}
