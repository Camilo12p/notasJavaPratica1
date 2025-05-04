package com.registronota.scoreadmissiontest.infrastructure.out;

import org.hibernate.validator.constraints.pl.PESEL;

import com.registronota.applicant.application.UpdateAppStatusUseCase;
import com.registronota.applicant.domain.service.ApplicantServiceRepository;
import com.registronota.applicant.infrastructure.in.ApplicantRepository;
import com.registronota.scoreadmissiontest.applicant.CreateScoreUseCase;
import com.registronota.scoreadmissiontest.domain.entity.DTOs.ScoreAdmissionEntranceDTO;
import com.registronota.scoreadmissiontest.domain.service.ScoreAdmissionServiceRespo;
import com.registronota.scoreadmissiontest.infrastructure.in.ScoreAdmissionRepository;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/score/create")
public class ScoreAdmissionPostController {
   
   
    private ScoreAdmissionServiceRespo scoreAdmServiceRepo = new ScoreAdmissionRepository();
    private CreateScoreUseCase createScoreUseCase = new CreateScoreUseCase(scoreAdmServiceRepo);

    private ApplicantServiceRepository aServiceRepository = new ApplicantRepository();
    private UpdateAppStatusUseCase uStatusApplicantUseCase = new UpdateAppStatusUseCase(aServiceRepository);
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response scoreAdmissionPostController(@Valid ScoreAdmissionEntranceDTO score){
        
        createScoreUseCase.execute(score);

        if(score.getScore() >= 60){

            uStatusApplicantUseCase.execute(2, score.getIdApplicant());
            return Response.status(Response.Status.ACCEPTED)
                    .entity("{\"score creado\"}")
                    .build();
        }else{

            uStatusApplicantUseCase.execute(3, score.getIdApplicant());
            return Response.status(Response.Status.ACCEPTED)
                    .entity("{\"score creado\"}")
                    .build();
        }
    }
}
