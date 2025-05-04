package com.registronota.applicant.application;

import com.registronota.applicant.domain.service.ApplicantServiceRepository;

public class UpdateAppStatusUseCase {

    private ApplicantServiceRepository applicantServiceRepository;

    public UpdateAppStatusUseCase(ApplicantServiceRepository applicantServiceRepository) {
        this.applicantServiceRepository = applicantServiceRepository;
    }

    public void execute(int idStatus, int idApplicant){
        applicantServiceRepository.updateStatusApplicant(idStatus, idApplicant);
    }
}
