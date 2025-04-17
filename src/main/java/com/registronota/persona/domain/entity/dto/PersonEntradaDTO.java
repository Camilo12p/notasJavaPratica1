package com.registronota.persona.domain.entity.dto;

import java.sql.Date;
import java.time.LocalDate;


public class PersonEntradaDTO {
    private long id;
    private int idTypeDocument;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;
    private long phoneNumber; 
     

    // constructors

    public PersonEntradaDTO (){

    }

    // getters and setters 

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getIdTypeDocument() {
        return idTypeDocument;
    }
    public void setIdTypeDocument(int idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    // to string
    @Override
    public String toString() {
        return "PersonEntradaDTO [id=" + id + ", idTypeDocument=" + idTypeDocument + ", name=" + name + ", lastName="
                + lastName + ", birthDate=" + birthDate + ", email=" + email + ", password=" + password
                + ", phoneNumber=" + phoneNumber + "]";
    }


    

}
