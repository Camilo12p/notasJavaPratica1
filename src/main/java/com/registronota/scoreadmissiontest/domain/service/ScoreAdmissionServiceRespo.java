package com.registronota.scoreadmissiontest.domain.service;

import java.util.List;
import java.util.Optional;

import com.registronota.scoreadmissiontest.domain.entity.ScoreAdmissionTest;
import com.registronota.scoreadmissiontest.domain.entity.DTOs.ScoreAdmissionEntranceDTO;

public interface ScoreAdmissionServiceRespo {

    public void createScore(ScoreAdmissionEntranceDTO score);
    public List<ScoreAdmissionTest> getAllScoreAdmission(long idPerson);
    public Optional<ScoreAdmissionTest> getScoreMoreRecently(long idPerson);
}
