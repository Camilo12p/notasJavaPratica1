package com.registronota.persona.application;

import java.util.List;

import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.service.PersonService;

public class GetAllPersonUseCase {

    private PersonService personService;

    public GetAllPersonUseCase (PersonService personService){
        this.personService = personService;
    }

    public List<Person> execute(){
        return personService.getAllPerson();
    }

}
