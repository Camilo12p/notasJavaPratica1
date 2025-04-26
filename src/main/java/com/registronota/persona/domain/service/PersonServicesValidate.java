package com.registronota.persona.domain.service;

import com.registronota.persona.domain.entity.dto.PersonEntraceDTO;

public interface PersonServicesValidate {
    boolean validateEmail(String email);
    boolean validateAllFields(PersonEntraceDTO personEntradaDTO);
    boolean validatePassword(String password);
}   
