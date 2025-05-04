package com.registronota.applicant.domain.service;

import java.util.List;
import java.util.Optional;

import com.registronota.applicant.domain.entity.dto.ApplicantOutDTO;
import com.registronota.persona.domain.entity.Person;

public interface ApplicantServiceRepository {
    public void createApplicant(Person person);
    public void updateStatusApplicant(int idStatus, int idApplicant);

    public List<ApplicantOutDTO> getAllApplicantAccept();
    public List<ApplicantOutDTO> getAllApplicant();
    public Optional<ApplicantOutDTO> getApplicantByid(int idApplicant);
    
}
