package com.registronota.persona.application;


import com.registronota.persona.domain.service.PersonService;

public class DeletePersonUseCase {

    private PersonService personService;

    // constructors 

    public DeletePersonUseCase(PersonService personService){
        this.personService = personService;
    }

    // execute 

    public void execute(long id){
        personService.deletePersonById(id);
    }

}
