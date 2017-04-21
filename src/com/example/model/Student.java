package com.example.model;


import java.sql.Date;

public class Student {

    private int id;
    private String name;
    private int age;
    private String mobile;
    private Date dob;
    private String stream;

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
