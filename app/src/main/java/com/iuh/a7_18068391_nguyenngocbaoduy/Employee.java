package com.iuh.a7_18068391_nguyenngocbaoduy;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String detail;


    public Employee(int id, String name, int age,String detail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.detail = detail;

    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
