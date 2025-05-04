package com.registronota.applicant.application;

import java.util.Optional;

import com.registronota.applicant.domain.entity.dto.ApplicantOutDTO;
import com.registronota.applicant.domain.service.ApplicantServiceRepository;

public class GetApplicantById {

    private ApplicantServiceRepository applicantServiceRepository;

    public GetApplicantById(ApplicantServiceRepository applicantServiceRepository) {
        this.applicantServiceRepository = applicantServiceRepository;
    }
    
    public Optional<ApplicantOutDTO> execute(int idApplicant){
        return applicantServiceRepository.getApplicantByid(idApplicant);
    }

}
