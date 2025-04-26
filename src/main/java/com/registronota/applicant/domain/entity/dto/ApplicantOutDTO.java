package com.registronota.applicant.domain.entity.dto;

import java.time.LocalDate;

import com.registronota.persona.domain.entity.dto.PersonOutDTO;
import com.registronota.statusapplicant.domain.entity.StatusApplicant;

public class ApplicantOutDTO{

    private int id;
    private StatusApplicant statusApplicant;
    private PersonOutDTO personOutDTO;
    private LocalDate dateEntry;
    
    
    public ApplicantOutDTO(){

    }
    


    // getters and setters
    public int getId(){
        return this.id;
    }

    public PersonOutDTO getPerson() {
        return personOutDTO;
    }

    public void setPerson(PersonOutDTO personOutDTO) {
        this.personOutDTO = personOutDTO;
    }   

    public void setId(int id) {
        this.id = id;
    }
    public StatusApplicant getStatusApplicant() {
        return statusApplicant;
    }
    public void setStatusApplicant(StatusApplicant statusApplicant) {
        this.statusApplicant = statusApplicant;
    }
    public LocalDate getDateEntry() {
        return dateEntry;
    }
    public void setDateEntry(LocalDate dateEntry) {
        this.dateEntry = dateEntry;
    }


    //to String
    
    @Override
    public String toString() {
        return "ApplicantOutDTO [id=" + id + ", statusApplicant=" + statusApplicant + ", personOutDTO=" + personOutDTO
                + ", dateEntry=" + dateEntry + "]";
    }
   
    // to String 

    


    
}
