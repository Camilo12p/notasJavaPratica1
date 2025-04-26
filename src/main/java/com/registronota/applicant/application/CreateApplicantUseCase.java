package com.registronota.applicant.application;

import com.registronota.applicant.domain.service.ApplicantServiceRepository;
import com.registronota.persona.domain.entity.Person;

public class CreateApplicantUseCase {

    private ApplicantServiceRepository applicantServiceRepository;

    public CreateApplicantUseCase(ApplicantServiceRepository applicantServiceRepository){
        this.applicantServiceRepository = applicantServiceRepository;
    }

    public void execute(Person person){
        applicantServiceRepository.createApplicant(person);
    }

}   
