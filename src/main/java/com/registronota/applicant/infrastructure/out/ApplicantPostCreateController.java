package com.registronota.applicant.infrastructure.out;


import com.registronota.applicant.application.CreateApplicantUseCase;
import com.registronota.applicant.domain.service.ApplicantServiceRepository;
import com.registronota.applicant.infrastructure.in.ApplicantRepository;
import com.registronota.persona.application.CreatePersonUseCase;
import com.registronota.persona.application.VerifyEmailUseCase;
import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.entity.dto.PersonEntraceDTO;
import com.registronota.persona.domain.service.PersonServiceRepository;
import com.registronota.persona.infrastructure.in.repositorymysql.PersonRepository;
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

@Path("/applicant/sign-up")
public class ApplicantPostCreateController {

    private PersonServiceRepository pRepository = new PersonRepository();
    private CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(pRepository);
    private VerifyEmailUseCase verifyEmailUseCase = new VerifyEmailUseCase(pRepository);
    

    private TypeDocumentService tRepository = new TypeDocumentRepository();
    private GetTypeDocByIdUseCase getTypeDocByIdUseCase = new GetTypeDocByIdUseCase(tRepository); 
    
    private ApplicantServiceRepository aRepository = new ApplicantRepository();
    private CreateApplicantUseCase createApplicantUseCase = new CreateApplicantUseCase(aRepository);

    private RolPersonServiceRepo rPersonServiceRepo = new RolPersonRepository();
    private GetRolPersonByIdUseCase getRolPersonByIdUseCase = new GetRolPersonByIdUseCase(rPersonServiceRepo);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCreateController(@Valid PersonEntraceDTO personEntraceDTO){


        System.out.println(personEntraceDTO);

        if(
            !verifyEmailUseCase.execute(personEntraceDTO.getEmail())
        ){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"el email ya se encuentra registrado\"}")
                    .build();
        }


        TypeDocument typeDocument = getTypeDocByIdUseCase.execute(personEntraceDTO.getIdTypeDocument())
                                    .get();

        RolPerson rolPerson = getRolPersonByIdUseCase.execute(1).get();
        Person  person = new Person(personEntraceDTO , typeDocument , rolPerson);
        
        createPersonUseCase.execute(person);
        createApplicantUseCase.execute(person);

        return Response.status(Response.Status.ACCEPTED)
                .entity(person)
                .build();
        
    }
}
