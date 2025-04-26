package com.registronota.persona.infrastructure.out.controllers;

import java.util.List;

import com.registronota.persona.application.GetAllPersonUseCase;
import com.registronota.persona.domain.entity.dto.PersonOutDTO;
import com.registronota.persona.domain.service.PersonServiceRepository;
import com.registronota.persona.infrastructure.in.repositorymysql.PersonRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/personall")
public class PersonGetAllController {
    private PersonServiceRepository personRepository = new PersonRepository();
    private GetAllPersonUseCase getAll = new GetAllPersonUseCase(personRepository);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonOutDTO> getAllPerson(){
        return getAll.execute();
    }

}
