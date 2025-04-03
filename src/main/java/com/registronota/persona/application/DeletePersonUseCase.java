package com.registronota.persona.application;

import java.util.Optional;

import com.registronota.persona.domain.PersonService;
import com.registronota.persona.domain.entity.Person;

public class DeletePersonUseCase {

    private PersonService personService;

    // constructors 

    public DeletePersonUseCase(PersonService personService){
        this.personService = personService;
    }

    // execute 

    public Optional<Person> execute(long id){
        return personService.deletePerson(id);
    }

}
