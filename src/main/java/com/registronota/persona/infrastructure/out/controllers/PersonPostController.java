package com.registronota.persona.infrastructure.out.controllers;

import java.time.ZoneId;
import java.util.Optional;

import com.registronota.persona.application.CreatePersonUseCase;
import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.entity.dto.PersonEntradaDTO;
import com.registronota.persona.domain.service.PersonService;
import com.registronota.persona.infrastructure.in.repositorymysql.PersonRepository;
import com.registronota.typedoc.application.GetByIdUseCase;
import com.registronota.typedoc.domai.service.TypeDocumentService;
import com.registronota.typedoc.domain.entity.TypeDocument;
import com.registronota.typedoc.infrastructure.in.TypeDocumentRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("persona/create")
public class PersonPostController {
    PersonService personService = new PersonRepository();
    CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);    
    
    TypeDocumentService typeDocumentService = new TypeDocumentRepository();
    GetByIdUseCase getByIdUseCase = new GetByIdUseCase(typeDocumentService);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response personPostController(PersonEntradaDTO personEntradaDTO){
        


        TypeDocument typeDocument = getByIdUseCase.execute(personEntradaDTO.getIdTypeDocument()).get();
        
        
        Person person = new Person();
        person.setId(personEntradaDTO.getId());
        person.setTypeDocument(typeDocument);
        person.setName(personEntradaDTO.getName());
        person.setLastName(personEntradaDTO.getLastName());
        person.setBirthDate(personEntradaDTO.getBirthDate());
        person.setEmail(personEntradaDTO.getEmail());
        person.setPassword(personEntradaDTO.getPassword());
        person.setPhoneNumber(personEntradaDTO.getPhoneNumber());


        System.out.println(person);

        createPersonUseCase.execute(person);
        
        return Response.status(Response.Status.CREATED)
        .entity(person)
        .build();
    }   
}
