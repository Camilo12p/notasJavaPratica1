package com.registronota.persona.domain.service;

import java.util.List;
import java.util.Optional;

import com.registronota.persona.domain.entity.Person;

public interface PersonService {

    void createPerson(Person person);
    void updatePerson(Person person);
    void deletePersonById(Long id);
    Optional<Person> searchPersonById(Long id);
    List<Person> getAllPerson();
    
}
