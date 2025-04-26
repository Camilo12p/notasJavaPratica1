package com.registronota.persona.application;


import com.registronota.persona.domain.service.PersonServiceRepository;

public class DeletePersonUseCase {

    private PersonServiceRepository personService;

    // constructors 

    public DeletePersonUseCase(PersonServiceRepository personService){
        this.personService = personService;
    }

    // execute 

    public void execute(long id){
        personService.deletePersonById(id);
    }

}
