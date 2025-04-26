package com.registronota.statusapplicant.domain.entity;

public class StatusApplicant {

    private int id;
    private String name;


    // constructors

    public StatusApplicant() {
    }

    
    // getters and setters
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


    // to String

    @Override
    public String toString() {
        return "StatusApplicant [id=" + id + ", name=" + name + "]";
    }


    

}
