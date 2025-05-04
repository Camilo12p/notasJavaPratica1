package com.registronota.scoreadmissiontest.applicant;

import com.registronota.scoreadmissiontest.domain.entity.DTOs.ScoreAdmissionEntranceDTO;
import com.registronota.scoreadmissiontest.domain.service.ScoreAdmissionServiceRespo;

public class CreateScoreUseCase {
    
    private ScoreAdmissionServiceRespo scoreAdmissionServiceRespo;

    public CreateScoreUseCase(ScoreAdmissionServiceRespo scoreAdmissionServiceRespo){
        this.scoreAdmissionServiceRespo = scoreAdmissionServiceRespo;
    }
    
    public void execute(ScoreAdmissionEntranceDTO score){
        scoreAdmissionServiceRespo.createScore(score);
    }

}
