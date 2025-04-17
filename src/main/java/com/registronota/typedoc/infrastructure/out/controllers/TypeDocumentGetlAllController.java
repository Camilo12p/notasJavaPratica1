package com.registronota.typedoc.infrastructure.out.controllers;

import java.util.List;


import com.registronota.typedoc.application.GetAllTypeDocumentUseCase;
import com.registronota.typedoc.domai.service.TypeDocumentService;
import com.registronota.typedoc.domain.entity.TypeDocument;
import com.registronota.typedoc.infrastructure.in.TypeDocumentRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/typedocumentall")
public class TypeDocumentGetlAllController {

    private TypeDocumentService typeDocumentService = new TypeDocumentRepository();
    private GetAllTypeDocumentUseCase getAllTypeDocumentUseCase = new GetAllTypeDocumentUseCase(typeDocumentService) ;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeDocument> getAllTypeDocuments(){
        return getAllTypeDocumentUseCase.execute();
    }

}
