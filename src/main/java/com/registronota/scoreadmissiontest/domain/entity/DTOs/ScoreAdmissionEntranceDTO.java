package com.registronota.scoreadmissiontest.domain.entity.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ScoreAdmissionEntranceDTO {
    
    @JsonAlias("score_test_admission")
    @Max(value = 100 , message = "score is not valid")
    @Positive(message = "no exist negative score")
    private float score;

    @JsonAlias("id_applicant")
    @NotNull(message = "id can't null")
    @Min(value = 1, message = "id is not valid")
    private int idApplicant;


    // constructors
    public ScoreAdmissionEntranceDTO() {
    }


    // getters and setters

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(int idApplicant) {
        this.idApplicant = idApplicant;
    }



    

}
