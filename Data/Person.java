package com.example.recyclerview.Data;

public class Person extends Data {
    private int pId;
    private String name;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int imageId, int pId, String name) {
        super(imageId);
        this.pId = pId;
        this.name = name;
    }

    public Person(int pId, String name) {
        this.pId = pId;
        this.name = name;
    }

    public Person() {
    }
}
