package com.registronota.persona.domain.entity;

import java.time.LocalDate;

public class Person {

    private long id;
    private int idTypeDocument;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    

    private int phoneNumber;
    
    // constructors

    public Person (){

    }

    public Person
    ( 
        long id, 
        int idTypeDocument,
        String name,
        String lastName,
        LocalDate birthDate,
        int phoneNumber
    ){
        this.id = id;
        this.idTypeDocument = idTypeDocument;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;

    }
    
    
    
    // getters y setters 

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
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
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdTypeDocument() {
        return idTypeDocument;
    }

    public void setIdTypeDocument(int idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }
    
    
}
