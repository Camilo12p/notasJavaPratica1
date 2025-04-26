package com.registronota.persona.domain.entity.dto;

import java.time.LocalDate;

import com.registronota.typedoc.domain.entity.TypeDocument;

public class PersonOutDTO {

    private long id;
    private TypeDocument TypeDocument;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private long phoneNumber;
    
    
    
    
    // constructors 
    
    public PersonOutDTO() {
    }
    
    
    // getters and setters 
    
    public long getId() {
        return id;
    }
   
    public void setId(long id) {
        this.id = id;
    }
    public TypeDocument getTypeDocument() {
        return TypeDocument;
    }
    public void setTypeDocument(TypeDocument typeDocument) {
        TypeDocument = typeDocument;
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
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    

}
