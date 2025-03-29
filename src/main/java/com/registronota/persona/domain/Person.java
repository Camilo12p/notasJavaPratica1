package com.registronota.persona.domain;

import java.sql.Date;

public class Person {

    private long id;
    private String name;
    private String lastName;
    private Date birthDate;
    private int phoneNumber;
    
    // constructors

    public Person (){

    }

    public Person
    ( 
        long id, 
        String name,
        String lastName,
        Date birthDate,
        int phoneNumber
    ){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;

    }
    
    
    
    // getters y setters 

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
