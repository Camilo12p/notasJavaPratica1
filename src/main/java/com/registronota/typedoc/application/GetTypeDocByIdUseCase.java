package com.registronota.typedoc.application;

import java.util.Optional;

import com.registronota.typedoc.domai.service.TypeDocumentService;
import com.registronota.typedoc.domain.entity.TypeDocument;

public class GetTypeDocByIdUseCase {
    private TypeDocumentService typeDocumentService;

    public GetTypeDocByIdUseCase(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    public Optional<TypeDocument> execute(int id){
        return typeDocumentService.getTypeDocumentById(id);
    }



}
