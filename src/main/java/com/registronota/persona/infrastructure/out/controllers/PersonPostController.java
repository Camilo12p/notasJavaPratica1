package com.registronota.persona.infrastructure.out.controllers;


import com.registronota.persona.application.CreatePersonUseCase;
import com.registronota.persona.application.VerifyEmailUseCase;
import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.entity.dto.PersonEntraceDTO;
import com.registronota.persona.domain.service.PersonServiceRepository;
import com.registronota.persona.domain.service.PersonServicesValidate;
import com.registronota.persona.infrastructure.in.repositorymysql.PersonRepository;
import com.registronota.persona.infrastructure.in.repositorymysql.PersonValidate;
import com.registronota.rolPerson.application.GetRolPersonByIdUseCase;
import com.registronota.rolPerson.domain.entity.RolPerson;
import com.registronota.rolPerson.domain.service.RolPersonServiceRepo;
import com.registronota.rolPerson.infrastrucute.RolPersonRepository;
import com.registronota.typedoc.application.GetTypeDocByIdUseCase;
import com.registronota.typedoc.domai.service.TypeDocumentService;
import com.registronota.typedoc.domain.entity.TypeDocument;
import com.registronota.typedoc.infrastructure.in.TypeDocumentRepository;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("persona/create")
public class PersonPostController {
    
    
    // insert dependent
    PersonServiceRepository personServiceRepository = new PersonRepository();
    CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personServiceRepository);    
    VerifyEmailUseCase verifyEmailUseCase = new VerifyEmailUseCase(personServiceRepository);
    PersonServicesValidate personServicesValidate = new PersonValidate();
    
    TypeDocumentService typeDocumentService = new TypeDocumentRepository();
    GetTypeDocByIdUseCase getByIdUseCase = new GetTypeDocByIdUseCase(typeDocumentService);

    RolPersonServiceRepo rPersonServiceRepo = new RolPersonRepository();
    GetRolPersonByIdUseCase getRolPersonByIdUseCase = new GetRolPersonByIdUseCase(rPersonServiceRepo);


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response personPostController(@Valid PersonEntraceDTO personEntranceDTO){


        if(!verifyEmailUseCase.execute(personEntranceDTO.getEmail())){
            return Response.status(Response.Status.BAD_REQUEST)
            .entity("{\"error\" : \"El email ya se encuetra registrado\"}")
            .build();
        }

        TypeDocument typeDocument = getByIdUseCase.execute(personEntranceDTO.getIdTypeDocument()).get();
        RolPerson rolPerson = getRolPersonByIdUseCase.execute(1).get();
        
        
        Person person = new Person(personEntranceDTO,typeDocument,rolPerson);


        System.out.println(person);

        createPersonUseCase.execute(person);
        
        return Response.status(Response.Status.CREATED)
        .entity(person)
        .build();
    }   
}
