package com.registronota.persona.application;

import com.registronota.persona.domain.service.PersonServiceRepository;

public class VerifyEmailUseCase {

    private PersonServiceRepository personServiceRepository;

    public VerifyEmailUseCase(PersonServiceRepository personServiceRepository){
        this.personServiceRepository = personServiceRepository;
    }

    public boolean execute(String email){
        return personServiceRepository.verifyEmail(email);
    }
}
