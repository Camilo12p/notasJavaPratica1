package com.registronota.persona.application;

import com.registronota.persona.domain.PersonService;
import com.registronota.persona.domain.entity.Person;

public class CreatePersonUseCase {

    private final PersonService personService;

    
    // constructors
    public CreatePersonUseCase(PersonService personService){
        this.personService = personService;
    }

    // execute Use Case
    public void execute(Person person){
        personService.createPerson(person);
    }
    
}
