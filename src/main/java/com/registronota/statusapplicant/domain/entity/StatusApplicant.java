package com.registronota.statusapplicant.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusApplicant {

    @JsonProperty("id_status")
    private int id;

    @JsonProperty("name_status")
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
