package com.registronota.persona.domain.entity;

import java.time.LocalDate;

import com.registronota.persona.domain.entity.dto.PersonEntraceDTO;
import com.registronota.rolPerson.domain.entity.RolPerson;
import com.registronota.typedoc.domain.entity.TypeDocument;

public class Person {

    private long id;
    private TypeDocument TypeDocument;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;
    private long phoneNumber;
    private RolPerson rolPerson;
    
    
    
    
    // constructors

    
    public Person (){

    }



    // methods

    public Person(PersonEntraceDTO personEntraceDTO, TypeDocument typeDocument, RolPerson rolPerson){
        this.id = personEntraceDTO.getId();
        this.TypeDocument = typeDocument;
        this.name = personEntraceDTO.getName();
        this.lastName = personEntraceDTO.getLastName();
        this.birthDate = personEntraceDTO.getBirthDate();
        this.email = personEntraceDTO.getEmail();
        this.password = personEntraceDTO.getPassword();
        this.phoneNumber = personEntraceDTO.getPhoneNumber();
        this.rolPerson = rolPerson;
    }

    public Person
    ( 
        long id, 
        TypeDocument TypeDocument,
        String name,
        String lastName,
        LocalDate birthDate,
        int phoneNumber,
        String password,
        RolPerson rolPerson
    ){
        this.id = id;
        this.TypeDocument = TypeDocument;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.rolPerson = rolPerson;

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
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TypeDocument getTypeDocument() {
        return TypeDocument;
    }

    public void setTypeDocument(TypeDocument TypeDocument) {
        this.TypeDocument = TypeDocument;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolPerson getRolPerson() {
        return rolPerson;
    }



    public void setRolPerson(RolPerson rolPerson) {
        this.rolPerson = rolPerson;
    }
    
    // toString
    @Override
    public String toString() {
        return "Person [id=" + id + ", TypeDocument=" + TypeDocument + ", name=" + name + ", lastName=" + lastName
                + ", birthDate=" + birthDate + ", email=" + email + ", password=" + password + ", phoneNumber="
                + phoneNumber + "]";
    }



    
    
    
}
