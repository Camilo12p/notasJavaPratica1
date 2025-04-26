package com.registronota.persona.application;

import java.util.List;

import com.registronota.persona.domain.entity.dto.PersonOutDTO;
import com.registronota.persona.domain.service.PersonServiceRepository;

public class GetAllPersonUseCase {

    private PersonServiceRepository personService;

    public GetAllPersonUseCase (PersonServiceRepository personService){
        this.personService = personService;
    }

    public List<PersonOutDTO> execute(){
        return personService.getAllPerson();
    }

}
