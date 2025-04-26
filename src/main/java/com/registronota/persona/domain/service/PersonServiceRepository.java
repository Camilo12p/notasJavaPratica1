package com.registronota.persona.domain.service;

import java.util.List;
import java.util.Optional;

import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.entity.dto.PersonEntranceLoginDTO;
import com.registronota.persona.domain.entity.dto.PersonOutDTO;

public interface PersonServiceRepository {

    void createPerson(Person person);
    void updatePerson(Person person);
    void deletePersonById(Long id);
    
    Optional<PersonOutDTO> searchPersonById(Long id);
    Optional<PersonEntranceLoginDTO> searchPersonByEmail(String email);
    List<PersonOutDTO> getAllPerson();
    boolean verifyEmail(String email);
    
    
}
