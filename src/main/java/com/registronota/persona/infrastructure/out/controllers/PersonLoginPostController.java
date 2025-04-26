package com.registronota.persona.infrastructure.out.controllers;

import java.util.Optional;

import com.registronota.persona.domain.entity.dto.PersonEntranceLoginDTO;
import com.registronota.persona.domain.service.PersonServiceRepository;
import com.registronota.persona.infrastructure.in.repositorymysql.PersonRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/loginperson")
public class PersonLoginPostController {

    private PersonServiceRepository personServiceRepository = new PersonRepository();
    

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginPostController(PersonEntranceLoginDTO personEntranceLoginDTO){
        
        Optional<PersonEntranceLoginDTO> person = personServiceRepository
                                                .searchPersonByEmail(personEntranceLoginDTO.getEmail());
        


        if  ( 
                person.
                isEmpty())
            {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\" : \"Error en encontrar el email\"}")
                        .build();
            };
        
   

        if  ( 
                !person.get().getEmail().equals(personEntranceLoginDTO.getEmail()) ||
                !person.get().getPassword().equals(personEntranceLoginDTO.getPassword())
            ){
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\":\"data incorrect \"}")
                        .build();
            }
        
        
        //System.out.println("entro en el sitema");           
        return Response.status(Response.Status.CREATED)
                .entity("{\"token\":\"yo habia pinido un toke aqui xD \"}")
                .build();
    }   

}
