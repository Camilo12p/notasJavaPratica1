package com.registronota.persona.application;

import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.service.PersonServiceRepository;

public class CreatePersonUseCase {

    private final PersonServiceRepository personService;

    
    // constructors
    public CreatePersonUseCase(PersonServiceRepository personService){
        this.personService = personService;
    }

    // execute Use Case
    public void execute(Person person){
        personService.createPerson(person);
    }
    
}
