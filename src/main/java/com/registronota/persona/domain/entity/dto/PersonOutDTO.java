package com.registronota.persona.domain.entity.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.registronota.rolPerson.domain.entity.RolPerson;
import com.registronota.typedoc.domain.entity.TypeDocument;

public class PersonOutDTO {

    @JsonProperty("id_person")
    private long id;

    @JsonProperty("type_document_person")
    private TypeDocument TypeDocument;
    
    @JsonProperty("name_person")
    private String name;

    @JsonProperty("last_name_person")
    private String lastName;

    @JsonProperty("birth_Date_person")
    private LocalDate birthDate;

    @JsonProperty("email_person")
    private String email;

    @JsonProperty("phone_number_person")
    private long phoneNumber;

    @JsonProperty("rol_person")
    private RolPerson rolPerson;
    
    
    
    
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
    

    public RolPerson getRolPerson() {
        return rolPerson;
    }


    public void setRolPerson(RolPerson rolPerson) {
        this.rolPerson = rolPerson;
    }


    // to String

    @Override
    public String toString() {
        return "PersonOutDTO [id=" + id + ", TypeDocument=" + TypeDocument + ", name=" + name + ", lastName=" + lastName
                + ", birthDate=" + birthDate + ", email=" + email + ", phoneNumber=" + phoneNumber + ", rolPerson="
                + rolPerson + "]";
    }

    



    
    
}
