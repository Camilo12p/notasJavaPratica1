package com.registronota.applicant.infrastructure.out;

import com.registronota.applicant.application.GetApplicantById;
import com.registronota.applicant.domain.entity.dto.ApplicantOutDTO;
import com.registronota.applicant.domain.service.ApplicantServiceRepository;
import com.registronota.applicant.infrastructure.in.ApplicantRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/applicant/{id}")
public class GetApplicantByIdController {
    private ApplicantServiceRepository aRepository = new ApplicantRepository();
    private GetApplicantById getApplicantById = new GetApplicantById(aRepository);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplicantById(@PathParam("id") int id){

        
        if(getApplicantById.execute(id).isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{{\"error\":\"id no found\"}}")
                    .build();
        };

        ApplicantOutDTO applicantOutDTO = getApplicantById.execute(id).get();
        
        return Response.status(Response.Status.ACCEPTED)
                .entity(applicantOutDTO)
                .build();

    }
}
