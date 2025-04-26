package com.registronota.applicant.domain.entity;

import java.time.LocalDate;

import com.registronota.persona.domain.entity.Person;
import com.registronota.statusapplicant.domain.entity.StatusApplicant;

public class Applicant {

    private int id;
    private Person person;
    private LocalDate dateEntry;
    private StatusApplicant status;
    
    
    // constructors
    public Applicant() {
    }

    
    // getters and setters
    public int getId() {
        return id;
    }
   
    public void setId(int id) {
        this.id = id;
    }
    public Person getPerson() {
        return person;
    }
    public void setIdPerson(Person person) {
        this.person = person;
    }
    public LocalDate getDateEntry() {
        return dateEntry;
    }
    public void setDateEntry(LocalDate dateEntry) {
        this.dateEntry = dateEntry;
    }
    public StatusApplicant getStatus() {
        return status;
    }
    public void setStatus(StatusApplicant status) {
        this.status = status;
    }
    
    
    
    // to string
    @Override
    public String toString() {
        return "Applicant [id=" + id + ", idPerson=" + person + ", dateEntry=" + dateEntry + ", status=" + status
                + "]";
    }
    

    
    
    

}
