package com.registronota.scoreadmissiontest.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.registronota.applicant.domain.entity.dto.ApplicantOutDTO;

public class ScoreAdmissionTest {

    @JsonProperty("id_score_admission_test")
    private int id;

    @JsonProperty("score_admission_test")
    private float score;

    @JsonProperty("Applicant")
    private ApplicantOutDTO applicantOutDTO;

    @JsonProperty("date_register")
    private LocalDateTime dateRegister;



    // constructors
    public ScoreAdmissionTest() {
    }

    // getters and setters


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public ApplicantOutDTO getPersonOutDTO() {
        return applicantOutDTO;
    }

    public void setPersonOutDTO(ApplicantOutDTO applicantOutDTO) {
        this.applicantOutDTO = applicantOutDTO;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDateTime dateRegister) {
        this.dateRegister = dateRegister;
    }




    

}
