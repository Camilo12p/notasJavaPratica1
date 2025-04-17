package com.registronota.persona.infrastructure.out.controllers;

import java.util.List;

import com.registronota.persona.application.GetAllPersonUseCase;
import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.service.PersonService;
import com.registronota.persona.infrastructure.in.repositorymysql.PersonRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/personall")
public class PersonGetAllController {
    private PersonService personRepository = new PersonRepository();
    private GetAllPersonUseCase getAll = new GetAllPersonUseCase(personRepository);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPerson(){
        return getAll.execute();
    }

}
