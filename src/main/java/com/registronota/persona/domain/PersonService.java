package com.registronota.persona.domain;

import java.util.Optional;

public interface PersonService {

    void createPerson(Person person);
    void updatePerson(Person person);
    Optional<Person> deletePerson(Long id);
    Optional<Person> searchPersonById(Long id);
    
}
